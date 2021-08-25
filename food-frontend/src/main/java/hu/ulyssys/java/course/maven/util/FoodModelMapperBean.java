package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.rest.model.FoodModel;

public class FoodModelMapperBean extends CoreModelMapperBean<FoodModel, Food>{
    @Override
    public FoodModel initNewModel() {
        return new FoodModel();
    }
}
