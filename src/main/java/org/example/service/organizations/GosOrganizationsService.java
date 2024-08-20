package org.example.service.organizations;

import lombok.RequiredArgsConstructor;
import org.example.dao.organizations.GosOrganizationsRepository;
import org.example.dto.organizations.GosOrganizationsDto;
import org.example.entity.organizations.GosOrganizations;
import org.example.mapper.organizations.GosOrganizationsMapper;

import java.util.Optional;

@RequiredArgsConstructor
public class GosOrganizationsService {

    private final GosOrganizationsRepository gosOrganizationsRepository;

    private final GosOrganizationsMapper gosOrganizationsMapper;

    public GosOrganizations create(GosOrganizationsDto gosOrganizationsDto) {
        return gosOrganizationsRepository.save(gosOrganizationsMapper.mapTo(gosOrganizationsDto));
    }

    public Optional<GosOrganizations> findById(Long id) {
        return gosOrganizationsRepository.findById(id);
    }
}
