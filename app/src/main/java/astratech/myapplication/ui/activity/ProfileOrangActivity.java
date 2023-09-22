package astratech.myapplication.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import astratech.myapplication.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileOrangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_orang);
        String mId = getIntent().getStringExtra("id");
        String mNama = getIntent().getStringExtra("nama");
        CardView mBackButton = findViewById(R.id.backBtn);
        TextView mNamaOrang = findViewById(R.id.nama_orang);
        CircleImageView mFotoProfil = findViewById(R.id.foto_profile);
        mNamaOrang.setText(mNama);
        if(mId.equals("1")){
            mFotoProfil.setImageResource(R.drawable.foto3);
        } else if (mId.equals("2")) {
            mFotoProfil.setImageResource(R.drawable.foto1);
        } else if (mId.equals("3")) {
            mFotoProfil.setImageResource(R.drawable.foto2);
        } else if (mId.equals("4")) {
            mFotoProfil.setImageResource(R.drawable.foto3);
        }  else if (mId.equals("5")) {
            mFotoProfil.setImageResource(R.drawable.foto1);
        } else if (mId.equals("6")) {
            mFotoProfil.setImageResource(R.drawable.foto2);
        } else if (mId.equals("7")) {
            mFotoProfil.setImageResource(R.drawable.foto3);
        }else if (mId.equals("8")) {
            mFotoProfil.setImageResource(R.drawable.foto1);
        }

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
