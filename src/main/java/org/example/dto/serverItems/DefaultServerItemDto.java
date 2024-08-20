package org.example.dto.serverItems;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.entity.items.Items;
import org.example.entity.user.User;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DefaultServerItemDto extends ServerItemDto {

    private Integer count;

    @Builder
    public DefaultServerItemDto(Long id, Items items, Integer count, User user, Integer slots_id) {
        super(id, items, user, slots_id);
        this.count = count;
    }
}
