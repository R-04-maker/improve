package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import astratech.myapplication.R;
import astratech.myapplication.model.Lomba;
import astratech.myapplication.model.Seminar;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    private RecyclerView mRvRekomendasiLomba, mRvRekomendasiSeminar;
    private ImageButton mBtnSavedEvent, mBtnNotification;
    private LombaAdapter mLombaAdapter;
    private SeminarAdapter mSeminarAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        mRvRekomendasiLomba = view.findViewById(R.id.rv_lomba);
        mRvRekomendasiLomba.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvRekomendasiLomba.setAdapter(mLombaAdapter);

        mRvRekomendasiSeminar = view.findViewById(R.id.rv_seminar);
        mRvRekomendasiSeminar.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRvRekomendasiSeminar.setAdapter(mSeminarAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateLomba(dataLomba());
        updateSeminar(dataSeminar());
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

    private class LombaAdapter extends RecyclerView.Adapter<LombaAdapter.LombaHolder>{
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

        private class LombaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private ImageView mPoster;
            private TextView mNamaLomba;
            private Lomba mLomba;

            public LombaHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_rekomendasi_home, parent, false));

                mPoster = itemView.findViewById(R.id.cover_image);
                mNamaLomba = itemView.findViewById(R.id.title);
                itemView.setOnClickListener(this);
            }
            public void bind(Lomba lomba){
                mLomba = lomba;

/*                Picasso.get()
                        .load(koleksi.getGambar())
                        .placeholder(R.drawable.no_cover_book)
                        .error(R.drawable.no_cover_book)
                        .into(mBookImage);*/

                mNamaLomba.setText(lomba.getNamaLomba());
            }
            @Override
            public void onClick(View v) {
/*                Intent intent = new Intent(getActivity(), BookDetailActivity.class);
                intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                startActivity(intent);*/
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

        private class SeminarHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private ImageView mPoster;
            private TextView mNamaSeminar;
            private Seminar mSeminar;

            public SeminarHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_rekomendasi_home, parent, false));

                mPoster = itemView.findViewById(R.id.cover_image);
                mNamaSeminar = itemView.findViewById(R.id.title);
                itemView.setOnClickListener(this);
            }
            public void bind(Seminar seminar){
                mSeminar = seminar;

/*                Picasso.get()
                        .load(koleksi.getGambar())
                        .placeholder(R.drawable.no_cover_book)
                        .error(R.drawable.no_cover_book)
                        .into(mBookImage);*/

                mNamaSeminar.setText(seminar.getNamaSeminar());
            }
            @Override
            public void onClick(View v) {
/*                Intent intent = new Intent(getActivity(), BookDetailActivity.class);
                intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                startActivity(intent);*/
            }
        }
    }
}