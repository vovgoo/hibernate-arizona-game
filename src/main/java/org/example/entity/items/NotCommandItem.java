package org.example.entity.items;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("notCommandItem")
public class NotCommandItem extends Items {
    @Builder
    public NotCommandItem(Long id, String name, String description, Integer stackingCount, List<Tags> tagsList) {
        super(id, name, description, stackingCount, tagsList);
    }
}
