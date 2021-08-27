package hu.ulyssys.java.course.maven.rest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CourierModel extends CoreRestModel{
    @NotNull
    @Size(max = 500, message = "Maximum 500 karakter")
    private String firstName;
    @NotNull
    @Size(max = 500, message = "Maximum 500 karakter")
    private String lastName;
    @NotNull
    @Pattern(regexp = "^([+]{1}[3]{1}[6]{1}[/]{1}[\\d]{2}[ ]{1}[\\d]{3}[-]{1}[\\d]{4}+)?$", message = "+36/70 701-8674 alakban kell megadni a telefonszámot")
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
