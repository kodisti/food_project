package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.entity.FoodOrder;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.service.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named
@ViewScoped
public class OrderCRUDMbean extends CourierAwareCRUDMbean<Order> implements Serializable {

    @Inject
    private UserService userService;

    @Inject
    private LoggedInUserbean loggedInUserbean;

    @Inject
    private OrderService orderService;

    @Inject
    private FoodService foodService;

    @Inject
    private FoodOrderService foodOrderService;


    private List<Food> foods;

    private Food food;

    private List<Order> orderList;

    private List<FoodOrder> foodOrderList;

    @Inject
    public OrderCRUDMbean(OrderService orderService, CourierService courierService, FoodService foodService, FoodOrderService foodOrderService, LoggedInUserbean loggedInUserbean) {
        super(orderService, courierService, foodService);
        food = new Food();
        setFoods(foodService.getAll());
        //getListByUserRole();
        orderList = new ArrayList<>();
        if (!loggedInUserbean.isLoggedIn()){
            setList(orderList);
        }else if (loggedInUserbean.isLoggedIn() && !loggedInUserbean.isAdmin()){
            orderList.addAll(orderService.getAllByCreatingUserId(loggedInUserbean.getModel().getId()));
            setList(orderList);
        }
    }

    @Override
    public void save() {
        try {
            user = userService.findByUsername(loggedInUserbean.getModel().getUsername());
            /*setFoodOrderList(foodOrderService.findAllByOrderId(getSelectedEntity().getId()));
            for (FoodOrder foodOrder: foodOrderList) {
                getSelectedEntity().getFoodList().add(foodService.findById(foodOrder.getFoodId().getId()));
            }*/
            if (getSelectedEntity().getId()==null){
                getSelectedEntity().setCreatingUser(user);
                //getSelectedEntity().setFoodList(foods);
            }else {
                getSelectedEntity().setLastModifiedDate(new Date());
                getSelectedEntity().setModifyingUser(user);
                //getSelectedEntity().setFoodList(foods);
            }
            super.save();
            getListByUserRole();
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen művelet", null));
        }
    }

    @Override
    public void remove(){
        super.remove();
        getListByUserRole();
    }

    public void addList(){
        try {
            getSelectedEntity().getFoodList().add(getFood());
            System.out.println("FoodList: " + getFoodList());
            food = new Food();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Sikeres hozzáadás"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Sikertelen hozzáadás"));
        }
    }

    public void removeList(){
        try {
            getSelectedEntity().getFoodList().remove(getFood());
            food = new Food();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres eltávolítás"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Sikertelen eltávolítás"));
        }
    }

    public void getListByUserRole(){
        orderList = new ArrayList<>();
        if (!loggedInUserbean.isLoggedIn()){
            setList(orderList);
        }else if (loggedInUserbean.isLoggedIn() && !loggedInUserbean.isAdmin()){
            orderList.addAll(orderService.getAllByCreatingUserId(loggedInUserbean.getModel().getId()));
            setList(orderList);
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<FoodOrder> getFoodOrderList() {
        return foodOrderList;
    }

    public void setFoodOrderList(List<FoodOrder> foodOrderList) {
        this.foodOrderList = foodOrderList;
    }
}
