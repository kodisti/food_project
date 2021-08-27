package hu.ulyssys.java.course.maven.rest.model;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class OrderModel extends CoreRestModel{
    @NotNull
    @Future(message = "A dátum nem lehet múltba menő")
    @JsonbDateFormat("yyyy.MM.dd HH:mm:ss")
    private Date deliveryDate;
    private Long courierId;
    //@NotEmpty(message = "Minimum egynek kell lennie")
    private List<Long> foodListId;
    @NotNull
    @Size(max = 200, message = "Maximum 200 karakter")
    private String settlement;
    @NotNull
    @Size(max = 200, message = "Maximum 200 karakter")
    private String publicSpace;
    @NotNull
    @Size(max = 200, message = "Maximum 200 karakter")
    private String publicSpaceNature;
    @NotNull
    @Size(max = 200, message = "Maximum 200 karakter")
    private String houseNumber;

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public List<Long> getFoodListId() {
        return foodListId;
    }

    public void setFoodListId(List<Long> foodListId) {
        this.foodListId = foodListId;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getPublicSpace() {
        return publicSpace;
    }

    public void setPublicSpace(String publicSpace) {
        this.publicSpace = publicSpace;
    }

    public String getPublicSpaceNature() {
        return publicSpaceNature;
    }

    public void setPublicSpaceNature(String publicSpaceNature) {
        this.publicSpaceNature = publicSpaceNature;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

}
