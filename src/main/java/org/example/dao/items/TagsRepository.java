package org.example.dao.items;

import org.example.dao.BaseRepository;
import org.example.entity.items.Tags;

import javax.persistence.EntityManager;

public class TagsRepository extends BaseRepository<Long, Tags> {
    public TagsRepository(EntityManager entityManager) {
        super(entityManager, Tags.class);
    }
}
