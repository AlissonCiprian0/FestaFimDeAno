package com.alissoncipriano.festafimdeano.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.alissoncipriano.festafimdeano.R;
import com.alissoncipriano.festafimdeano.constant.FimDeAnoConstants;
import com.alissoncipriano.festafimdeano.data.Data;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();
    private Data mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mData = new Data(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.checkPresence();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_participate) {
            if (this.mViewHolder.checkParticipate.isChecked()) {
                // Salvar a presença da pessoa no evento
                this.mData.storeString(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.CONFIRM_YES);
            }
            else {
                // Salvar a ausênncia da pessoa no evento
                this.mData.storeString(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.CONFIRM_NO);
            }
        }
    }

    public void checkPresence() {
        String presence = mData.getStoredString(FimDeAnoConstants.PRESENCE_KEY);

        if (presence.equals(FimDeAnoConstants.CONFIRM_YES)) {
            this.mViewHolder.checkParticipate.setChecked(true);
        }
        else {
            this.mViewHolder.checkParticipate.setChecked(false);
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}