package com.example.demospringboot.controller.dto;

import com.example.demospringboot.model.Address;

import java.util.List;

public class CreateUser {

    private String firstName;
    private String lastName;
    private String email;


    private List<AddressDto> addressList;

    public CreateUser() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressDto> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDto> addressList) {
        this.addressList = addressList;
    }
}
