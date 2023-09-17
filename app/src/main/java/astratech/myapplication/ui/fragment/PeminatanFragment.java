package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.HomeActivity;
import astratech.myapplication.ui.activity.PeminatanActivity;
import astratech.myapplication.ui.activity.QuizActivity;

public class PeminatanFragment extends Fragment {

    public static PeminatanFragment newInstance(){
        return new PeminatanFragment();
    }

    private static final String TAG = "PeminatanFragment";

    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txt8;
    private TextView mBtnSimpan;
    private TextView disini;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pilihpeminatan, container, false);
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable gradientDrawable1 = new GradientDrawable();
        int customColor = Color.rgb(255, 0, 0);
        gradientDrawable.setColor(Color.rgb(255,157,39)); // Warna latar belakang menjadi biru
        gradientDrawable.setCornerRadius(60); // Atur radius sesuai kebutuhan (dalam satuan dp)
        gradientDrawable1.setColor(Color.parseColor("#E4E1E1")); // Warna latar belakang menjadi biru
        gradientDrawable1.setCornerRadius(60);
        final boolean[] isClicked = {false};
        // Set drawable sebagai background

        final Drawable newDrawable = getResources().getDrawable(R.drawable.changebutton); // Replace with the new drawable resource
        mBtnSimpan = (TextView) view.findViewById(R.id.button);
        txt1 = (TextView) view.findViewById(R.id.toggleButton);
        txt2 = (TextView) view.findViewById(R.id.toggleButton7);
        txt3 = (TextView) view.findViewById(R.id.toggleButton2);
        txt4 = (TextView) view.findViewById(R.id.toggleButton4);
        txt5 = (TextView) view.findViewById(R.id.toggleButton9);
        txt6 = (TextView) view.findViewById(R.id.toggleButton3);
        txt7 = (TextView) view.findViewById(R.id.toggleButton6);
        txt8 = (TextView) view.findViewById(R.id.toggleButton10);
        disini = (TextView) view.findViewById(R.id.disini);

        int orangeCount = 0;
        TextView[] textViews = {txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8};
        for (final TextView textView : textViews) {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int orangeCount = 0;
                    int textColor = textView.getCurrentTextColor();
                    int orangeColor = Color.parseColor("#FFA500"); // Define the orange color

                    if (textColor == orangeColor || orangeCount < 3) {
                        // Either the TextView is already orange or there are less than 3 orange TextViews
                        // Handle the click event for the current TextView here

                        // If the clicked TextView is not orange, make it orange
                        if (textColor != orangeColor) {
                            textView.setTextColor(orangeColor);
                            orangeCount++;
                        }
                    } else {
                        // Do nothing or show a message indicating that you can't click more TextViews
                    }
                }
            });
        }
// Check if a TextView's text color is orange
        if (isTextColorOrange(txt1)) {
            orangeCount++;
        }
        if (isTextColorOrange(txt2)) {
            orangeCount++;
        }
        if (isTextColorOrange(txt3)) {
            orangeCount++;
        }
        if (isTextColorOrange(txt4)) {
            orangeCount++;
        }
        if (isTextColorOrange(txt5)) {
            orangeCount++;
        }
        if (isTextColorOrange(txt6)) {
            orangeCount++;
        }
        if (isTextColorOrange(txt7)) {
            orangeCount++;
        }
        if (isTextColorOrange(txt8)) {
            orangeCount++;
        }
        if (orangeCount == 3) {
            disini.setVisibility(View.VISIBLE);
        } else {
            disini.setVisibility(View.INVISIBLE);
        }

        mBtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

//        txt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isClicked[0]) {
//                    // Revert to the original color on the second click
//                    txt1.setBackground(gradientDrawable1); // Set to transparent or the original background color
//                } else {
//                    // Change the background color on the first click
//                    txt1.setBackground(gradientDrawable); // Change to your desired color
//                }
//
//                // Toggle the state
//                isClicked[0] = !isClicked[0];
//            }
//
//        });
//        txt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isClicked[0]) {
//                    // Revert to the original color on the second click
//                    txt2.setBackground(gradientDrawable1); // Set to transparent or the original background color
//                } else {
//                    // Change the background color on the first click
//                    txt2.setBackground(gradientDrawable); // Change to your desired color
//                }
//
//                // Toggle the state
//                isClicked[0] = !isClicked[0];
//            }
//
//
//        });
//        txt3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isClicked[0]) {
//                    // Revert to the original color on the second click
//                    txt3.setBackground(gradientDrawable1); // Set to transparent or the original background color
//                } else {
//                    // Change the background color on the first click
//                    txt3.setBackground(gradientDrawable); // Change to your desired color
//                }
//
//                // Toggle the state
//                isClicked[0] = !isClicked[0];
//            }
//        });
//        txt4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isClicked[0]) {
//                    // Revert to the original color on the second click
//                    txt4.setBackground(gradientDrawable1); // Set to transparent or the original background color
//                } else {
//                    // Change the background color on the first click
//                    txt4.setBackground(gradientDrawable); // Change to your desired color
//                }
//
//                // Toggle the state
//                isClicked[0] = !isClicked[0];
//            }
//        });
//        txt5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isClicked[0]) {
//                    // Revert to the original color on the second click
//                    txt5.setBackground(gradientDrawable1); // Set to transparent or the original background color
//                } else {
//                    // Change the background color on the first click
//                    txt5.setBackground(gradientDrawable); // Change to your desired color
//                }
//
//                // Toggle the state
//                isClicked[0] = !isClicked[0];
//            }
//        });
//        txt6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isClicked[0]) {
//                    // Revert to the original color on the second click
//                    txt6.setBackground(gradientDrawable1); // Set to transparent or the original background color
//                } else {
//                    // Change the background color on the first click
//                    txt6.setBackground(gradientDrawable); // Change to your desired color
//                }
//
//                // Toggle the state
//                isClicked[0] = !isClicked[0];
//            }
//        });
//        txt7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isClicked[0]) {
//                    // Revert to the original color on the second click
//                    txt7.setBackground(gradientDrawable1); // Set to transparent or the original background color
//                } else {
//                    // Change the background color on the first click
//                    txt7.setBackground(gradientDrawable); // Change to your desired color
//                }
//
//                // Toggle the state
//                isClicked[0] = !isClicked[0];
//            }
//        });
//        txt8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isClicked[0]) {
//                    // Revert to the original color on the second click
//                    txt8.setBackground(gradientDrawable1); // Set to transparent or the original background color
//                } else {
//                    // Change the background color on the first click
//                    txt8.setBackground(gradientDrawable); // Change to your desired color
//                }
//
//                // Toggle the state
//                isClicked[0] = !isClicked[0];
//            }
//        });
        disini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), QuizActivity.class);
                startActivity(intent);

            }
        });


        return view;
    }

    private boolean isTextColorOrange(TextView textView) {
        int textColor = textView.getCurrentTextColor();
        int orangeColor = Color.rgb(255,157,39); // Define the orange color
        return textColor == orangeColor;
    }
}
