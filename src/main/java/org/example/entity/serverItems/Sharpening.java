package org.example.entity.serverItems;

import lombok.*;
import org.example.entity.items.Accessory;
import org.example.entity.user.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("sharpening")
public class Sharpening extends ServerItems {

    private Integer Sharpening;

    @Builder
    public Sharpening(Long id, Accessory accessory, Integer sharpening, User user, Integer slots_id) {
        super(id, accessory, user, slots_id);
        Sharpening = sharpening;
    }
}
