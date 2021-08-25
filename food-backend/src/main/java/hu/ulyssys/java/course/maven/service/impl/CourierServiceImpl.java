package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.CourierDAO;
import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.service.CourierService;

import javax.ejb.Stateless;

@Stateless
public class CourierServiceImpl extends AbstractFoodCourierServiceImpl<Courier> implements CourierService {
    @Override
    public Courier findByName(String name) {
        return ((CourierDAO) dao).findByName(name);
    }
}
