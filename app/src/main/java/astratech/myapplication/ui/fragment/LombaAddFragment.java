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
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.HistoryPoinActivity;
import astratech.myapplication.ui.activity.PoinActivity;

public class LombaAddFragment extends Fragment {

    private ConstraintLayout btnTglAwal;
    private ConstraintLayout btnTglAkhir;

    private EditText mTglAwal;
    private EditText mTglAkhir;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_lomba, container, false);


        btnTglAwal = view.findViewById(R.id.frame_add_tgl_awal_lomba);
        btnTglAkhir = view.findViewById(R.id.frame_add_tgl_akhir_lomba);
        mTglAwal = view.findViewById(R.id.tgl_mulai_add);
        mTglAkhir = view.findViewById(R.id.tgl_akhir_add);

        btnTglAwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePickerTglAwal();
            }
        });

        btnTglAkhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePickerTglAkhir();
            }
        });


        Spinner spinner = view.findViewById(R.id.spinner_pilih_topik_lomba);

        // Buat adapter untuk Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.data_topik, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        // Atur adapter ke Spinner
        spinner.setAdapter(adapter);


        Spinner spinnerJenis = view.findViewById(R.id.spinner_pilih_jenis);
        // Buat adapter untuk Spinner
        ArrayAdapter<CharSequence> adapterJenis = ArrayAdapter.createFromResource(requireContext(),
                R.array.data_jenis, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        // Atur adapter ke Spinner
        spinnerJenis.setAdapter(adapterJenis);


        Spinner spinnerTingkat = view.findViewById(R.id.spinner_pilih_tingkat);
        // Buat adapter untuk Spinner
        ArrayAdapter<CharSequence> adapterTingkat = ArrayAdapter.createFromResource(requireContext(),
                R.array.data_tingkat, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        // Atur adapter ke Spinner
        spinnerTingkat.setAdapter(adapterTingkat);


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

    //    private void openTimePicker() {
//        timePickerDialog = new TimePickerDialog(this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
//            @Override
//            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
//                // Menampilkan nilai yang dipilih di textView
//                textView.setText(String.valueOf(hour) + ":" + String.valueOf(minute));
//
//                // Menutup dialog time picker setelah nilai dipilih
//                if (timePickerDialog != null && timePickerDialog.isShowing()) {
//                    timePickerDialog.dismiss();
//                }
//            }
//        }, 15, 30, false);
//
//        timePickerDialog.show();
//    }
}
