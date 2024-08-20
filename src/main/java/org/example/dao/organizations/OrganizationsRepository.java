package org.example.dao.organizations;

import org.example.dao.BaseRepository;
import org.example.entity.organizations.Organizations;

import javax.persistence.EntityManager;

public class OrganizationsRepository extends BaseRepository<Long, Organizations> {
    public OrganizationsRepository(EntityManager entityManager) {
        super(entityManager, Organizations.class);
    }
}
