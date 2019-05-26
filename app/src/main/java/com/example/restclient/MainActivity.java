package com.example.restclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public List<Tracks> listatracks;
    private ApiTracks apitracks;
    public Recycler recycler;
    public RecyclerView recyclerView;
    TextView textViewid;
    TextView textViewtitle;
    TextView textViewsinger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recycler = new Recycler();
        recyclerView.setAdapter(recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        textViewid = findViewById(R.id.id);
        textViewtitle = findViewById(R.id.title);
        textViewsinger = findViewById(R.id.singer);
        apitracks = ApiTracks.retrofit.create(ApiTracks.class);
        getData();
    }

    private void getData() {

        Call<List<Tracks>> tracksCall = apitracks.mistracks();
        tracksCall.enqueue(new Callback<List<Tracks>>() {
            @Override
            public void onResponse(Call<List<Tracks>> call, Response<List<Tracks>> response) {

                listatracks = response.body();
                recycler.rellenarLista(listatracks);

                //a
            }

            @Override
            public void onFailure(Call<List<Tracks>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fallo con la petición de información", Toast.LENGTH_SHORT);
            }
        });
    }

}