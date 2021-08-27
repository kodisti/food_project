package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.Order;

import java.util.List;

public interface OrderDAO extends CourierAwareDAO<Order>{
    List<Order> findAllByCreatingUserId(Long id);
}
