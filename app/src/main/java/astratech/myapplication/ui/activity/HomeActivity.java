package astratech.myapplication.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import astratech.myapplication.R;
import astratech.myapplication.ui.fragment.ProfileFragment;
import astratech.myapplication.ui.fragment.HomeFragment;
import astratech.myapplication.ui.fragment.LeaderBoardFragment;

public class HomeActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    ProfileFragment firstFragment = new ProfileFragment();
    HomeFragment mHomeFragment = new HomeFragment();
    LeaderBoardFragment thirdFragment = new LeaderBoardFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.profile);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
                setTitle("Profile");
                return true;
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, mHomeFragment).commit();
                return true;
            case R.id.leaderboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
                return true;
        }
        return false;
    }
}