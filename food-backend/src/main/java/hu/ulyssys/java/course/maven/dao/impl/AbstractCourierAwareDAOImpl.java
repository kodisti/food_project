package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CourierAwareDAO;
import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;

import java.util.List;

public abstract class AbstractCourierAwareDAOImpl<T extends AbstractFoodCourier> extends AbstractFoodCourierDAOImpl<T> implements CourierAwareDAO<T> {
    @Override
    public List<T> findCourierById(Long id){
        return entityManager.createQuery("select n from " + getManagedClass().getSimpleName() + " n where n.courier.id=:id order by n.id", getManagedClass())
                .setParameter("id", id).getResultList();
    }
}
