package hu.ulyssys.java.course.maven.service.impl;


import hu.ulyssys.java.course.maven.dao.CourierAwareDAO;
import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;
import hu.ulyssys.java.course.maven.service.CourierAwareService;

import java.util.List;

public abstract class AbstractCourierAwareServiceImpl<T extends AbstractFoodCourier> extends AbstractFoodCourierServiceImpl<T> implements CourierAwareService<T> {
    @Override
    public List<T> finByCourierId(Long id) {
        return ((CourierAwareDAO<T>) dao).findCourierById(id);
    }
}
