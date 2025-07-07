package com.example.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "reader", namespace = "http://example.com/service")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReaderDTO {
    @XmlElement(namespace = "http://example.com/service")
    private String name;

    @XmlElement(namespace = "http://example.com/service")
    private String email;

    @XmlElement(namespace = "http://example.com/service")
    private String phone;

    public ReaderDTO(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public ReaderDTO(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}