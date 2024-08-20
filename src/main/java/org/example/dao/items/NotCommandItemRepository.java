package org.example.dao.items;

import org.example.dao.BaseRepository;
import org.example.entity.items.NotCommandItem;

import javax.persistence.EntityManager;

public class NotCommandItemRepository extends BaseRepository<Long, NotCommandItem> {

    private final EntityManager entityManager;

    public NotCommandItemRepository(EntityManager entityManager) {
        super(entityManager, NotCommandItem.class);
        this.entityManager = entityManager;
    }

    public NotCommandItem findByName(String name) {

        var cb = entityManager.getCriteriaBuilder();
        var criteria =  cb.createQuery(NotCommandItem.class);
        var notCommandItem = criteria.from(NotCommandItem.class);

        criteria.select(notCommandItem).where(
                cb.equal(notCommandItem.get("name"), name)
        );

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
