package org.example.mapper.organizations;

import org.example.dto.organizations.GosOrganizationsDto;
import org.example.entity.organizations.GosOrganizations;
import org.example.mapper.Mapper;

public class GosOrganizationsMapper implements Mapper<GosOrganizations, GosOrganizationsDto> {
    @Override
    public GosOrganizationsDto mapFrom(GosOrganizations object) {
        return GosOrganizationsDto.builder()
                .name(object.getName())
                .users(object.getUsers())
                .coffers(object.getCoffers())
                .build();
    }

    @Override
    public GosOrganizations mapTo(GosOrganizationsDto object) {
        return GosOrganizations.builder()
                .name(object.getName())
                .users(object.getUsers())
                .coffers(object.getCoffers())
                .build();
    }
}
