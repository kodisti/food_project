package hu.ulyssys.java.course.maven.rest.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class OrderModel extends CoreRestModel{
    private Long courierId;
    @NotEmpty
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
}
