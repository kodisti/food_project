package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;

import java.util.List;

public interface CourierAwareService<T extends AbstractFoodCourier> extends FoodCourierService<T>{
    List<T> finByCourierId(Long id);
}
