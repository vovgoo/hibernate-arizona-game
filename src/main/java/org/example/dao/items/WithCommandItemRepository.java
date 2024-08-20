package org.example.dao.items;

import org.example.dao.BaseRepository;
import org.example.entity.items.WithCommandItem;

import javax.persistence.EntityManager;

public class WithCommandItemRepository extends BaseRepository<Long, WithCommandItem> {
    public WithCommandItemRepository(EntityManager entityManager) {
        super(entityManager, WithCommandItem.class);
    }
}
