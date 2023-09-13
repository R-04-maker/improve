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
import astratech.myapplication.ui.activity.DetailLombaActivity;

public class ItemFilterLombaFragment extends Fragment {
    private static final String KEY_SEARCH = "search-value";
    private String data = "";
    private RecyclerView mRvFilterLomba;
    private LombaAdapter mLombaAdapter;
    private View mEmptyData;
    private List<Lomba> mLombaList;
    public ItemFilterLombaFragment() {
    }

    @SuppressWarnings("unused")
    public static ItemFilterLombaFragment newInstance(String data) {
        ItemFilterLombaFragment fragment = new ItemFilterLombaFragment();
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
        View view = inflater.inflate(R.layout.fragment_item_filter_lomba, container, false);

        mRvFilterLomba = view.findViewById(R.id.rv_filter_lomba);
        mRvFilterLomba.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvFilterLomba.setAdapter(mLombaAdapter);
        mEmptyData = view.findViewById(R.id.layout_empty_data_con_lomba);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLombaList = dataLomba();
        updateUI(mLombaList);
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
    private void updateUI(List<Lomba> lombaList){
        mLombaAdapter = new LombaAdapter(mLombaList);
        mRvFilterLomba.setAdapter(mLombaAdapter);

        mEmptyData.setVisibility(mLombaList.size() == 0 ? View.VISIBLE : View.GONE);
        mRvFilterLomba.setVisibility(mLombaList.size() == 0 ? View.GONE : View.VISIBLE);
    }
    private class LombaAdapter extends RecyclerView.Adapter<LombaAdapter.LombaHolder>{
        private List<Lomba> mLombas;

        public LombaAdapter(List<Lomba> lombas){
            mLombas = lombas;
        }

        @NonNull
        @Override
        public LombaAdapter.LombaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new LombaAdapter.LombaHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(@NonNull LombaAdapter.LombaHolder holder, int position) {
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
                super(inflater.inflate(R.layout.list_card_event, parent, false));

                mPoster = itemView.findViewById(R.id.cover_book_list_view);
                mNamaLomba = itemView.findViewById(R.id.nama_lomba);
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
            public void bind(Lomba lomba){
                mLomba = lomba;
                mNamaLomba.setText(lomba.getNamaLomba());
            }
        }
    }
}
