package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.OrderDAO;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.service.OrderService;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderServiceImpl extends AbstractCourierAwareServiceImpl<Order> implements OrderService {
    @Override
    public List<Order> getAllByCreatingUserId(Long id) {
        return ((OrderDAO) dao).findAllByCreatingUserId(id);
    }
}
