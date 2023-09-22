package astratech.myapplication.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import astratech.myapplication.R;

public class DetailLombaActivity extends AppCompatActivity {

    private TextView mDetailEvent, mSelengkapnya, mLink, mNamaKegiatan;
    private CardView mBackButton, mShareButton;
    private FloatingActionButton mSavedBtn;
    private String mId, mNama, mJenis;
    private ImageView mFrontImg, mBackImg;
    String fullText = "Assalamualaikum wr wb ✨ \n\nHallo Sobat Informatika 🙌🏻 \nGet Ready to NovAstech 2023! \nSaatnya tunjukkan potensi dalam dirimu, mari berprestasi bersama NovAstech! NovAstech merupakan lomba internal Politeknik Astra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lomba);
        mId = getIntent().getStringExtra("id");
        mNama = getIntent().getStringExtra("nama");
        mJenis = getIntent().getStringExtra("jenis_kegiatan");

        mDetailEvent = findViewById(R.id.detail_lomba_bawah);
        mSelengkapnya = findViewById(R.id.selengkapnya);
        mBackButton = findViewById(R.id.backBtn);
        mShareButton = findViewById(R.id.shareBtn);
        mLink = findViewById(R.id.informasi_lanjut);
        mSavedBtn = findViewById(R.id.icon_cart);
        mNamaKegiatan = findViewById(R.id.txtNamaKegiatan);
        mFrontImg = findViewById(R.id.imageViewDetailLomba);
        mBackImg = findViewById(R.id.imageView9);

        mNamaKegiatan.setText(mNama);

        if(mJenis.equals("Lomba")){
            if(mId.equals("1")){
                mFrontImg.setImageResource(R.drawable.lomba1);
                mBackImg.setImageResource(R.drawable.lomba1);
            } else if (mId.equals("2")) {
                mFrontImg.setImageResource(R.drawable.lomba2);
                mBackImg.setImageResource(R.drawable.lomba2);
            } else if (mId.equals("3")) {
                mFrontImg.setImageResource(R.drawable.lomba3);
                mBackImg.setImageResource(R.drawable.lomba3);
            } else if (mId.equals("4")) {
                mFrontImg.setImageResource(R.drawable.lomba4);
                mBackImg.setImageResource(R.drawable.lomba4);
            } else if (mId.equals("5")) {
                mFrontImg.setImageResource(R.drawable.lomba5);
                mBackImg.setImageResource(R.drawable.lomba5);
            }
        } else if (mJenis.equals("Seminar")) {
            if(mId.equals("1")){
                mFrontImg.setImageResource(R.drawable.seminar1);
                mBackImg.setImageResource(R.drawable.seminar1);
            } else if (mId.equals("2")) {
                mFrontImg.setImageResource(R.drawable.seminar4);
                mBackImg.setImageResource(R.drawable.seminar4);
            } else if (mId.equals("3")) {
                mFrontImg.setImageResource(R.drawable.seminar5);
                mBackImg.setImageResource(R.drawable.seminar5);
            } else if (mId.equals("4")) {
                mFrontImg.setImageResource(R.drawable.seminar1);
                mBackImg.setImageResource(R.drawable.seminar1);
            } else if (mId.equals("5")) {
                mFrontImg.setImageResource(R.drawable.seminar4);
                mBackImg.setImageResource(R.drawable.seminar4);
            }
        } else if (mJenis.equals("Lainnya")) {
            if(mId.equals("1")){
                mFrontImg.setImageResource(R.drawable.lomba2);
                mBackImg.setImageResource(R.drawable.lomba2);
            } else if (mId.equals("2")) {
                mFrontImg.setImageResource(R.drawable.seminar4);
                mBackImg.setImageResource(R.drawable.seminar4);
            } else if (mId.equals("3")) {
                mFrontImg.setImageResource(R.drawable.lomba4);
                mBackImg.setImageResource(R.drawable.lomba4);
            } else if (mId.equals("4")) {
                mFrontImg.setImageResource(R.drawable.seminar1);
                mBackImg.setImageResource(R.drawable.seminar1);
            } else if (mId.equals("5")) {
                mFrontImg.setImageResource(R.drawable.seminar5);
                mBackImg.setImageResource(R.drawable.seminar5);
            }
        }

        mDetailEvent.setText(fullText);
        mDetailEvent.post(new Runnable() {
            @Override
            public void run() {
                if (mDetailEvent.getLineCount() > 5) {
                    mDetailEvent.setText(fullText.substring(0, mDetailEvent.getLayout().getLineEnd(4)));
                    mSelengkapnya.setVisibility(View.VISIBLE);
                }
            }
        });
        mSelengkapnya.setOnClickListener(new View.OnClickListener() {
            boolean isExpanded  = true;
            @Override
            public void onClick(View v) {
                if(isExpanded ){
                    mDetailEvent.setText(fullText);
                    mSelengkapnya.setVisibility(View.GONE);
                }
            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mLink.getText().toString();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareMessage = "Share Event " + mNama;
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);

                startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"));
            }
        });
        mLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mLink.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Pastikan ada aplikasi browser yang dapat menangani intent ini sebelum memulainya
                startActivity(intent);
            }
        });
        mSavedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable currentDrawable = mSavedBtn.getDrawable();
                if (currentDrawable.getConstantState().equals(getResources().getDrawable(R.drawable.bookmark_regular_1).getConstantState())) {
                    mSavedBtn.setImageResource(R.drawable.baseline_bookmark_24);
                } else {
                    mSavedBtn.setImageResource(R.drawable.bookmark_regular_1);
                }
            }
        });

        ImageView imageView = findViewById(R.id.imageViewDetailLomba);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailLombaActivity.this, PosterActivity.class);
                intent.putExtra("id", mId);
                intent.putExtra("jenis_kegiatan", mJenis);
                startActivity(intent);
            }
        });

    }




}