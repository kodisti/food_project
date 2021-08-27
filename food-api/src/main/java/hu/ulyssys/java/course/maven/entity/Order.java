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
    @ManyToMany(fetch = FetchType.EAGER)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (deliveryDate != null ? !deliveryDate.equals(order.deliveryDate) : order.deliveryDate != null) return false;
        if (courier != null ? !courier.equals(order.courier) : order.courier != null) return false;
        if (foodList != null ? !foodList.equals(order.foodList) : order.foodList != null) return false;
        if (settlement != null ? !settlement.equals(order.settlement) : order.settlement != null) return false;
        if (publicSpace != null ? !publicSpace.equals(order.publicSpace) : order.publicSpace != null) return false;
        if (publicSpaceNature != null ? !publicSpaceNature.equals(order.publicSpaceNature) : order.publicSpaceNature != null)
            return false;
        return houseNumber != null ? houseNumber.equals(order.houseNumber) : order.houseNumber == null;
    }

    @Override
    public int hashCode() {
        int result = deliveryDate != null ? deliveryDate.hashCode() : 0;
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        result = 31 * result + (foodList != null ? foodList.hashCode() : 0);
        result = 31 * result + (settlement != null ? settlement.hashCode() : 0);
        result = 31 * result + (publicSpace != null ? publicSpace.hashCode() : 0);
        result = 31 * result + (publicSpaceNature != null ? publicSpaceNature.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        return result;
    }
}
