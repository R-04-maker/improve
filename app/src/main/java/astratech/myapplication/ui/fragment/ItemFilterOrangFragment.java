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
        mRvFilterOrang.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFilterOrang.setAdapter(mOrangAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mOrangList = dataOrang();
        updateUI(mOrangList);
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
                    mPoster.setImageResource(R.drawable.foto);
                } else if (orang.getIdOrang().equals("2")) {
                    mPoster.setImageResource(R.drawable.foto1);
                } else if (orang.getIdOrang().equals("3")) {
                    mPoster.setImageResource(R.drawable.foto2);
                } else if (orang.getIdOrang().equals("4")) {
                    mPoster.setImageResource(R.drawable.foto3);
                }
            }
        }
    }

}
