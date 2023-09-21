package astratech.myapplication.ui.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.ViewPengajuanActivity;

public class LainnyaAddFragment extends Fragment {
    private String jenis;
    private EditText mTglAwal, mTglAkhir;
    private ConstraintLayout mBtnSimpan, mTgl1, mTgl2;
    private DatePickerDialog datePickerDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            jenis = bundle.getString("jenis");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_lainnya, container, false);
        mBtnSimpan = view.findViewById(R.id.constrain_save_kegiatan);
        mBtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewPengajuanActivity.class);
                intent.putExtra("jenis", jenis);
                startActivity(intent);
            }
        });
        mTgl1 = view.findViewById(R.id.frame_add_tgl_awal_lainnya);
        mTgl2 = view.findViewById(R.id.frame_add_tgl_akhir_lomba);

        mTglAwal = view.findViewById(R.id.tgl_mulai_lainnya);
        mTglAkhir = view.findViewById(R.id.tgl_akhir_lainnya);

        mTgl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerTglAwal();
            }
        });
        mTgl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerTglAkhir();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

    }
    private void openDatePickerTglAwal() {
        datePickerDialog = new DatePickerDialog(requireContext(), R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mTglAwal.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));

                if (datePickerDialog != null && datePickerDialog.isShowing()) {
                    datePickerDialog.dismiss();
                }
            }
        }, 2023, 01, 20);

        datePickerDialog.show();
    }
    private void openDatePickerTglAkhir() {
        datePickerDialog = new DatePickerDialog(requireContext(), R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mTglAkhir.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));

                if (datePickerDialog != null && datePickerDialog.isShowing()) {
                    datePickerDialog.dismiss();
                }
            }
        }, 2023, 01, 20);

        datePickerDialog.show();
    }
}
