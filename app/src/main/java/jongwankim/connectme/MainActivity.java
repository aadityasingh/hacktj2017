package jongwankim.connectme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidtutorialpoint.googlemapsapp.R;

public class MainActivity extends AppCompatActivity {
    Button news;
    Button map;
    Button friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        news = (Button) findViewById(R.id.news);
        map = (Button) findViewById(R.id.map);
        friend = (Button) findViewById(R.id.friend);

        news.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), News.class);
                startActivity(intent);
                finish();
            }
        });

        map.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        friend.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Friend.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
