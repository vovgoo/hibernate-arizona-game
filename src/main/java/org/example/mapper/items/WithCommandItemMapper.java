package org.example.mapper.items;

import lombok.RequiredArgsConstructor;
import org.example.dto.items.TagsDto;
import org.example.dto.items.WithCommandItemDto;
import org.example.entity.items.Tags;
import org.example.entity.items.WithCommandItem;
import org.example.mapper.Mapper;

import java.util.List;


@RequiredArgsConstructor
public class WithCommandItemMapper implements Mapper<WithCommandItem, WithCommandItemDto> {

    private final TagsMapper tagsMapper;

    @Override
    public WithCommandItemDto mapFrom(WithCommandItem object) {
        List<TagsDto> tagsDto = object.getTagsList().stream()
                .map(tagsMapper::mapFrom)
                .toList();

        WithCommandItemDto withCommandItemDto = WithCommandItemDto.builder()
                .id(object.getId())
                .name(object.getName())
                .description(object.getDescription())
                .stackingCount(object.getStackingCount())
                .tagsList(tagsDto)
                .command(object.getCommand())
                .build();

        tagsDto.forEach(tag -> tag.setItems(withCommandItemDto));

        return withCommandItemDto;
    }

    @Override
    public WithCommandItem mapTo(WithCommandItemDto object) {
        List<Tags> tags = object.getTagsList().stream()
                .map(tagsMapper::mapTo)
                .toList();

        WithCommandItem withCommandItem = WithCommandItem.builder()
                .id(object.getId())
                .name(object.getName())
                .description(object.getDescription())
                .stackingCount(object.getStackingCount())
                .tagsList(tags)
                .command(object.getCommand())
                .build();

        tags.forEach(tag -> tag.setItems(withCommandItem));

        return withCommandItem;
    }
}
