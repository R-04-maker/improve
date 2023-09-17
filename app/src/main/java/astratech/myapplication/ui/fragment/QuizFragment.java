package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.HomeActivity;
import astratech.myapplication.ui.activity.PeminatanActivity;
import astratech.myapplication.ui.activity.QuizSoalActivity;

public class QuizFragment extends Fragment {
    public static QuizFragment newInstance(){
        return new QuizFragment();
    }

    private static final String TAG = "QuizFragment";

    private TextView Ya;
    private TextView Tidak;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz, container, false);
        Ya = (TextView) view.findViewById(R.id.tingkatkan3);
        Tidak = (TextView) view.findViewById(R.id.tingkatkan2);
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
        return view;
    }
}
