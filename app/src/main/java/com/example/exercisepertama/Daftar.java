package com.example.exercisepertama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Daftar extends AppCompatActivity {

    EditText name, email, pass, repass, alamat;
    Button btndaf, btnbatal;
    RadioButton jeniskelamin, agama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        name = findViewById(R.id.dafNama);
        email = findViewById(R.id.dafEmail);
        pass = findViewById(R.id.dafPassword);
        repass = findViewById(R.id.dafRePassword);
        alamat = findViewById(R.id.dafAlamat);
        btndaf = findViewById(R.id.rbtndaftar);
        btnbatal = findViewById(R.id.rbtnbatal);

        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btndaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        alamat.getText().toString().isEmpty() ||
                        pass.getText().toString().isEmpty() ||
                        repass.getText().toString().isEmpty())
                {
                    name.setError("Masukkan Nama");
                    email.setError("Masukkan Email");
                    alamat.setError("Masukkan Alamat");
                    pass.setError("Masukkan Password");
                    repass.setError("Masukkan Re-Password");

                } else {
                    if (pass.getText().toString().equals(repass.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "registration is successful",
                                Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    } else {
                        Snackbar.make(v, "password and repassword must be same",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}