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
import astratech.myapplication.model.HistoryXP;
import astratech.myapplication.model.LeaderBoard;
import astratech.myapplication.ui.fragment.LeaderBoardFragment;

public class HistoryXPActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistoryXPAdapter adapter;
//    private List<HistoryXP> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_xp);

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.history_xp_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<HistoryXP> itemList = dataHistoryXP(); // Inisialisasi daftar item sejarah XP


        // Inisialisasi adapter
        adapter = new HistoryXPAdapter(itemList);
        recyclerView.setAdapter(adapter);

        ImageView mBackButton = findViewById(R.id.backBtn);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public List<HistoryXP> dataHistoryXP(){
        List<HistoryXP> historyXPList = new ArrayList<>();
        for(int i  = 0; i < 20; i++){
            HistoryXP historyXP = new HistoryXP();
            historyXP.setIdHistoryXP(i + 4);
            historyXP.setNamaKegiatan("Juara 1 Lomba Gemastik UI dan UX");
            historyXP.setTanggalKegiatan("20/08/2023");
            historyXP.setJumlahXP(20);
            historyXPList.add(historyXP);
        }
        return historyXPList;
    }

    private void updateHistoryXP(List<HistoryXP> historyXPLists){
        adapter = new HistoryXPAdapter(historyXPLists);
        recyclerView.setAdapter(adapter);
    }

    public class HistoryXPAdapter extends RecyclerView.Adapter<HistoryXPAdapter.ViewHolder> {

        private List<HistoryXP> itemList; // Anda perlu membuat kelas HistoryXP untuk menyimpan data

        public HistoryXPAdapter(List<HistoryXP> itemList) {
            this.itemList = itemList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_history_xp, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            HistoryXP item = itemList.get(position);
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
            private HistoryXP mHistoryXP;

            private TextView mTanggal;
            private ImageView mFotoOrang;
            private TextView mNamaOrang;
            private TextView mXP;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                mTanggal = itemView.findViewById(R.id.tanggal_history_xp);
                mNamaOrang = itemView.findViewById(R.id.nama_history_xp);
                mXP = itemView.findViewById(R.id.history_jumlah_xp);
                itemView.setOnClickListener(this);

                // Inisialisasi elemen-elemen tampilan di sini
                // Misalnya, textView = itemView.findViewById(R.id.textView);
            }

            public void bind(HistoryXP historyXP){
                mHistoryXP = historyXP;
                mNamaOrang.setText(historyXP.getNamaKegiatan());
                mTanggal.setText(historyXP.getTanggalKegiatan());
                mXP.setText(String.valueOf(historyXP.getJumlahXP()) + " xp");
            }


            @Override
            public void onClick(View view) {

            }
        }
    }

}
