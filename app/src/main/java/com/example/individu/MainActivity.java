package com.example.individu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.individu.RetrofitClientInstance;
import com.example.individu.datamodels.LogoutResponse;
import com.example.individu.retrofit.StoryClient;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity<isloggedin> extends AppCompatActivity {
    String token;
    Button log_out;
    SharedPrefManager sharedPrefManager;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        token = sharedPref.getString("TOKEN","");
        sharedPrefManager = new SharedPrefManager(this);

        log_out = findViewById(R.id.logout);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logout();
            }



            public void logout(){
                StoryClient client = RetrofitClientInstance.getRetrofitInstance().create(StoryClient.class);


                Call<LogoutResponse> call = client.logout("Bearer " + token );
                call.enqueue(new Callback<LogoutResponse>() {
                    @Override
                    public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                        if(response.isSuccessful()){
                            LogoutResponse ganti = response.body();
                            Toast.makeText(MainActivity.this, ganti.getMessage(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, login.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<LogoutResponse> call, Throwable t) {

                    }
                });
            }
        });}

    public void permintaanSeminar(View view){
        Intent pSeminar = new Intent (MainActivity. this,listPermintaanSeminar.class);
        startActivity(pSeminar);
    }

    public void permintaanSidang(View view){
        Intent pSidang = new Intent (MainActivity. this,listPermintaanSidang.class);
        startActivity(pSidang);
    }
}