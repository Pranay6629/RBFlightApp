package com.monu.rbflightapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.monu.rbflightapp.FlightDetailsActivity;
import com.monu.rbflightapp.R;
import com.monu.rbflightapp.pojo.RoasterPojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RoasterAdapter extends RecyclerView.Adapter<RoasterAdapter.RoasterHolder> {

    Context context;
    List<RoasterPojo> roasterPojos;

    public RoasterAdapter(Context context, List<RoasterPojo> roasterPojos) {
        this.context = context;
        this.roasterPojos = roasterPojos;
    }

    @NonNull
    @Override
    public RoasterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View ietm = layoutInflater.inflate(R.layout.list_item, parent,false);
        RoasterHolder holder = new RoasterHolder(ietm);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RoasterHolder holder, int position) {
        final RoasterPojo pojo = roasterPojos.get(position);
        String date = pojo.getDate();
        SimpleDateFormat dateFormatprev = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d = dateFormatprev.parse(date);
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd. yyyy");
            String changeDate = dateFormat.format(d);
            System.out.println("New date is" + changeDate);
            holder.flightDate.setText(changeDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        SimpleDateFormat dateFormatprev = new SimpleDateFormat("yyyy-MM-dd");
//        Date d = dateFormatprev.parse(deliveryDate);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd MMM yyyy");
//        String changedDate = dateFormat.format(d);


        holder.flightName.setText(pojo.getDeparture() + " - " + pojo.getDestination());
        holder.flightTime.setText(pojo.getTime_Depart() + " - " + pojo.getTime_Arrive());
        holder.flightTime.setTextColor(Color.parseColor("#FF0000"));
        System.out.println(pojo.getDate());
        holder.realPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FlightDetailsActivity.class);

                intent.putExtra("flightnr", pojo.getFlightnr());
                intent.putExtra("date", pojo.getDate());
                intent.putExtra("AircraftType", pojo.getAircraft_Type());
                intent.putExtra("tail", pojo.getTail());
                intent.putExtra("departure",pojo.getDeparture());
                intent.putExtra("destination", pojo.getDestination());
                intent.putExtra("time_Depart", pojo.getTime_Depart());
                intent.putExtra("time_Arrive", pojo.getTime_Arrive());
                intent.putExtra("dutyID", pojo.getDutyID());
                intent.putExtra("dutyCode", pojo.getDutyCode());
                intent.putExtra("captain", pojo.getCaptain());
                intent.putExtra("firstOfficer", pojo.getFirst_Officer());
                intent.putExtra("flightAttendant", pojo.getFlight_Attendant());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return roasterPojos.size();
    }

    public class RoasterHolder extends RecyclerView.ViewHolder {

        public TextView flightDate, flightName, flightTime;
        public RelativeLayout realPanel;
        public RoasterHolder(@NonNull View itemView) {
            super(itemView);
            flightDate = itemView.findViewById(R.id.flightdate);
            flightName = itemView.findViewById(R.id.flightname);
            flightTime = itemView.findViewById(R.id.flighttime);
            realPanel = itemView.findViewById(R.id.realPanel);

        }
    }
}
