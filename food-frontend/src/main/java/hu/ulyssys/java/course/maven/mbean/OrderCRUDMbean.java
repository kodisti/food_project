package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.service.FoodService;
import hu.ulyssys.java.course.maven.service.OrderService;
import hu.ulyssys.java.course.maven.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class OrderCRUDMbean extends CourierAwareCRUDMbean<Order> implements Serializable {

    @Inject
    private UserService userService;

    @Inject
    private LoggedInUserbean loggedInUserbean;

    @Inject
    private FoodService foodService;

    @Inject
    private OrderService orderService;


    private Food food;

    private List<Food> foods;

    @Inject
    public OrderCRUDMbean(OrderService service, CourierService courierService, FoodService foodService, LoggedInUserbean loggedInUserbean) {
        super(service, courierService, foodService);
        foods = new ArrayList<>();
        food = new Food();
        if (!loggedInUserbean.isLoggedIn()){
            List<Order> list = new ArrayList<>();
            setList(list);
        }
    }

    @Override
    public void save() {
        try {
            user = userService.findByUsername(loggedInUserbean.getModel().getUsername());
            getSelectedEntity().setFoodList(foods);
            foods = new ArrayList<>();
            if (getSelectedEntity().getId()==null){
                getSelectedEntity().setCreatingUser(user);
            }else {
                getSelectedEntity().setLastModifiedDate(new Date());
                getSelectedEntity().setModifyingUser(user);
            }
            super.save();
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen művelet", null));
        }
    }

    public void addList(){
        try {
            foods.add(getFood());
            food = new Food();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Sikeres hozzáadás"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Sikertelen hozzáadás"));
        }
    }

    public void removeList(){
        try {
            foods.remove(getFood());
            food = new Food();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres eltávolítás"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Sikertelen eltávolítás"));
        }
    }

    @Override
    protected String dialogName() {
        return "orderDialog";
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
