package astratech.myapplication.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import astratech.myapplication.R;

public class AddSertifikatActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sertifikat);

        ImageView mBackButton = findViewById(R.id.backBtn);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        Spinner spinner = findViewById(R.id.spinner_pilih_topik);
//
//        // Buat adapter untuk Spinner
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.choosen, R.layout.custom_spinner_item);
//        adapter.setDropDownViewResource(R.layout.custom_spinner_item);
//
//        // Atur adapter ke Spinner
//        spinner.setAdapter(adapter);


//        Spinner spinner = findViewById(R.id.spinner_pilih_topik);
//        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(AddSertifikatActivity.this,
//                R.layout.custom_spinner_item, getResources().getStringArray(R.array.choosen));
//        myAdapter.setDropDownViewResource(R.layout.custom_spinner_item);
//        spinner.setAdapter(myAdapter);
//
//
//        // Tambahkan listener untuk menampilkan drop-down saat diklik
//        spinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                spinner.performClick(); // Menampilkan drop-down
//            }
//        });

        Spinner spinner = findViewById(R.id.spinner_pilih_topik_sertifikat);

        // Buat adapter untuk Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.data_topik, R.layout.custom_spinner_item);
        adapter.setDropDownViewResource(R.layout.custom_spinner_item);

        // Atur adapter ke Spinner
        spinner.setAdapter(adapter);

//        // Tambahkan listener untuk menampilkan drop-down saat item dipilih
//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                spinner.performClick(); // Menampilkan drop-down
//            }
//        });


    }
}
