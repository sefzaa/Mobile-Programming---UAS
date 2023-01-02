package com.example.individu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailMahasiswaSidang extends AppCompatActivity {

    ImageView tvimgPhoto;
    TextView tvdate, tvnama, tvjudul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa_sidang);

        tvimgPhoto = findViewById(R.id.imageView8);
        tvdate = findViewById(R.id.textView10);
        tvnama = findViewById(R.id.textNama);
        tvjudul = findViewById(R.id.textView8);

        String name = getIntent().getStringExtra("name");
        Integer imgPhoto = getIntent().getIntExtra("imgPhoto", R.mipmap.ic_launcher);
        String date = getIntent().getStringExtra("date");
        String judul = getIntent().getStringExtra("judul");

        tvimgPhoto.setImageResource(imgPhoto);
        tvdate.setText(date);
        tvnama.setText(name);
        tvjudul.setText(judul);
    }



    public void tambahDosenSidang(View view){
        Intent tambah = new Intent(detailMahasiswaSidang. this, listDosenSeminar.class);
        startActivity(tambah);
    }


}