package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.FoodOrderDAO;
import hu.ulyssys.java.course.maven.entity.FoodOrder;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class FoodOrderDAOImpl extends AbstractCoreDAOImpl<FoodOrder> implements FoodOrderDAO {
    @Override
    protected Class<FoodOrder> getManagedClass() {
        return FoodOrder.class;
    }

    @Override
    public List<FoodOrder> findAllByOrderId(Long orderId) {
        return entityManager.createQuery("select f from FoodOrder f where f.orderId=:orderId", FoodOrder.class).setParameter("orderId", orderId).getResultList();
    }
}
