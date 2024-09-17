package com.akbar.thestudent;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    TextView showText;
    Button btnRegister, btnTanggal;
    EditText txtEditnama, txtEditusername, txtEditemail, txtEditpassword, txtEditalamat;
    Spinner spinGender, spinAgama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisialisasi komponen
        btnRegister = findViewById(R.id.btn_register);
        txtEditnama = findViewById(R.id.txt_edit_nama);
        txtEditusername = findViewById(R.id.txt_edit_username);
        txtEditemail = findViewById(R.id.txt_edit_email);
        txtEditpassword = findViewById(R.id.txt_edit_password);
        showText = findViewById(R.id.show_text);
        btnTanggal = findViewById(R.id.btn_tanggal);
        txtEditalamat = findViewById(R.id.txt_edit_alamat);
        spinGender = findViewById(R.id.spin_gender);
        spinAgama = findViewById(R.id.spin_agama);

        // event click btnRegister
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = txtEditnama.getText().toString();
                String gender = spinGender.getSelectedItem().toString();
                String agama = spinAgama.getSelectedItem().toString();

                // Show the Toast popup notification
                Toast.makeText(MainActivity.this, "Nama saya: " + nama + " Gender saya: " + gender + " Agama saya: " + agama, Toast.LENGTH_SHORT).show();
            }
        });

        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });
    }

    private void openDatePicker() {
        // Get current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, monthOfYear, dayOfMonth) -> {
            // Show selected date in showText TextView
            String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1; // Month is 0-indexed
            showText.setText(selectedDate);
        }, year, month, day);

        datePickerDialog.show();
    }
}
