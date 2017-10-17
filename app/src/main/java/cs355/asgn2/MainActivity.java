package cs355.asgn2;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.icu.text.DateFormat;
import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;

import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();
    Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        MainActivity2.class);
                Spinner spinner = (Spinner)findViewById(R.id.spinner);
                ArrayAdapter<CharSequence> adapter =
                        ArrayAdapter. createFromResource (MainActivity.this,
                        R.array.gender_array , android.R.layout. simple_spinner_item );
                adapter.setDropDownViewResource(android.R.layout. simple_spinner_dropdown_item );
                spinner.setAdapter(adapter);
                EditText edt1 = (EditText)findViewById(R.id.editText1);
                EditText edt2 = (EditText)findViewById(R.id.editText2);
                EditText edt3 = (EditText)findViewById(R.id.editText3);
                EditText edt4 = (EditText)findViewById(R.id.editText4);
                EditText edt5 = (EditText)findViewById(R.id.editText5);
                String value1 = edt1.getText().toString();
                String value2 = edt2.getText().toString();
                String value3 = edt3.getText().toString();
                String value4 = edt4.getText().toString();
                String value5 = edt5.getText().toString();
                intent.putExtra("extra1", value1);
                intent.putExtra("extra2", value2);
                intent.putExtra("extra3", value3);
                intent.putExtra("extra4", value4);
                intent.putExtra("extra5", value5);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btnDate = (Button) findViewById(R.id.btnChangeDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, d,
                        myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        updateLabel();
    }

    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    private void updateLabel() {
        EditText txt =(EditText) findViewById(R.id.editText3);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txt.setText(sdf.format(myCalendar.getTime()));
    }

}
