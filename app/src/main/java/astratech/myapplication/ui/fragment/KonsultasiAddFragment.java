package astratech.myapplication.ui.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.ViewPengajuanActivity;

public class KonsultasiAddFragment extends Fragment {
    private String jenis;
    private ConstraintLayout mBtnSimpan, mDate, mTime;
    private EditText mTgl, mTimee;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
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
        View view = inflater.inflate(R.layout.fragment_add_konsultasi, container, false);

        Spinner spinner = view.findViewById(R.id.spinner_pilih_lomba_konsultasi);

        // Buat adapter untuk Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.data_lomba, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        // Atur adapter ke Spinner
        spinner.setAdapter(adapter);


        Spinner spinnerDosen = view.findViewById(R.id.spinner_pilih_dosen_konsultasi);
        // Buat adapter untuk Spinner
        ArrayAdapter<CharSequence> adapterDosen = ArrayAdapter.createFromResource(requireContext(),
                R.array.data_dosen, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        // Atur adapter ke Spinner
        spinnerDosen.setAdapter(adapterDosen);
        mBtnSimpan = view.findViewById(R.id.constrain_save_konsultasi);

        mBtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewPengajuanActivity.class);
                intent.putExtra("jenis", jenis);
                startActivity(intent);
            }
        });
        mDate = view.findViewById(R.id.frame_add_tgl_konsultasi);
        mTime = view.findViewById(R.id.frame_add_waktu_konsultasi);

        mTgl = view.findViewById(R.id.tgl_konsultasi);
        mTimee = view.findViewById(R.id.waktu_konsultasi);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePickerTglAkhir();
            }
        });
        mTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimePicker();
            }
        });

    }
    private void openDatePickerTglAkhir() {
        datePickerDialog = new DatePickerDialog(requireContext(), R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mTgl.setText(String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));

                if (datePickerDialog != null && datePickerDialog.isShowing()) {
                    datePickerDialog.dismiss();
                }
            }
        }, 2023, 01, 20);

        datePickerDialog.show();
    }

    private void openTimePicker() {
        timePickerDialog = new TimePickerDialog(getActivity(), R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                // Menampilkan nilai yang dipilih di textView
                mTimee.setText(String.valueOf(hour) + ":" + String.valueOf(minute));

                // Menutup dialog time picker setelah nilai dipilih
                if (timePickerDialog != null && timePickerDialog.isShowing()) {
                    timePickerDialog.dismiss();
                }
            }
        }, 15, 30, false);

        timePickerDialog.show();
    }
}
