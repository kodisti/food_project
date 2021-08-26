package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.rest.model.FoodModel;

public class FoodModelMapperBean extends CoreModelMapperBean<FoodModel, Food>{

    @Override
    public FoodModel createModelFromEntity(Food entity) {
        super.createModelFromEntity(entity);
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setPrice(entity.getPrice());
        return model;
    }

    @Override
    public void populateEntityFromModel(Food entity, FoodModel model){
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setPrice(model.getPrice());
        super.populateEntityFromModel(entity, model);
    }

    @Override
    public FoodModel initNewModel() {
        return new FoodModel();
    }
}
