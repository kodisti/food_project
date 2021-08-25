package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;
import hu.ulyssys.java.course.maven.service.FoodCourierService;

public abstract class AbstractFoodCourierServiceImpl<T extends AbstractFoodCourier> extends AbstractCoreServiceImpl<T> implements FoodCourierService<T> {
}
