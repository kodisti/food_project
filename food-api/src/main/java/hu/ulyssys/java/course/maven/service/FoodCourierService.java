package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;

public interface FoodCourierService<T extends AbstractFoodCourier> extends CoreService<T> {
}
