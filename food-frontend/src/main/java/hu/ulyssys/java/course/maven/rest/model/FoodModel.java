package hu.ulyssys.java.course.maven.rest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FoodModel extends CoreRestModel{
    @NotNull
    @Size(max = 200, message = "Maximum 200 karakter")
    private String name;
    @NotNull
    @Size(max = 500, message = "Maximum 500 karakter")
    private String description;
    @NotNull
    private Integer price;

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
}
