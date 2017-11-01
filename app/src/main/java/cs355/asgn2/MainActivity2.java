package cs355.asgn2;

import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txt1 = (TextView) findViewById(R.id.textView3);
        String extra1 = getIntent().getStringExtra("extra1");
        txt1.setText(extra1);
        TextView txt2 = (TextView) findViewById(R.id.textView5);
        String extra2 = getIntent().getStringExtra("extra2");
        txt2.setText(extra2);
        TextView txt3 = (TextView) findViewById(R.id.textView7);
        String extra3 = getIntent().getStringExtra("extra3");
        int age = getAge(extra3);
        if(age==0){
            int m_age = getMonth(extra3);
            txt3.setText(Integer.toString(m_age) + " month");
        }
        else txt3.setText(Integer.toString(age) + " years");
        TextView txt4 = (TextView) findViewById(R.id.textView9);
        String extra4 = getIntent().getStringExtra("extra4");
        txt4.setText(extra4);
        TextView txt5 = (TextView) findViewById(R.id.textView11);
        String extra5 = getIntent().getStringExtra("extra5");
        txt5.setText(extra5);
        ImageView imgView= (ImageView)findViewById(R.id. imageView);
        if(age<=15) imgView.setImageResource(R.drawable.young);
        else if(age<=25) imgView.setImageResource(R.drawable.teen);
        else if(age<=60) imgView.setImageResource(R.drawable.working);
        else if(age<=150) imgView.setImageResource(R.drawable.old);
    }
    private int getAge(String s){
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
        int age = nowyear-year;
        if(nowmonth<month)age--;
        else if(nowmonth==month && nowday<day) age--;
        return age;
    }
    private int getMonth(String s){
        String[] split = s.split("/");;
        int month = Integer.parseInt(split[1]);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String nowDate = sdf.format(date);
        String[] nowSplit = nowDate.split("/");
        int nowmonth = Integer.parseInt(nowSplit[1]);
        int age = nowmonth-month;
        return age;
    }
}
