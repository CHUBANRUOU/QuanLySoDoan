package com.dangtrananhtu.qlsv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class homeFrag extends Fragment {
    RecyclerView rcvDoanVien;
    EditText editText;
    DvAdapter adapter;
    public static ArrayList<DoanVien> list = new ArrayList<>();
    DBHelp dbHelp;
    TextInputEditText edtId, edtTen, edtngaynop, edtGioiTinh, edtKhoa, edttinhtrang, edtKhoaSv;
    FloatingActionButton btnAdd;
    private BottomNavigationView mNavigationView;
    private ViewPager mViewPaper;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main,container,false);
        dbHelp = new DBHelp(getContext());
        dbHelp.createTable();
        list = dbHelp.getAllDoanVien();
        ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                        }
                        list = dbHelp.getAllDoanVien();
                        rcvDoanVien.setAdapter(adapter);
                        adapter.notifyData(list);
                    }
                });
        editText = view.findViewById(R.id.edt_search);
        rcvDoanVien = view.findViewById(R.id.rcv_doanvien);
        adapter = new DvAdapter(getContext(), list, mGetContent);
        rcvDoanVien.setAdapter(adapter);
        adapter.notifyData(list);
        btnAdd = (FloatingActionButton) view.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch(new Intent(getContext(),Add.class));
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                list = dbHelp.getAllDoanVien(editable.toString());
                adapter = new DvAdapter(getContext(), list, mGetContent);
                rcvDoanVien.setAdapter(adapter);
            }
        });
        return view;

    }


}
