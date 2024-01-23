package astratech.myapplication.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.HomeActivity;
import astratech.myapplication.ui.activity.PeminatanActivity;
import astratech.myapplication.ui.activity.QuizSoal2Activity;
import astratech.myapplication.ui.activity.QuizSoalActivity;
import astratech.myapplication.ui.activity.ResultActivity;

public class QuizSoalFragment extends Fragment {
    public static QuizSoalFragment newInstance(){
        return new QuizSoalFragment();
    }

    private static final String TAG = "QuizSoalFragment";

    private Dialog dialog;
    private Dialog dialog1;
    private Button ShowDialog;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView sebelum;
    private TextView sesudah;

    private TextView soal;
    private TextView textangka;
    String[] textnomor = {"2/2",  "2/2", "2/2", "2/2",  "2/2"};
    String[] soal1 = {"Seberapa tertarik anda \n dengan aspek keamanan \n jaringan dan perlindungan\n data?",
            "Apakah anda tertarik \n dengan bahasa  \ntertentu, seperti Java, \n C++, atau bahasa lainnya?",   "Apakah anda tertarik \n dengan bahasa  \ntertentu, seperti Java, \n C++, atau bahasa lainnya?", "Seberapa tertarik anda \n dengan aspek keamanan \n jaringan dan perlindungan\n data?"};

    String[] edittext1 ={"A.   Tertarik", "A.   Tertarik", "A.   Tertarik"};
    String[] edittext3 ={"B.   Mungkin Tertarik", "B.   Mungkin Tertarik", "B.   Mungkin Tertarik"};
    String[] edittext2 ={"C.   Tidak Tertarik", "C.   Tidak Tertarik", "C.   Tidak Tertarik"};
    int currentIndex = 0;

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
        sebelum = (TextView) view.findViewById(R.id.btn_PengajuanRuangan);
        sesudah = (TextView) view.findViewById(R.id.btn_PengajuanAset);
        soal = (TextView) view.findViewById(R.id.tingkatkan3);
        textangka = (TextView) view.findViewById(R.id.btn_PengajuanAset1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable gradientDrawable1 = new GradientDrawable();
        int customColor = Color.rgb(255, 0, 0);
        gradientDrawable.setColor(Color.rgb(255,157,39)); // Warna latar belakang menjadi biru
        gradientDrawable.setCornerRadius(60); // Atur radius sesuai kebutuhan (dalam satuan dp)
        gradientDrawable1.setColor(Color.parseColor("#FFFFFF")); // Warna latar belakang menjadi biru
        gradientDrawable1.setCornerRadius(60);
        final boolean[] isClicked = {false};


        dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.custom_dialog_layout_question);
        dialog.setCancelable(false);
        dialog1 = new Dialog(requireContext());
        dialog1.setContentView(R.layout.custom_dialog_layout_question);
        dialog1.setCancelable(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.custom_dialog_background);
        } else {
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.custom_dialog_background);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog1.getWindow().setBackgroundDrawableResource(R.drawable.custom_dialog_background);
        } else {
            dialog1.getWindow().setBackgroundDrawableResource(R.drawable.custom_dialog_background);
        }
        Button okayButton = dialog.findViewById(R.id.btn_okay);
        Button cancelButton = dialog.findViewById(R.id.btn_cancel);
        Button okayButton1 = dialog1.findViewById(R.id.btn_okay);
        Button cancelButton1 = dialog1.findViewById(R.id.btn_cancel);
        okayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ResultActivity.class);
                startActivity(intent);
            }
        });

        okayButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PeminatanActivity.class);
                startActivity(intent);
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(requireContext(), "Tidak", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        cancelButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(requireContext(), "Tidak", Toast.LENGTH_SHORT).show();
                dialog1.dismiss();
            }
        });



        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked[0]) {
                    // Revert to the original color on the second click
                    txt1.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    sesudah.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt1.setBackground(gradientDrawable); // Change to your desired color
                    txt2.setBackground(gradientDrawable1);
                    txt3.setBackground(gradientDrawable1);
                    sesudah.setEnabled(true);

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
                    sesudah.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt2.setBackground(gradientDrawable); // Change to your desired color
                    txt1.setBackground(gradientDrawable1);
                    txt3.setBackground(gradientDrawable1);
                    sesudah.setEnabled(true);
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
                    sesudah.setEnabled(false);
                } else {
                    // Change the background color on the first click
                    txt3.setBackground(gradientDrawable); // Change to your desired color
                    txt2.setBackground(gradientDrawable1);
                    txt1.setBackground(gradientDrawable1);
                    sesudah.setEnabled(true);
                }

                // Toggle the state
                isClicked[0] = !isClicked[0];
            }
        });
        sesudah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == 2 ) {
                    dialog.show();
                    // Open the desired activity here
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                    builder.setTitle("Konfirmasi");
//                    builder.setMessage("Apakah anda yakin ingin mengakhiri tes ini?");
//                    builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Intent intent = new Intent(getActivity(), ResultActivity.class);
//                            startActivity(intent);
////                            mSessionManager.logout();
////                            closefragment();
//                        }
//                    });
//                    builder.setNegativeButton("Tidak", null);
//                    builder.show();
                }else {
                    textangka.setText("2/2");

                    // Update the currentIndex to point to the next item
                    currentIndex = (currentIndex + 1) % textnomor.length;

                    soal.setText(soal1[currentIndex]);

                    // Update the currentIndex to point to the next item
                    currentIndex = (currentIndex + 1) % soal1.length;

                    txt1.setText(edittext1[currentIndex]);
                    currentIndex = (currentIndex + 1) % edittext1.length;

                    txt3.setText(edittext3[currentIndex]);
                    currentIndex = (currentIndex + 1) % edittext3.length;

                    txt2.setText(edittext2[currentIndex]);
                    currentIndex = (currentIndex + 1) % edittext2.length;

                    txt1.setBackground(gradientDrawable1);
                    txt2.setBackground(gradientDrawable1);
                    txt3.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    sesudah.setEnabled(false);
                    sebelum.setEnabled(true);
                }
            }
        });

        sebelum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == 0) {
                    // Open the desired activity here
                    dialog1.show();
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                    builder.setTitle("Konfirmasi");
//                    builder.setMessage("Apakah anda yakin ingin keluar dari tes ini?");
//                    builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Intent intent = new Intent(getActivity(), PeminatanActivity.class);
//                            startActivity(intent);
////                            mSessionManager.logout();
////                            closefragment();
//                        }
//                    });
//                    builder.setNegativeButton("Tidak", null);
//                    builder.show();
                }else {
                    textangka.setText("1/2");

                    // Update the currentIndex to point to the next item
                    currentIndex = (currentIndex + 1) % textnomor.length;

                    soal.setText(soal1[currentIndex]);

                    // Update the currentIndex to point to the next item
                    currentIndex = (currentIndex + 1) % soal1.length;

                    txt1.setText(edittext1[currentIndex]);
                    currentIndex = (currentIndex + 1) % edittext1.length;

                    txt3.setText(edittext3[currentIndex]);
                    currentIndex = (currentIndex + 1) % edittext3.length;

                    txt2.setText(edittext2[currentIndex]);
                    currentIndex = (currentIndex + 1) % edittext2.length;

                    txt1.setBackground(gradientDrawable1);
                    txt2.setBackground(gradientDrawable1);
                    txt3.setBackground(gradientDrawable1); // Set to transparent or the original background color
                    sesudah.setEnabled(false);

                }
            }
        });
        return view;
    }
}
