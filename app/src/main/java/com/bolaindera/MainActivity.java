package com.bolaindera;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String data = loadJSON(this);
        ResponseTeam responseTeam = new Gson().fromJson(data,ResponseTeam.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adapter adapter = new Adapter(this);
        recyclerView.setAdapter(adapter);

        adapter.setListBola(responseTeam.getTeams());


    }


    private static String loadJSON(Context context){
        StringBuilder builder = new StringBuilder();
        InputStream inputStream = context.getResources().openRawResource(R.raw.apibola);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String data ="";

        try{
            while ((data = reader.readLine()) != null) {
                builder.append(data);
            }
            return builder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
