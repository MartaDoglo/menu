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
    TextView answer;
    String mode = "USD";
    TextView r1;
    TextView r2;
    Boolean status = false;

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
        et.setHint("RUS");


        tv = findViewById(R.id.result);

        r1=findViewById(R.id.r1);
        r1.setText("RUS");
        r2=findViewById(R.id.r2);
        r2.setText(mode);
        getJSON(mode);
        answer = findViewById(R.id.answer);
        answer.setText("0");
        et.setRawInputType(InputType.TYPE_CLASS_NUMBER);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void getJSON(final String str) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.cbr-xml-daily.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<Data> messages = api.getInfo();
        messages.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful()) {
                    setVal(response.body().getValute().get(str).getValue());
                    setNom(response.body().getValute().get(str).getNominal());
                    tv.setText(str + "\nНоминал: " + nom + "\nКурс: " + val);
                } else {
                    Log.d("SECOND_STEP", "response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("THIRD_STEP", "failure " + t);
            }
        });
    }

    public void setMode(MenuItem item) {

        r1.setText("RUS");
        et.setHint("RUS");
        switch (item.getItemId()) {

            case R.id.USD:
                mode = "USD";
                break;
            case R.id.EUR:
                mode = "EUR";
                break;
            case R.id.UAH:
                mode = "UAH";
                break;
            default:
        }
        toMode();
        r2.setText(mode);
        getJSON(mode);
    }

    public void planeSolve(View view) {
        if (status==false)
            toMode();
        else toRus();
    }

    public void toMode (){
        et.setHint("RUS");
        r1.setText("RUS");
        r2.setText(mode);
        if (et.getText().length() != 0) {
            Double get = Double.parseDouble(et.getText().toString());
            Double result = get / val * nom;
            answer.setText("" + Math.floor(result * 100) / 100);
        }
    }
    public void toRus(){
        et.setHint(mode);
        r2.setText("RUS");
        r1.setText(mode);
        if (et.getText().length() != 0) {
            Double get = Double.parseDouble(et.getText().toString());
            Double result = get * val / nom;
            answer.setText("" + Math.floor(result * 100) / 100);
        }
    }
        public void convert (View view){
            if (status==false) {
                status=true;
                toRus();
            } else {
                toMode();
                status=false;
            }
        }
    }
