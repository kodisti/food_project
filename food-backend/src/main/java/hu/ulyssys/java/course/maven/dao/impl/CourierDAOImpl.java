package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.CourierDAO;
import hu.ulyssys.java.course.maven.entity.Courier;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CourierDAOImpl extends AbstractFoodCourierDAOImpl<Courier> implements CourierDAO {
    @Override
    protected Class<Courier> getManagedClass() {
        return Courier.class;
    }

    @Override
    public Courier findByName(String name) {
        String[] names = name.split(" ");
        TypedQuery<Courier> query = entityManager.createQuery("select c from Courier c where (c.lastName=:lastName and c.firstName=:firstName)", Courier.class);
        query.setParameter("lastName", names[0]);
        query.setParameter("firstName", names[1]);
        List<Courier> courierList = query.getResultList();
        if (courierList.isEmpty()){
            return null;
        }
        return courierList.get(0);
    }
}
