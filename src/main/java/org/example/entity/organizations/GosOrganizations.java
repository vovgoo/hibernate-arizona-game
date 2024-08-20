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
@DiscriminatorValue("gosOrganizations")
public class GosOrganizations extends Organizations {

    private Double coffers;

    @Builder
    public GosOrganizations(Long id, String name, List<User> users, Double coffers) {
        super(id, name, users);
        this.coffers = coffers;
    }
}
