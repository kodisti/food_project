package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.AbstractFoodCourier;
import hu.ulyssys.java.course.maven.rest.model.CoreRestModel;
import hu.ulyssys.java.course.maven.service.UserService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CoreModelMapperBean<M extends CoreRestModel, T extends AbstractFoodCourier> {

    @Inject
    private UserService userService;

    protected M model;

    public M createModelFromEntity(T entity) {
        model = initNewModel();
        model.setId(entity.getId());
        model.setCreatedDate(entity.getCreatedDate());
        model.setLastModifiedDate(entity.getLastModifiedDate());
        if (entity.getCreatingUser() != null){
            model.setCreatingUserId(entity.getCreatingUser().getId());
        }
        if (entity.getModifyingUser() != null){
            model.setModifyingUserId(entity.getModifyingUser().getId());
        }
        return model;
    }

    public List<M> createModelsFromList(List<T> entity) {
        return entity.stream().map(this::createModelFromEntity).collect(Collectors.toList());
    }

    public void populateEntityFromModel(T entity, M model) {
        if (model.getCreatingUserId() != null) {
            entity.setCreatingUser(userService.findById(model.getCreatingUserId()));
        }
        if (model.getModifyingUserId() != null) {
            entity.setModifyingUser(userService.findById(model.getModifyingUserId()));
        }
        entity.setCreatedDate(model.getCreatedDate());
        entity.setLastModifiedDate(model.getLastModifiedDate());
    }

    public abstract M initNewModel();

}
