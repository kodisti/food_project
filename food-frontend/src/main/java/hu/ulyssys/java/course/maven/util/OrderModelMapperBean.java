package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.rest.model.OrderModel;

public class OrderModelMapperBean extends CoreModelMapperBean<OrderModel, Order>{
    @Override
    public OrderModel initNewModel() {
        return new OrderModel();
    }
}
