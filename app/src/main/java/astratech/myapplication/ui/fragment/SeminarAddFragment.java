package astratech.myapplication.ui.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import astratech.myapplication.R;
import astratech.myapplication.ui.activity.ViewPengajuanActivity;

public class SeminarAddFragment extends Fragment {
    private String jenis;
    private ConstraintLayout mBtnSimpan, mBtnTgl;
    private EditText mTgl;
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
        View view = inflater.inflate(R.layout.fragment_add_seminar, container, false);

        mBtnSimpan = view.findViewById(R.id.constrain_save_lomba);
        mBtnTgl = view.findViewById(R.id.frame_add_tgl_seminar);
        mBtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewPengajuanActivity.class);
                intent.putExtra("jenis", jenis);
                startActivity(intent);
            }
        });

        mBtnTgl.setOnClickListener(new View.OnClickListener() {
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

        Spinner spinner = view.findViewById(R.id.spinner_pilih_topik_seminar);

        // Buat adapter untuk Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.data_topik, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        // Atur adapter ke Spinner
        spinner.setAdapter(adapter);

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
}
