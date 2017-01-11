package com.example.rezaandriyunanto.modul1activity;

import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private EditText edtPanjang, edtLebar;
    private Button btnHitung;
    private TextView txtLuas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hitung Luas Persegi Panjang");

        edtPanjang = (EditText) findViewById(R.id.edt_panjang);
        edtLebar = (EditText) findViewById(R.id.edt_lebar);
        btnHitung = (Button) findViewById(R.id.btn_hitung);
        txtLuas = (TextView) findViewById(R.id.txt_luas);

        btnHitung.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String panjang = edtPanjang.getText().toString().trim();
             String lebar = edtLebar.getText().toString().trim();
             try {
                 double p = Double.parseDouble(panjang);
                 double l = Double.parseDouble(lebar);
                 //Agar hasil hanya menjadi 4digit dibelakang koma
                 double luas = Math.round(p * l *10000.0)/10000.0 ;
                 txtLuas.setText("Luas : " + luas);
             }catch (NumberFormatException e){
                 Toast.makeText(getApplicationContext(),"Masukan Angka pada kolom inputan",Toast.LENGTH_SHORT).show();
             }
         }
     }

        );
    }

}
