package org.example.dto.items;

import lombok.*;

import java.util.List;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WithCommandItemDto extends ItemsDto {

    private String command;

    @Builder
    public WithCommandItemDto(Long id, String name, String description, Integer stackingCount, List<TagsDto> tagsList, String command) {
        super(id, name, description, stackingCount, tagsList);
        this.command = command;
    }
}
