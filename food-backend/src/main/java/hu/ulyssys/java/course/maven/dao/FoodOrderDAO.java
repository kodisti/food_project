package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.FoodOrder;

import java.util.List;

public interface FoodOrderDAO extends CoreDAO<FoodOrder>{
    List<FoodOrder> findAllByOrderId(Long orderId);
}
