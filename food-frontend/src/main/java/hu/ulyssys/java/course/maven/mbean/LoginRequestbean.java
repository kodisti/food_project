package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.User;
import hu.ulyssys.java.course.maven.mbean.model.LoggedInUserModel;
import hu.ulyssys.java.course.maven.mbean.model.LoginModel;
import hu.ulyssys.java.course.maven.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.PrimeFaces;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Named
@RequestScoped
public class LoginRequestbean {
    private LoginModel model = new LoginModel();

    @Inject
    private LoggedInUserbean bean;

    @Inject
    private UserService userService;

    public void doLogin() {

        try {
            //Ha sikeres a login
            User user = userService.findByUsername(model.getUsername());
            if (user == null) {
                throw new SecurityException("Nem létező felhasználó");
            }
            String hashedPassword = DigestUtils.md5Hex(model.getPassword());
            if (!hashedPassword.equals(user.getPasswordHash())) {
                throw new SecurityException("Nem megfelelő jelszó");

            }
            LoggedInUserModel loggedInUserModel = new LoggedInUserModel();
            loggedInUserModel.setUsername(user.getUsername());
            loggedInUserModel.setId(user.getId());
            loggedInUserModel.setRole(user.getRole());
            bean.setModel(loggedInUserModel);
            PrimeFaces.current().executeScript("PF('loginDialog').hide()");
            //Akkor  sessionbe beállítjuk a usert reprezentáló modelt.
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen bejelentkezés", ""));
        }
    }

    public void doLogout() {
        bean.setModel(null);
    }

    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }
}
