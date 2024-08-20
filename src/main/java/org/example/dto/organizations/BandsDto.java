package org.example.dto.organizations;

import lombok.*;
import org.example.entity.user.User;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BandsDto extends OrganizationsDto {

    public Integer ammo;

    public Integer medicineChest;

    @Builder
    public BandsDto(Long id, String name, Integer ammo, List<User> users, Integer medicineChest) {
        super(id, name, users);
        this.ammo = ammo;
        this.medicineChest = medicineChest;
    }
}
