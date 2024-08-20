package org.example.dto.items;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDto {

    private Long id;

    private String name;

    private String description;

    private Integer stackingCount;

    private List<TagsDto> tagsList = new ArrayList<>();
    public void addTags(TagsDto tagsDto) {
        tagsList.add(tagsDto);
        tagsDto.setItems(this);
    }
}
