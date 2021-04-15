package com.monu.rbflightapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.monu.rbflightapp.adapter.RoasterAdapter;
import com.monu.rbflightapp.dao.RoasterDao;
import com.monu.rbflightapp.database.DatabaseClient;
import com.monu.rbflightapp.entitty.Roaster;
import com.monu.rbflightapp.pojo.RoasterPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static String FETCHURL = "https://rosterbuster.aero/wp-content/uploads/dummy-response.json";
    private RecyclerView recyclerview;
    List<RoasterPojo> roasetr;
    private ArrayList<RoasterPojo> arrayList;
    private RoasterAdapter roasterAdapter;
    private RoasterDao roasterDao;
    private ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        recyclerview = findViewById(R.id.recyclerview);
        arrayList = new ArrayList<>();
//        roasterAdapter = new RoasterAdapter(this, arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setNestedScrollingEnabled(false);
//        recyclerview.setAdapter(roasterAdapter);

        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting() && arrayList != null) {
            fetchfromServer();
        } else {


            fetchfromRoom();
        }

        swipeRefreshLayout = findViewById(R.id.refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        if (networkInfo != null && networkInfo.isConnectedOrConnecting() && arrayList != null) {
            fetchfromServer();
            swipeRefreshLayout.setRefreshing(false);
        } else {
            fetchfromRoom();
            Toast.makeText(MainActivity.this, "No Network is available", Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    private void fetchfromRoom() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Roaster> roasterList = DatabaseClient.getInstance(MainActivity.this).getRoasterDatabase().roasterDao().getAll();
                arrayList.clear();
                for (Roaster roaster : roasterList){
                    RoasterPojo pojo = new RoasterPojo(roaster.getFlightnr(),
                            roaster.getDate(),
                            roaster.getAircraft_Type(),
                            roaster.getTail(),
                            roaster.getDeparture(),
                            roaster.getDestination(),
                            roaster.getTime_Depart(),
                            roaster.getTime_Arrive(),
                            roaster.getDutyID(),
                            roaster.getDutyCode(),
                            roaster.getCaptain(),
                            roaster.getFirst_Officer(),
                            roaster.getFlight_Attendant());

                    arrayList.add(pojo);

                }
//                roasterAdapter = new RoasterAdapter(getApplicationContext(), arrayList);
//                recyclerview.setAdapter(roasterAdapter);
                // refreshing recycler view
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        roasterAdapter.notifyDataSetChanged();
                    }
                });

            }
        });
        thread.start();
    }

    private void fetchfromServer() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, FETCHURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("Response is ====>" + response.toString());

                try {
                    JSONArray array = new JSONArray(response);

                    for (int i = 0; i < array.length(); i++) {
                        JSONObject o = array.getJSONObject(i);
                        RoasterPojo pojo = new RoasterPojo(
                                o.getString("Flightnr"),
                                o.getString("Date"),
                                o.getString("Aircraft Type"),
                                o.getString("Tail"),
                                o.getString("Departure"),
                                o.getString("Destination"),
                                o.getString("Time_Depart"),
                                o.getString("Time_Arrive"),
                                o.getString("DutyID"),
                                o.getString("DutyCode"),
                                o.getString("Captain"),
                                o.getString("First Officer"),
                                o.getString("Flight Attendant")
                        );
                        arrayList.add(pojo);
                    }
                    roasterAdapter = new RoasterAdapter(getApplicationContext(), arrayList);
                    recyclerview.setAdapter(roasterAdapter);
                    progressBar.setVisibility(View.GONE);
                    //saveTask();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(FETCHURL, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                System.out.println("response is :"+response.toString());
//                roasetr = new ArrayList<RoasterPojo>();
//                if (response == null) {
//                    Toast.makeText(getApplicationContext(), "Couldn't fetch the menu! Pleas try again.", Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//
//                roasetr = new Gson().fromJson(response.toString(), new TypeToken<List<RoasterPojo>>() {
//                }.getType());
//                //arrayList.clear();
//                saveTask();
//                arrayList.addAll(roasetr);
//                roasterAdapter = new RoasterAdapter(getApplicationContext(), arrayList);
//
//                //roasterAdapter.notifyDataSetChanged();
//
//                recyclerview.setAdapter(roasterAdapter);
//
//
//
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("TAG", "Error: " + error.getMessage());
//                Toast.makeText(getApplicationContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        jsonArrayRequest.setShouldCache(false);
//
//        requestQueue.add(jsonArrayRequest);
//    }
//
//        private void saveTask () {
//            class SaveTask extends AsyncTask<Void, Void, Void> {
//
//                @Override
//                protected Void doInBackground(Void... voids) {
//                    for (int i = 0; i < roasetr.size(); i++) {
//                        Roaster roaster = new Roaster();
//                        roaster.setFlightnr(roasetr.get(i).getFlightnr());
//                        roaster.setDate(roasetr.get(i).getDate());
//                        roaster.setAircraft_Type(roasetr.get(i).getAircraft_Type());
//                        roaster.setTail(roasetr.get(i).getTail());
//                        roaster.setDeparture(roasetr.get(i).getDeparture());
//                        roaster.setDestination(roasetr.get(i).getDestination());
//                        roaster.setTime_Depart(roasetr.get(i).getTime_Depart());
//                        roaster.setTime_Arrive(roasetr.get(i).getTime_Arrive());
//                        roaster.setDutyID(roasetr.get(i).getDutyID());
//                        roaster.setDutyCode(roasetr.get(i).getDutyCode());
//                        roaster.setCaptain(roasetr.get(i).getCaptain());
//                        roaster.setFirst_Officer(roasetr.get(i).getFirst_Officer());
//                        roaster.setFlight_Attendant(roasetr.get(i).getFlight_Attendant());
//                    }
//                    return null;
//                }
//
//                @Override
//                protected void onPostExecute(Void aVoid) {
//                    super.onPostExecute(aVoid);
//                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
//                }
//            }
//            SaveTask st = new SaveTask();
//            st.execute();
//        }

    }

}