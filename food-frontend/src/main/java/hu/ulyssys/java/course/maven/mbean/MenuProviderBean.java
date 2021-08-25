package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.MenuItemFood;
import hu.ulyssys.java.course.maven.service.MenuItemFoodService;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MenuProviderBean {

    @Inject
    private MenuItemFoodService service;

    @Inject
    private LoggedInUserbean loggedInUserBean;

    public MenuModel getMenuModel() {
        DefaultMenuModel menuModel = new DefaultMenuModel();
        service.getAll().forEach(menuItem -> {
            addMenuItem(menuModel, menuItem);
        });

        return menuModel;
    }

    private void addMenuItem(DefaultMenuModel menuModel, MenuItemFood item) {
        DefaultMenuItem element = new DefaultMenuItem();
        element.setHref(item.getUrl());
        element.setValue(item.getLabel());
        if (Boolean.FALSE.equals(item.getAdminFunction()) || item.getAdminFunction() == null || (Boolean.TRUE.equals(item.getAdminFunction())) && loggedInUserBean.isAdmin()) {
            menuModel.getElements().add(element);
        }
    }
}
