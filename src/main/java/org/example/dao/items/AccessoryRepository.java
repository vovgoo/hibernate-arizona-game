package org.example.dao.items;

import org.example.dao.BaseRepository;
import org.example.entity.items.Accessory;

import javax.persistence.EntityManager;

public class AccessoryRepository extends BaseRepository<Long, Accessory> {

    private final EntityManager entityManager;

    public AccessoryRepository(EntityManager entityManager) {
        super(entityManager, Accessory.class);
        this.entityManager = entityManager;
    }

    public Accessory findByName(String name) {

        var cb = entityManager.getCriteriaBuilder();
        var criteria =  cb.createQuery(Accessory.class);
        var accessory = criteria.from(Accessory.class);

        criteria.select(accessory).where(
                cb.equal(accessory.get("name"), name)
        );

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
