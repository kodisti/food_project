package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.OrderDAO;
import hu.ulyssys.java.course.maven.entity.Order;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class OrderDAOImpl extends AbstractCourierAwareDAOImpl<Order> implements OrderDAO {

    @Override
    public List<Order> findAllByCreatingUserId(Long id) {
        return entityManager.createQuery("select o from Order o where o.creatingUser.id=:id order by o.id", Order.class).setParameter("id", id).getResultList();
    }

    @Override
    protected Class<Order> getManagedClass() {
        return Order.class;
    }
}
