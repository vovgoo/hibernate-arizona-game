package org.example.dto.items;

import lombok.*;
import org.example.entity.items.AccessoryBody;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AccessoryDto extends ItemsDto {

    private AccessoryBody accessoryBody;

    @Builder
    public AccessoryDto(Long id, String name, String description, Integer stackingCount, List<TagsDto> tagsList, AccessoryBody accessoryBody) {
        super(id, name, description, stackingCount, tagsList);
        this.accessoryBody = accessoryBody;
    }
}
