package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.rest.model.OrderModel;

import javax.ws.rs.Path;

@Path("/order")
public class OrderRestService extends CoreRestService<Order, OrderModel> {
    @Override
    protected Order initNewEntity() {
        return new Order();
    }
}
