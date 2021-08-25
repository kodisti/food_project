package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.FoodDAO;
import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.service.FoodService;

import javax.ejb.Stateless;

@Stateless
public class FoodServiceImpl extends AbstractFoodCourierServiceImpl<Food> implements FoodService {
    @Override
    public Food findByName(String name) {
        return ((FoodDAO) dao).findByName(name);
    }
}
