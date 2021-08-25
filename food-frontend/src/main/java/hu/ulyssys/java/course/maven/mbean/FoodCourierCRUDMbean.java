package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;
import hu.ulyssys.java.course.maven.service.FoodCourierService;

import java.io.Serializable;

public abstract class FoodCourierCRUDMbean<T extends AbstractFoodCourier> extends CoreCRUDMbean<T> implements Serializable {

    public FoodCourierCRUDMbean(FoodCourierService<T> service) {
        super(service);
    }


}
