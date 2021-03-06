package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;
import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.service.FoodCourierService;
import hu.ulyssys.java.course.maven.service.FoodService;

import java.util.List;

public abstract class CourierAwareCRUDMbean<T extends AbstractFoodCourier> extends FoodCourierCRUDMbean<T>{

    private List<Courier> courierList;
    private List<Food> foods;

    public CourierAwareCRUDMbean(FoodCourierService<T> service, CourierService courierService, FoodService foodService) {
        super(service);
        courierList = courierService.getAll();
        foods = foodService.getAll();
    }

    public List<Courier> getCourierList() {
        return courierList;
    }

    public void setCourierList(List<Courier> courierList) {
        this.courierList = courierList;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
