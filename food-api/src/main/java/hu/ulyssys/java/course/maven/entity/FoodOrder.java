package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "foods_orders")
@Entity
public class FoodOrder extends AbstractEntity implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order orderId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private Food foodId;

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Food getFoodId() {
        return foodId;
    }

    public void setFoodId(Food foodId) {
        this.foodId = foodId;
    }
}
