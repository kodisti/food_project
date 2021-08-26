package hu.ulyssys.java.course.maven.util;

import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.rest.model.OrderModel;
import hu.ulyssys.java.course.maven.service.CourierService;

import javax.inject.Inject;

public class OrderModelMapperBean extends CoreModelMapperBean<OrderModel, Order>{

    @Inject
    private CourierService courierService;

    @Override
    public OrderModel createModelFromEntity(Order entity) {
        super.createModelFromEntity(entity);
        model.setDeliveryDate(entity.getDeliveryDate());
        if (entity.getCourier() != null){
            model.setCourierId(entity.getCourier().getId());
        }
        //model.setFoodListId(entity.getFoodList());
        model.setSettlement(entity.getSettlement());
        model.setPublicSpace(entity.getPublicSpace());
        model.setPublicSpaceNature(entity.getPublicSpaceNature());
        model.setHouseNumber(entity.getHouseNumber());
        return model;
    }

    @Override
    public void populateEntityFromModel(Order entity, OrderModel model){
        entity.setDeliveryDate(model.getDeliveryDate());
        if (model.getCourierId() != null){
            entity.setCourier(courierService.findById(model.getCourierId()));
        }
        //entity.setFoodList(model.getFoodListId());
        entity.setSettlement(model.getSettlement());
        entity.setPublicSpace(model.getPublicSpace());
        entity.setPublicSpaceNature(model.getPublicSpaceNature());
        entity.setHouseNumber(model.getHouseNumber());
        super.populateEntityFromModel(entity, model);
    }

    @Override
    public OrderModel initNewModel() {
        return new OrderModel();
    }
}
