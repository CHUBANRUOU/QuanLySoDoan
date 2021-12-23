package com.dangtrananhtu.qlsv;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
public class Add extends AppCompatActivity {
    TextInputEditText edtId, edtTen, edtngaynop, edtGioiTinh, edtKhoa, edttinhtrang, edtKhoaSv;
    Button btnAdd;
    DBHelp dbHelp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        dbHelp = new DBHelp(this);
        edtId = findViewById(R.id.edt_id);
        edtTen = findViewById(R.id.edt_ten);
        edtngaynop = findViewById(R.id.edt_ngaynop);
        edtGioiTinh = findViewById(R.id.edt_gioitinh);
        edtKhoa = findViewById(R.id.edt_khoa);
        edttinhtrang = findViewById(R.id.edt_tinhtrang);
        edtKhoaSv = findViewById(R.id.edt_khoasv);
        btnAdd = findViewById(R.id.btn_add1);
        if (getIntent().getBooleanExtra("edit", false)) {
            btnAdd.setText("Sửa");
            DoanVien doanVien = dbHelp.getDoanVien(getIntent().getStringExtra("id"));
            edtId.setText(doanVien.mssv);
            edtTen.setText(doanVien.tensv);
            edtngaynop.setText(doanVien.ngaynop);
            edtKhoa.setText(doanVien.khoa);
            edttinhtrang.setText(doanVien.tinhtrang);
            edtKhoaSv.setText(doanVien.khoaSv);
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoanVien doanVien = new DoanVien();
                doanVien.setMssv(edtId.getText().toString());
                doanVien.setTensv(edtTen.getText().toString());
                doanVien.setGioitinh(edtGioiTinh.getText().toString());
                doanVien.setKhoa(edtKhoa.getText().toString());
                doanVien.setKhoaSv(edtKhoaSv.getText().toString());
                doanVien.setTinhtrang(edttinhtrang.getText().toString());
                doanVien.setNgaynop(edtngaynop.getText().toString());
                if (getIntent().getBooleanExtra("edit", false)) {
                    doanVien.setId(getIntent().getStringExtra("id"));
                    dbHelp.updateDv(doanVien);
                } else {
                    dbHelp.insertDv(doanVien);
                }
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }

}
