package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Food;
import hu.ulyssys.java.course.maven.service.FoodService;
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
public class FoodCRUDMbean extends FoodCourierCRUDMbean<Food> implements Serializable {

    @Inject
    private UserService userService;

    @Inject
    private LoggedInUserbean loggedInUserbean;

    @Inject
    public FoodCRUDMbean(FoodService service, LoggedInUserbean loggedInUserbean) {
        super(service);
        if (!loggedInUserbean.isLoggedIn()){
            List<Food> list = new ArrayList<>();
            setList(list);
        }
    }

    @Override
    public void save() {
        try {
            user = userService.findByUsername(loggedInUserbean.getModel().getUsername());
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

    @Override
    protected String dialogName() {
        return "foodDialog";
    }

    @Override
    protected Food initNewEntity() {
        return new Food();
    }
}
