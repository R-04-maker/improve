package astratech.myapplication.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import astratech.myapplication.R;
import astratech.myapplication.model.HistoryPoin;

public class HistoryPoinActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryPoinAdapter adapter;
//    private List<HistoryXP> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_point);

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.history_poin_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<HistoryPoin> itemList = dataHistoryPoin(); // Inisialisasi daftar item sejarah XP


        // Inisialisasi adapter
        adapter = new HistoryPoinActivity.HistoryPoinAdapter(itemList);
        recyclerView.setAdapter(adapter);

        ImageView mBackButton = findViewById(R.id.backBtn);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public List<HistoryPoin> dataHistoryPoin(){
        List<HistoryPoin> historyPoinList = new ArrayList<>();
        for(int i  = 0; i < 20; i++){
            HistoryPoin historyPoin = new HistoryPoin();
            historyPoin.setIdHistoryPoin(i + 4);
            historyPoin.setNamaKegiatan("Memberikan Review Seminar");
            historyPoin.setTanggalKegiatan("12/11/2023");
            historyPoin.setJumlahPoin(10);
            historyPoinList.add(historyPoin);
        }
        return historyPoinList;
    }

    private void updateHistoryPoin(List<HistoryPoin> historyPoinLists){
        adapter = new HistoryPoinAdapter(historyPoinLists);
        recyclerView.setAdapter(adapter);
    }

    public class HistoryPoinAdapter extends RecyclerView.Adapter<HistoryPoinAdapter.ViewHolder> {

        private List<HistoryPoin> itemList; // Anda perlu membuat kelas HistoryXP untuk menyimpan data

        public HistoryPoinAdapter(List<HistoryPoin> itemList) {
            this.itemList = itemList;
        }

        @NonNull
        @Override
        public HistoryPoinAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_history_poin, parent, false);
            return new HistoryPoinAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull HistoryPoinAdapter.ViewHolder holder, int position) {
            HistoryPoin item = itemList.get(position);
            holder.bind(item);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);
            // Set data dari item ke tampilan holder
            // Misalnya, holder.textView.setText(item.getText());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            // Deklarasikan elemen-elemen tampilan di sini
            // Misalnya, TextView textView;
            private HistoryPoin mHistoryPoin;

            private TextView mTanggal;
            private ImageView mFotoOrang;
            private TextView mNamaOrang;
            private TextView mPoin;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                mTanggal = itemView.findViewById(R.id.tanggal_history_poin);
                mNamaOrang = itemView.findViewById(R.id.nama_history_poin);
                mPoin = itemView.findViewById(R.id.history_jumlah_poin);
                itemView.setOnClickListener(this);

                // Inisialisasi elemen-elemen tampilan di sini
                // Misalnya, textView = itemView.findViewById(R.id.textView);
            }

            public void bind(HistoryPoin historyPoin){
                mHistoryPoin = historyPoin;
                mNamaOrang.setText(historyPoin.getNamaKegiatan());
                mTanggal.setText(historyPoin.getTanggalKegiatan());
                mPoin.setText(String.valueOf(historyPoin.getJumlahPoin()) + " poin");
            }


            @Override
            public void onClick(View view) {

            }
        }
    }

}
