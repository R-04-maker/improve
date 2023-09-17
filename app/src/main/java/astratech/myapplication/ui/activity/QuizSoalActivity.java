package astratech.myapplication.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import astratech.myapplication.R;
import astratech.myapplication.ui.fragment.QuizFragment;
import astratech.myapplication.ui.fragment.QuizSoalFragment;

public class QuizSoalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizsoal);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.quizsoalya);
        if (fragment == null) {
            fragment = new QuizSoalFragment().newInstance();
            fm.beginTransaction().replace(R.id.quizsoalya, fragment).commit();
        }
    }
}
