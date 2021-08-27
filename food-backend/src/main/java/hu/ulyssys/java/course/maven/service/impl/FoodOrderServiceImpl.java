package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.FoodOrderDAO;
import hu.ulyssys.java.course.maven.entity.FoodOrder;
import hu.ulyssys.java.course.maven.service.FoodOrderService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class FoodOrderServiceImpl extends AbstractCoreServiceImpl<FoodOrder> implements FoodOrderService {
    @Override
    public List<FoodOrder> findAllByOrderId(Long orderId) {
        return ((FoodOrderDAO) dao).findAllByOrderId(orderId);
    }
}
