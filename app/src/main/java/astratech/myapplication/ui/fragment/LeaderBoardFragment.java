package astratech.myapplication.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import astratech.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeaderBoardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeaderBoardFragment extends Fragment {


    private RecyclerView mLeaderBoardRecyclerView;
    private LeaderBoardAdapter mAdapter;

    public LeaderBoardFragment() {
        // Required empty public constructor
    }

    public static LeaderBoardFragment newInstance(String param1, String param2) {
        LeaderBoardFragment fragment = new LeaderBoardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);


        mLeaderBoardRecyclerView = (RecyclerView)
                view.findViewById(R.id.leaderboard_recycler_view);
        mLeaderBoardRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity()));
        mLeaderBoardRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private class LeaderBoardHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        public LeaderBoardHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_leaderboard, parent, false));
            this.itemView.setOnClickListener(this);

        }

        public void bindDrawable(Drawable drawable){
//            mImageLomba.setImageDrawable(drawable);
        }


        @Override
        public void onClick(View v){
//            mCallbacks.onLombaSelected(mLomba.getIdLomba());
        }
    }
//
    private class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardHolder> {
        @Override
        public LeaderBoardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new LeaderBoardHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(LeaderBoardHolder holder, int position) {
            // Bind data dummy ke tampilan item dalam RecyclerView
            // Misalnya, set teks untuk TextView dengan ID lomba_title
            holder.bindDrawable(getResources().getDrawable(R.drawable.add));
        }

        @Override
        public int getItemCount() {
            return 10; // Ganti jumlah item dummy sesuai kebutuhan
        }
    }
}