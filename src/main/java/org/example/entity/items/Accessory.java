package org.example.entity.items;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("accessory")
public class Accessory extends Items {

    @Enumerated(EnumType.STRING)
    private AccessoryBody accessoryBody;

    @Builder
    public Accessory(Long id, String name, String description, Integer stackingCount, List<Tags> tagsList, AccessoryBody accessoryBody) {
        super(id, name, description, stackingCount, tagsList);
        this.accessoryBody = accessoryBody;
    }
}
