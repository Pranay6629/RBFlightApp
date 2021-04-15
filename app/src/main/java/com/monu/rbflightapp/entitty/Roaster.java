package com.monu.rbflightapp.entitty;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "task")
public class Roaster implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "flightnr")
    String flightnr;

    @ColumnInfo(name = "date")
    String date;

    @ColumnInfo(name = "aircraft_Type")
    String aircraft_Type;

    @ColumnInfo(name = "tail")
    String tail;

    @ColumnInfo(name = "departure")
    String departure;

    @ColumnInfo(name = "destination")
    String destination;

    @ColumnInfo(name = "time_Depart")
    String time_Depart;

    @ColumnInfo(name = "time_Arrive")
    String time_Arrive;

    @ColumnInfo(name = "dutyID")
    String dutyID;

    @ColumnInfo(name = "dutyCode")
    String dutyCode;

    @ColumnInfo(name = "captain")
    String captain;

    @ColumnInfo(name = "first_Officer")
    String first_Officer;

    @ColumnInfo(name = "flight_Attendant")
    String flight_Attendant;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
