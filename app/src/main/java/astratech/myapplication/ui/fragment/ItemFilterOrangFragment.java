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
import astratech.myapplication.model.Lomba;
import astratech.myapplication.model.Orang;
import astratech.myapplication.model.Seminar;
import astratech.myapplication.ui.activity.DetailLombaActivity;
import astratech.myapplication.ui.activity.ProfileOrangActivity;

public class ItemFilterOrangFragment extends Fragment {
    private static final String KEY_SEARCH = "search-value";
    private String data = "";
    private RecyclerView mRvFilterOrang;
    private List<Orang> mOrangList;
    private OrangAdapter mOrangAdapter;

    public ItemFilterOrangFragment() {
    }

    @SuppressWarnings("unused")
    public static ItemFilterOrangFragment newInstance(String data) {
        ItemFilterOrangFragment fragment = new ItemFilterOrangFragment();
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
        View view = inflater.inflate(R.layout.fragment_item_filter_orang, container, false);

        mRvFilterOrang = view.findViewById(R.id.rv_filter_orang);
        mRvFilterOrang = view.findViewById(R.id.rv_filter_orang);
        mRvFilterOrang.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFilterOrang.setAdapter(mOrangAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mOrangList = dataOrang();
        List<Orang> orangs = dataOrang1();

        mOrangAdapter = new OrangAdapter (orangs);
        mRvFilterOrang.setAdapter(mOrangAdapter);
//        updateUI(mOrangList);
    }
    public List<Orang> dataOrang(){
        List<Orang> oranglist = new ArrayList<>();
        for(int i  = 0; i < 5; i++){
            Orang orang = new Orang();
            orang.setIdOrang("" + i + 1);
            orang.setNamaOrang("Orang " + i);
            oranglist.add(orang);
        }
        return oranglist;
    }
    private void updateUI(List<Orang> orangList){
        mOrangAdapter = new OrangAdapter(mOrangList);
        mRvFilterOrang.setAdapter(mOrangAdapter);
    }

    private class OrangAdapter extends RecyclerView.Adapter<OrangAdapter.OrangHolder>{
        private List<Orang> mOrangs;

        public OrangAdapter(List<Orang> orangs){
            mOrangs = orangs;
        }

        @NonNull
        @Override
        public OrangAdapter.OrangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new OrangAdapter.OrangHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull OrangAdapter.OrangHolder holder, int position) {
            Orang orang = mOrangs.get(position);
            holder.bind(orang);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);
        }

        @Override
        public int getItemCount() {
            return mOrangs.size();
        }

        private class OrangHolder extends RecyclerView.ViewHolder{
            private ImageView mPoster;
            private TextView mNamaOrang;
            private Orang mOrang;

            public OrangHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_card_orang, parent, false));
                mPoster = itemView.findViewById(R.id.foto_profile);
                mNamaOrang = itemView.findViewById(R.id.nama_lomba);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Animation scaleDown = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_down);
                        itemView.startAnimation(scaleDown);
                        Intent intent = new Intent(getContext(), ProfileOrangActivity.class);
//                        intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                        startActivity(intent);
                    }
                });
            }

            public void bind(Orang orang){
                mOrang = orang;
                mNamaOrang.setText(orang.getNamaOrang());
                if(orang.getIdOrang().equals("1")){
                    mPoster.setImageResource(R.drawable.foto3);
                } else if (orang.getIdOrang().equals("2")) {
                    mPoster.setImageResource(R.drawable.foto1);
                } else if (orang.getIdOrang().equals("3")) {
                    mPoster.setImageResource(R.drawable.foto2);
                } else if (orang.getIdOrang().equals("4")) {
                    mPoster.setImageResource(R.drawable.foto3);
                }  else if (orang.getIdOrang().equals("5")) {
                mPoster.setImageResource(R.drawable.foto1);
                } else if (orang.getIdOrang().equals("6")) {
                    mPoster.setImageResource(R.drawable.foto2);
                } else if (orang.getIdOrang().equals("7")) {
                    mPoster.setImageResource(R.drawable.foto3);
                }else if (orang.getIdOrang().equals("8")) {
                    mPoster.setImageResource(R.drawable.foto1);
                }
            }
        }
    }


    public List<Orang> dataOrang1(){
        List<Orang> orangList = new ArrayList<>();

        Orang orang1 = new Orang();
        orang1.setIdOrang("1");
        orang1.setNamaOrang("Irfan Muhammad");
        orangList.add(orang1);

        Orang orang2 = new Orang();
        orang2.setIdOrang("2");
        orang2.setNamaOrang("Nazwa Frida");
        orangList.add(orang2);

        Orang orang3 = new Orang();
        orang3.setIdOrang("3");
        orang3.setNamaOrang("Robby Fahsya");
        orangList.add(orang3);

        Orang orang4 = new Orang();
        orang4.setIdOrang("4");
        orang4.setNamaOrang("Daniel Dwiki");
        orangList.add(orang4);

        Orang orang5 = new Orang();
        orang5.setIdOrang("5");
        orang5.setNamaOrang("Atika Nur");
        orangList.add(orang5);

        Orang orang6 = new Orang();
        orang6.setIdOrang("6");
        orang6.setNamaOrang("Robby Fahsya");
        orangList.add(orang6);

        Orang orang7 = new Orang();
        orang7.setIdOrang("7");
        orang7.setNamaOrang("Gema Ramadhan");
        orangList.add(orang7);

        Orang orang8 = new Orang();
        orang8.setIdOrang("8");
        orang8.setNamaOrang("Nadiva Syifa");
        orangList.add(orang8);
//        for(int i  = 0; i < 5; i++){
//            Seminar seminar = new Seminar();
//            seminar.setIdSeminar("" + i + 1);
//            seminar.setNamaSeminar("Seminar " + i);
//            seminarList.add(seminar);
//        }
        return orangList;
    }

}
