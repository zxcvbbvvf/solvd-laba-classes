package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"booking_id", "customer_id", "room_id", "booking_date", "check_in_date", "check_out_date", "total_price", "payment_status"})
public class Booking {
    @JsonProperty("booking_id")
    private int booking_id;

    @JsonProperty("customer_id")
    private int customer_id;

    @JsonProperty("room_id")
    private int room_id;

    @JsonProperty("booking_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date booking_date;

    @JsonProperty("check_in_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date check_in_date;

    @JsonProperty("check_out_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date check_out_date;

    @JsonProperty("total_price")
    private double total_price;

    @JsonProperty("payment_status")
    private boolean payment_status;

    public Booking() {
    }

    public Booking(int booking_id, int customer_id, int room_id, Date booking_date, Date check_in_date, Date check_out_date, double total_price, boolean payment_status) {

        this.booking_id = booking_id;

        this.customer_id = customer_id;

        this.room_id = room_id;

        this.booking_date = booking_date;

        this.check_in_date = check_in_date;

        this.check_out_date = check_out_date;

        this.total_price = total_price;

        this.payment_status = payment_status;

    }

    // Getters and Setters
    @XmlElement
    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    @XmlElement
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @XmlElement
    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    @XmlElement
    @XmlSchemaType(name = "date")
    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    @XmlElement
    @XmlSchemaType(name = "date")
    public Date getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(Date check_in_date) {
        this.check_in_date = check_in_date;
    }

    @XmlElement
    @XmlSchemaType(name = "date")
    public Date getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(Date check_out_date) {
        this.check_out_date = check_out_date;
    }

    @XmlElement
    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @XmlElement
    public boolean isPayment_status() {
        return payment_status;
    }

    public void setPayment_status(boolean payment_status) {
        this.payment_status = payment_status;
    }
}
