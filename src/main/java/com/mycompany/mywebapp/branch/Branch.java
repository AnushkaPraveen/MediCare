package com.mycompany.mywebapp.branch;

import javax.persistence.*;

@Entity
@Table(name = "branchers")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;

    @Column(nullable = false,length = 45)
    private String branchCode;


    @Column(nullable = false,length = 45)
    private String name;

    @Column(nullable = false,length = 45)
    private String province;

    @Column(nullable = false,length = 45)
    private String district;

    @Column(nullable = false,length = 45)
    private String phone;

    @Column(nullable = false,length = 45)
    private String address;

    @Column(nullable = false,length = 45)
    private String email;








    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "bid=" + bid +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", branchCode='" + branchCode + '\'' +

                '}';
    }
}
