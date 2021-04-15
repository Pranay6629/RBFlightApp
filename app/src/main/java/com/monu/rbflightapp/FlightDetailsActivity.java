package com.monu.rbflightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightDetailsActivity extends AppCompatActivity {
    private TextView flightnr, date, aircraftType, tail, departure, destination, time_Depart, time_Arrive, dutyID, dutyCode, captain, firstOfficer, flightAttendant;
    String flightnrTV, dateTV, aircraftTypeTV, tailTV, departureTV, destinationTV, time_DepartTV, time_ArriveTV, dutyIDTV, dutyCodeTV, captaitTV, firstOfficeTV, flightAttendantTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        flightnr = findViewById(R.id.flightnrTV);
        date = findViewById(R.id.dateTV);
        aircraftType = findViewById(R.id.aircraftTypeTV);
        tail = findViewById(R.id.tailTV);
        departure = findViewById(R.id.departureTV);
        destination = findViewById(R.id.destinationTV);
        time_Depart = findViewById(R.id.time_DepartTV);
        time_Arrive = findViewById(R.id.time_ArriveTV);
        dutyID = findViewById(R.id.dutyIDTV);
        dutyCode = findViewById(R.id.dutyCodeTV);
        captain = findViewById(R.id.captainTV);
        firstOfficer = findViewById(R.id.firstOfficerTV);
        flightAttendant = findViewById(R.id.flightAttendantTV);

        flightnrTV= getIntent().getStringExtra("flightnr");
        dateTV= getIntent().getStringExtra("date");
        aircraftTypeTV= getIntent().getStringExtra("AircraftType");
        tailTV= getIntent().getStringExtra("tail");
        departureTV=getIntent().getStringExtra("departure");
        destinationTV=getIntent().getStringExtra("destination");
        time_DepartTV=getIntent().getStringExtra("time_Depart");
        time_ArriveTV=getIntent().getStringExtra("time_Arrive");
        dutyIDTV=getIntent().getStringExtra("dutyID");
        dutyCodeTV=getIntent().getStringExtra("dutyCode");
        captaitTV=getIntent().getStringExtra("captain");
        firstOfficeTV=getIntent().getStringExtra("firstOfficer");
        flightAttendantTV=getIntent().getStringExtra("flightAttendant");

        String dates = dateTV;
        SimpleDateFormat dateFormatprev = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = dateFormatprev.parse(dates);
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd. yyyy");
            String changeDate = dateFormat.format(d);
            System.out.println("New date is" + changeDate);
            date.setText(changeDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        flightnr.setText(flightnrTV);
        aircraftType.setText(aircraftTypeTV);
        tail.setText(tailTV);
        departure.setText(departureTV);
        destination.setText(destinationTV);
        time_Depart.setText(time_DepartTV);
        time_Arrive.setText(time_ArriveTV);
        dutyID.setText(dutyIDTV);
        dutyCode.setText(dutyCodeTV);
        captain.setText(captaitTV);
        firstOfficer.setText(firstOfficeTV);
        flightAttendant.setText(flightAttendantTV);

    }
}