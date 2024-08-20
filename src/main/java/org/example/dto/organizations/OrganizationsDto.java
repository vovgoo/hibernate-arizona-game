package org.example.dto.organizations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.user.User;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationsDto {

    private Long id;

    private String name;

    List<User> users = new ArrayList<>();
}
