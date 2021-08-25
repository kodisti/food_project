package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.Courier;

public interface CourierService extends FoodCourierService<Courier> {
    Courier findByName(String name);
}
