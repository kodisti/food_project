package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.FoodOrder;

import java.util.List;

public interface FoodOrderService extends CoreService<FoodOrder>{
    List<FoodOrder> findAllByOrderId(Long orderId);
}
