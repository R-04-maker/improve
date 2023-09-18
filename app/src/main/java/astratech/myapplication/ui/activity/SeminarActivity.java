package astratech.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import astratech.myapplication.R;
import astratech.myapplication.model.Lomba;
import astratech.myapplication.model.Seminar;

public class SeminarActivity extends AppCompatActivity {
    private ImageView mBackBtn;
    private ViewPager2 mViewPager2;
    private RecyclerView mRVSeminar, mRVSeminarLain;
    private Handler slideHandler = new Handler();
    private List<Seminar> mSeminars;
    private SeminarAdapter mSeminarAdapter;
    private SeminarLainAdapter mSeminarLainAdapter;
    private boolean showAllItems = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seminar);

        mBackBtn = findViewById(R.id.back_buttonn);

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mViewPager2 = findViewById(R.id.slider);
        mViewPager2.setClipToPadding(false);
        mViewPager2.setClipChildren(false);
        mViewPager2.setOffscreenPageLimit(5);
        mViewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        mRVSeminar = findViewById(R.id.rv_lomba_lomba);
        mRVSeminar.setLayoutManager(new LinearLayoutManager(SeminarActivity.this, LinearLayoutManager.HORIZONTAL, false));
        mRVSeminar.setAdapter(mSeminarAdapter);

        mRVSeminarLain = findViewById(R.id.rv_lomba_lainnya);
        mRVSeminarLain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRVSeminarLain.setAdapter(mSeminarLainAdapter);
        mRVSeminarLain.setItemAnimator(null);
        mRVSeminarLain.setOverScrollMode(mRVSeminarLain.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });
        mViewPager2.setPageTransformer(compositePageTransformer);

        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable, 2000);
            }
        });
        List<Seminar> lombas = dataLomba();
        updateSlider(lombas);
        updateLomba(lombas);
        updateLombaLain(lombas);

        ImageView textViewLihatLainnya = findViewById(R.id.textViewLihatLainnya);
        textViewLihatLainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAllItems = !showAllItems;
                mSeminarLainAdapter.notifyDataSetChanged();
                if (showAllItems) {
                    textViewLihatLainnya.setVisibility(View.GONE);
                }
            }
        });
    }
    private void updateSlider(List<Seminar> seminarList){
        mSeminars = seminarList;
        mViewPager2.setAdapter(new SliderAdapter(mSeminars,mViewPager2));
    }
    private void updateLomba(List<Seminar> seminarList){
        mSeminars = seminarList;
        mSeminarAdapter = new SeminarAdapter(mSeminars);
        mRVSeminar.setAdapter(mSeminarAdapter);
    }
    private void updateLombaLain(List<Seminar> seminarList){
        mSeminars = seminarList;
        mSeminarLainAdapter = new SeminarLainAdapter(mSeminars);
        mRVSeminarLain.setAdapter(mSeminarLainAdapter);
    }
    public List<Seminar> dataLomba(){
        List<Seminar> seminarList = new ArrayList<>();
        for(int i  = 0; i < 5; i++){
            Seminar seminar = new Seminar();
            seminar.setIdSeminar("" + i + 1);
            seminar.setNamaSeminar("Seminar " + i);
            seminarList.add(seminar);
        }
        return seminarList;
    }
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            mViewPager2.setCurrentItem(mViewPager2.getCurrentItem() + 1);
        }
    };
    private class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderHolder>{
        private List<Seminar> mSeminars;
        private ViewPager2 mViewPager2;

        public SliderAdapter(List<Seminar> seminars, ViewPager2 viewPager2){
            mSeminars = seminars;
            mViewPager2 = viewPager2;
        }

        @NonNull
        @Override
        public SliderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(SeminarActivity.this);

            return new SliderHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SliderHolder holder, int position) {
            Seminar seminar = mSeminars.get(position);
            holder.onBindViewHolder(seminar);
        }

        @Override
        public int getItemCount() {
            return mSeminars.size();
        }

        private class SliderHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private TextView mNamaLomba, mKategori, mTanggal;
            private ImageView mPoster;
            private Seminar mSeminar;

            public SliderHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_banner_card, parent, false));

                mPoster = itemView.findViewById(R.id.cover_book_list_view);
                mNamaLomba = itemView.findViewById(R.id.nama_lomba);
                mTanggal = itemView.findViewById(R.id.tgl_lomba);

                itemView.setOnClickListener(this);
            }
            public void onBindViewHolder(Seminar seminar){
                mSeminar = seminar;
                mNamaLomba.setText(mSeminar.getNamaSeminar());
            }
            @Override
            public void onClick(View view){
                Animation scaleDown = AnimationUtils.loadAnimation(SeminarActivity.this, R.anim.scale_down);
                itemView.startAnimation(scaleDown);
                Intent intent = new Intent(SeminarActivity.this, DetailLombaActivity.class);
//                        intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                startActivity(intent);            }
        }
    }
    private class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.SeminarHolder>{
        private List<Seminar> mSeminars;

        public SeminarAdapter(List<Seminar> seminars){
            mSeminars = seminars;
        }

        @NonNull
        @Override
        public SeminarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(SeminarActivity.this);

            return new SeminarHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull SeminarHolder holder, int position) {
            Seminar seminar = mSeminars.get(position);
            holder.bind(seminar);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);
        }

        @Override
        public int getItemCount() {
            return mSeminars.size();
        }

        private class SeminarHolder extends RecyclerView.ViewHolder{
            private ImageView mPoster;
            private TextView mNamaLomba;
            private Seminar mSeminar;

            public SeminarHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_rekomendasi_home, parent, false));

                mPoster = itemView.findViewById(R.id.cover_image);
                mNamaLomba = itemView.findViewById(R.id.title);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(SeminarActivity.this, R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(SeminarActivity.this, DetailLombaActivity.class);
//                        intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                        startActivity(intent);
                    }
                });
            }
            public void bind(Seminar seminar){
                mSeminar = seminar;
                mNamaLomba.setText(seminar.getNamaSeminar());
            }
        }
    }
    private class SeminarLainAdapter extends RecyclerView.Adapter<SeminarLainAdapter.SeminarHolder>{
        private List<Seminar> mSeminars;

        public SeminarLainAdapter(List<Seminar> seminars){
            mSeminars = seminars;
        }

        @NonNull
        @Override
        public SeminarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(SeminarActivity.this);

            return new SeminarHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull SeminarHolder holder, int position) {

            if (!showAllItems && position >= 3) {
                holder.itemView.setVisibility(View.GONE);
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            } else {
                Seminar seminar = mSeminars.get(position);
                holder.bind(seminar);
                Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
                holder.itemView.startAnimation(animation);
                holder.itemView.setVisibility(View.VISIBLE);
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
            }
        }

        @Override
        public int getItemCount() {
            return mSeminars.size();
        }

        private class SeminarHolder extends RecyclerView.ViewHolder{
            private ImageView mPoster;
            private TextView mNamaLomba;
            private Seminar mSeminar;

            public SeminarHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_card_event, parent, false));

                mPoster = itemView.findViewById(R.id.cover_book_list_view);
                mNamaLomba = itemView.findViewById(R.id.nama_lomba);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(SeminarActivity.this, R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(SeminarActivity.this, DetailLombaActivity.class);
//                        intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                        startActivity(intent);
                    }
                });
            }
            public void bind(Seminar seminar){
                mSeminar = seminar;
                mNamaLomba.setText(seminar.getNamaSeminar());
            }
        }
    }
}