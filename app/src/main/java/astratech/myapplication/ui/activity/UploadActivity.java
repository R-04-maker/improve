package astratech.myapplication.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import astratech.myapplication.R;
import astratech.myapplication.model.Pengajuan;

public class UploadActivity extends AppCompatActivity {

    private RecyclerView mRVPengajuan;
    private UploadAdapter mUploadAdapter;
    private ConstraintLayout mLayoutRiwayat, mLayoutPengajuan, mLayoutDiterima, mLayoutDitolak;
    private ImageView mImgRiwayat, mImgPengajuan, mImgDiterima, mImgDitolak;
    private ConstraintLayout mUploadBtn;
    private TextView mTxtRiwayat, mTxtPengajuan, mTxtDitrima, mTxtDitolak;
    private List<Pengajuan> mPengajuan;
    private int selectedTab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        mUploadBtn = findViewById(R.id.ic_btn_upload);
//
//        mLayoutRiwayat = findViewById(R.id.riwayat_layout);
//        mImgRiwayat = findViewById(R.id.iv_riwayat);
//        mTxtRiwayat = findViewById(R.id.txt_riwayat);

        mLayoutPengajuan = findViewById(R.id.pengajuan_layout);
        mImgPengajuan = findViewById(R.id.iv_pengajuan);
        mTxtPengajuan = findViewById(R.id.txt_pengajuan);

        mLayoutDiterima = findViewById(R.id.diterima_layout);
        mImgDiterima = findViewById(R.id.iv_diterima);
        mTxtDitrima = findViewById(R.id.txt_diterima);

        mLayoutDitolak = findViewById(R.id.ditolak_layout);
        mImgDitolak = findViewById(R.id.iv_ditolak);
        mTxtDitolak = findViewById(R.id.txt_ditolak);

        mLayoutPengajuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImgDiterima.setImageResource(R.drawable.filter_pengajuan);
                mTxtDitrima.setTextColor(getResources().getColor(R.color.tab_uncliked));

                mImgDitolak.setImageResource(R.drawable.filter_pengajuan);
                mTxtDitolak.setTextColor(getResources().getColor(R.color.tab_uncliked));

                mImgPengajuan.setImageResource(R.drawable.filter_pengajuan_clicked);
                mTxtPengajuan.setTextColor(getResources().getColor(R.color.tab_licked));

                ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f,  Animation.RELATIVE_TO_SELF, 0.0f);
                scaleAnimation.setDuration(200);
                scaleAnimation.setFillAfter(true);
                mLayoutPengajuan.startAnimation(scaleAnimation);

                update(loadDataPengajuan());
            }
        });

        mLayoutDiterima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImgPengajuan.setImageResource(R.drawable.filter_pengajuan);
                mTxtPengajuan.setTextColor(getResources().getColor(R.color.tab_uncliked));

                mImgDitolak.setImageResource(R.drawable.filter_pengajuan);
                mTxtDitolak.setTextColor(getResources().getColor(R.color.tab_uncliked));

                mImgDiterima.setImageResource(R.drawable.filter_diterima_clicked);
                mTxtDitrima.setTextColor(getResources().getColor(R.color.tab_licked_terima));

                ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f,  Animation.RELATIVE_TO_SELF, 0.0f);
                scaleAnimation.setDuration(200);
                scaleAnimation.setFillAfter(true);
                mLayoutDiterima.startAnimation(scaleAnimation);

                update(loadDataDiterima());
            }
        });

        mLayoutDitolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImgPengajuan.setImageResource(R.drawable.filter_pengajuan);
                mTxtPengajuan.setTextColor(getResources().getColor(R.color.tab_uncliked));

                mImgDiterima.setImageResource(R.drawable.filter_pengajuan);
                mTxtDitrima.setTextColor(getResources().getColor(R.color.tab_uncliked));

                mImgDitolak.setImageResource(R.drawable.filter_ditolak_clicked);
                mTxtDitolak.setTextColor(getResources().getColor(R.color.tab_licked_tolak));

                ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f,  Animation.RELATIVE_TO_SELF, 0.0f);
                scaleAnimation.setDuration(200);
                scaleAnimation.setFillAfter(true);
                mLayoutDitolak.startAnimation(scaleAnimation);

                update(loadDataDitolak());
            }
        });

        mRVPengajuan = findViewById(R.id.rv_card_pengajuan);
        mRVPengajuan.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRVPengajuan.setAdapter(mUploadAdapter);

        mUploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        update(loadDataPengajuan());
    }
    public void update(List<Pengajuan> list){
        mPengajuan = list;
        mUploadAdapter = new UploadAdapter(mPengajuan);
        mRVPengajuan.setAdapter(mUploadAdapter);
    }
    public List<Pengajuan> loadData(){
        List<Pengajuan> pengajuans = new ArrayList<>();
        for(int i  = 0; i < 5; i++){
            Pengajuan pengajuan = new Pengajuan();
            pengajuan.setIdPengajuan("" + i + 1);
            pengajuan.setJenisPengajuan("Pengajuan Lomba " + i);
            pengajuan.setTglPengajuan("20 September 2023");
            pengajuan.setNamaPengajuan("Novastech 2023");
            pengajuan.setStatus("Pengajuan");
            pengajuans.add(pengajuan);
        }
        return pengajuans;
    }
    public List<Pengajuan> loadDataPengajuan(){
        List<Pengajuan> pengajuans = new ArrayList<>();
        for(int i  = 0; i < 3; i++){
            Pengajuan pengajuan = new Pengajuan();
            pengajuan.setIdPengajuan("" + i + 1);
            pengajuan.setJenisPengajuan("Pengajuan Lomba " + i);
            pengajuan.setTglPengajuan("20 September 2023");
            pengajuan.setNamaPengajuan("Novastech 2023");
            pengajuan.setStatus("Pengajuan");
            pengajuans.add(pengajuan);
        }
        return pengajuans;
    }
    public List<Pengajuan> loadDataDiterima(){
        List<Pengajuan> pengajuans = new ArrayList<>();
        for(int i  = 0; i < 2; i++){
            Pengajuan pengajuan = new Pengajuan();
            pengajuan.setIdPengajuan("" + i + 1);
            pengajuan.setJenisPengajuan("Pengajuan Lomba " + i);
            pengajuan.setTglPengajuan("20 September 2023");
            pengajuan.setNamaPengajuan("Novastech 2023");
            pengajuan.setStatus("Diterima");
            pengajuans.add(pengajuan);
        }
        return pengajuans;
    }
    public List<Pengajuan> loadDataDitolak(){
        List<Pengajuan> pengajuans = new ArrayList<>();
        for(int i  = 0; i < 1; i++){
            Pengajuan pengajuan = new Pengajuan();
            pengajuan.setIdPengajuan("" + i + 1);
            pengajuan.setJenisPengajuan("Pengajuan Lomba " + i);
            pengajuan.setTglPengajuan("20 September 2023");
            pengajuan.setNamaPengajuan("Novastech 2023");
            pengajuan.setStatus("Ditolak");
            pengajuans.add(pengajuan);
        }
        return pengajuans;
    }
    private class UploadAdapter extends RecyclerView.Adapter<UploadAdapter.UploadHolder>{
        private List<Pengajuan> mPengajuans;

        public UploadAdapter(List<Pengajuan> pengajuans){
            mPengajuans = pengajuans;
        }

        @NonNull
        @Override
        public UploadAdapter.UploadHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(UploadActivity.this);

            return new UploadAdapter.UploadHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull UploadAdapter.UploadHolder holder, int position) {
            Pengajuan pengajuan = mPengajuans.get(position);
            holder.bind(pengajuan);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);
        }

        @Override
        public int getItemCount() {
            return mPengajuans.size();
        }

        private class UploadHolder extends RecyclerView.ViewHolder{
            private TextView mNamaPengajuan, mJenisPengajuan, mTglPengajuan;
            private ImageView mIcStatus, mSideCard;
            private Pengajuan mPengajuan;
            private String jenis = "from-card";

            public UploadHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_pengajuan, parent, false));

                mNamaPengajuan = itemView.findViewById(R.id.txtNamaEvent);
                mJenisPengajuan = itemView.findViewById(R.id.txtJenisPengajuan);
                mTglPengajuan = itemView.findViewById(R.id.txtTgl);
                mIcStatus = itemView.findViewById(R.id.ic_Status);
                mSideCard = itemView.findViewById(R.id.side_card);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(UploadActivity.this, R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(UploadActivity.this, ViewPengajuanActivity.class);
                        intent.putExtra("jenis", jenis);
                        startActivity(intent);
                    }
                });
            }
            public void bind(Pengajuan pengajuan){
                mPengajuan = pengajuan;
                mNamaPengajuan.setText(pengajuan.getNamaPengajuan());
                mJenisPengajuan.setText(pengajuan.getJenisPengajuan());
                mTglPengajuan.setText(pengajuan.getTglPengajuan());
                if(pengajuan.getStatus() == "Diterima"){
                    String hexColor = "#3079af";
                    mIcStatus.setImageResource(R.drawable.icon_upload_2);
                    int color = Color.parseColor(hexColor);
                    mSideCard.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                    mIcStatus.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                }else if (pengajuan.getStatus() == "Pengajuan"){
                    mIcStatus.setImageResource(R.drawable.icon_upload_1);
                    String hexColor = "#F7893C";
                    int color = Color.parseColor(hexColor);
                    mSideCard.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                    mIcStatus.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                } else if (pengajuan.getStatus() == "Ditolak") {
                    mIcStatus.setImageResource(R.drawable.icon_upload_3);
                    String hexColor = "#d66972";
                    int color = Color.parseColor(hexColor);
                    mSideCard.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                    mIcStatus.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                }
            }
        }
    }
}