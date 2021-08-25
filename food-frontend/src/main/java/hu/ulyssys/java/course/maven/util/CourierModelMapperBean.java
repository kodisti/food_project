package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.rest.model.CourierModel;

public class CourierModelMapperBean extends CoreModelMapperBean<CourierModel, Courier>{
    @Override
    public CourierModel initNewModel() {
        return new CourierModel();
    }
}
