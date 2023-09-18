package astratech.myapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import astratech.myapplication.R;
import astratech.myapplication.ui.fragment.ItemFilterAllFragment;
import astratech.myapplication.ui.fragment.ItemFilterLainnyaFragment;
import astratech.myapplication.ui.fragment.ItemFilterLombaFragment;
import astratech.myapplication.ui.fragment.ItemFilterOrangFragment;
import astratech.myapplication.ui.fragment.ItemFilterSeminarFragment;

public class SearchActivity extends AppCompatActivity {

    private static final String KEY_SEARCH = "search-value";
    private int selectedTab = 1;
    private EditText mSearchETxt;
    private LinearLayout mSemuaLayout, mLombaLayout, mSeminarLayout, mOrangLayout, mLainnyaLayout;
    private TextView mSemuaTxt, mLombaTxt,  mSeminarTxt, mOrangTxt, mLainnyaTxt;
    private ImageView mBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mBackBtn = findViewById(R.id.back_button);

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSearchETxt = findViewById(R.id.search_edit_text);

        mSemuaLayout = findViewById(R.id.semua_layout);
        mLombaLayout = findViewById(R.id.lomba_layout);
        mSeminarLayout = findViewById(R.id.seminar_layout);
        mOrangLayout = findViewById(R.id.orang_layout);
        mLainnyaLayout = findViewById(R.id.lainnya_layout);

        mSemuaTxt = findViewById(R.id.semua_txt);
        mLombaTxt = findViewById(R.id.lomba_txt);
        mSeminarTxt = findViewById(R.id.seminar_txt);
        mOrangTxt = findViewById(R.id.orang_txt);
        mLainnyaTxt = findViewById(R.id.lainnya_txt);

        String searchData = mSearchETxt.getText().toString();

        ItemFilterAllFragment fm = ItemFilterAllFragment.newInstance(searchData);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_list_search, fm)
                .commit();

        mSemuaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab != 1){
                    ItemFilterAllFragment fm = ItemFilterAllFragment.newInstance(searchData);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_list_search, fm)
                            .commit();

                    mLombaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mSeminarLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mOrangLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mLainnyaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    mSemuaLayout.setBackgroundResource(R.drawable.rounded_bg);
                    mSeminarTxt.setVisibility(View.VISIBLE);

                    mSemuaTxt.setTypeface(null, Typeface.BOLD);
                    mLombaTxt.setTypeface(null, Typeface.NORMAL);
                    mSeminarTxt.setTypeface(null, Typeface.NORMAL);
                    mOrangTxt.setTypeface(null, Typeface.NORMAL);
                    mLainnyaTxt.setTypeface(null, Typeface.NORMAL);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f,  Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    mSemuaLayout.startAnimation(scaleAnimation);

                    selectedTab = 1;
                }
            }
        });

        mLombaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab != 2){
                    ItemFilterLombaFragment fm = ItemFilterLombaFragment.newInstance(searchData);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_list_search, fm)
                            .commit();

                    mSemuaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mSeminarLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mOrangLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mLainnyaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    mLombaLayout.setBackgroundResource(R.drawable.rounded_bg);
                    mSemuaTxt.setVisibility(View.VISIBLE);

                    mSemuaTxt.setTypeface(null, Typeface.NORMAL);
                    mLombaTxt.setTypeface(null, Typeface.BOLD);
                    mSeminarTxt.setTypeface(null, Typeface.NORMAL);
                    mOrangTxt.setTypeface(null, Typeface.NORMAL);
                    mLainnyaTxt.setTypeface(null, Typeface.NORMAL);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f,  Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    mLombaLayout.startAnimation(scaleAnimation);

                    selectedTab = 2;
                }
            }
        });

        mSeminarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab != 3){
                    ItemFilterSeminarFragment fm = ItemFilterSeminarFragment.newInstance(searchData);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_list_search, fm)
                            .commit();

                    mSemuaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mLombaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mOrangLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mLainnyaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    mSeminarLayout.setBackgroundResource(R.drawable.rounded_bg);
                    mSeminarTxt.setVisibility(View.VISIBLE);

                    mSemuaTxt.setTypeface(null, Typeface.NORMAL);
                    mLombaTxt.setTypeface(null, Typeface.NORMAL);
                    mSeminarTxt.setTypeface(null, Typeface.BOLD);
                    mOrangTxt.setTypeface(null, Typeface.NORMAL);
                    mLainnyaTxt.setTypeface(null, Typeface.NORMAL);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f,  Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    mSeminarLayout.startAnimation(scaleAnimation);

                    selectedTab = 3;
                }
            }
        });

        mOrangLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab != 4){
                    ItemFilterOrangFragment fm = ItemFilterOrangFragment.newInstance(searchData);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_list_search, fm)
                            .commit();

                    mSemuaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mLombaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mSeminarLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mLainnyaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    mOrangLayout.setBackgroundResource(R.drawable.rounded_bg);
                    mOrangTxt.setVisibility(View.VISIBLE);

                    mSemuaTxt.setTypeface(null, Typeface.NORMAL);
                    mLombaTxt.setTypeface(null, Typeface.NORMAL);
                    mSeminarTxt.setTypeface(null, Typeface.NORMAL);
                    mOrangTxt.setTypeface(null, Typeface.BOLD);
                    mLainnyaTxt.setTypeface(null, Typeface.NORMAL);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f,  Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    mOrangLayout.startAnimation(scaleAnimation);

                    selectedTab = 4;
                }
            }
        });

        mLainnyaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTab != 5){
                    ItemFilterLainnyaFragment fm = ItemFilterLainnyaFragment.newInstance(searchData);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_list_search, fm)
                            .commit();

                    mSemuaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mLombaLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mSeminarLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    mOrangLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    mLainnyaLayout.setBackgroundResource(R.drawable.rounded_bg);
                    mLainnyaTxt.setVisibility(View.VISIBLE);

                    mSemuaTxt.setTypeface(null, Typeface.NORMAL);
                    mLombaTxt.setTypeface(null, Typeface.NORMAL);
                    mSeminarTxt.setTypeface(null, Typeface.NORMAL);
                    mOrangTxt.setTypeface(null, Typeface.NORMAL);
                    mLainnyaTxt.setTypeface(null, Typeface.BOLD);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f,  Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    mLainnyaLayout.startAnimation(scaleAnimation);

                    selectedTab = 5;
                }
            }
        });
    }
}