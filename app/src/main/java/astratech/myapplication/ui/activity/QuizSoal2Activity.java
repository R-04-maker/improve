package astratech.myapplication.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import astratech.myapplication.R;
import astratech.myapplication.ui.fragment.QuizSoal2Fragment;
import astratech.myapplication.ui.fragment.QuizSoalFragment;

public class QuizSoal2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizsoal2);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.quizsoalya2);
        if (fragment == null) {
            fragment = new QuizSoal2Fragment().newInstance();
            fm.beginTransaction().replace(R.id.quizsoalya2, fragment).commit();
        }
    }
}
