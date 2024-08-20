package org.example.dto.serverItems;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.entity.items.Accessory;
import org.example.entity.user.User;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SharpeningServerItemDto extends ServerItemDto {

    private Integer Sharpening;

    @Builder
    public SharpeningServerItemDto(Long id, Accessory accessory, Integer sharpening, User user, Integer slots_id) {
        super(id, accessory, user, slots_id);
        Sharpening = sharpening;
    }
}
