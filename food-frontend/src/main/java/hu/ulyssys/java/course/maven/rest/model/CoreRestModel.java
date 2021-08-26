package hu.ulyssys.java.course.maven.rest.model;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.NotNull;
import java.util.Date;

public abstract class CoreRestModel {
    private Long id;
    @JsonbDateFormat("yyyy.MM.dd HH:mm:ss")
    private Date createdDate;
    @JsonbDateFormat("yyyy.MM.dd HH:mm:ss")
    private Date lastModifiedDate;
    @NotNull
    private Long creatingUserId;
    private Long modifyingUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getCreatingUserId() {
        return creatingUserId;
    }

    public void setCreatingUserId(Long creatingUserId) {
        this.creatingUserId = creatingUserId;
    }

    public Long getModifyingUserId() {
        return modifyingUserId;
    }

    public void setModifyingUserId(Long modifyingUserId) {
        this.modifyingUserId = modifyingUserId;
    }
}
