package hu.ulyssys.java.course.maven.rest;

import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;
import hu.ulyssys.java.course.maven.rest.model.CoreRestModel;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.util.CoreModelMapperBean;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.stream.Collectors;

public abstract class CoreRestService<T extends AbstractFoodCourier, M extends CoreRestModel> {
    @Inject
    private CoreService<T> coreService;

    @Inject
    private CoreModelMapperBean<M, T> modelMapperBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findByID(@PathParam("id") Long id) {
        T entity = coreService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();

    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(coreService.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid M model) {

        T entity = initNewEntity();
        model.setCreatedDate(new Date());
        model.setModifyingUserId(initNewModel().getModifyingUserId());
        populateEntityFromModel(entity, model);

        coreService.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid M model) {
        T entity = coreService.findById(model.getId());
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        model.setCreatedDate(coreService.findById(model.getId()).getCreatedDate());
        populateEntityFromModel(entity, model);
        entity.setLastModifiedDate(new Date());
        entity.setCreatingUser(coreService.findById(model.getId()).getCreatingUser());
        coreService.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        T entity = coreService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        coreService.remove(entity);
        return Response.ok().build();
    }

    protected void populateEntityFromModel(T entity, M model) {
        modelMapperBean.populateEntityFromModel(entity, model);
    }

    protected M createModelFromEntity(T entity) {
        return modelMapperBean.createModelFromEntity(entity);
    }

    protected abstract T initNewEntity();

    protected M initNewModel() {
        return modelMapperBean.initNewModel();
    }
}
