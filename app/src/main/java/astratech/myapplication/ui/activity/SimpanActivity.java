package astratech.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import astratech.myapplication.R;
import astratech.myapplication.model.Lomba;
import astratech.myapplication.model.Simpan;
import astratech.myapplication.model.Simpan;

public class SimpanActivity extends AppCompatActivity {

    private RecyclerView mRVSimpan;
    private SimpanAdapter mSimpanAdapter;
    private List<Simpan> mSimpan;
    private String mSelectedSimpan = "Semua";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        ImageView mBackButton = findViewById(R.id.backBtn);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRVSimpan = findViewById(R.id.rv_semua_disimpan);
        mRVSimpan.setLayoutManager(new LinearLayoutManager(SimpanActivity.this, LinearLayoutManager.VERTICAL, false));
        mRVSimpan.setAdapter(mSimpanAdapter);

        updateSimpan(lombas);

        View garisSemua = findViewById(R.id.garis_semua);
        View garisLomba = findViewById(R.id.garis_lomba);
        View garisSeminar = findViewById(R.id.garis_seminar);
        View garisLainnya = findViewById(R.id.garis_lainnya);

        ConstraintLayout constraintSemua = findViewById(R.id.frame_ic_semua_disimpan);
        constraintSemua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                garisSemua.setVisibility(View.VISIBLE);
                garisLomba.setVisibility(View.INVISIBLE);
                garisSeminar.setVisibility(View.INVISIBLE);
                garisLainnya.setVisibility(View.INVISIBLE);

                mSelectedSimpan = "Semua";
                updateFilteredTingkat();
            }
        });

        ConstraintLayout constraintLomba = findViewById(R.id.frame_ic_lomba_disimpan);
        constraintLomba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                garisSemua.setVisibility(View.INVISIBLE);
                garisLomba.setVisibility(View.VISIBLE);
                garisSeminar.setVisibility(View.INVISIBLE);
                garisLainnya.setVisibility(View.INVISIBLE);

                mSelectedSimpan = "Lomba";
                updateFilteredTingkat();
            }
        });

        ConstraintLayout constraintSeminar = findViewById(R.id.frame_ic_seminar_disimpan);
        constraintSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                garisSemua.setVisibility(View.INVISIBLE);
                garisLomba.setVisibility(View.INVISIBLE);
                garisSeminar.setVisibility(View.VISIBLE);
                garisLainnya.setVisibility(View.INVISIBLE);

                mSelectedSimpan = "Seminar";
                updateFilteredTingkat();
            }
        });

        ConstraintLayout constraintLainnya = findViewById(R.id.frame_ic_lainnya_disimpan);
        constraintLainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                garisSemua.setVisibility(View.INVISIBLE);
                garisLomba.setVisibility(View.INVISIBLE);
                garisSeminar.setVisibility(View.INVISIBLE);
                garisLainnya.setVisibility(View.VISIBLE);

                mSelectedSimpan = "Lainnya";
                updateFilteredTingkat();
            }
        });


        ImageView icTitikTiga = findViewById(R.id.ic_titik_tiga);
        icTitikTiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_simpan, popupMenu.getMenu());

        // Set tindakan saat item-menu dipilih
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_about:
                        // Tindakan yang akan diambil saat item About diklik
                        mSimpan.clear(); // Menghapus data dari itemList (variabel lokal di adapter)
                        mSimpanAdapter.setData(mSimpan); // Memperbarui adapter dengan data yang baru (kosong)
                        return true;
                    default:
                        return false;
                }
            }
        });
        // Tampilkan menu
        popupMenu.show();
    }


    private class SimpanAdapter extends RecyclerView.Adapter<SimpanAdapter.SimpanHolder>{
        private List<Simpan> mSimpans;

        public SimpanAdapter(List<Simpan> lombas){
            mSimpans = lombas;
        }

        public void setData(List<Simpan> lombas) {
            mSimpans = lombas;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public SimpanAdapter.SimpanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(SimpanActivity.this);

            return new SimpanAdapter.SimpanHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull SimpanAdapter.SimpanHolder holder, int position) {

            Simpan lomba = mSimpans.get(position);
            holder.bind(lomba);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);
            holder.itemView.setVisibility(View.VISIBLE);

            // Tambahkan OnClickListener ke ImageView sampah
            holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = holder.getAdapterPosition();
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        // Hapus item dari ArrayList dan RecyclerView
                        mSimpans.remove(itemPosition);
                        notifyItemRemoved(itemPosition);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mSimpans.size();
        }

        private class SimpanHolder extends RecyclerView.ViewHolder{
            private ImageView mPoster;
            private TextView mNamaLomba;
            private Simpan mSimpan;
            private ImageView deleteImageView;

            public SimpanHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_item_simpan, parent, false));

                mPoster = itemView.findViewById(R.id.cover_book_list_view);
                mNamaLomba = itemView.findViewById(R.id.nama_lomba);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(SimpanActivity.this, R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(SimpanActivity.this, DetailLombaActivity.class);
                        startActivity(intent);
                    }
                });

                deleteImageView = itemView.findViewById(R.id.ic_hapus_disimpan);
            }
            public void bind(Simpan lomba){
                mSimpan = lomba;
                mNamaLomba.setText(lomba.getNamaLomba());
                if(lomba.getIdLomba().equals("1")){
                    mPoster.setImageResource(R.drawable.lomba1);
                } else if (lomba.getIdLomba().equals("2")) {
                    mPoster.setImageResource(R.drawable.lomba2);
                } else if (lomba.getIdLomba().equals("3")) {
                    mPoster.setImageResource(R.drawable.lomba3);
                } else if (lomba.getIdLomba().equals("4")) {
                    mPoster.setImageResource(R.drawable.seminar1);
                } else if (lomba.getIdLomba().equals("5")) {
                    mPoster.setImageResource(R.drawable.seminar4);
                }else if (lomba.getIdLomba().equals("6")) {
                    mPoster.setImageResource(R.drawable.seminar5);
                } else if (lomba.getIdLomba().equals("7")) {
                    mPoster.setImageResource(R.drawable.lomba4);
                } else if (lomba.getIdLomba().equals("8")) {
                    mPoster.setImageResource(R.drawable.lomba5);
                } else if (lomba.getIdLomba().equals("9")) {
                    mPoster.setImageResource(R.drawable.lomba1);
                }
            }
        }
    }



    private void updateSimpan(List<Simpan> lombaList){
        mSimpan = lombaList;
        mSimpanAdapter = new SimpanAdapter(mSimpan);
        mRVSimpan.setAdapter(mSimpanAdapter);
    }

    List<Simpan> lombas = dataSimpan1();

    public List<Simpan> dataSimpan1(){
        List<Simpan> simpanList = new ArrayList<>();

        Simpan simpan1 = new Simpan();
        simpan1.setIdLomba("1");
        simpan1.setNamaLomba("Amikom Video Competition");
        simpan1.setJenisDisimpan("Lomba");
        simpanList.add(simpan1);

        Simpan simpan2 = new Simpan();
        simpan2.setIdLomba("2");
        simpan2.setNamaLomba("Teknologi Zaman Now");
        simpan2.setJenisDisimpan("Lomba");
        simpanList.add(simpan2);

        Simpan simpan3 = new Simpan();
        simpan3.setIdLomba("3");
        simpan3.setNamaLomba("Robonec");
        simpan3.setJenisDisimpan("Lomba");
        simpanList.add(simpan3);

        Simpan simpan4 = new Simpan();
        simpan4.setIdLomba("4");
        simpan4.setJenisDisimpan("Seminar");
        simpan4.setNamaLomba("First Step");
        simpanList.add(simpan4);

        Simpan simpan5 = new Simpan();
        simpan5.setIdLomba("5");
        simpan5.setJenisDisimpan("Seminar");
        simpan5.setNamaLomba("Start Up");
        simpanList.add(simpan5);

        Simpan simpan6 = new Simpan();
        simpan6.setIdLomba("6");
        simpan6.setJenisDisimpan("Seminar");
        simpan6.setNamaLomba("Let Secure Your Code");
        simpanList.add(simpan6);

        Simpan simpan7 = new Simpan();
        simpan7.setIdLomba("7");
        simpan7.setJenisDisimpan("Lainnya");
        simpan7.setNamaLomba("Sertifikasi Huawei");
        simpanList.add(simpan7);

        Simpan simpan8 = new Simpan();
        simpan8.setIdLomba("8");
        simpan8.setJenisDisimpan("Lainnya");
        simpan8.setNamaLomba("MSIB Program Magang");
        simpanList.add(simpan8);

        Simpan simpan9 = new Simpan();
        simpan9.setIdLomba("9");
        simpan9.setJenisDisimpan("Lainnya");
        simpan9.setNamaLomba("Magang Kampus Merdeka");
        simpanList.add(simpan9);
//        for(int i  = 0; i < 5; i++){
//            Seminar seminar = new Seminar();
//            seminar.setIdSeminar("" + i + 1);
//            seminar.setNamaSeminar("Seminar " + i);
//            seminarList.add(seminar);
//        }
        return simpanList;
    }

    public List<Simpan> dataSimpan(){
        List<Simpan> lombaList = new ArrayList<>();
        for(int i  = 0; i < 3; i++){
            Simpan simpan = new Simpan();
            simpan.setIdLomba("" + i + 1);
            simpan.setNamaLomba("Lomba " + i);
            simpan.setJenisDisimpan("Lomba");
            lombaList.add(simpan);
        }
        for(int i  = 3; i < 6; i++){
            Simpan simpan = new Simpan();
            simpan.setIdLomba("" + i + 1);
            simpan.setNamaLomba("Seminar " + i);
            simpan.setJenisDisimpan("Seminar");
            lombaList.add(simpan);
        }
        for(int i  = 6; i < 9; i++){
            Simpan simpan = new Simpan();
            simpan.setIdLomba("" + i + 1);
            simpan.setNamaLomba("Kegiatan Lainnya " + i);
            simpan.setJenisDisimpan("Lainnya");
            lombaList.add(simpan);
        }
        return lombaList;
    }

    private void updateFilteredTingkat() {
        List<Simpan> filteredList = new ArrayList<>();
        if (mSimpan != null) {
            if (mSelectedSimpan.equals("Semua")) {
                // Jika "Select One" dipilih, tampilkan semua data historis
                filteredList.addAll(mSimpan);
            } else {
                // Jika filter lain dipilih, lakukan pemfilteran berdasarkan status
                for (Simpan lomba : mSimpan) {
                    if (mSelectedSimpan.equals("Semua") && lomba.getJenisDisimpan() == "Semua") {
                        filteredList.add(lomba);
                    } else if (mSelectedSimpan.equals("Lomba") && lomba.getJenisDisimpan() == "Lomba") {
                        filteredList.add(lomba);
                    } else if (mSelectedSimpan.equals("Seminar") && lomba.getJenisDisimpan() == "Seminar") {
                        filteredList.add(lomba);
                    } else if (mSelectedSimpan.equals("Lainnya") && lomba.getJenisDisimpan() == "Lainnya") {
                        filteredList.add(lomba);
                    }
                }
            }
        }
        mSimpanAdapter.setData(filteredList);
    }





}
