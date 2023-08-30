package astratech.myapplication.ui.fragment;

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
import astratech.myapplication.model.LeaderBoard;


public class LeaderBoardFragment extends Fragment {

    private static final String TAG = "LeaderBoardFragment";
    private RecyclerView mRvLeaderBoard;
    private LeaderBoardAdapter mLeaderBoardAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);


        mRvLeaderBoard = view.findViewById(R.id.leaderboard_recycler_view);
        mRvLeaderBoard.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRvLeaderBoard.setAdapter(mLeaderBoardAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        updateLeaderBoard(dataLeaderBoard());
    }

    private void updateLeaderBoard(List<LeaderBoard> leaderBoards){
        mLeaderBoardAdapter = new LeaderBoardAdapter(leaderBoards);
        mRvLeaderBoard.setAdapter(mLeaderBoardAdapter);
    }

    public List<LeaderBoard> dataLeaderBoard(){
        List<LeaderBoard> leaderboardList = new ArrayList<>();
        for(int i  = 0; i < 7; i++){
            LeaderBoard lomba = new LeaderBoard();
            lomba.setIdLeaderBoard(i + 4);
                lomba.setNamaOrang("Muhammad Gema Rhomadon");
            if (i == 5){
                lomba.setNamaOrang("Dewi Sonya (You)");
            }
            lomba.setJumlahXP(19997 - i);
            leaderboardList.add(lomba);
        }
        return leaderboardList;
    }

    private class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.LeaderBoardHolder> {

        private List<LeaderBoard> mLeaderBoards;

        public LeaderBoardAdapter(List<LeaderBoard> leaderBoards){
            mLeaderBoards = leaderBoards;
        }

        @NonNull
        @Override
        public LeaderBoardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new LeaderBoardHolder(layoutInflater, parent);
        }


        @Override
        public void onBindViewHolder(@NonNull LeaderBoardHolder holder, int position) {
            LeaderBoard leaderBoard = mLeaderBoards.get(position);
            holder.bind(leaderBoard);
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in);
            holder.itemView.startAnimation(animation);
        }

        @Override
        public int getItemCount() {
            return mLeaderBoards.size();
        }

        private class LeaderBoardHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            private TextView mNomor;
            private ImageView mFotoOrang;
            private TextView mNamaOrang;
            private TextView mXP;
            private LeaderBoard mLeaderBoard;

            public LeaderBoardHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.list_item_leaderboard, parent, false));

                mNomor = itemView.findViewById(R.id.nomor_lb);
                mNamaOrang = itemView.findViewById(R.id.nama_orang_lb);
                mFotoOrang = itemView.findViewById(R.id.imageOrang_lb);
                mXP = itemView.findViewById(R.id.XP_lb);
                itemView.setOnClickListener(this);
            }
            public void bind(LeaderBoard leaderBoard){
                mLeaderBoard = leaderBoard;
                mNomor.setText(String.valueOf(leaderBoard.getIdLeaderBoard()));
                mNamaOrang.setText(leaderBoard.getNamaOrang());
                mXP.setText(String.valueOf(leaderBoard.getJumlahXP()));
            }
            @Override
            public void onClick(View v) {
    /*                Intent intent = new Intent(getActivity(), BookDetailActivity.class);
                    intent.putExtra(KEY_EXTRA, mKoleksi.getIdKoleksi());
                    startActivity(intent);*/
            }
        }
    }

    public static LeaderBoardFragment newInstance(){
        return new LeaderBoardFragment();
    }


}