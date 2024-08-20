package org.example.dao.users;

import org.example.dao.BaseRepository;
import org.example.entity.user.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserRepository extends BaseRepository<Long, User> {

    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        super(entityManager, User.class);
        this.entityManager = entityManager;
    }

    public boolean deleteAll() {
        entityManager.createQuery("DELETE FROM User").executeUpdate();
        return true;
    }

    public Long countUser() {
        return entityManager.createQuery("SELECT COUNT(*) FROM User", Long.class).getSingleResult();
    }

    public Optional<User> findByUsername(String name) {

        var cb = entityManager.getCriteriaBuilder();
        var criteria = cb.createQuery(User.class);
        var user = criteria.from(User.class);

        criteria.select(user).where(
                cb.equal(user.get("username"), name)
        );

        return Optional.ofNullable(entityManager.createQuery(criteria).getSingleResult());
    }
}
