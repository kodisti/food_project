package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.Food;

public interface FoodDAO extends FoodCourierDAO<Food>{
    Food findByName(String name);
}
