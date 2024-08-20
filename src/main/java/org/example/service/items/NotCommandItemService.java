package org.example.service.items;

import lombok.RequiredArgsConstructor;
import org.example.dao.items.NotCommandItemRepository;
import org.example.dto.items.NotCommandItemDto;
import org.example.entity.items.NotCommandItem;
import org.example.mapper.items.NotCommandItemsMapper;

@RequiredArgsConstructor
public class NotCommandItemService {

    private final NotCommandItemRepository notCommandItemRepository;

    private final NotCommandItemsMapper notCommandItemsMapper;

    public NotCommandItem create(NotCommandItemDto notCommandItemDto) {
        return notCommandItemRepository.save(notCommandItemsMapper.mapTo(notCommandItemDto));
    }

    public NotCommandItem findByName(String name) {
        return notCommandItemRepository.findByName(name);
    }

}
