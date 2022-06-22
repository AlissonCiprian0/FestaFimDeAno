package com.alissoncipriano.festafimdeano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.text_today = findViewById(R.id.text_today);
        this.mViewHolder.text_daysLeft = findViewById(R.id.text_daysLeft);
        this.mViewHolder.button_confirm = findViewById(R.id.button_confirm);

        this.mViewHolder.button_confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_confirm) {
            Intent intent = new Intent(this, DetailsActivity.class);

            startActivity(intent);
        }
    }

    private static class ViewHolder {
        TextView text_today;
        TextView text_daysLeft;
        Button button_confirm;
    }
}