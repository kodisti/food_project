package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Table(name = "foodorder")
@Entity
public class Order extends AbstractFoodCourier {
    @Column(name = "delivery_date")
    private Date deliveryDate;
    @JoinColumn(name = "courier_id")
    @ManyToOne
    private Courier courier;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Food> foodList;
    @Column(name = "settlement")
    private String settlement;
    @Column(name = "public_space")
    private String publicSpace;
    @Column(name = "public_space_nature")
    private String publicSpaceNature;
    @Column(name = "house_number")
    private String houseNumber;

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
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
