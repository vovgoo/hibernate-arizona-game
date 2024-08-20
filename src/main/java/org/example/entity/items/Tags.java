package org.example.entity.items;

import lombok.*;
import org.example.entity.BaseEntity;

import javax.persistence.*;

@EqualsAndHashCode(of = "tagName", callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tags")
public class Tags implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagName;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "items_id")
    private Items items;
}
