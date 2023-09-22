package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import astratech.myapplication.model.Seminar;
import astratech.myapplication.ui.activity.DetailLombaActivity;

public class ItemFilterSeminarFragment extends Fragment {
    private static final String KEY_SEARCH = "search-value";
    private String data = "";
    private RecyclerView mRvFilterSeminar;
    private SeminarAdapter mSeminarAdapter;
    private List<Seminar> mSeminarList;

    public ItemFilterSeminarFragment() {
    }

    @SuppressWarnings("unused")
    public static ItemFilterSeminarFragment newInstance(String data) {
        ItemFilterSeminarFragment fragment = new ItemFilterSeminarFragment();
        Bundle args = new Bundle();
        args.putString(KEY_SEARCH, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            data = getArguments().getString(KEY_SEARCH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_filter_seminar, container, false);

        mRvFilterSeminar = view.findViewById(R.id.rv_filter_seminar);
        mRvFilterSeminar.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFilterSeminar.setAdapter(mSeminarAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSeminarList = dataSeminar();
        updateUI(mSeminarList);
    }

    public List<Seminar> dataSeminar(){
        List<Seminar> seminarList = new ArrayList<>();

        Seminar seminar1 = new Seminar();
        seminar1.setIdSeminar("1");
        seminar1.setNamaSeminar("First Step");
        seminarList.add(seminar1);

        Seminar seminar2 = new Seminar();
        seminar2.setIdSeminar("2");
        seminar2.setNamaSeminar("Start Up");
        seminarList.add(seminar2);

        Seminar seminar3 = new Seminar();
        seminar3.setIdSeminar("3");
        seminar3.setNamaSeminar("Let Secure Your Code");
        seminarList.add(seminar3);

        Seminar seminar4 = new Seminar();
        seminar4.setIdSeminar("4");
        seminar4.setNamaSeminar("First Step");
        seminarList.add(seminar4);

        Seminar seminar5 = new Seminar();
        seminar5.setIdSeminar("5");
        seminar5.setNamaSeminar("Let Secure Your Code");
        seminarList.add(seminar3);

//        for(int i  = 0; i < 5; i++){
//            Seminar seminar = new Seminar();
//            seminar.setIdSeminar("" + i + 1);
//            seminar.setNamaSeminar("Seminar " + i);
//            seminarList.add(seminar);
//        }
        return seminarList;
    }
    private void updateUI(List<Seminar> mSeminarList){
        mSeminarAdapter = new SeminarAdapter(mSeminarList);
        mRvFilterSeminar.setAdapter(mSeminarAdapter);
    }
    private class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.SeminarHolder>{
        private List<Seminar> mSeminars;

        public SeminarAdapter(List<Seminar> Seminars){
            mSeminars = Seminars;
        }

        @NonNull
        @Override
        public SeminarAdapter.SeminarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new SeminarAdapter.SeminarHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull SeminarAdapter.SeminarHolder holder, int position) {
            Seminar Seminar = mSeminars.get(position);
            holder.bind(Seminar);
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
                super(inflater.inflate(R.layout.list_card_event, parent, false));

                mPoster = itemView.findViewById(R.id.cover_book_list_view);
                mNamaSeminar = itemView.findViewById(R.id.nama_lomba);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(getContext(), DetailLombaActivity.class);
//                        intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                        startActivity(intent);
                    }
                });
            }
            public void bind(Seminar seminar){
                mSeminar = seminar;
                mNamaSeminar.setText(seminar.getNamaSeminar());

                if(seminar.getIdSeminar().equals("1")){
                    mPoster.setImageResource(R.drawable.seminar1);
                } else if (seminar.getIdSeminar().equals("2")) {
                    mPoster.setImageResource(R.drawable.seminar4);
                } else if (seminar.getIdSeminar().equals("3")) {
                    mPoster.setImageResource(R.drawable.seminar5);
                } else if (seminar.getIdSeminar().equals("4")) {
                    mPoster.setImageResource(R.drawable.seminar1);
                } else if (seminar.getIdSeminar().equals("5")) {
                    mPoster.setImageResource(R.drawable.seminar4);
                }
            }
        }
    }

}