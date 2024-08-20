package org.example.entity.items;

import lombok.*;
import org.example.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "name", callSuper = false)
@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Items implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer stackingCount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "items")
    private List<Tags> tagsList = new ArrayList<>();

    public void addTags(Tags tag) {
        tagsList.add(tag);
        tag.setItems(this);
    }
}