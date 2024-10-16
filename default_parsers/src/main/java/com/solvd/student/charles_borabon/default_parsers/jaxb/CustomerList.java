package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "customers")
@XmlType(propOrder = {"customers"})
public class CustomerList {
    @JsonProperty("customers")
    private List<Customer> customers;

    @XmlElement(name = "customer")
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}