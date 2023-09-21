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
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.HomeActivity;
import astratech.myapplication.ui.activity.QuizActivity;

public class PeminatanFragment extends Fragment {

    public static PeminatanFragment newInstance(){
        return new PeminatanFragment();
    }

    private static final String TAG = "PeminatanFragment";

    private CardView txt1;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private TextView text6;
    private TextView text7;
    private TextView text8;
    private TextView text9;
    private CardView txt2;
    private CardView txt3;
    private CardView txt4;
    private CardView txt5;
    private CardView txt6;
    private CardView txt7;
    private CardView txt8;
    private CardView txt9;
    private Button mBtnSimpan;
    private TextView disini;
    private CardView minat;

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
        gradientDrawable1.setColor(Color.parseColor("#FFFFFF")); // Warna latar belakang menjadi biru
        gradientDrawable1.setCornerRadius(60);
        final boolean[] isClicked = {false};
        // Set drawable sebagai background

        final Drawable newDrawable = getResources().getDrawable(R.drawable.changebutton); // Replace with the new drawable resource
        mBtnSimpan = (Button) view.findViewById(R.id.button);
        minat = (CardView) view.findViewById(R.id.buttonkuis);
        txt1 = (CardView) view.findViewById(R.id.card2_kategori1);
        text1 = (TextView) view.findViewById(R.id.txtminat2);

        txt2 = (CardView) view.findViewById(R.id.card3_kategori1);
        text2 = (TextView) view.findViewById(R.id.txtminat5);

        txt3 = (CardView) view.findViewById(R.id.card3_kategori3);
        text3 = (TextView) view.findViewById(R.id.txtminat3);

        txt4 = (CardView) view.findViewById(R.id.card4_kategori1);
        text4 = (TextView) view.findViewById(R.id.txtminat4);

        txt5 = (CardView) view.findViewById(R.id.cardView13);
        text5 = (TextView) view.findViewById(R.id.txtminat6);

        txt6 = (CardView) view.findViewById(R.id.cardView17);
        text6 = (TextView) view.findViewById(R.id.txtminat7);

        txt7 = (CardView) view.findViewById(R.id.cardView18);
        text7 = (TextView) view.findViewById(R.id.txtminat8);


        txt8 = (CardView) view.findViewById(R.id.cardView19);
        text8 = (TextView) view.findViewById(R.id.txtminat9);

        txt9 = (CardView) view.findViewById(R.id.cardView20);
        text9 = (TextView) view.findViewById(R.id.txtminat10);

        int orangeCount = 0;
        CardView[] textViews = {txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9};
        for (final CardView textView : textViews) {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int orangeCount = 0;
                    int textColor = textView.getSolidColor();
                    int orangeColor = Color.parseColor("#FFA500"); // Define the orange color

                    if (textColor == orangeColor || orangeCount < 3) {
                        // Either the TextView is already orange or there are less than 3 orange TextViews
                        // Handle the click event for the current TextView here

                        // If the clicked TextView is not orange, make it orange
                        if (textColor != orangeColor) {
                            textView.setBackgroundColor(orangeColor);
                            orangeCount++;
                        }
                    } else {
                        // Do nothing or show a message indicating that you can't click more TextViews
                    }
                }
            });
        }
// Check if a TextView's text color is orange
//

        mBtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HomeActivity.class);
                startActivity(intent);
                text1.setTextColor(Color.parseColor("#FFFFFF"));
                text2.setTextColor(Color.parseColor("#FFFFFF"));
                text3.setTextColor(Color.parseColor("#FFFFFF"));
                text4.setTextColor(Color.parseColor("#FFFFFF"));
                text5.setTextColor(Color.parseColor("#FFFFFF"));
                text6.setTextColor(Color.parseColor("#FFFFFF"));
                text7.setTextColor(Color.parseColor("#FFFFFF"));
                text8.setTextColor(Color.parseColor("#FFFFFF"));
                txt1.setBackground(gradientDrawable1);
                txt2.setBackground(gradientDrawable1);
                txt3.setBackground(gradientDrawable1);
                txt4.setBackground(gradientDrawable1);
                txt5.setBackground(gradientDrawable1);
                txt6.setBackground(gradientDrawable1);
                txt7.setBackground(gradientDrawable1);
                txt8.setBackground(gradientDrawable1);
            }
        });

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt1.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    text1.setTextColor(Color.parseColor("#727272"));
//                                        mBtnSimpan.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt1.setBackground(gradientDrawable); // Change to your desired color
                    text1.setTextColor(Color.parseColor("#FFFFFF"));
                    mBtnSimpan.setEnabled(true);
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
                    txt2.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    text2.setTextColor(Color.parseColor("#727272"));
//                    mBtnSimpan.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt2.setBackground(gradientDrawable); // Change to your desired color
                    text2.setTextColor(Color.parseColor("#FFFFFF"));
                    mBtnSimpan.setEnabled(true);
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
                    txt3.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    text3.setTextColor(Color.parseColor("#727272"));
//                    mBtnSimpan.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt3.setBackground(gradientDrawable); // Change to your desired color
                    text3.setTextColor(Color.parseColor("#FFFFFF"));
                    mBtnSimpan.setEnabled(true);
                }

                // Toggle the state
                isClicked[0] = !isClicked[0];
            }
        });
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt4.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    text4.setTextColor(Color.parseColor("#727272"));
//                    mBtnSimpan.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt4.setBackground(gradientDrawable); // Change to your desired color
                    text4.setTextColor(Color.parseColor("#FFFFFF"));
                    mBtnSimpan.setEnabled(true);
                }

                // Toggle the state
                isClicked[0] = !isClicked[0];
            }
        });
        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt5.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    text5.setTextColor(Color.parseColor("#727272"));
//                    mBtnSimpan.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt5.setBackground(gradientDrawable); // Change to your desired color
                    text5.setTextColor(Color.parseColor("#FFFFFF"));
                    mBtnSimpan.setEnabled(true);
                }

                // Toggle the state
                isClicked[0] = !isClicked[0];
            }
        });
        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt6.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    text6.setTextColor(Color.parseColor("#727272"));
//                    mBtnSimpan.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt6.setBackground(gradientDrawable); // Change to your desired color
                    text6.setTextColor(Color.parseColor("#FFFFFF"));
                    mBtnSimpan.setEnabled(true);
                }

                // Toggle the state
                isClicked[0] = !isClicked[0];
            }
        });
        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt7.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    text7.setTextColor(Color.parseColor("#727272"));
//                    mBtnSimpan.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt7.setBackground(gradientDrawable); // Change to your desired color
                    text7.setTextColor(Color.parseColor("#FFFFFF"));
                    mBtnSimpan.setEnabled(true);
                }
                isClicked[0] = !isClicked[0];

            }
            });

        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt8.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    text8.setTextColor(Color.parseColor("#727272"));
//                    mBtnSimpan.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt8.setBackground(gradientDrawable); // Change to your desired color
                    text8.setTextColor(Color.parseColor("#FFFFFF"));
                    mBtnSimpan.setEnabled(true);
                }

                // Toggle the state
                isClicked[0] = !isClicked[0];
            }
        });

        minat.setOnClickListener(new View.OnClickListener() {
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
