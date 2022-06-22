package com.alissoncipriano.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alissoncipriano.festafimdeano.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.text_today = findViewById(R.id.text_today);
        this.mViewHolder.text_daysLeft = findViewById(R.id.text_daysLeft);
        this.mViewHolder.button_confirm = findViewById(R.id.button_confirm);

        this.mViewHolder.button_confirm.setOnClickListener(this);

        // Datas
        this.mViewHolder.text_today.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));
        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.dias));
        this.mViewHolder.text_daysLeft.setText(daysLeft);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirm) {
            Intent intent = new Intent(this, DetailsActivity.class);

            startActivity(intent);
        }
    }

    private int getDaysLeft() {
        // Data de hoje
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);


        // Dia máximo do ano ( [1 - 365 ou 366] )
        Calendar calendarLastDay = Calendar.getInstance();
        int dayMax = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        // Dias restantes para o fim do ano
        return dayMax - today;

    }

    private static class ViewHolder {
        TextView text_today;
        TextView text_daysLeft;
        Button button_confirm;
    }
}