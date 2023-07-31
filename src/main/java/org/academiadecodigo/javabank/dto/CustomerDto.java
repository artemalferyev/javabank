package org.academiadecodigo.javabank.dto;

import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.persistence.model.Recipient;
import org.academiadecodigo.javabank.persistence.model.account.Account;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDto extends Customer {

    @NotNull(message = "first name is mandatory")
    @NotBlank(message = "first name is mandatory")
    @Size(min=3, max=64)
    private String firstName;

    @NotNull(message = "last name is mandatory")
    @NotBlank(message = "last name is mandatory")
    @Size(min=3, max=64)
    private String lastName;

    @Email
    private String email;

    @Pattern(regexp = "^\\+?\\d*$", message = "phone has invalid characters")
    @Size(min=9, max=16)
    private String phone;
    private List<Account> accounts = new ArrayList<>();
    private List<Recipient> recipients = new ArrayList<>();


    public CustomerDto(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
