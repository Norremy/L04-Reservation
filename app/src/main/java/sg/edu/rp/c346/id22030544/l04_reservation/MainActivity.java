package sg.edu.rp.c346.id22030544.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etNumber;
    EditText etPax;
    RadioGroup rgTable;
    DatePicker dp;
    TimePicker tp;
    TextView tvDisplay;
    Button btnReset;
    Button btnReserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etNumber = findViewById(R.id.editTextNo);
        etPax = findViewById(R.id.editTextPax);
        rgTable = findViewById(R.id.RGTable);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);

    }
}