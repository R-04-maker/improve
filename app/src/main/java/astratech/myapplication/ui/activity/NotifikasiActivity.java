package astratech.myapplication.ui.activity;

import android.annotation.SuppressLint;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import astratech.myapplication.R;
import astratech.myapplication.model.HistoryPoin;
import astratech.myapplication.model.HistoryXP;
import astratech.myapplication.model.Notifikasi;
import astratech.myapplication.model.Simpan;

public class NotifikasiActivity extends AppCompatActivity {

    private RecyclerView mRVNotifikasi;
    private NotifikasiAdapter mNotifikasiAdapter;
    private List<Notifikasi> mNotifikasi = dataNotifikasi();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifikasi);

        ImageView mBackButton = findViewById(R.id.backBtn);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        // Inisialisasi RecyclerView
        mRVNotifikasi = findViewById(R.id.rv_notifikasi);
        mRVNotifikasi.setLayoutManager(new LinearLayoutManager(this));


        // Inisialisasi adapter
        mNotifikasiAdapter = new NotifikasiAdapter(mNotifikasi);
        mRVNotifikasi.setAdapter(mNotifikasiAdapter);

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
                        mNotifikasi.clear(); // Menghapus data dari itemList (variabel lokal di adapter)
                        mNotifikasiAdapter.setData(mNotifikasi); // Memperbarui adapter dengan data yang baru (kosong)
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Tampilkan menu
        popupMenu.show();
    }


    private void updateFilteredTingkat() {
        List<Notifikasi> filteredList = new ArrayList<>();


//        if (mSimpan != null) {
//            if (mSelectedSimpan.equals("Semua")) {
//                // Jika "Select One" dipilih, tampilkan semua data historis
//                filteredList.addAll(mSimpan);
//            } else {
//                // Jika filter lain dipilih, lakukan pemfilteran berdasarkan status
//                for (Simpan lomba : mSimpan) {
//                    if (mSelectedSimpan.equals("Semua") && lomba.getJenisDisimpan() == "Semua") {
//                        filteredList.add(lomba);
//                    } else if (mSelectedSimpan.equals("Lomba") && lomba.getJenisDisimpan() == "Lomba") {
//                        filteredList.add(lomba);
//                    } else if (mSelectedSimpan.equals("Seminar") && lomba.getJenisDisimpan() == "Seminar") {
//                        filteredList.add(lomba);
//                    } else if (mSelectedSimpan.equals("Lainnya") && lomba.getJenisDisimpan() == "Lainnya") {
//                        filteredList.add(lomba);
//                    }
//                }
//            }
//        }
//        mSimpanAdapter.setData(filteredList);
    }



    public List<Notifikasi> dataNotifikasi(){
        List<Notifikasi> notifikasiList = new ArrayList<>();

        Notifikasi notifikasi1 = new Notifikasi();
        notifikasi1.setIdNotifikasi(String.valueOf(0));
        notifikasi1.setNamaNotifikasi("Pengajuan Lomba Diterima");
        notifikasi1.setDeskripsiNotifikasi("Selamat!!!, pengajuan perlombaan Web Design yang di selenggarakan oleh Universitas Brawijaya");
        notifikasi1.setWaktuNotifikasi("10 jam");
        notifikasi1.setJenisNotifikasi("Lomba");
        notifikasiList.add(notifikasi1);

        Notifikasi notifikasi2 = new Notifikasi();
        notifikasi2.setIdNotifikasi(String.valueOf(1));
        notifikasi2.setNamaNotifikasi("Pengajuan Dana Diterima");
        notifikasi2.setDeskripsiNotifikasi("Selamat!!!, pengajuan dana untuk mengikuti perlombaan Web Design yang di selenggarakan oleh");
        notifikasi2.setWaktuNotifikasi("15 jam");
        notifikasi2.setJenisNotifikasi("Dana");
        notifikasiList.add(notifikasi2);

        Notifikasi notifikasi3 = new Notifikasi();
        notifikasi3.setIdNotifikasi(String.valueOf(2));
        notifikasi3.setNamaNotifikasi("Pengajuan Surat Diterima");
        notifikasi3.setDeskripsiNotifikasi("Selamat!!!, pengajuan surat pengantar untuk mengikuti perlombaan Web Design yang di selengga");
        notifikasi3.setWaktuNotifikasi("20 jam");
        notifikasi3.setJenisNotifikasi("Surat Pengantar");
        notifikasiList.add(notifikasi3);

        Notifikasi notifikasi4 = new Notifikasi();
        notifikasi4.setIdNotifikasi(String.valueOf(3));
        notifikasi4.setNamaNotifikasi("Pengajuan Kegiatan Ditolak");
        notifikasi4.setDeskripsiNotifikasi("Maaf!!!, pengajuan kegiatan magang dan sertifikasi yang di selenggarakan oleh kampus merdeka");
        notifikasi4.setWaktuNotifikasi("1 hari");
        notifikasi4.setJenisNotifikasi("Lainnya");
        notifikasiList.add(notifikasi4);

        Notifikasi notifikasi5 = new Notifikasi();
        notifikasi5.setIdNotifikasi(String.valueOf(4));
        notifikasi5.setNamaNotifikasi("Pengajuan Seminar Diterima");
        notifikasi5.setDeskripsiNotifikasi("Selamat!!!, pengajuan seminar Data Analis yang di selenggarkan oleh perusahaan Astra Honda M");
        notifikasi5.setWaktuNotifikasi("2 hari");
        notifikasi5.setJenisNotifikasi("Seminar");
        notifikasiList.add(notifikasi5);

        Notifikasi notifikasi6 = new Notifikasi();
        notifikasi6.setIdNotifikasi(String.valueOf(5));
        notifikasi6.setNamaNotifikasi("Pengajuan Lomba Diterima");
        notifikasi6.setDeskripsiNotifikasi("Selamat!!!, pengajuan perlombaan Web Design yang di selenggaran oleh Universitas Brawijaya");
        notifikasi6.setWaktuNotifikasi("1 minggu");
        notifikasi6.setJenisNotifikasi("Lomba");
        notifikasiList.add(notifikasi6);

        Notifikasi notifikasi7 = new Notifikasi();
        notifikasi7.setIdNotifikasi(String.valueOf(6));
        notifikasi7.setNamaNotifikasi("Pengajuan Konsultasi Diterima");
        notifikasi7.setDeskripsiNotifikasi("Selamat!!!, pengajuan konsultasi perlombaan Web Design yang di selenggaran oleh Universitas");
        notifikasi7.setWaktuNotifikasi("5 minggu");
        notifikasi7.setJenisNotifikasi("Konsultasi");
        notifikasiList.add(notifikasi7);

        Notifikasi notifikasi8 = new Notifikasi();
        notifikasi8.setIdNotifikasi(String.valueOf(7));
        notifikasi8.setNamaNotifikasi("Pengajuan Lomba Diterima");
        notifikasi8.setDeskripsiNotifikasi("Selamat!!!, pengajuan perlombaan Web Design yang di selenggaran oleh Universitas Brawijaya");
        notifikasi8.setWaktuNotifikasi("7 bulan");
        notifikasi8.setJenisNotifikasi("Lomba");
        notifikasiList.add(notifikasi8);

        return notifikasiList;
    }

    private void updateNotifikasi(List<Notifikasi> notifikasiLists){
        mNotifikasiAdapter = new NotifikasiAdapter(notifikasiLists);
        mRVNotifikasi.setAdapter(mNotifikasiAdapter);
    }

    public class NotifikasiAdapter extends RecyclerView.Adapter<NotifikasiAdapter.ViewHolder> {


        public void setData(List<Notifikasi> lombas) {
            mNotifikasi = lombas;
            notifyDataSetChanged();
        }

        private List<Notifikasi> itemList; // Anda perlu membuat kelas HistoryXP untuk menyimpan data

        public NotifikasiAdapter(List<Notifikasi> itemList) {
            this.itemList = itemList;
        }

        @NonNull
        @Override
        public NotifikasiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_notifikasi, parent, false);
            return new NotifikasiAdapter.ViewHolder(view);
        }

        public void removeItem(int position) {
            if (position >= 0 && position < itemList.size()) {
                itemList.remove(position);
                notifyItemRemoved(position);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull NotifikasiAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            Notifikasi item = itemList.get(position);
            holder.bind(item);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);

            holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = holder.getAdapterPosition();
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        // Hapus item dari ArrayList dan RecyclerView
                        mNotifikasi.remove(itemPosition);
                        notifyItemRemoved(itemPosition);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            // Deklarasikan elemen-elemen tampilan di sini
            // Misalnya, TextView textView;
            private Notifikasi mNotifikasi;

            private TextView mTanggal;
            private ImageView mImageIcon;
            private TextView mNamaOrang;
            private TextView mPoin;
            private TextView mJudulWaktu;

            private ImageView deleteImageView;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                mTanggal = itemView.findViewById(R.id.tanggal_history_poin);
                mNamaOrang = itemView.findViewById(R.id.nama_history_poin);
                mPoin = itemView.findViewById(R.id.history_jumlah_poin);
                mImageIcon = itemView.findViewById(R.id.image_ic_notifikasi);
                mJudulWaktu = itemView.findViewById(R.id.txt_waktu);
                deleteImageView = itemView.findViewById(R.id.ic_hapus_notifikasi);

                itemView.setOnClickListener(this);

                // Inisialisasi elemen-elemen tampilan di sini
                // Misalnya, textView = itemView.findViewById(R.id.textView);
            }

            public void bind(Notifikasi notifikasi){
                mNotifikasi = notifikasi;
                mNamaOrang.setText(notifikasi.getNamaNotifikasi());
                mTanggal.setText(notifikasi.getDeskripsiNotifikasi());
                mPoin.setText(notifikasi.getWaktuNotifikasi());

                if(notifikasi.getJenisNotifikasi().equals("Lomba")){
                    mImageIcon.setImageResource(R.drawable.ic_lomba);
                }else if(notifikasi.getJenisNotifikasi().equals("Seminar")){
                    mImageIcon.setImageResource(R.drawable.ic_seminar);
                }else if(notifikasi.getJenisNotifikasi().equals("Lainnya")){
                    mImageIcon.setImageResource(R.drawable.ic_lainnya);
                }else if(notifikasi.getJenisNotifikasi().equals("Dana")){
                    mImageIcon.setImageResource(R.drawable.ic_dana);
                }else if(notifikasi.getJenisNotifikasi().equals("Konsultasi")){
                    mImageIcon.setImageResource(R.drawable.ic_konsultasi);
                }else if(notifikasi.getJenisNotifikasi().equals("Surat Pengantar")){
                    mImageIcon.setImageResource(R.drawable.ic_surat);
                }

                if(notifikasi.getWaktuNotifikasi().equals("10 jam")){
                    mJudulWaktu.setVisibility(View.VISIBLE);
                } else if (notifikasi.getWaktuNotifikasi().equals("1 hari")) {
                    mJudulWaktu.setVisibility(View.VISIBLE);
                    mJudulWaktu.setText("7 Hari Terakhir");
                } else if (notifikasi.getWaktuNotifikasi().equals("1 minggu")) {
                    mJudulWaktu.setVisibility(View.VISIBLE);
                    mJudulWaktu.setText("30 Hari Terakhir");
                } else if (notifikasi.getWaktuNotifikasi().equals("7 bulan")) {
                    mJudulWaktu.setVisibility(View.VISIBLE);
                    mJudulWaktu.setText("Lebih dari 30 Hari");
                }

            }


            @Override
            public void onClick(View view) {

            }
        }
    }
}
