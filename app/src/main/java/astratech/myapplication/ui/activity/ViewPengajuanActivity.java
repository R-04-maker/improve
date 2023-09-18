package astratech.myapplication.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import astratech.myapplication.R;

public class ViewPengajuanActivity extends AppCompatActivity {

    private ImageView mBackBtn;
    private TextView mBatal, mTxtKegiatanVal;
    private TextView mTxtCV1_2, mTxtCV1_3, mTxtCV1_4;
    private TextView mTxtCV1_2Val, mTxtCV1_3Val, mTxtCV1_4Val;
    private TextView mTxtCV2_1, mTxtCV2_2, mTxtCV2_3, mTxtCV2_4, mTxtCV2_5;
    private TextView mTxtCV2_1Val, mTxtCV2_2Val, mTxtCV2_3Val, mTxtCV2_4Val, mTxtCV2_5Val;
    private CardView mCVPoster, mCVInfoLanjut;
    private ConstraintLayout mSubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pengajuan);

        mTxtCV1_2 = findViewById(R.id.textView24);
        mTxtCV1_3 = findViewById(R.id.textView25);
        mTxtCV1_4 = findViewById(R.id.textView27);
        mTxtCV1_2Val = findViewById(R.id.textView22);
        mTxtCV1_3Val = findViewById(R.id.textView26);
        mTxtCV1_4Val = findViewById(R.id.textView28);

        mTxtCV2_1 = findViewById(R.id.detail_lomba_bawah);
        mTxtCV2_2 = findViewById(R.id.selengkapnya);
        mTxtCV2_3 = findViewById(R.id.htm);
        mTxtCV2_4 = findViewById(R.id.pelaksanaan);
        mTxtCV2_5 = findViewById(R.id.penyelenggara);
        mTxtCV2_1Val = findViewById(R.id.tgl_mulai_rev);
        mTxtCV2_2Val = findViewById(R.id.tgl_selesai_rev);
        mTxtCV2_3Val = findViewById(R.id.htm_rev);
        mTxtCV2_4Val = findViewById(R.id.pelaksanaan_rev);
        mTxtCV2_5Val = findViewById(R.id.penyelenggara_rev);

        mSubmitBtn = findViewById(R.id.ic_btn_upload);

        mBackBtn = findViewById(R.id.back_btn);
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBatal = findViewById(R.id.batal_unggah);
        mBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewPengajuanActivity.this);
                builder.setTitle(R.string.konfirmasi);
                builder.setMessage(R.string.konfirmasi_batal);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProgressDialog progressDialog = ProgressDialog.show(ViewPengajuanActivity.this, "", "Loading ...", true);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                                finish();
                            }
                        }, 1000); // 2000 milidetik = 2 detik
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                // Show Confirmation Dialog
                AlertDialog dialog = builder.create();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                        Button negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                        positiveButton.setTextColor(Color.BLACK);
                        negativeButton.setTextColor(Color.BLACK);
                    }
                });
                dialog.show();
            }
        });

        mCVPoster = findViewById(R.id.cv_1);

        Intent intent = getIntent();

        // Mengambil data yang dikirimkan menggunakan putExtra
        String jenis = intent.getStringExtra("jenis");
        mTxtKegiatanVal = findViewById(R.id.txtkegiatan_val);
        Toast.makeText(getApplicationContext(),"VALUE : " + jenis,Toast.LENGTH_SHORT);
        mCVPoster = findViewById(R.id.cv_1);
        mCVInfoLanjut = findViewById(R.id.cv_3);
        if (jenis.equals("Surat Pengantar")) {
            mCVPoster.setVisibility(View.GONE);
            mCVInfoLanjut.setVisibility(View.GONE);
            mTxtCV2_1.setText("Lomba");
            mTxtCV2_2.setText("Dosen Pembimbing");
            mTxtCV2_3.setText("NIM Ketua");
            mTxtCV2_4.setText("NIM Anggota");
            mTxtCV2_5.setVisibility(View.GONE);
            mTxtCV2_1Val.setText("Novastech Politeknik Astra");
            mTxtCV2_2Val.setText("Vian Ardiyansyah S. , S.S.T., M.Kom.");
            mTxtCV2_3Val.setText("0320210067");
            mTxtCV2_4Val.setText("0320210070");
            mTxtCV2_5Val.setVisibility(View.GONE);
        } else if (jenis.equals("Dana")) {
            mCVPoster.setVisibility(View.GONE);
            mCVInfoLanjut.setVisibility(View.GONE);
            mTxtCV2_1.setText("Lomba");
            mTxtCV2_2.setText("Nama Penerima Bank");
            mTxtCV2_3.setText("Nama Bank");
            mTxtCV2_4.setText("No Rekening");
            mTxtCV2_5.setText("Bukti Pengajuan");
            mTxtCV2_1Val.setText("Novastech Politeknik Astra");
            mTxtCV2_2Val.setText("Robby Fahsya");
            mTxtCV2_3Val.setText("Bank Permata");
            mTxtCV2_4Val.setText("9920290192");
            mTxtCV2_5Val.setText("Ada");
        } else if (jenis.equals("Konsultasi")) {
            mCVPoster.setVisibility(View.GONE);
            mCVInfoLanjut.setVisibility(View.GONE);
            mTxtCV2_1.setText("Lomba");
            mTxtCV2_2.setText("Dosen Pembimbing");
            mTxtCV2_3.setText("Tanggal Konsultasi");
            mTxtCV2_4.setText("Waktu Konsultasi");
            mTxtCV2_5.setVisibility(View.GONE);
            mTxtCV2_1Val.setText("Novastech Politeknik Astra");
            mTxtCV2_2Val.setText("Vian Ardiyansyah S. , S.S.T., M.Kom.");
            mTxtCV2_3Val.setText("29 September 2023");
            mTxtCV2_4Val.setText("15:00");
            mTxtCV2_5Val.setVisibility(View.GONE);
        }else if (jenis.equals("from-card")){
            mBatal.setVisibility(View.GONE);
            mSubmitBtn.setVisibility(View.GONE);
        }
    }
}