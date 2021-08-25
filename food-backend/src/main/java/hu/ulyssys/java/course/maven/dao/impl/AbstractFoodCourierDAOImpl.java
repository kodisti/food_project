package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.FoodCourierDAO;
import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;

public abstract class AbstractFoodCourierDAOImpl<T extends AbstractFoodCourier> extends AbstractCoreDAOImpl<T> implements FoodCourierDAO<T> {
}
