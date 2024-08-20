package org.example.mapper.serverItems;

import org.example.dto.serverItems.DefaultServerItemDto;
import org.example.entity.serverItems.Default;
import org.example.mapper.Mapper;

public class DefaultServerItemMapper implements Mapper<Default, DefaultServerItemDto> {
    @Override
    public DefaultServerItemDto mapFrom(Default object) {
        return DefaultServerItemDto.builder()
                .id(object.getId())
                .user(object.getUser())
                .items(object.getItems())
                .count(object.getCount())
                .slots_id(object.getSlots_id())
                .build();
    }

    @Override
    public Default mapTo(DefaultServerItemDto object) {
        return Default.builder()
                .id(object.getId())
                .user(object.getUser())
                .items(object.getItems())
                .count(object.getCount())
                .slots_id(object.getSlots_id())
                .build();
    }
}
