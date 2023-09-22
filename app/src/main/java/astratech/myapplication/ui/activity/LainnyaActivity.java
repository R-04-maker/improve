package astratech.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

public class LainnyaActivity extends AppCompatActivity {
    private ViewPager2 mViewPager2;
    private ImageView mBackBtn;
    private RecyclerView mRVLomba, mRVLombaLain;
    private Handler slideHandler = new Handler();
    private List<Lomba> mLomba;
    private EditText mSearchTxt;
    private LombaAdapter mLombaAdapter;
    private LombaLainAdapter mLombaLainAdapter;
    private boolean showAllItems = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lainnya);

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

        mRVLomba = findViewById(R.id.rv_lomba_lomba);
        mRVLomba.setLayoutManager(new LinearLayoutManager(LainnyaActivity.this, LinearLayoutManager.HORIZONTAL, false));
        mRVLomba.setAdapter(mLombaAdapter);

        mRVLombaLain = findViewById(R.id.rv_lomba_lainnya);
        mRVLombaLain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRVLombaLain.setAdapter(mLombaLainAdapter);
        mRVLombaLain.setItemAnimator(null);
        mRVLombaLain.setOverScrollMode(mRVLombaLain.OVER_SCROLL_NEVER);

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
        List<Lomba> lombas = dataLomba();
        updateSlider(lombas);
        updateLomba(lombas);
        updateLombaLain(lombas);

        ImageView textViewLihatLainnya = findViewById(R.id.textViewLihatLainnya);
        textViewLihatLainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAllItems = !showAllItems;
                mLombaLainAdapter.notifyDataSetChanged();
                if (showAllItems) {
                    textViewLihatLainnya.setVisibility(View.GONE);
                }
            }
        });
        mSearchTxt = findViewById(R.id.search);

        mSearchTxt.setFocusable(false);
        mSearchTxt.setClickable(false);
        mSearchTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LainnyaActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
    private void updateSlider(List<Lomba> lombaList){
        mLomba = lombaList;
        mViewPager2.setAdapter(new SliderAdapter(mLomba,mViewPager2));
    }
    private void updateLomba(List<Lomba> lombaList){
        mLomba = lombaList;
        mLombaAdapter = new LombaAdapter(mLomba);
        mRVLomba.setAdapter(mLombaAdapter);
    }
    private void updateLombaLain(List<Lomba> lombaList){
        mLomba = lombaList;
        mLombaLainAdapter = new LombaLainAdapter(mLomba);
        mRVLombaLain.setAdapter(mLombaLainAdapter);
    }
    public List<Lomba> dataLomba(){
        List<Lomba> lombaList = new ArrayList<>();

        Lomba lomba = new Lomba();
        lomba.setIdLomba("1");
        lomba.setNamaLomba("Teknologi Zaman Now");
        lomba.setGambarPoster("lomba1");
        lombaList.add(lomba);

        Lomba lomba1 = new Lomba();
        lomba1.setIdLomba("2");
        lomba1.setNamaLomba("Start Up");
        lomba1.setGambarPoster("lomba2");
        lombaList.add(lomba1);

        Lomba lomba2 = new Lomba();
        lomba2.setIdLomba("3");
        lomba2.setNamaLomba("E-Time");
        lomba2.setGambarPoster("lomba3");
        lombaList.add(lomba2);

        Lomba lomba3 = new Lomba();
        lomba3.setIdLomba("4");
        lomba3.setNamaLomba("First Step");
        lomba3.setGambarPoster("lomba4");
        lombaList.add(lomba3);

        Lomba lomba4 = new Lomba();
        lomba4.setIdLomba("5");
        lomba4.setNamaLomba("Let Secure Your Code");
        lomba4.setGambarPoster("lomba5");
        lombaList.add(lomba4);

        return lombaList;
    }
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            mViewPager2.setCurrentItem(mViewPager2.getCurrentItem() + 1);
        }
    };
    private class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderHolder>{
        private List<Lomba> mLombas;
        private ViewPager2 mViewPager2;

        public SliderAdapter(List<Lomba> lombas, ViewPager2 viewPager2){
            mLombas = lombas;
            mViewPager2 = viewPager2;
        }

        @NonNull
        @Override
        public SliderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(LainnyaActivity.this);

            return new SliderHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SliderHolder holder, int position) {
            Lomba lomba = mLombas.get(position);
            holder.onBindViewHolder(lomba);
        }

        @Override
        public int getItemCount() {
            return mLombas.size();
        }

        private class SliderHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private TextView mNamaLomba, mKategori, mTanggal;
            private ImageView mPoster;
            private Lomba mLomba;

            public SliderHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_banner_card, parent, false));

                mPoster = itemView.findViewById(R.id.cover_book_list_view);
                mNamaLomba = itemView.findViewById(R.id.nama_lomba);
                mTanggal = itemView.findViewById(R.id.tgl_lomba);

                itemView.setOnClickListener(this);
            }
            public void onBindViewHolder(Lomba lomba){
                mLomba = lomba;
                mNamaLomba.setText(lomba.getNamaLomba());
                if(lomba.getIdLomba().equals("1")){
                    mPoster.setImageResource(R.drawable.lomba2);
                } else if (lomba.getIdLomba().equals("2")) {
                    mPoster.setImageResource(R.drawable.seminar4);
                } else if (lomba.getIdLomba().equals("3")) {
                    mPoster.setImageResource(R.drawable.lomba4);
                } else if (lomba.getIdLomba().equals("4")) {
                    mPoster.setImageResource(R.drawable.seminar1);
                } else if (lomba.getIdLomba().equals("5")) {
                    mPoster.setImageResource(R.drawable.seminar5);
                }
            }
            @Override
            public void onClick(View view){
                Animation scaleDown = AnimationUtils.loadAnimation(LainnyaActivity.this, R.anim.scale_down);
                itemView.startAnimation(scaleDown);
                Intent intent = new Intent(LainnyaActivity.this, DetailLombaActivity.class);
                intent.putExtra("id", mLomba.getIdLomba());
                intent.putExtra("nama", mLomba.getNamaLomba());
                intent.putExtra("jenis_kegiatan", "Lainnya");
                startActivity(intent);
            }
        }
    }
    private class LombaAdapter extends RecyclerView.Adapter<LombaAdapter.LombaHolder>{
        private List<Lomba> mLombas;

        public LombaAdapter(List<Lomba> lombas){
            mLombas = lombas;
        }

        @NonNull
        @Override
        public LombaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(LainnyaActivity.this);

            return new LombaHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull LombaHolder holder, int position) {
            Lomba lomba = mLombas.get(position);
            holder.bind(lomba);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);
        }

        @Override
        public int getItemCount() {
            return mLombas.size();
        }

        private class LombaHolder extends RecyclerView.ViewHolder{
            private ImageView mPoster;
            private TextView mNamaLomba;
            private Lomba mLomba;

            public LombaHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_rekomendasi_home, parent, false));

                mPoster = itemView.findViewById(R.id.cover_image);
                mNamaLomba = itemView.findViewById(R.id.title);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(LainnyaActivity.this, R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(LainnyaActivity.this, DetailLombaActivity.class);
                        intent.putExtra("id", mLomba.getIdLomba());
                        intent.putExtra("nama", mLomba.getNamaLomba());
                        intent.putExtra("jenis_kegiatan", "Lainnya");
                        startActivity(intent);
                    }
                });
            }
            public void bind(Lomba lomba){
                mLomba = lomba;
                mNamaLomba.setText(lomba.getNamaLomba());
                if(lomba.getIdLomba().equals("1")){
                    mPoster.setImageResource(R.drawable.lomba2);
                } else if (lomba.getIdLomba().equals("2")) {
                    mPoster.setImageResource(R.drawable.seminar4);
                } else if (lomba.getIdLomba().equals("3")) {
                    mPoster.setImageResource(R.drawable.lomba4);
                } else if (lomba.getIdLomba().equals("4")) {
                    mPoster.setImageResource(R.drawable.seminar1);
                } else if (lomba.getIdLomba().equals("5")) {
                    mPoster.setImageResource(R.drawable.seminar5);
                }
            }
        }
    }
    private class LombaLainAdapter extends RecyclerView.Adapter<LombaLainAdapter.LombaHolder>{
        private List<Lomba> mLombas;

        public LombaLainAdapter(List<Lomba> lombas){
            mLombas = lombas;
        }

        @NonNull
        @Override
        public LombaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(LainnyaActivity.this);

            return new LombaHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull LombaHolder holder, int position) {
/*            Lomba lomba = mLombas.get(position);
            holder.bind(lomba);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);*/

            if (!showAllItems && position >= 3) {
                holder.itemView.setVisibility(View.GONE);
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            } else {
                Lomba lomba = mLombas.get(position);
                holder.bind(lomba);
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
            return mLombas.size();
        }

        private class LombaHolder extends RecyclerView.ViewHolder{
            private ImageView mPoster;
            private TextView mNamaLomba;
            private Lomba mLomba;

            public LombaHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_card_event, parent, false));

                mPoster = itemView.findViewById(R.id.cover_book_list_view);
                mNamaLomba = itemView.findViewById(R.id.nama_lomba);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(LainnyaActivity.this, R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(LainnyaActivity.this, DetailLombaActivity.class);
                        intent.putExtra("id", mLomba.getIdLomba());
                        intent.putExtra("nama", mLomba.getNamaLomba());
                        intent.putExtra("jenis_kegiatan", "Lainnya");
                        startActivity(intent);
                    }
                });
            }
            public void bind(Lomba lomba){
                mLomba = lomba;
                mNamaLomba.setText(lomba.getNamaLomba());
                if(lomba.getIdLomba().equals("1")){
                    mPoster.setImageResource(R.drawable.lomba2);
                } else if (lomba.getIdLomba().equals("2")) {
                    mPoster.setImageResource(R.drawable.seminar4);
                } else if (lomba.getIdLomba().equals("3")) {
                    mPoster.setImageResource(R.drawable.lomba4);
                } else if (lomba.getIdLomba().equals("4")) {
                    mPoster.setImageResource(R.drawable.seminar1);
                } else if (lomba.getIdLomba().equals("5")) {
                    mPoster.setImageResource(R.drawable.seminar5);
                }
            }
        }
    }
}