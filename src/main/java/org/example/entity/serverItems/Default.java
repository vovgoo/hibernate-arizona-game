package org.example.entity.serverItems;

import lombok.*;
import org.example.entity.items.Items;
import org.example.entity.user.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("default")
public class Default extends ServerItems{

    private Integer count;

    @Builder
    public Default(Long id, Items items, Integer count, User user, Integer slots_id) {
        super(id, items, user, slots_id);
        this.count = count;
    }
}
