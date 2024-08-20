package org.example.mapper.serverItems;

import org.example.dto.serverItems.SharpeningServerItemDto;
import org.example.entity.items.Accessory;
import org.example.entity.serverItems.Sharpening;
import org.example.mapper.Mapper;

public class SharpeningServerItemMapper implements Mapper<Sharpening, SharpeningServerItemDto> {

    @Override
    public SharpeningServerItemDto mapFrom(Sharpening object) {
        return SharpeningServerItemDto.builder()
                .id(object.getId())
                .user(object.getUser())
                .accessory((Accessory) object.getItems())
                .sharpening(object.getSharpening())
                .slots_id(object.getSlots_id())
                .build();
    }

    @Override
    public Sharpening mapTo(SharpeningServerItemDto object) {
        return Sharpening.builder()
                .id(object.getId())
                .user(object.getUser())
                .accessory((Accessory) object.getItems())
                .sharpening(object.getSharpening())
                .slots_id(object.getSlots_id())
                .build();
    }
}
