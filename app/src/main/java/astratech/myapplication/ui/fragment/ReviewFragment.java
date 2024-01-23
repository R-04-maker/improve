package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Space;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.ArrayList;
import astratech.myapplication.R; // Gantilah dengan nama package aplikasi Anda
import astratech.myapplication.model.Review;
import astratech.myapplication.model.Simpan;
import astratech.myapplication.ui.activity.DetailReviewActivity;
import astratech.myapplication.ui.activity.DetailSertifikatActivity;
import astratech.myapplication.ui.activity.PotoReviewActivity;
import astratech.myapplication.ui.activity.SimpanActivity;

public class ReviewFragment extends Fragment {

    private RecyclerView recyclerView;
    private ReviewAdapter adapter;
    private List<Review> mReview;
    private String mSelectedReview = "FYP";

    public int Status = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review, container, false);

        // Inisialisasi RecyclerView
        recyclerView = view.findViewById(R.id.review_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        updateSimpan(lombas);


        ImageView imgSeparatorFYP = view.findViewById(R.id.separatororange);
        ImageView imgSeparatorTop = view.findViewById(R.id.separatororangeTeratas);

        TextView txtFyp = view.findViewById(R.id.FYPtxt);
        TextView txtTeratas = view.findViewById(R.id.reviewteratastxt);

        txtFyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelectedReview = "FYP";
                updateFilteredReview();
                Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
                Typeface normalTypeface = Typeface.defaultFromStyle(Typeface.NORMAL);

                txtFyp.setTypeface(boldTypeface);
                txtTeratas.setTypeface(normalTypeface);

                Status = 0;
  /*              if (Status == 1){
                    Status = 0;
                } else {
                    Status= 1;
                }*/

                imgSeparatorFYP.setVisibility(View.VISIBLE);
                imgSeparatorTop.setVisibility(View.INVISIBLE);
            }
        });


        txtTeratas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSelectedReview = "TOP";
                updateFilteredReview();

                Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
                Typeface normalTypeface = Typeface.defaultFromStyle(Typeface.NORMAL);

                txtFyp.setTypeface(normalTypeface);
                txtTeratas.setTypeface(boldTypeface);

                imgSeparatorFYP.setVisibility(View.INVISIBLE);
                imgSeparatorTop.setVisibility(View.VISIBLE);

                Status = 1;

            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // dx adalah perubahan horizontal dan dy adalah perubahan vertikal saat RecyclerView digeser.

                if (dy > 0) {
                    ImageView spasiImg = view.findViewById(R.id.spasi_kebawah_rv);
                    spasiImg.setVisibility(View.VISIBLE);
                    // RecyclerView sedang digeser ke bawah (scroll down)
                    // Tambahkan kode yang ingin dijalankan saat scroll down di sini
                } else if (dy < 0) {
                    ImageView spasiImg = view.findViewById(R.id.spasi_kebawah_rv);
                    spasiImg.setVisibility(View.GONE);
                    // RecyclerView sedang digeser ke atas (scroll up)
                    // Tambahkan kode yang ingin dijalankan saat scroll up di sini
                }
            }
        });

        return view;
    }

    private void updateSimpan(List<Review> lombaList){
        mReview = lombaList;
        adapter = new ReviewAdapter(mReview);
        recyclerView.setAdapter(adapter);
    }

    List<Review> lombas = dataReview();

    private void updateFilteredReview() {
        List<Review> filteredList = new ArrayList<>();

        if (mReview != null) {
            if (mSelectedReview.equals("FYP")) {
                // Jika "Select One" dipilih, tampilkan semua data historis
                filteredList.addAll(mReview);
            } else {
                // Jika filter lain dipilih, lakukan pemfilteran berdasarkan status
                for (Review lomba : mReview) {
                    if (mSelectedReview.equals("TOP") && lomba.getJenisReview().equals("TOP")) {
                        filteredList.add(lomba);
                        System.out.println(mSelectedReview);
                    }
                }
            }
        }
        adapter.setData(filteredList);
    }

    public List<Review> dataReview() {
        List<Review> reviewList = new ArrayList<>();

        Review review1 = new Review();
        review1.setIdReview(1);
        review1.setNamaPereview("Arya Kusuma Dharmawan");
        review1.setTglReview("7 hari");
        review1.setCaptionReview("Assalamualaikum guys, menjadi finalis di Semarang fest 2023,  Alhamdulillah dapat juara 2, mudah2-an temen2 nyusul !!");
        review1.setJenisReview("FYP");
        reviewList.add(review1);

        Review review2 = new Review();
        review2.setIdReview(2);
        review2.setNamaPereview("Rian Fauzi");
        review2.setTglReview("12 hari");
        review2.setCaptionReview("Hallo Teman-teman, menjadi finalis di Gemastik Pemrograman 2023,  Alhamdulillah dapat juara 2, dah dah !");
        review2.setJenisReview("FYP");
        reviewList.add(review2);

        Review review3 = new Review();
        review3.setIdReview(3);
        review3.setNamaPereview("Rapli Ananta");
        review3.setTglReview("25 hari");
        review3.setCaptionReview("Halo guys, menjadi Juara di Bekasi fest 2023,  Alhamdulillah dapat juara 2, terimakasih ");
        review3.setJenisReview("FYP");
        reviewList.add(review3);

        Review review4 = new Review();
        review4.setIdReview(4);
        review4.setNamaPereview("Farhan Ramadhan");
        review4.setTglReview("1 bulan");
        review4.setCaptionReview("Selamat Pagi guys, menjadi Juara di Bekasi fest 2023,  Alhamdulillah dapat juara 2, Semangat teman-teman");
        review4.setJenisReview("FYP");
        reviewList.add(review4);

        Review review5 = new Review();
        review5.setIdReview(5);
        review5.setNamaPereview("Dinda Putri");
        review5.setTglReview("7 hari");
        review5.setCaptionReview("Assalamualaikum guys, menjadi finalis di Semarang fest 2023,  Alhamdulillah dapat juara 2, mudah2-an temen2 nyusul !");
        review5.setJenisReview("FYP");
        reviewList.add(review5);

        Review review6 = new Review();
        review6.setIdReview(6);
        review6.setNamaPereview("Wahid isnaini");
        review6.setTglReview("12 hari");
        review6.setCaptionReview("Hallo Teman-teman, menjadi finalis di Gemastik Pemrograman 2023,  Alhamdulillah dapat juara 2, terimakasih dukungannya teman-teman !");
        review6.setJenisReview("TOP");
        reviewList.add(review6);

        Review review7 = new Review();
        review7.setIdReview(7);
        review7.setNamaPereview("Salman Alfirdaus");
        review7.setTglReview("25 hari");
        review7.setCaptionReview("Halo guys, menjadi Juara di Bekasi fest 2023,  Alhamdulillah dapat juara 2, terimakasih dukungannya teman-teman !");
        review7.setJenisReview("TOP");
        reviewList.add(review7);

        Review review8 = new Review();
        review8.setIdReview(8);
        review8.setNamaPereview("Farhan Ramadhan");
        review8.setTglReview("1 bulan");
        review8.setCaptionReview("Selamat Pagi guys, menjadi Juara di Bekasi fest 2023,  Alhamdulillah dapat juara 2, terimakasih dukungannya teman-teman !");
        review8.setJenisReview("TOP");
        reviewList.add(review8);

        Review review9 = new Review();
        review9.setIdReview(9);
        review9.setNamaPereview("Ell Nur Ghazy");
        review9.setTglReview("1 bulan");
        review9.setCaptionReview("Selamat Pagi guys, menjadi Juara di Bekasi fest 2023,  Alhamdulillah dapat juara 2, terimakasih dukungannya teman-teman !");
        review9.setJenisReview("TOP");
        reviewList.add(review9);

        Review review10 = new Review();
        review10.setIdReview(10);
        review10.setNamaPereview("Yunika Faradila");
        review10.setTglReview("1 bulan");
        review10.setCaptionReview("Selamat Pagi guys, menjadi Juara di Bekasi fest 2023,  Alhamdulillah dapat juara 2, terimakasih dukungannya teman-teman !");
        review10.setJenisReview("TOP");
        reviewList.add(review10);

//        for (int i = 0; i < 5; i++) {
//            Review review = new Review();
//            review.setIdReview(i + 1);
//            review.setNamaPereview("Nazwa Frida Fauziyyah");
//            review.setTglReview("7 hari");
//            review.setCaptionReview("Share pengalamanku saat lomba dan menjadi finalis di Gemastik Perpusnas 2023,  Alhamdulillah dapat juara 2, terimakasih dukungannya teman-teman !");
//            review.setJenisReview("FYP");
//            reviewList.add(review);
//        }
//        for (int i = 5; i < 10; i++) {
////            Review review = new Review();
//            review.setIdReview(i + 1);
//            review.setNamaPereview("Muhammad Gema Rhomadhon");
//            review.setTglReview("30 hari");
//            review.setCaptionReview("Pengalamanku saat lomba yang sangat mengesankan, menambah banyak ilmu pengetahuan, pengalaman dan wawasan yang luas, saya alhamdulillah mendapat juara 1, terimakasih doanya teman-teman !");
//            review.setJenisReview("TOP");
//            reviewList.add(review);
//        }
        return reviewList;
    }


    private int jumlah = 0;

    // Sisipkan kelas Adapter di dalam kelas Fragment ini
    public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

        private List<Review> mReviews;

        public ReviewAdapter(List<Review> itemList) {
            this.mReviews = itemList;
        }

        public void setData(List<Review> lombas) {
            mReviews = lombas;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_review, parent, false);
            return new ReviewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {
            Review item = mReviews.get(position);
            holder.bind(item);

            holder.imgTitikTiga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showPopupMenu(view);
                }
            });

            holder.photoReview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), PotoReviewActivity.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mReviews.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView mNamaOrang;
            private TextView mTanggal;
            private TextView mCaption;
            private ImageView imgTitikTiga;
            private ImageView photoReview, imageView, photoOrangReview;
            private TextView space;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                mNamaOrang = itemView.findViewById(R.id.nama_orang_lb);
                mTanggal = itemView.findViewById(R.id.tgl_review);
                mCaption = itemView.findViewById(R.id.caption_review);

                imgTitikTiga = itemView.findViewById(R.id.ic_titik_tiga_review);
                photoReview = itemView.findViewById(R.id.img_review);
                space = itemView.findViewById(R.id.spasi_kebawah);
                imageView = itemView.findViewById(R.id.api_review1);

                photoOrangReview = itemView.findViewById(R.id.imageOrang_rev1);


                itemView.setOnClickListener(this);
            }

            public void bind(Review review) {
                mNamaOrang.setText(review.getNamaPereview());
                mTanggal.setText(review.getTglReview());
                mCaption.setText(review.getCaptionReview());

                if(review.getIdReview() == 1){
                    photoReview.setImageResource(R.drawable.review1);
                    photoOrangReview.setImageResource(R.drawable.foto1);
                } else if (review.getIdReview() == 2) {
                    photoReview.setImageResource(R.drawable.review2);
                    photoOrangReview.setImageResource(R.drawable.foto2);
                } else if (review.getIdReview() == 3) {
                    photoReview.setImageResource(R.drawable.review3);
                    photoOrangReview.setImageResource(R.drawable.foto3);
                } else if (review.getIdReview() == 4) {
                    photoReview.setImageResource(R.drawable.review4);
                    photoOrangReview.setImageResource(R.drawable.foto2);
                } else if (review.getIdReview() == 5) {
                    photoReview.setImageResource(R.drawable.review5);
                    photoOrangReview.setImageResource(R.drawable.foto1);
                } else if (review.getIdReview() == 6) {
                    photoReview.setImageResource(R.drawable.review2);
                    photoOrangReview.setImageResource(R.drawable.foto2);
                } else if (review.getIdReview() == 7) {
                    photoReview.setImageResource(R.drawable.review3);
                    photoOrangReview.setImageResource(R.drawable.foto2);
                } else if (review.getIdReview() == 8) {
                    photoReview.setImageResource(R.drawable.review4);
                    photoOrangReview.setImageResource(R.drawable.foto3);
                } else if (review.getIdReview() == 9) {
                    photoReview.setImageResource(R.drawable.review5);
                    photoOrangReview.setImageResource(R.drawable.foto2);
                } else if (review.getIdReview() == 10) {
                    photoReview.setImageResource(R.drawable.review5);
                    photoOrangReview.setImageResource(R.drawable.foto1);
                }

                if(Status == 0){
                    imageView.setVisibility(View.GONE);
                }else {
                    imageView.setVisibility(View.VISIBLE);
                }





//                jumlah = jumlah + 1;
//                if(jumlah == 10){
//                    space.setVisibility(View.VISIBLE);
//                }
            }

            @Override
            public void onClick(View view) {
                // Implementasi tindakan klik jika diperlukan
                Intent intent = new Intent(getActivity(), DetailReviewActivity.class);
                startActivity(intent);
            }
        }
    }


    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), view); // Gunakan requireContext() untuk mendapatkan konteks fragment
        requireActivity().getMenuInflater().inflate(R.menu.menu_report, popupMenu.getMenu());

        // Set tindakan saat item-menu dipilih
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_about:
                        // Tindakan yang akan diambil saat item About diklik
                        // Misalnya, tampilkan dialog About di sini
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Tampilkan menu
        popupMenu.show();
    }
}
