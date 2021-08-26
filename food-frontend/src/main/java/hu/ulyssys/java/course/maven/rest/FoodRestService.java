package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.rest.model.FoodModel;

import javax.ws.rs.Path;

@Path("/food")
public class FoodRestService extends CoreRestService<Food, FoodModel> {
    @Override
    protected Food initNewEntity() {
        return new Food();
    }
}
