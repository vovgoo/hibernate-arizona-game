package org.example.dao.organizations;

import org.example.dao.BaseRepository;
import org.example.entity.organizations.GosOrganizations;

import javax.persistence.EntityManager;

public class GosOrganizationsRepository extends BaseRepository<Long, GosOrganizations> {
    public GosOrganizationsRepository(EntityManager entityManager) {
        super(entityManager, GosOrganizations.class);
    }
}
