package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.Exceptions.SelectedSlotAlreadyOccupiedException;
import org.example.dao.items.AccessoryRepository;
import org.example.dao.items.NotCommandItemRepository;
import org.example.dao.items.WithCommandItemRepository;
import org.example.dao.organizations.BandsRepository;
import org.example.dao.organizations.GosOrganizationsRepository;
import org.example.dao.serverItems.DefaultServerItemRepository;
import org.example.dao.serverItems.ServerItemRepository;
import org.example.dao.serverItems.SharpeningServerItemRepository;
import org.example.dao.users.UserRepository;
import org.example.dto.items.AccessoryDto;
import org.example.dto.items.NotCommandItemDto;
import org.example.dto.items.TagsDto;
import org.example.dto.items.WithCommandItemDto;
import org.example.dto.organizations.BandsDto;
import org.example.dto.organizations.GosOrganizationsDto;
import org.example.dto.serverItems.DefaultServerItemDto;
import org.example.dto.serverItems.SharpeningServerItemDto;
import org.example.dto.users.UserDto;
import org.example.entity.items.Accessory;
import org.example.entity.items.AccessoryBody;
import org.example.entity.items.NotCommandItem;
import org.example.entity.organizations.Bands;
import org.example.entity.organizations.GosOrganizations;
import org.example.entity.user.Gender;
import org.example.entity.user.User;
import org.example.mapper.items.AccessoryMapper;
import org.example.mapper.items.NotCommandItemsMapper;
import org.example.mapper.items.TagsMapper;
import org.example.mapper.items.WithCommandItemMapper;
import org.example.mapper.organizations.BandsMapper;
import org.example.mapper.organizations.GosOrganizationsMapper;
import org.example.mapper.serverItems.DefaultServerItemMapper;
import org.example.mapper.serverItems.SharpeningServerItemMapper;
import org.example.mapper.users.UserMapper;
import org.example.service.items.AccessoryService;
import org.example.service.items.NotCommandItemService;
import org.example.service.items.WithCommandItemService;
import org.example.service.organizations.BandsService;
import org.example.service.organizations.GosOrganizationsService;
import org.example.service.serverItems.DefaultServerItemService;
import org.example.service.serverItems.SharpeningServerItemService;
import org.example.service.users.UserService;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class MainTest {

    @Test
    public void createUser() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {
                UserMapper userReadMapper = new UserMapper();

                UserRepository userRepository = new UserRepository(session);

                UserService userService = new UserService(userRepository, userReadMapper);

                UserDto userDto = UserDto.builder()
                        .username("Carl_Johnson")
                        .password("test1234")
                        .gender(Gender.MAN)
                        .level(0)
                        .respect(0)
                        .money(0)
                        .law_abiding(0)
                        .updatedAt(LocalDateTime.now())
                        .createdAt(LocalDateTime.now())
                        .countSlotsInInventory(10)
                        .build();

                Transaction transaction = session.beginTransaction();

                try {
                    if(userService.deleteAll()) {
                        User user = userService.create(userDto);
                        userService.stats(user.getId());
                    }
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }

                assertEquals(1, userService.getUserCount(), "User added successful");
            }
        }
    }

    @Test
    public void createWithCommandItem() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                WithCommandItemRepository withCommandItemRepository = new WithCommandItemRepository(session);

                TagsMapper tagsMapper = new TagsMapper();

                WithCommandItemMapper withCommandItemMapper = new WithCommandItemMapper(tagsMapper);

                WithCommandItemService withCommandItemService = new WithCommandItemService(withCommandItemRepository, withCommandItemMapper);

                WithCommandItemDto withCommandItemDto = WithCommandItemDto.builder()
                        .name("Телефон")
                        .description("Используется для установления связи с другими игроками сервера")
                        .stackingCount(1)
                        .tagsList(new ArrayList<>())
                        .command("/phone")
                        .build();

                TagsDto tagsDto = TagsDto.builder()
                        .tagName("Воспользоваться можно с помощью команды /phone")
                        .build();

                TagsDto tagsDto1 = TagsDto.builder()
                        .tagName("Можно использовать нажав на кнопку P")
                        .build();

                TagsDto tagsDto2 = TagsDto.builder()
                        .tagName("Пополнить баланс вашего телефона можно в центральном банке.")
                        .build();

                withCommandItemDto.addTags(tagsDto);
                withCommandItemDto.addTags(tagsDto1);
                withCommandItemDto.addTags(tagsDto2);

                Transaction transaction = session.beginTransaction();

                try {
                    withCommandItemService.create(withCommandItemDto);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }

            }
        }
    }

    @Test
    public void createAccessory() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                AccessoryRepository accessoryRepository = new AccessoryRepository(session);

                TagsMapper tagsMapper = new TagsMapper();

                AccessoryMapper accessoryMapper = new AccessoryMapper(tagsMapper);

                AccessoryService accessoryService = new AccessoryService(accessoryRepository, accessoryMapper);

                AccessoryDto accessoryDto = AccessoryDto.builder()
                        .name("Черная маска")
                        .description("Аксессуар который может изменить ваш внешний вид.")
                        .stackingCount(1)
                        .tagsList(new ArrayList<>())
                        .accessoryBody(AccessoryBody.FACE)
                        .build();

                TagsDto tagsDto = TagsDto.builder()
                        .tagName("Кастомизируйте внешнйи вид вашего персонажа.")
                        .build();


                accessoryDto.addTags(tagsDto);

                Transaction transaction = session.beginTransaction();

                try {
                    accessoryService.create(accessoryDto);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }
            }
        }
    }

    @Test
    public void createNotCommandItem() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                NotCommandItemRepository notCommandItemRepository = new NotCommandItemRepository(session);

                TagsMapper tagsMapper = new TagsMapper();

                NotCommandItemsMapper notCommandItemsMapper = new NotCommandItemsMapper(tagsMapper);

                NotCommandItemService notCommandItemService = new NotCommandItemService(notCommandItemRepository, notCommandItemsMapper);

                 NotCommandItemDto notCommandItemDto = NotCommandItemDto.builder()
                        .name("Хлопок")
                        .description("Ресурс, который используется в крафте предметов.")
                        .stackingCount(100)
                        .tagsList(new ArrayList<>())
                        .build();

                TagsDto tagsDto = TagsDto.builder()
                        .tagName("Можете продать на центральном рынке.")
                        .build();

                TagsDto tagsDto1 = TagsDto.builder()
                        .tagName("Можете использовать в обмене с другими игрока /trade.")
                        .build();

                notCommandItemDto.addTags(tagsDto);
                notCommandItemDto.addTags(tagsDto1);

                Transaction transaction = session.beginTransaction();

                try {
                    notCommandItemService.create(notCommandItemDto);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }
            }
        }
    }

    @Test
    public void createDefaultServerItem() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                UserRepository userRepository = new UserRepository(session);

                UserMapper userMapper = new UserMapper();

                UserService userService = new UserService(userRepository, userMapper);

                User user = userService.findByUsername("Carl_Johnson").orElseThrow();


                NotCommandItemRepository notCommandItemRepository = new NotCommandItemRepository(session);

                TagsMapper tagsMapper = new TagsMapper();

                NotCommandItemsMapper notCommandItemsMapper = new NotCommandItemsMapper(tagsMapper);

                NotCommandItemService notCommandItemService = new NotCommandItemService(notCommandItemRepository, notCommandItemsMapper);

                NotCommandItem notCommandItem = notCommandItemService.findByName("Хлопок");



                ServerItemRepository serverItemRepository = new ServerItemRepository(session);

                DefaultServerItemRepository defaultServerItemRepository = new DefaultServerItemRepository(session);

                DefaultServerItemMapper defaultServerItemMapper = new DefaultServerItemMapper();

                DefaultServerItemService defaultServerItemService = new DefaultServerItemService(serverItemRepository ,defaultServerItemRepository, defaultServerItemMapper);

                if(serverItemRepository.haveEmptySlot(user)) {
                    DefaultServerItemDto defaultServerItemDto = DefaultServerItemDto.builder()
                            .items(notCommandItem)
                            .user(user)
                            .slots_id(serverItemRepository.getEmptySlot(user))
                            .count(64)
                            .build();

                    Transaction transaction = session.beginTransaction();
                    try {
                        if(defaultServerItemService.canExist(defaultServerItemDto.getUser().getId(), defaultServerItemDto.getSlots_id())) {
                            defaultServerItemService.create(defaultServerItemDto);
                        } else {
                            throw new SelectedSlotAlreadyOccupiedException();
                        }
                        transaction.commit();
                    } catch (Exception ex) {
                        transaction.rollback();
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    @Test
    public void createSharpeningServerItem() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                UserRepository userRepository = new UserRepository(session);

                UserMapper userMapper = new UserMapper();

                UserService userService = new UserService(userRepository, userMapper);

                User user = userService.findByUsername("Carl_Johnson").orElseThrow();


                ServerItemRepository serverItemRepository = new ServerItemRepository(session);

                AccessoryRepository accessoryRepository = new AccessoryRepository(session);

                TagsMapper tagsMapper = new TagsMapper();

                AccessoryMapper accessoryMapper = new AccessoryMapper(tagsMapper);

                AccessoryService AccessoryService = new AccessoryService(accessoryRepository, accessoryMapper);

                Accessory accessory = AccessoryService.findByName("Черная маска");


                SharpeningServerItemRepository sharpeningServerItemRepository = new SharpeningServerItemRepository(session);

                SharpeningServerItemMapper sharpeningServerItemMapper = new SharpeningServerItemMapper();

                SharpeningServerItemService sharpeningServerItemService = new SharpeningServerItemService(serverItemRepository, sharpeningServerItemRepository, sharpeningServerItemMapper);

                SharpeningServerItemDto sharpeningServerItemDto = SharpeningServerItemDto.builder()
                        .accessory(accessory)
                        .user(user)
                        .sharpening(0)
                        .slots_id(sharpeningServerItemService.getEmptySlot(user))
                        .build();

                Transaction transaction = session.beginTransaction();
                try {
                    if(sharpeningServerItemService.canExist(sharpeningServerItemDto.getUser().getId(), sharpeningServerItemDto.getSlots_id())) {
                        sharpeningServerItemService.create(sharpeningServerItemDto);
                    } else {
                        throw new SelectedSlotAlreadyOccupiedException();
                    }
                    transaction.commit();
                } catch (Exception ex) {
                    transaction.rollback();
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    @Test
    public void createBands() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                BandsRepository bandsRepository = new BandsRepository(session);

                BandsMapper bandsMapper = new BandsMapper();

                BandsService bandsService = new BandsService(bandsRepository, bandsMapper);

                BandsDto bandsDto = BandsDto.builder()
                        .name("Varios Los Aztecas")
                        .users(new ArrayList<>())
                        .ammo(0)
                        .medicineChest(0)
                        .build();

                Transaction transaction = session.beginTransaction();
                try {
                    bandsService.create(bandsDto);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }
            }
        }
    }

    @Test
    public void createGosOrganizations() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                GosOrganizationsRepository gosOrganizationsRepository = new GosOrganizationsRepository(session);

                GosOrganizationsMapper gosOrganizationsMapper = new GosOrganizationsMapper();

                GosOrganizationsService gosOrganizationsService = new GosOrganizationsService(gosOrganizationsRepository, gosOrganizationsMapper);

                GosOrganizationsDto gosOrganizationsDto = GosOrganizationsDto.builder()
                        .name("Правительство")
                        .users(new ArrayList<>())
                        .coffers(0D)
                        .build();

                Transaction transaction = session.beginTransaction();
                try {
                    gosOrganizationsService.create(gosOrganizationsDto);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }
            }
        }
    }

    @Test
    public void addUserToBands() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                BandsRepository bandsRepository = new BandsRepository(session);

                BandsMapper bandsMapper = new BandsMapper();

                BandsService bandsService = new BandsService(bandsRepository, bandsMapper);

                Bands bands = bandsService.findById(1L).orElseThrow();

                UserRepository userRepository = new UserRepository(session);

                UserMapper userMapper = new UserMapper();

                UserService userService = new UserService(userRepository, userMapper);

                User user = userService.findByUsername("Carl_Johnson").orElseThrow();

                Transaction transaction = session.beginTransaction();
                try {
                    user.setOrganizations(bands);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }
            }
        }
    }

    @Test
    public void addUserToGosOrganizations() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            try (Session session = sessionFactory.openSession()) {

                GosOrganizationsRepository gosOrganizationsRepository = new GosOrganizationsRepository(session);

                GosOrganizationsMapper gosOrganizationsMapper = new GosOrganizationsMapper();

                GosOrganizationsService gosOrganizationsService = new GosOrganizationsService(gosOrganizationsRepository, gosOrganizationsMapper);

                GosOrganizations gosOrganizations = gosOrganizationsService.findById(2L).orElseThrow();

                UserRepository userRepository = new UserRepository(session);

                UserMapper userMapper = new UserMapper();

                UserService userService = new UserService(userRepository, userMapper);

                User user = userService.findByUsername("Carl_Johnson").orElseThrow();

                Transaction transaction = session.beginTransaction();
                try {
                    user.setOrganizations(gosOrganizations);
                    transaction.commit();
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }
            }
        }
    }

}