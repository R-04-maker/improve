package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.Timer;
import java.util.TimerTask;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.HomeActivity;
import astratech.myapplication.ui.activity.PeminatanActivity;
import astratech.myapplication.ui.activity.QuizActivity;
import astratech.myapplication.ui.activity.QuizSoalActivity;

public class QuizFragment extends Fragment {
    public static QuizFragment newInstance(){
        return new QuizFragment();
    }

    private static final String TAG = "QuizFragment";

    private LinearLayout Ya;
    private LinearLayout Tidak;
    int counter = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz, container, false);
        Ya = (LinearLayout) view.findViewById(R.id.btnPengajuanAsset2);
        Tidak = (LinearLayout) view.findViewById(R.id.btnPengajuanAsset1);
        Ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuizSoalActivity.class);
                startActivity(intent);
            }
        });

        Tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PeminatanActivity.class);
                startActivity(intent);
            }
        });

//            final Timer t = new Timer();
//            TimerTask tt = new TimerTask() {
//                @Override
//                public void run() {
//                    counter++;
//                    PB.setProgress(counter);
//
//                    if (counter == 100)
//                        t.cancel();
//                    Intent intent = new Intent(getContext(), QuizSoalActivity.class);
//                    startActivity(intent);
//                }
//            };
//
//            t.schedule(tt, 0, 100);

        return view;
    }


}
