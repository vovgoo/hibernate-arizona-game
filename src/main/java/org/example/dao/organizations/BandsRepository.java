package org.example.dao.organizations;

import org.example.dao.BaseRepository;
import org.example.entity.organizations.Bands;

import javax.persistence.EntityManager;

public class BandsRepository extends BaseRepository<Long, Bands> {
    public BandsRepository(EntityManager entityManager) {
        super(entityManager, Bands.class);
    }
}
