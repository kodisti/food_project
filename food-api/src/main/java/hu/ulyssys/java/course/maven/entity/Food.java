package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;

@Table(name = "food")
@Entity
public class Food extends AbstractFoodCourier {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private Order foodorder;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Order getFoodorder() {
        return foodorder;
    }

    public void setFoodorder(Order foodorder) {
        this.foodorder = foodorder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (name != null ? !name.equals(food.name) : food.name != null) return false;
        if (description != null ? !description.equals(food.description) : food.description != null) return false;
        if (price != null ? !price.equals(food.price) : food.price != null) return false;
        return foodorder != null ? foodorder.equals(food.foodorder) : food.foodorder == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (foodorder != null ? foodorder.hashCode() : 0);
        return result;
    }
}
