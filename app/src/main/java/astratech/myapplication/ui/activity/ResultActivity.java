package astratech.myapplication.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import astratech.myapplication.R;
import astratech.myapplication.ui.fragment.QuizSoalFragment;
import astratech.myapplication.ui.fragment.ResultFragmnet;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultquiz);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.resultQuiz);
        if (fragment == null) {
            fragment = new ResultFragmnet().newInstance();
            fm.beginTransaction().replace(R.id.resultQuiz, fragment).commit();
        }
    }
}
