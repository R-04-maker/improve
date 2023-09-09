package astratech.myapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import astratech.myapplication.R;

public class DetailLombaActivity extends AppCompatActivity {

    private TextView mDetailEvent, mSelengkapnya, mLink;
    private CardView mBackButton, mShareButton;
    String fullText = "Assalamualaikum wr wb ✨ \n\nHallo Sobat Informatika 🙌🏻 \nGet Ready to NovAstech 2023! \nSaatnya tunjukkan potensi dalam dirimu, mari berprestasi bersama NovAstech! NovAstech merupakan lomba internal Politeknik Astra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lomba);

        mDetailEvent = findViewById(R.id.detail_lomba_bawah);
        mSelengkapnya = findViewById(R.id.selengkapnya);
        mBackButton = findViewById(R.id.backBtn);
        mShareButton = findViewById(R.id.shareBtn);
        mLink = findViewById(R.id.informasi_lanjut);

        mDetailEvent.setText(fullText);
        mDetailEvent.post(new Runnable() {
            @Override
            public void run() {
                if (mDetailEvent.getLineCount() > 5) {
                    Log.d("DetailLombaActivity", "post: masuk if line maks 5, skrg cuman" + mDetailEvent.getLineCount());
                    mDetailEvent.setText(fullText.substring(0, mDetailEvent.getLayout().getLineEnd(4)));
                    mSelengkapnya.setVisibility(View.VISIBLE);
                } else {
                    Log.d("DetailLombaActivity", "post: GAK MASUK if line maks 5, skrg cuman " + mDetailEvent.getLineCount());
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
                String shareMessage = "Ini adalah teks atau URL yang ingin Anda bagikan.";
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
    }
}