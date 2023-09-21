package astratech.myapplication.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import astratech.myapplication.R;

public class DetailReviewActivity extends AppCompatActivity {

    private RecyclerView mRVNotifikasi;
//    private NotifikasiAdapter mNotifikasiAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_review);

        ImageView mBackButton = findViewById(R.id.backBtn);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
