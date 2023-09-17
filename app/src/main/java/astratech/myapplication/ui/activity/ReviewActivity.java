package astratech.myapplication.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import astratech.myapplication.R;
import astratech.myapplication.ui.fragment.QuizFragment;
import astratech.myapplication.ui.fragment.ReviewFragment;

public class ReviewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.Review);
        if (fragment == null) {
            fragment = new ReviewFragment().newInstance();
            fm.beginTransaction().replace(R.id.Review, fragment).commit();
        }
    }
}
