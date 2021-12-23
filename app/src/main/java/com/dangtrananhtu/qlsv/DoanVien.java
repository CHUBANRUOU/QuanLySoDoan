package com.dangtrananhtu.qlsv;

import java.util.ArrayList;

public class DoanVien {
    String id,mssv,tensv,ngaynop,gioitinh,khoa,khoaSv,tinhtrang;
    public DoanVien(){}

    public DoanVien(String id, String mssv, String tensv, String gioitinh, String khoa, String khoaSv, String tinhtrang,String ngaynop) {
        this.id = id;
        this.mssv = mssv;
        this.tensv = tensv;
        this.gioitinh = gioitinh;
        this.khoa = khoa;
        this.khoaSv = khoaSv;
        this.tinhtrang = tinhtrang;
        this.ngaynop = ngaynop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getNgaynop() {
        return ngaynop;
    }

    public void setNgaynop(String ngaynop) {
        this.ngaynop = ngaynop;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getKhoaSv() {
        return khoaSv;
    }

    public void setKhoaSv(String khoaSv) {
        this.khoaSv = khoaSv;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

}
