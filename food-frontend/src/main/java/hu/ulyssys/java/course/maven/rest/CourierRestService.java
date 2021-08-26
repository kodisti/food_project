package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.rest.model.CourierModel;

import javax.ws.rs.Path;

@Path("/courier")
public class CourierRestService extends CoreRestService<Courier, CourierModel> {
    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
