package org.example.service.items;

import lombok.RequiredArgsConstructor;
import org.example.dao.items.WithCommandItemRepository;
import org.example.dto.items.WithCommandItemDto;
import org.example.entity.items.WithCommandItem;
import org.example.mapper.items.WithCommandItemMapper;

@RequiredArgsConstructor
public class WithCommandItemService {

    private final WithCommandItemRepository withCommandItemRepository;

    private final WithCommandItemMapper withCommandItemMapper;

    public WithCommandItem create(WithCommandItemDto withCommandItemDto) {
        return withCommandItemRepository.save(withCommandItemMapper.mapTo(withCommandItemDto));
    }
}
