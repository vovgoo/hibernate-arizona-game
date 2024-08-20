package org.example.service.items;

import lombok.RequiredArgsConstructor;
import org.example.dao.items.AccessoryRepository;
import org.example.dto.items.AccessoryDto;
import org.example.entity.items.Accessory;
import org.example.mapper.items.AccessoryMapper;

@RequiredArgsConstructor
public class AccessoryService {

    private final AccessoryRepository accessoryRepository;

    private final AccessoryMapper accessoryMapper;

    public Accessory create(AccessoryDto accessoryDto) {
        return accessoryRepository.save(accessoryMapper.mapTo(accessoryDto));
    }

    public Accessory findByName(String name) {
        return accessoryRepository.findByName(name);
    }
}
