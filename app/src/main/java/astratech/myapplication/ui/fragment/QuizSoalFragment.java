package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import astratech.myapplication.ui.activity.ResultActivity;

public class QuizSoalFragment extends Fragment {
    public static QuizSoalFragment newInstance(){
        return new QuizSoalFragment();
    }

    private static final String TAG = "QuizSoalFragment";

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView sebelum;
    private TextView sesudah;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quizsoal, container, false);
        txt1 = (TextView) view.findViewById(R.id.myEditText);
        txt2 = (TextView) view.findViewById(R.id.myEditText2);
        txt3 = (TextView) view.findViewById(R.id.myEditText3);
        sebelum = (TextView) view.findViewById(R.id.btn_PengajuanAset);
        sesudah = (TextView) view.findViewById(R.id.btn_PengajuanRuangan);
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable gradientDrawable1 = new GradientDrawable();
        int customColor = Color.rgb(255, 0, 0);
        gradientDrawable.setColor(Color.rgb(255,157,39)); // Warna latar belakang menjadi biru
        gradientDrawable.setCornerRadius(60); // Atur radius sesuai kebutuhan (dalam satuan dp)
        gradientDrawable1.setColor(Color.parseColor("#FFFFFF")); // Warna latar belakang menjadi biru
        gradientDrawable1.setCornerRadius(60);
        final boolean[] isClicked = {false};
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt1.setBackground(gradientDrawable1); // Set to transparent or the original background color
                } else {
                    // Change the background color on the first click
                    txt1.setBackground(gradientDrawable); // Change to your desired color
                }

                // Toggle the state
                isClicked[0] = !isClicked[0];
            }
        });
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt1.setBackground(gradientDrawable1); // Set to transparent or the original background color
                } else {
                    // Change the background color on the first click
                    txt1.setBackground(gradientDrawable); // Change to your desired color
                }

                // Toggle the state
                isClicked[0] = !isClicked[0];
            }
        });
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt1.setBackground(gradientDrawable1); // Set to transparent or the original background color
                } else {
                    // Change the background color on the first click
                    txt1.setBackground(gradientDrawable); // Change to your desired color
                }

                // Toggle the state
                isClicked[0] = !isClicked[0];
            }
        });
        sesudah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ResultActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
