package org.example.dao.items;

import org.example.dao.BaseRepository;
import org.example.entity.items.Items;

import javax.persistence.EntityManager;

public class ItemsRepository extends BaseRepository<Long, Items> {
    public ItemsRepository(EntityManager entityManager) {
        super(entityManager, Items.class);
    }
}
