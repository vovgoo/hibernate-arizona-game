package org.example.entity.user;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.entity.EditableEntity;
import org.example.entity.organizations.Organizations;
import org.example.entity.serverItems.ServerItems;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "username", callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@Table(name = "users")
public class User extends EditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer level;

    private Integer respect;

    private Integer money;

    private Integer law_abiding;

    @Builder.Default
    private Integer countSlotsInInventory = 10;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<ServerItems> inventory = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Organizations organizations;

}
