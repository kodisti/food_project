package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.FoodDAO;
import hu.ulyssys.java.course.maven.entity.Food;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class FoodDAOImpl extends AbstractFoodCourierDAOImpl<Food> implements FoodDAO {
    @Override
    protected Class<Food> getManagedClass() {
        return Food.class;
    }

    @Override
    public Food findByName(String name) {
        List<Food> foodList = entityManager.createQuery("select f from Food f where f.name=:name", Food.class).setParameter("name", name).getResultList();
        if (foodList.isEmpty()){
            return null;
        }
        return foodList.get(0);
    }
}
