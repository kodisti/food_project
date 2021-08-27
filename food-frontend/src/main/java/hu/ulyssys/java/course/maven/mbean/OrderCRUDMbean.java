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
    private OrderService orderService;

    @Inject
    private FoodService foodService;


    private Food food;

    private List<Order> orderList;

    private List<Food> listFood;

    @Inject
    public OrderCRUDMbean(OrderService orderService, CourierService courierService, FoodService foodService, LoggedInUserbean loggedInUserbean) {
        super(orderService, courierService, foodService);
        food = new Food();
        listFood = new ArrayList<>();
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
            List<Food> lists = new ArrayList<>();
            if (getSelectedEntity().getId()==null){
                getSelectedEntity().setCreatingUser(user);
                //getSelectedEntity().setFoodList(lists);
                //getSelectedEntity().setFoodList(listFood);
            }else {
                getSelectedEntity().setLastModifiedDate(new Date());
                getSelectedEntity().setModifyingUser(user);
                //getSelectedEntity().getFoodList().addAll(listFood);
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
            //listFood.add(food);
            getSelectedEntity().getFoodList().add(getFood());
            System.out.println("FoodList: " + listFood);
            food = new Food();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Sikeres hozzáadás"));
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage( "Sikertelen hozzáadás"));
        }
    }

    public void removeList(){
        try {
            //listFood.remove(food);
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
    public Date getMinDate() {
        return new Date();
    }

    @Override
    protected String dialogName() {
        return "orderDialog";
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
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

    public List<Food> getListFood() {
        return listFood;
    }

    public void setListFood(List<Food> listFood) {
        this.listFood = listFood;
    }
}
