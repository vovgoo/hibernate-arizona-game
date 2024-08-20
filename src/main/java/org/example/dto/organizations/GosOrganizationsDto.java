package org.example.dto.organizations;

import lombok.*;
import org.example.entity.user.User;

import java.util.List;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GosOrganizationsDto extends OrganizationsDto {

    private Double coffers;

    @Builder
    public GosOrganizationsDto(Long id, String name, List<User> users, Double coffers) {
        super(id, name, users);
        this.coffers = coffers;
    }
}
