package org.example.service.serverItems;

import org.example.dao.serverItems.DefaultServerItemRepository;
import org.example.dao.serverItems.ServerItemRepository;
import org.example.dto.serverItems.DefaultServerItemDto;
import org.example.entity.serverItems.Default;
import org.example.mapper.serverItems.DefaultServerItemMapper;

import java.util.List;

public class DefaultServerItemService extends ServerItemService {

    private final DefaultServerItemRepository defaultServerItemRepository;

    private final DefaultServerItemMapper defaultServerItemMapper;

    public DefaultServerItemService(ServerItemRepository serverItemRepository, DefaultServerItemRepository defaultServerItemRepository, DefaultServerItemMapper defaultServerItemMapper) {
        super(serverItemRepository);
        this.defaultServerItemRepository = defaultServerItemRepository;
        this.defaultServerItemMapper = defaultServerItemMapper;
    }

    public Default create(DefaultServerItemDto defaultServerItemDto) {

        List<Default> items = defaultServerItemRepository.getElementsWithType(defaultServerItemDto);

        Integer count = defaultServerItemDto.getCount();

        Integer maxCount = defaultServerItemDto.getItems().getStackingCount();

        for(Default item : items) {
            Integer temp = maxCount - item.getCount();

            if(temp - count < 0) {
                item.setCount(item.getCount() + temp);
                count -= temp;
            } else {
                item.setCount(item.getCount() + temp);
                return items.getLast();
            }

            defaultServerItemRepository.save(item);
        }

        defaultServerItemDto.setCount(count);

        return defaultServerItemRepository.save(defaultServerItemMapper.mapTo(defaultServerItemDto));
    }
}
