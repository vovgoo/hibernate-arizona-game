package org.example.entity.items;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("withCommandItem")
public class WithCommandItem extends Items {

    private String command;

    @Builder
    public WithCommandItem(Long id, String name, String description, Integer stackingCount, List<Tags> tagsList, String command) {
        super(id, name, description, stackingCount, tagsList);
        this.command = command;
    }
}