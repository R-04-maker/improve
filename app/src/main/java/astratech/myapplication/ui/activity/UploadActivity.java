package astratech.myapplication.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import astratech.myapplication.R;
import astratech.myapplication.model.Pengajuan;

public class UploadActivity extends AppCompatActivity {

    private RecyclerView mRVPengajuan;
    private UploadAdapter mUploadAdapter;
    private List<Pengajuan> mPengajuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        mRVPengajuan = findViewById(R.id.rv_card_pengajuan);
        mRVPengajuan.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRVPengajuan.setAdapter(mUploadAdapter);
        updateLomba(loadData());
    }
    public void updateLomba(List<Pengajuan> list){
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
            private Pengajuan mPengajuan;

            public UploadHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_pengajuan, parent, false));

                mNamaPengajuan = itemView.findViewById(R.id.txtNamaEvent);
                mJenisPengajuan = itemView.findViewById(R.id.txtJenisPengajuan);
                mTglPengajuan = itemView.findViewById(R.id.txtTgl);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(UploadActivity.this, R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(UploadActivity.this, DetailLombaActivity.class);
//                        intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                        startActivity(intent);
                    }
                });
            }
            public void bind(Pengajuan pengajuan){
                mPengajuan = pengajuan;
                mNamaPengajuan.setText(pengajuan.getNamaPengajuan());
                mJenisPengajuan.setText(pengajuan.getJenisPengajuan());
                mTglPengajuan.setText(pengajuan.getTglPengajuan());
            }
        }
    }
}