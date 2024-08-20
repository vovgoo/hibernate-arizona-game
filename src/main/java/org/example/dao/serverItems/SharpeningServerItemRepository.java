package org.example.dao.serverItems;

import org.example.dao.BaseRepository;
import org.example.entity.serverItems.Sharpening;

import javax.persistence.EntityManager;

public class SharpeningServerItemRepository extends BaseRepository<Long, Sharpening> {
    public SharpeningServerItemRepository(EntityManager entityManager) {
        super(entityManager, Sharpening.class);
    }
}
