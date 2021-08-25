package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.MenuItemFoodDAO;
import hu.ulyssys.java.course.maven.entity.MenuItemFood;

import javax.ejb.Stateless;

@Stateless
public class MenuItemFoodDAOImpl extends AbstractCoreDAOImpl<MenuItemFood> implements MenuItemFoodDAO {
    @Override
    protected Class<MenuItemFood> getManagedClass() {
        return MenuItemFood.class;
    }
}
