package astratech.myapplication.ui.fragment;

import android.animation.ValueAnimator;
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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import astratech.myapplication.R;
import astratech.myapplication.model.Lomba;
import astratech.myapplication.model.Seminar;
import astratech.myapplication.ui.activity.DetailLombaActivity;
import astratech.myapplication.ui.activity.LainnyaActivity;
import astratech.myapplication.ui.activity.LombaActivity;
import astratech.myapplication.ui.activity.NotifikasiActivity;
import astratech.myapplication.ui.activity.SearchActivity;
import astratech.myapplication.ui.activity.SeminarActivity;
import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity;
import smartdevelop.ir.eram.showcaseviewlib.listener.GuideListener;
import astratech.myapplication.ui.activity.SimpanActivity;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    private RecyclerView mRvRekomendasiLomba, mRvRekomendasiSeminar;
    private ConstraintLayout mLombaMenu, mSeminarMenu, mLainnyaMenu, mCardAll;
    private EditText mSearchTxt;
    private TextView mBtnSeeAllLomba, mBtnSeeAllSeminar;
    private LombaAdapter mLombaAdapter;
    private SeminarAdapter mSeminarAdapter;
    private CardView mCardPeminatan;
    private ScrollView mScrollView;
    private ImageView mCardQuiz;

    private ImageView BtnImageViewDisimpan;
    private ImageView BtnImageViewNotifikasi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        mLombaMenu = view.findViewById(R.id.lomba);
        mSeminarMenu = view.findViewById(R.id.seminar);
        mLainnyaMenu = view.findViewById(R.id.lainnya);
        mSearchTxt = view.findViewById(R.id.search);
        mBtnSeeAllLomba = view.findViewById(R.id.btn_seeAll_lomba);
        mBtnSeeAllSeminar = view.findViewById(R.id.btn_seeAll_seminar);


        BtnImageViewDisimpan = view.findViewById(R.id.btn_ic_disimpan);
        BtnImageViewNotifikasi = view.findViewById(R.id.btn_ic_notifikasi);

        mRvRekomendasiLomba = view.findViewById(R.id.rv_lomba);
        mRvRekomendasiLomba.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvRekomendasiLomba.setAdapter(mLombaAdapter);

        mRvRekomendasiSeminar = view.findViewById(R.id.rv_seminar);
        mRvRekomendasiSeminar.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvRekomendasiSeminar.setAdapter(mSeminarAdapter);

        mCardPeminatan = view.findViewById(R.id.cardView);
        mCardAll = view.findViewById(R.id.all_card);

        mScrollView = view.findViewById(R.id.sv_1);
        mCardQuiz = view.findViewById(R.id.card_quiz);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBtnSeeAllLomba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LombaActivity.class);
                startActivity(intent);
            }
        });
        mBtnSeeAllSeminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SeminarActivity.class);
                startActivity(intent);
            }
        });
        mLombaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scaleDown = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);
                mLombaMenu.startAnimation(scaleDown);
                Intent intent = new Intent(getActivity(), LombaActivity.class);
                startActivity(intent);
            }
        });

        mSeminarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scaleDown = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);
                mSeminarMenu.startAnimation(scaleDown);
                Intent intent = new Intent(getActivity(), SeminarActivity.class);
                startActivity(intent);
            }
        });

        mLainnyaMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scaleDown = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);
                mLainnyaMenu.startAnimation(scaleDown);
                Intent intent = new Intent(getActivity(), LainnyaActivity.class);
                startActivity(intent);
            }
        });

        List<Lomba> lombas = dataLomba();
        List<Seminar> seminars = dataSeminar();

        mLombaAdapter = new LombaAdapter(lombas);
        mSeminarAdapter = new SeminarAdapter(seminars);

        mRvRekomendasiLomba.setAdapter(mLombaAdapter);
        mRvRekomendasiSeminar.setAdapter(mSeminarAdapter);

        mSearchTxt.setFocusable(false);
        mSearchTxt.setClickable(false);
        mSearchTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        new GuideView.Builder(getContext())
                .setTitle("Peminatan")
                .setContentText("Sesuaikan peminatanmu agar \n rekomendasi yang diberikan sesuai ")
                .setTargetView(mCardPeminatan)
                .setGravity(Gravity.auto)
                .setDismissType(DismissType.anywhere)
                .setGuideListener(new GuideListener() {
                    @Override
                    public void onDismiss(View view) {
                        new GuideView.Builder(getContext())
                                .setTitle("Menu")
                                .setContentText("Akan menampilkan kegiatan rekomendasi \n yang sesuai dengan peminatan anda ")
                                .setTargetView(mCardAll)
                                .setGravity(Gravity.auto)
                                .setDismissType(DismissType.anywhere)
                                .setGuideListener(new GuideListener() {
                                    @Override
                                    public void onDismiss(View view) {
                                        new GuideView.Builder(getContext())
                                                .setTitle("Rekomendasi Lomba")
                                                .setContentText("Rekomendasi Lomba berdasarkan minatmu")
                                                .setTargetView(mRvRekomendasiLomba)
                                                .setGravity(Gravity.auto)
                                                .setDismissType(DismissType.anywhere)
                                                .setGuideListener(new GuideListener() {
                                                    @Override
                                                    public void onDismiss(View view) {
                                                        new GuideView.Builder(getContext())
                                                                .setTitle("Rekomendasi Seminar")
                                                                .setContentText("Rekomendasi Seminar berdasarkan minatmu")
                                                                .setTargetView(mRvRekomendasiSeminar)
                                                                .setGravity(Gravity.auto)
                                                                .setDismissType(DismissType.anywhere)
                                                                .setGuideListener(new GuideListener() {
                                                                    @Override
                                                                    public void onDismiss(View view) {
                                                                        animateScrollToPosition(0,1000);
                                                                    }
                                                                })
                                                                .build()
                                                                .show();
                                                    }
                                                })
                                                .build()
                                                .show();
                                    }
                                })
                                .build()
                                .show();
                    }
                })
                .build()
                .show();
        BtnImageViewDisimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SimpanActivity.class);
                startActivity(intent);
            }
        });


        BtnImageViewNotifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NotifikasiActivity.class);
                startActivity(intent);
            }
        });


    }
    private void scrollToPosition(final int x, final int y) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                mScrollView.scrollTo(x, y);
            }
        });
    }
    private void animateScrollToPosition(int x, final int y) {
        final int startY = mScrollView.getScrollY();
        final ValueAnimator animator = ValueAnimator.ofInt(startY, y);
        animator.setDuration(500); // Durasi animasi (ms)

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                mScrollView.scrollTo(x, currentValue);
            }
        });

        animator.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showGuideView();
            }
        }, 500);
    }
    private void showGuideView(){
        new GuideView.Builder(getContext())
                .setTitle("Improove Choice")
                .setContentText("Fitur untuk menemukan pemintananmu \n melalui kuiz interaktif")
                .setTargetView(mCardQuiz)
                .setGravity(Gravity.auto)
                .setDismissType(DismissType.anywhere)
                .build()
                .show();
    }
    private void updateLomba(List<Lomba> lombas){
        mLombaAdapter = new LombaAdapter(lombas);
        mRvRekomendasiLomba.setAdapter(mLombaAdapter);
    }
    private void updateSeminar(List<Seminar> seminars){
        mSeminarAdapter = new SeminarAdapter(seminars);
        mRvRekomendasiSeminar.setAdapter(mSeminarAdapter);
    }

    public List<Lomba> dataLomba(){
        List<Lomba> lombaList = new ArrayList<>();
        for(int i  = 0; i < 5; i++){
            Lomba lomba = new Lomba();
            lomba.setIdLomba("" + i + 1);
            lomba.setNamaLomba("Lomba " + i);
            lombaList.add(lomba);
        }
        return lombaList;
    }
    public List<Seminar> dataSeminar(){
        List<Seminar> seminarList = new ArrayList<>();
        for(int i  = 0; i < 5; i++){
            Seminar seminar = new Seminar();
            seminar.setIdSeminar("" + i + 1);
            seminar.setNamaSeminar("Seminar " + i);
            seminarList.add(seminar);
        }
        return seminarList;
    }

    public class LombaAdapter extends RecyclerView.Adapter<LombaAdapter.LombaHolder>{
        private List<Lomba> mLombas;

        public LombaAdapter(List<Lomba> lombas){
            mLombas = lombas;
        }

        @NonNull
        @Override
        public LombaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

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
                        Animation scaleDown = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(getActivity(), DetailLombaActivity.class);
//                        intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                        startActivity(intent);
                    }
                });
            }
            public void bind(Lomba lomba){
                mLomba = lomba;
                mNamaLomba.setText(lomba.getNamaLomba());
            }
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
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

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
            private TextView mNamaSeminar;
            private Seminar mSeminar;

            public SeminarHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_rekomendasi_home, parent, false));

                mPoster = itemView.findViewById(R.id.cover_image);
                mNamaSeminar = itemView.findViewById(R.id.title);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Toast.makeText(getActivity(), "Clicked " + mSeminar.getNamaSeminar(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            public void bind(Seminar seminar){
                mSeminar = seminar;
                mNamaSeminar.setText(seminar.getNamaSeminar());
            }
        }
    }
}