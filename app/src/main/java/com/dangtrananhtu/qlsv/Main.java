package com.dangtrananhtu.qlsv;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    RecyclerView rcvDoanVien;
    EditText editText;
    DvAdapter adapter;
    ArrayList<DoanVien> list = new ArrayList<>();
    DBHelp dbHelp;
    TextInputEditText edtId, edtTen, edtngaynop, edtGioiTinh, edtKhoa, edttinhtrang, edtKhoaSv;
    Button btnAdd;
    private BottomNavigationView mNavigationView;
    private ViewPager mViewPaper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        mNavigationView = findViewById(R.id.bottom_nav);
        mViewPaper = findViewById(R.id.view_paper);
        setUpViewpaper();
        mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.main:
                        break;
                    case R.id.profile:
                        break;
                }
                return true;
            }
        });

    }
    private void setUpViewpaper() {
        ViewAdapter viewPagerAdapter = new ViewAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPaper.setAdapter(viewPagerAdapter);

        mViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        mNavigationView.getMenu().findItem(R.id.profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
