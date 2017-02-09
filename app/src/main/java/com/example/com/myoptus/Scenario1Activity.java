package com.example.com.myoptus;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Scenario1Activity extends AppCompatActivity implements View.OnClickListener{

    Button b1,b2,b3;
    FrameLayout l1;
    TextView t1,fragmenttext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenario1);
        l1 = (FrameLayout) findViewById(R.id.layout4);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
        l1.setBackgroundColor(Color.RED);
            }
        });

        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                l1.setBackgroundColor(Color.BLUE);

            }
        });

        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                l1.setBackgroundColor(Color.GREEN);
            }
        });

        LinearLayout layout = (LinearLayout) findViewById(R.id.thumbnails);
        for (int i = 0; i < 10; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.ic_launcher));
            imageView.setOnClickListener(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            layout.addView(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        t1 = (TextView) findViewById(R.id.textView4);
        t1.setText("Image"+ (v.getId()+1));
    }

    public static class TitlesFragment extends android.app.Fragment {

      /* /@Override
        public void onActivityCreated(Bundle savedInstanceState)
        {
            super.onActivityCreated(savedInstanceState);
            View detailsFrame = getActivity().findViewById(R.id.titles);

        }*/

       public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           TextView text = new TextView(getActivity());
           text.setText("Fragment 1");
           text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
           //text.setBackground(Color.CYAN);
            return text;
        }

    }
}
