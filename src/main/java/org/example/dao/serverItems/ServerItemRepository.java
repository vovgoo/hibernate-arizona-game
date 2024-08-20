package org.example.dao.serverItems;

import org.example.dao.BaseRepository;
import org.example.entity.serverItems.ServerItems;
import org.example.entity.user.User;

import javax.persistence.EntityManager;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ServerItemRepository extends BaseRepository<Long, ServerItems> {

    private final EntityManager entityManager;
    public ServerItemRepository(EntityManager entityManager) {
        super(entityManager, ServerItems.class);
        this.entityManager = entityManager;
    }

    public boolean findByUserIdAndSlotsId(Long userId, Integer slotsId) {
        var cb = entityManager.getCriteriaBuilder();
        var criteria =  cb.createQuery(ServerItems.class);
        var serverItem = criteria.from(ServerItems.class);

        criteria.select(serverItem).where(
                cb.equal(serverItem.get("user"), userId),
                cb.equal(serverItem.get("slots_id"), slotsId)
        );

        return entityManager.createQuery(criteria).getResultList().isEmpty();
    }

    public boolean haveEmptySlot(User user) {

        var cb = entityManager.getCriteriaBuilder();
        var criteria =  cb.createQuery(ServerItems.class);
        var serverItem = criteria.from(ServerItems.class);

        criteria.select(serverItem).where(
                cb.equal(serverItem.get("user"), user.getId())
        );

        TreeSet<Integer> result = entityManager.createQuery(criteria).getResultList().stream().map(ServerItems::getSlots_id).collect(Collectors.toCollection(TreeSet::new));

        TreeSet<Integer> userInventory = new TreeSet<>(IntStream.rangeClosed(1, user.getCountSlotsInInventory()).boxed().toList());

        userInventory.removeAll(result);

        return !userInventory.isEmpty();
    }

    public Integer getEmptySlot(User user) {

        var cb = entityManager.getCriteriaBuilder();
        var criteria =  cb.createQuery(ServerItems.class);
        var serverItem = criteria.from(ServerItems.class);

        criteria.select(serverItem).where(
                cb.equal(serverItem.get("user"), user.getId())
        );

        TreeSet<Integer> result = entityManager.createQuery(criteria).getResultList().stream().map(ServerItems::getSlots_id).collect(Collectors.toCollection(TreeSet::new));

        TreeSet<Integer> userInventory = new TreeSet<>(IntStream.rangeClosed(1, user.getCountSlotsInInventory()).boxed().toList());

        userInventory.removeAll(result);

        return userInventory.getFirst();
    }
}
