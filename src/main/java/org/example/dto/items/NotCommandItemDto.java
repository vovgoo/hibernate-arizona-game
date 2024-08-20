package org.example.dto.items;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NotCommandItemDto extends ItemsDto {

    @Builder
    public NotCommandItemDto(Long id, String name, String description, Integer stackingCount, List<TagsDto> tagsList) {
        super(id, name, description, stackingCount, tagsList);
    }
}
