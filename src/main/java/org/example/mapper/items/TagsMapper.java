package org.example.mapper.items;

import org.example.dto.items.TagsDto;
import org.example.entity.items.Tags;
import org.example.mapper.Mapper;

public class TagsMapper implements Mapper<Tags, TagsDto> {

    @Override
    public TagsDto mapFrom(Tags object) {
        return TagsDto.builder()
                .id(object.getId())
                .tagName(object.getTagName())
                .build();
    }

    @Override
    public Tags mapTo(TagsDto object) {
        return Tags.builder()
                .id(object.getId())
                .tagName(object.getTagName())
                .build();
    }
}
