package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.User;
import hu.ulyssys.java.course.maven.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class UserCRUDMbean extends CoreCRUDMbean<User> implements Serializable {

    @Inject
    public UserCRUDMbean(UserService userService, LoggedInUserbean loggedInUserBean) {
        super(userService);
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság");
        }
    }

    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null){
                getSelectedEntity().setPasswordHash(hashPassword(getSelectedEntity().getPasswordHash()));
            }
            super.save();
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt jelszóhashelés közben", null));
            e.printStackTrace();
        }
    }

    @Override
    protected String dialogName() {
        return "userDialog";
    }

    @Override
    protected User initNewEntity() {
        return new User();
    }

    private String hashPassword(String password){
        return DigestUtils.md5Hex(password);
    }
}
