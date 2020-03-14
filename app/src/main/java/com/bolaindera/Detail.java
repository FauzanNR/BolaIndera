package com.bolaindera;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Detail extends AppCompatActivity {

    Adapter adapterData;
    ProgressBar progressBar;
    ImageView logo;
    TextView nama, deskripsi, stadion, liga;
    String getNama, getdeskripsi, getlogo,getStadion,getLiga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        nama = findViewById(R.id.nama_club);
        deskripsi = findViewById(R.id.detail_content);
        stadion = findViewById(R.id.stadion);
        liga = findViewById(R.id.liga);
        logo = findViewById(R.id.logo);


        getNama = getIntent().getStringExtra("nama");
        nama.setText(getNama);
        getdeskripsi = getIntent().getStringExtra("deskripsi");
        deskripsi.setText(getdeskripsi);

        getStadion =getIntent().getStringExtra("stadion");
        stadion.setText(getStadion);
        getLiga = getIntent().getStringExtra("liga");
        liga.setText(getLiga);
        getlogo = getIntent().getStringExtra("logo");
        Glide.with(getApplicationContext())
                .load(getlogo)
                .apply(new RequestOptions())
                .into(logo);







    }
}
