package org.example.entity.organizations;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.entity.user.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("bands")
public class Bands extends Organizations {

    public Integer ammo;

    public Integer medicineChest;

    @Builder
    public Bands(Long id, String name, Integer ammo, List<User> users, Integer medicineChest) {
        super(id, name, users);
        this.ammo = ammo;
        this.medicineChest = medicineChest;
    }
}
