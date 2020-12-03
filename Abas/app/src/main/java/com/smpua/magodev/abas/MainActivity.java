package com.smpua.magodev.abas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout mSmartTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mSmartTabLayout = findViewById(R.id.view_pager_tab);
        this.mViewPager = findViewById(R.id.view_pager);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment.class)
                        .add("Aba 2", SegundaAbaFragment.class)
                        .create());

        this.mViewPager.setAdapter(adapter);
        this.mSmartTabLayout.setViewPager(mViewPager);
    }
}