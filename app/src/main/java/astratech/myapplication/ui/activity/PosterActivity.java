package astratech.myapplication.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import astratech.myapplication.R;

public class PosterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster_event);
        String mId = getIntent().getStringExtra("id");
        String mJenis = getIntent().getStringExtra("jenis_kegiatan");

        ImageView mBackButton = findViewById(R.id.backBtn);
        ImageView mPoster = findViewById(R.id.photoViewDetailLomba);

        if(mJenis.equals("Lomba")){
            if(mId.equals("1")){
                mPoster.setImageResource(R.drawable.lomba1);
            } else if (mId.equals("2")) {
                mPoster.setImageResource(R.drawable.lomba2);
            } else if (mId.equals("3")) {
                mPoster.setImageResource(R.drawable.lomba3);
            } else if (mId.equals("4")) {
                mPoster.setImageResource(R.drawable.lomba4);
            } else if (mId.equals("5")) {
                mPoster.setImageResource(R.drawable.lomba5);
            }
        } else if (mJenis.equals("Seminar")) {
            if(mId.equals("1")){
                mPoster.setImageResource(R.drawable.seminar1);
            } else if (mId.equals("2")) {
                mPoster.setImageResource(R.drawable.seminar4);
            } else if (mId.equals("3")) {
                mPoster.setImageResource(R.drawable.seminar5);
            } else if (mId.equals("4")) {
                mPoster.setImageResource(R.drawable.seminar1);
            } else if (mId.equals("5")) {
                mPoster.setImageResource(R.drawable.seminar4);
            }
        }  else if (mJenis.equals("Lainnya")) {
            if(mId.equals("1")){
                mPoster.setImageResource(R.drawable.lomba2);
            } else if (mId.equals("2")) {
                mPoster.setImageResource(R.drawable.seminar4);
            } else if (mId.equals("3")) {
                mPoster.setImageResource(R.drawable.lomba4);
            } else if (mId.equals("4")) {
                mPoster.setImageResource(R.drawable.seminar1);
            } else if (mId.equals("5")) {
                mPoster.setImageResource(R.drawable.seminar5);
            }
        }

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
