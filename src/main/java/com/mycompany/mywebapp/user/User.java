package com.mycompany.mywebapp.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 45)
    private String email;


    @Column(length = 45,nullable = false,name = "first_name")
    private String firstName;

    @Column(length = 45,nullable = false,name = "last_name")
    private String lastName;

    @Column(length = 25,nullable = false,name = "nic")
    private Integer nic;

    @Column(length = 25,name = "phone")
    private String phone;

    @Column(length = 25,name = "address")
    private String address;

    @Column(length = 25,name = "gender")
    private String gender;

    @Column(length = 25,nullable = false,name = "insurance_type")
    private String insuranceType;

    @Column(length = 25,nullable = false,name = "insurance_value")
    private Double insuranceValue;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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



    public Integer getNIC() {
        return nic;
    }

    public void setNIC(Integer nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Double getInsuranceValue() {
        return insuranceValue;
    }

    public void setInsuranceValue(Double insuranceValue) {
        this.insuranceValue = insuranceValue;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nic='" + nic + '\'' +

                '}';
    }


}
