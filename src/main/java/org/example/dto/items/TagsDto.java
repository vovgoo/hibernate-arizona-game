package org.example.dto.items;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.example.dto.items.ItemsDto;

@Data
@AllArgsConstructor
@Builder
@ToString(exclude = "items")
public class TagsDto {

    private Long id;

    private String tagName;

    private ItemsDto items;
}
