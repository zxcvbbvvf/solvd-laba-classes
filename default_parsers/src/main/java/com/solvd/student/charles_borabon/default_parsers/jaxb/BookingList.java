package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "bookings")
@XmlType(propOrder = {"booking_id", "customer_id", "room_id", "booking_date", "check_in_date", "check_out_date", "total_price", "payment_status"})
public class BookingList {

    private List<Booking> bookings;

    @XmlElement(name = "booking")
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}

@XmlType(propOrder = {"booking_id", "customer_id", "room_id", "booking_date", "check_in_date", "check_out_date", "total_price", "payment_status"})
class Booking {
    private int booking_id;
    private int customer_id;
    private int room_id;
    private String booking_date;
    private String check_in_date;
    private String check_out_date;
    private double total_price;
    private boolean payment_status;

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
    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    @XmlElement
    public String getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }

    @XmlElement
    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
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