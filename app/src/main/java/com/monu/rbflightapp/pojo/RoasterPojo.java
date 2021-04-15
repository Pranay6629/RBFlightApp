package com.monu.rbflightapp.pojo;

public class RoasterPojo {
    String flightnr;
    String date;
    String aircraft_Type;
    String tail;
    String departure;
    String destination;
    String time_Depart;
    String time_Arrive;
    String dutyID;
    String dutyCode;
    String captain;
    String first_Officer;
    String flight_Attendant;


    public RoasterPojo(String flightnr, String date, String aircraft_Type, String tail, String departure, String destination, String time_Depart, String time_Arrive, String dutyID, String dutyCode, String captain, String first_Officer, String flight_Attendant) {
        this.flightnr = flightnr;
        this.date = date;
        this.aircraft_Type = aircraft_Type;
        this.tail = tail;
        this.departure = departure;
        this.destination = destination;
        this.time_Depart = time_Depart;
        this.time_Arrive = time_Arrive;
        this.dutyID = dutyID;
        this.dutyCode = dutyCode;
        this.captain = captain;
        this.first_Officer = first_Officer;
        this.flight_Attendant = flight_Attendant;
    }

    public String getFlightnr() {
        return flightnr;
    }

    public void setFlightnr(String flightnr) {
        this.flightnr = flightnr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAircraft_Type() {
        return aircraft_Type;
    }

    public void setAircraft_Type(String aircraft_Type) {
        this.aircraft_Type = aircraft_Type;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime_Depart() {
        return time_Depart;
    }

    public void setTime_Depart(String time_Depart) {
        this.time_Depart = time_Depart;
    }

    public String getTime_Arrive() {
        return time_Arrive;
    }

    public void setTime_Arrive(String time_Arrive) {
        this.time_Arrive = time_Arrive;
    }

    public String getDutyID() {
        return dutyID;
    }

    public void setDutyID(String dutyID) {
        this.dutyID = dutyID;
    }

    public String getDutyCode() {
        return dutyCode;
    }

    public void setDutyCode(String dutyCode) {
        this.dutyCode = dutyCode;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getFirst_Officer() {
        return first_Officer;
    }

    public void setFirst_Officer(String first_Officer) {
        this.first_Officer = first_Officer;
    }

    public String getFlight_Attendant() {
        return flight_Attendant;
    }

    public void setFlight_Attendant(String flight_Attendant) {
        this.flight_Attendant = flight_Attendant;
    }
}
