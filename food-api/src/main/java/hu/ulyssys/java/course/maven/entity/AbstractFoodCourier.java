package hu.ulyssys.java.course.maven.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractFoodCourier extends AbstractEntity{
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @JoinColumn(name = "creating_user_id")
    @ManyToOne
    private User creatingUser;

    @JoinColumn(name = "modifying_user_id")
    @ManyToOne
    private User modifyingUser;


    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public User getCreatingUser() {
        return creatingUser;
    }

    public void setCreatingUser(User creatingUser) {
        this.creatingUser = creatingUser;
    }

    public User getModifyingUser() {
        return modifyingUser;
    }

    public void setModifyingUser(User modifyingUser) {
        this.modifyingUser = modifyingUser;
    }
}
