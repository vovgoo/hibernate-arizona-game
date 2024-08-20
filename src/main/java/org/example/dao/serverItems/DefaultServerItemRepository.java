package org.example.dao.serverItems;

import org.example.dao.BaseRepository;
import org.example.dto.serverItems.DefaultServerItemDto;
import org.example.entity.serverItems.Default;

import javax.persistence.EntityManager;
import java.util.List;

public class DefaultServerItemRepository extends BaseRepository<Long, Default> {

    private final EntityManager entityManager;

    public DefaultServerItemRepository(EntityManager entityManager) {
        super(entityManager, Default.class);
        this.entityManager = entityManager;
    }

    public List<Default> getElementsWithType(DefaultServerItemDto defaultServerItemDto) {

        var cb = entityManager.getCriteriaBuilder();
        var criteria =  cb.createQuery(Default.class);
        var serverItem = criteria.from(Default.class);
        var items = serverItem.join("items");

        criteria.select(serverItem).where(
                cb.equal(serverItem.get("user"), defaultServerItemDto.getUser().getId()),
                cb.equal(serverItem.get("items"), defaultServerItemDto.getItems().getId()),
                cb.lessThan(serverItem.get("count"), items.get("stackingCount"))
        ).orderBy(cb.asc(serverItem.get("slots_id")));

        return entityManager.createQuery(criteria).getResultList();
    }
}
