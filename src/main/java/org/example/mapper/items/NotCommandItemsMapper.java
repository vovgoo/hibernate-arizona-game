package org.example.mapper.items;

import lombok.RequiredArgsConstructor;
import org.example.dto.items.NotCommandItemDto;
import org.example.dto.items.TagsDto;
import org.example.entity.items.NotCommandItem;
import org.example.entity.items.Tags;
import org.example.mapper.Mapper;

import java.util.List;

@RequiredArgsConstructor
public class NotCommandItemsMapper implements Mapper<NotCommandItem, NotCommandItemDto> {

    private final TagsMapper tagsMapper;


    @Override
    public NotCommandItemDto mapFrom(NotCommandItem object) {
        List<TagsDto> tags = object.getTagsList().stream()
                .map(tagsMapper::mapFrom)
                .toList();

        NotCommandItemDto notCommandItemDto = NotCommandItemDto.builder()
                .id(object.getId())
                .name(object.getName())
                .description(object.getDescription())
                .stackingCount(object.getStackingCount())
                .tagsList(tags)
                .build();

        tags.forEach(tag -> tag.setItems(notCommandItemDto));

        return notCommandItemDto;
    }

    @Override
    public NotCommandItem mapTo(NotCommandItemDto object) {
        List<Tags> tags = object.getTagsList().stream()
                .map(tagsMapper::mapTo)
                .toList();

        NotCommandItem notCommandItem = NotCommandItem.builder()
                .id(object.getId())
                .name(object.getName())
                .description(object.getDescription())
                .stackingCount(object.getStackingCount())
                .tagsList(tags)
                .build();

        tags.forEach(tag -> tag.setItems(notCommandItem));

        return notCommandItem;
    }
}
