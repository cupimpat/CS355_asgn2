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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;


public class MainActivity extends AppCompatActivity {
    Calendar myCalendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter. createFromResource (MainActivity.this,
                        R.array.gender_array , android.R.layout. simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout. simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                EditText edt1 = (EditText)findViewById(R.id.editText1);
                EditText edt2 = (EditText)findViewById(R.id.editText2);
                EditText edt3 = (EditText)findViewById(R.id.editText3);
                EditText edt4 = (EditText)findViewById(R.id.editText4);
                EditText edt5 = (EditText)findViewById(R.id.editText5);
                Spinner spinner = (Spinner)findViewById(R.id.spinner);
                String spnText = spinner.getSelectedItem().toString();
                String name = edt1.getText().toString();
                if (name.matches("")) {
                    Toast.makeText(getApplicationContext(), "plz enter your firstname", Toast.LENGTH_SHORT).show();
                    return;
                }
                String value1 = spnText+" "+name;
                String value2 = edt2.getText().toString();
                if (value2.matches("")) {
                    Toast.makeText(getApplicationContext(), "plz enter your lastname", Toast.LENGTH_SHORT).show();
                    return;
                }
                String value3 = edt3.getText().toString();
                if (value3.matches("")) {
                    Toast.makeText(getApplicationContext(), "plz enter your date of Birth", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!checkDate(value3)){
                    Toast.makeText(getApplicationContext(), "your can't born in the future!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String value4 = edt4.getText().toString();
                if (value4.matches("")) {
                    Toast.makeText(getApplicationContext(), "plz enter your e-mail", Toast.LENGTH_SHORT).show();
                    return;
                }
                String value5 = edt5.getText().toString();
                if (value5.matches("")) {
                    Toast.makeText(getApplicationContext(), "plz enter your phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (value5.trim().length()<10) {
                    Toast.makeText(getApplicationContext(), "plz enter your phone number 10 digit", Toast.LENGTH_SHORT).show();
                    return;
                }

                final RadioButton rbt = (RadioButton) findViewById(R.id.radioButton);
                final RadioButton rbt2 = (RadioButton) findViewById(R.id.radioButton2);
                if(rbt.isChecked()){

                }else if(rbt2.isChecked()){

                }else {
                    Toast.makeText(getApplicationContext(), "plz select RadioButton", Toast.LENGTH_SHORT).show();
                    return;
                }

                intent.putExtra("extra1", value1);
                intent.putExtra("extra2", value2);
                intent.putExtra("extra3", value3);
                intent.putExtra("extra4", value4);
                intent.putExtra("extra5", value5);
                startActivity(intent);
            }
        });

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

<<<<<<< HEAD
=======
    private boolean checkDate(String s){
        String[] split = s.split("/");
        int day = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int year = Integer.parseInt(split[2]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String nowDate = sdf.format(date);
        String[] nowSplit = nowDate.split("/");
        int nowday = Integer.parseInt(nowSplit[0]);
        int nowmonth = Integer.parseInt(nowSplit[1]);
        int nowyear = Integer.parseInt(nowSplit[2]);
        int checkyear = nowyear-year;
        if(checkyear<=0){
            int checkmonth = nowmonth-month;
            if(checkmonth<0)return false;
            int checkday = nowday-day;
            if(checkmonth==0&&checkday<=0)return false;
        }
        return true;
    }
>>>>>>> b99367210aee0ab2645fca82f5cd1bf5ec8a9350

}
