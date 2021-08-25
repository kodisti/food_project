package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class CourierCRUDMbean extends FoodCourierCRUDMbean<Courier> implements Serializable {

    @Inject
    private UserService userService;

    @Inject
    private LoggedInUserbean loggedInUserbean;

    @Inject
    public CourierCRUDMbean(CourierService service, LoggedInUserbean loggedInUserbean) {
        super(service);
        if (!loggedInUserbean.isAdmin()){
            throw new SecurityException("Nincs elég jogosultság");
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
        return "courierDialog";
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
