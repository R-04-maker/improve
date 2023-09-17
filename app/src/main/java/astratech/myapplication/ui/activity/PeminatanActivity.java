package astratech.myapplication.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import astratech.myapplication.R;
import astratech.myapplication.ui.fragment.PeminatanFragment;

public class PeminatanActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilihpeminatan);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.pilihpeminatan);
        if (fragment == null) {
            fragment = new PeminatanFragment().newInstance();
            fm.beginTransaction().replace(R.id.pilihpeminatan, fragment).commit();
        }
    }
}
