package hu.ulyssys.java.course.maven.rest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CourierModel extends CoreRestModel{
    @NotNull
    @Size(max = 500, message = "Maximum 500 karakter")
    private String firstName;
    @NotNull
    @Size(max = 500, message = "Maximum 500 karakter")
    private String lastName;
    @NotNull
    @Size(min = 12,max = 12, message = "Maximum 12 karakter, melynek +36dddddddd alakban kell lenni")
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
