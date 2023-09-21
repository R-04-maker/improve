package astratech.myapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import astratech.myapplication.R;
import astratech.myapplication.model.LeaderBoard;
import astratech.myapplication.ui.fragment.LeaderBoardFragment;
import astratech.myapplication.ui.fragment.LoginFragment;
import astratech.myapplication.ui.fragment.OnBoardingFragment;
import astratech.myapplication.ui.fragment.QuizSoal2Fragment;
import astratech.myapplication.ui.fragment.QuizSoalFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment==null){
            fragment = OnBoardingFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }


}