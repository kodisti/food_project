package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.rest.model.CourierModel;

public class CourierModelMapperBean extends CoreModelMapperBean<CourierModel, Courier>{

    @Override
    public CourierModel createModelFromEntity(Courier entity) {
        super.createModelFromEntity(entity);
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setPhoneNumber(entity.getPhoneNumber());
        return model;
    }

    @Override
    public void populateEntityFromModel(Courier entity, CourierModel model){
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setPhoneNumber(model.getPhoneNumber());
        super.populateEntityFromModel(entity, model);
    }

    @Override
    public CourierModel initNewModel() {
        return new CourierModel();
    }
}
