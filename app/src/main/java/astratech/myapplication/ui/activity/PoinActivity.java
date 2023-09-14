package astratech.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import astratech.myapplication.R;

public class PoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        ImageView mBackButton = findViewById(R.id.backBtnPoin);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ConstraintLayout constraintHistoryPoin = findViewById(R.id.constrain_history_poin);
        constraintHistoryPoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PoinActivity.this, HistoryPoinActivity.class);
                startActivity(intent);
            }
        });
    }

}
