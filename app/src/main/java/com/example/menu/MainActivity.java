package com.example.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;

    private double val;

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    private int nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.addValue);
        tv = findViewById(R.id.result);

        et.setRawInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void choose(MenuItem item) {
    }

    public void calculating (){

    }

    public void solve(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.cbr-xml-daily.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Data> messages =api.getInfo();

        messages.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful()) {
                    Log.d("ZERO_STEP","response " + response.body().getValute().get("USD").getValue());
                    Log.d("ZERO_STEP","response " + response.body().getValute().get("EUR").getValue());
                    Log.d("ZERO_STEP","response " + response.body().getValute().get("UAH").getValue());
                    //tv.setText(""+response.body().getValute().get("USD").getValue());
                } else {
                    Log.d("SECOND_STEP","response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("THIRD_STEP","failure " + t);
            }
        });
    }
    
    public void setMode(MenuItem item) {
        switch (item.getItemId()){
            case R.id.to_usd:

                break;
            case R.id.to_eur:

                break;
            case R.id.to_uah:

                break;
            default:

        }

    }
}
