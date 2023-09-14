package astratech.myapplication.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import astratech.myapplication.R;
import astratech.myapplication.ui.fragment.DanaAddFragment;
import astratech.myapplication.ui.fragment.KonsultasiAddFragment;
import astratech.myapplication.ui.fragment.LainnyaAddFragment;
import astratech.myapplication.ui.fragment.LombaAddFragment;
import astratech.myapplication.ui.fragment.SeminarAddFragment;
import astratech.myapplication.ui.fragment.SuratPengantarAddFragment;

public class AddActivity extends AppCompatActivity {

//    private TextView textView;
//    private Button button;
//    private ConstraintLayout btnTglAwal;
//    private ConstraintLayout btnTglAkhir;
//
//    private EditText mTglAwal;
//    private EditText mTglAkhir;
//
//    private DatePickerDialog datePickerDialog;
//    private TimePickerDialog timePickerDialog;

    private String mSelectedPengajuan = "Pilih Pengajuan";
    LombaAddFragment lombaAddFragment = new LombaAddFragment();
    SeminarAddFragment seminarAddFragment = new SeminarAddFragment();
    LainnyaAddFragment lainnyaAddFragment = new LainnyaAddFragment();
    SuratPengantarAddFragment suratPengantarAddFragment = new SuratPengantarAddFragment();
    KonsultasiAddFragment konsultasiAddFragment = new KonsultasiAddFragment();
    DanaAddFragment danaAddFragment = new DanaAddFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUpload, lombaAddFragment).commit();

        Spinner spinner = findViewById(R.id.spinner_pilih_pengajuan);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pilihan_pengajuan, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedPengajuan = parent.getItemAtPosition(position).toString();
                mSelectedPengajuan = selectedPengajuan;
                updateFormPengajuan();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });



//        btnTglAwal = findViewById(R.id.frame_add_tgl_awal_lomba);
//        btnTglAkhir = findViewById(R.id.frame_add_tgl_akhir_lomba);
//        mTglAwal = findViewById(R.id.tgl_mulai_add);
//        mTglAkhir = findViewById(R.id.tgl_akhir_add);
//
//        btnTglAwal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDatePickerTglAwal();
//            }
//        });
//
//        btnTglAkhir.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDatePickerTglAkhir();
//            }
//        });

//        ImageView mBackButton = findViewById(R.id.backBtnPoin);
//        mBackButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//
//        ConstraintLayout constraintHistoryPoin = findViewById(R.id.constrain_history_poin);
//        constraintHistoryPoin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(PoinActivity.this, HistoryPoinActivity.class);
//                startActivity(intent);
//            }
//        });
    }






    private void updateFormPengajuan() {

        if (mSelectedPengajuan.equals("Pilih Pengajuan")) {
            // Jika "Select One" dipilih, tampilkan semua data historis
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUpload, lombaAddFragment).commit();
        } else if (mSelectedPengajuan.equals("Lomba")){
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUpload, lombaAddFragment).commit();
        } else if (mSelectedPengajuan.equals("Seminar")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUpload, seminarAddFragment).commit();
        } else if (mSelectedPengajuan.equals("Lainnya")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUpload, lainnyaAddFragment).commit();
        } else if (mSelectedPengajuan.equals("Surat Pengantar")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUpload, suratPengantarAddFragment).commit();
        } else if (mSelectedPengajuan.equals("Dana")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUpload, danaAddFragment).commit();
        } else if (mSelectedPengajuan.equals("Konsultasi")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentUpload, konsultasiAddFragment).commit();
        }
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
