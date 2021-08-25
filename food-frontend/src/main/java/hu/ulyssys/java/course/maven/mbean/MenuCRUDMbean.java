package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.MenuItemFood;
import hu.ulyssys.java.course.maven.service.MenuItemFoodService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class MenuCRUDMbean extends CoreCRUDMbean<MenuItemFood> implements Serializable {


    @Inject
    public MenuCRUDMbean(MenuItemFoodService menuItemFoodService, LoggedInUserbean loggedInUserBean) {
        super(menuItemFoodService);
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság");
        }
    }


    @Override
    protected String dialogName() {
        return "menuDialog";
    }

    @Override
    protected MenuItemFood initNewEntity() {
        return new MenuItemFood();
    }
}
