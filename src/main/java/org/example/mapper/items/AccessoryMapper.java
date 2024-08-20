package org.example.mapper.items;

import lombok.RequiredArgsConstructor;
import org.example.dto.items.AccessoryDto;
import org.example.dto.items.TagsDto;
import org.example.entity.items.Accessory;
import org.example.entity.items.Tags;
import org.example.mapper.Mapper;

import java.util.List;

@RequiredArgsConstructor
public class AccessoryMapper implements Mapper<Accessory, AccessoryDto> {

    private final TagsMapper tagsMapper;

    @Override
    public AccessoryDto mapFrom(Accessory object) {
        List<TagsDto> tagsDto = object.getTagsList().stream()
                .map(tagsMapper::mapFrom)
                .toList();

        AccessoryDto accessory = AccessoryDto.builder()
                .id(object.getId())
                .name(object.getName())
                .description(object.getDescription())
                .stackingCount(object.getStackingCount())
                .tagsList(tagsDto)
                .accessoryBody(object.getAccessoryBody())
                .build();

        tagsDto.forEach(tag -> tag.setItems(accessory));

        return accessory;
    }

    @Override
    public Accessory mapTo(AccessoryDto object) {
        List<Tags> tags = object.getTagsList().stream()
                .map(tagsMapper::mapTo)
                .toList();

        Accessory accessory = Accessory.builder()
                .id(object.getId())
                .name(object.getName())
                .description(object.getDescription())
                .stackingCount(object.getStackingCount())
                .tagsList(tags)
                .accessoryBody(object.getAccessoryBody())
                .build();

        tags.forEach(tag -> tag.setItems(accessory));

        return accessory;
    }
}
