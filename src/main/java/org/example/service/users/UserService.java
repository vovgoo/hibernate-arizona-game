package org.example.service.users;

import lombok.RequiredArgsConstructor;
import org.example.dao.users.UserRepository;
import org.example.dto.users.UserDto;
import org.example.entity.user.Gender;
import org.example.entity.user.User;
import org.example.mapper.users.UserMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public boolean delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u -> userRepository.delete(id));
        return user.isPresent();
    }

    public boolean deleteAll() {
        return userRepository.deleteAll();
    }

    public Optional<UserDto> findUserById(Long id) {
        return userRepository.findById(id).map(userMapper::mapFrom);
    }

    public User create(UserDto userDto) {
        return userRepository.save(userMapper.mapTo(userDto));
    }

    public Long getUserCount() {
        return userRepository.countUser();
    }

    public Optional<User> findByUsername(String name) { return userRepository.findByUsername(name); }

    public void stats(Long id) {
        Optional<UserDto> readUserDtoOptional = userRepository.findById(id)
                .map(userMapper::mapFrom);

        if (readUserDtoOptional.isPresent()) {
            UserDto readUserDto = readUserDtoOptional.get();
            System.out.println("____________________________________________________________________________________");
            System.out.println("ID: " + readUserDto.getId());
            System.out.println("Почта: " + readUserDto.getEmail());
            System.out.println("Никнейм: " + readUserDto.getUsername());
            String gender = (readUserDto.getGender() == Gender.MAN) ? "Мужской" : "Женский";
            System.out.println("Пол: " + gender);
            System.out.println("Уровень: " + readUserDto.getLevel());
            System.out.println("Уважение: " + readUserDto.getRespect() + " | " + 8 * (readUserDto.getLevel() + 1));
            System.out.println("Деньги: " + readUserDto.getMoney());
            System.out.println("Законопослушность: " + readUserDto.getLaw_abiding());
            System.out.println("____________________________________________________________________________________");
        } else {
            System.out.println("User not found.");
        }
    }

    public void payday(Long id) {
        Optional<UserDto> readUserDtoOptional = userRepository.findById(id)
                .map(userMapper::mapFrom);

        if (readUserDtoOptional.isPresent()) {
            UserDto user = readUserDtoOptional.get();

            if (user.getLaw_abiding() < 100) {
                user.setLaw_abiding(user.getLaw_abiding() + 1);
            }

            int requiredRespectForNextLevel = (user.getLevel() + 1) * 8;

            if (user.getRespect() + 2 >= requiredRespectForNextLevel) {
                user.setLevel(user.getLevel() + 1);
                user.setRespect(0);
            } else {
                user.setRespect(user.getRespect() + 2);
            }

            userRepository.update(userMapper.mapTo(user));

        } else {
            System.out.println("User with ID " + id + " not found.");
        }
    }

}
