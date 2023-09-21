package astratech.myapplication.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.AddReviewActivity;
import astratech.myapplication.ui.activity.AddSertifikatActivity;
import astratech.myapplication.ui.activity.DetailSertifikatActivity;
import astratech.myapplication.ui.activity.EditProfileActivity;
import astratech.myapplication.ui.activity.PoinActivity;
import astratech.myapplication.ui.activity.XPActivty;
import smartdevelop.ir.eram.showcaseviewlib.GuideView;
import smartdevelop.ir.eram.showcaseviewlib.config.DismissType;
import smartdevelop.ir.eram.showcaseviewlib.config.Gravity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ConstraintLayout constraintXP = view.findViewById(R.id.constraint_xp);
        constraintXP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), XPActivty.class);
                startActivity(intent);
            }
        });

        ConstraintLayout constraintPoin = view.findViewById(R.id.constraint_point);
        constraintPoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PoinActivity.class);
                startActivity(intent);
            }
        });


        ImageView iconEditProfile = view.findViewById(R.id.ic_edit_profile);
        iconEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EditProfileActivity.class);
                startActivity(intent);
            }
        });


        ConstraintLayout constraintTambahSertifikat = view.findViewById(R.id.constrain_btn_tambah_sertifikat);
        constraintTambahSertifikat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddSertifikatActivity.class);
                startActivity(intent);
            }
        });

        ConstraintLayout layoutXpPoint = view.findViewById(R.id.constrain_profile_xp_point);
        new GuideView.Builder(getContext())
            .setTitle("XP dan Poin")
            .setContentText("Dapatkan XP dan Poin  \n dengan mengunggah kegiatan \n atau berbagi pengalaman mu")
            .setTargetView(layoutXpPoint)
            .setGravity(Gravity.auto)
            .setDismissType(DismissType.anywhere)
            .build()
            .show();


        ConstraintLayout constraintSertifikat = view.findViewById(R.id.cardSertifikat1);
        constraintSertifikat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailSertifikatActivity.class);
                startActivity(intent);
            }
        });

        ConstraintLayout constraintUlasan = view.findViewById(R.id.constrain_tambah_ulasan_pf);
        constraintUlasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddReviewActivity.class);
                startActivity(intent);
            }
        });
    }
}