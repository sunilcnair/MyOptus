package com.example.com.myoptus;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Scenario2Activity extends AppCompatActivity {

    private Button b1;
    private Spinner s1;
  //  private String display;
    ArrayList<MyLocations> locList = new ArrayList<>();
    MyLocations selectedLoc;
    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario2);
        b1=(Button)findViewById(R.id.navbutton);
        loadJSONFromAsset();
        addItemsOnSpinner();
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               // Toast.makeText(Scenario2Activity.this,"New Item: " + display,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                //Bundle bundle = new Bundle();
                i.putExtra("Latitude", selectedLoc.getLatitude());
                i.putExtra("Longitude", selectedLoc.getLongitude());
                i.putExtra("Name",selectedLoc.getName());
                startActivity(i);
            }
        });

        t1 = (TextView) findViewById(R.id.textView1);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
       // addItemsOnSpinner();
    }

    public void loadJSONFromAsset()
    {
        String json = null;
        try {
            InputStream is = getAssets().open("destination.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            //return null;
        }
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray m_jArry = obj.getJSONArray("locations");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                MyLocations location = new MyLocations();
                location.setLatitude((float) jo_inside.getDouble("latitude"));
                location.setLongitude((float) jo_inside.getDouble("longitude"));
                location.setCarMode(jo_inside.getString("car"));
                location.setName(jo_inside.getString("name"));
                location.setTrainMode(jo_inside.getString("train"));


                //Add your values in your `ArrayList` as below:
                locList.add(location);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //return locList;
    }


    public void addItemsOnSpinner()
    {
        s1 = (Spinner) findViewById(R.id.spinner);
        List<String> l1 = new ArrayList<String>();
        for(MyLocations loc : locList){
            l1.add(loc.getName());
        }

        ArrayAdapter<String> dataadapater = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, l1);
        dataadapater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(dataadapater);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLoc = locList.get(position);
                t2.setText("Car : "+selectedLoc.getCarMode());
                t3.setText("Train : "+selectedLoc.getTrainMode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
      //  s1.getOnItemSelectedListener().onItemSelected();
       // display = String.valueOf(s1.getSelectedItem());
       // s1.setOnItemClickListener();
    }

}
