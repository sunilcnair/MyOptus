package com.example.com.myoptus;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.com.myoptus.R.id.button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),Scenario1Activity.class);
                startActivity(i);
            }
        });
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, Scenario1Activity.class);
        startActivity(intent);
    }

    public void sendMessage2(View view)
    {
        Intent intent = new Intent(this, Scenario2Activity.class);
        startActivity(intent);
    }
}
