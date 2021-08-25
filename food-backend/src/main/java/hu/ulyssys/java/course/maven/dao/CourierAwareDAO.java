package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;

import java.util.List;

public interface CourierAwareDAO<T extends AbstractFoodCourier> extends FoodCourierDAO<T> {
    List<T> findCourierById(Long id);
}
