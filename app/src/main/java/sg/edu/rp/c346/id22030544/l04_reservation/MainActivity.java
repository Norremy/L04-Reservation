package sg.edu.rp.c346.id22030544.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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

        dp.updateDate(2020,5,1);
        tp.setHour(19);
        tp.setMinute(30);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(hourOfDay>20){
                    Toast.makeText(MainActivity.this,"Please Select Time Before 9PM",
                            Toast.LENGTH_LONG).show();
                    tp.setHour(20);

                }
                else if(hourOfDay<8){
                    Toast.makeText(MainActivity.this,"Please Select From 8AM Onwards",
                            Toast.LENGTH_LONG).show();
                    tp.setHour(8);

                }
            }
        });
//        dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                if
//            }
//        });

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String  number = etNumber.getText().toString();
                String pax = etPax.getText().toString();
                String type;
                String frame = null;
                if(rgTable.getCheckedRadioButtonId()==R.id.radioButtonSmoking){
                    type = "Smoking";
                }
                else {
                    type = "Non-smoking";}

                if(name.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Please Enter Name",
                            Toast.LENGTH_LONG).show();

                }
                else if(number.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Please Enter Mobile Number",
                            Toast.LENGTH_LONG).show();

                }
                else if(pax.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Please Enter No. of Pax",
                            Toast.LENGTH_LONG).show();

                }
                else if(rgTable.getCheckedRadioButtonId()!=R.id.radioButtonSmoking&&rgTable.getCheckedRadioButtonId()!=R.id.radioButtonNS){
                    Toast.makeText(MainActivity.this,"Please Select Table Type",
                            Toast.LENGTH_LONG).show();
                }
                else{

                        Toast.makeText(MainActivity.this, "Succesfully Reserved",
                                Toast.LENGTH_LONG).show();
                        String text =("Summary" +
                                "\nName: " + name +
                                "\nMobile Number: " + number +
                                "\nNo. of  pax: " + pax +
                                "\nTable Type: " + type +
                                "\nDate: " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() +
                                "\nTime: " + tp.getHour() + ":" + tp.getMinute()
                        );
                        tvDisplay.setText(text);


                }
            }

        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText(null);
                etNumber.setText(null);
                etPax.setText(null);
                rgTable.clearCheck();
                dp.updateDate(2020,5,1);
                tp.setHour(19);
                tp.setMinute(30);


            }
        });
    }
}