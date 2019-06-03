package com.medical.models;

public class MedicalClinic {
    Long id;
    private String city;
    private int district;
    private String streetName;
    private String streetNumber;

    public MedicalClinic(){}

    public MedicalClinic(Long id, String city, int district, String streetName, String streetNumber) {
        this.id = id;
        this.city = city;
        this.district = district;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return "MedicalClinic{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", district=" + district +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
