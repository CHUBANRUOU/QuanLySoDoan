package com.dangtrananhtu.qlsv;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
public class DBHelp {
        Context context;
        String dbName = "qldv.db";
        public DBHelp(Context context){
            this.context = context;
        }
    private SQLiteDatabase openDB() {
        return context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
    }
    private void closeDB(SQLiteDatabase db) {
        db.close();
    }
    public void createTable() {
        SQLiteDatabase db = openDB();
        String sqlQldv = "CREATE TABLE IF NOT EXISTS qldv (" +
                " ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " masv TEXT," +
                " tensv TEXT," +
                " gioitinh TEXT," +
                " khoa TEXT," +
                " khoa_sv TEXT," +
                " tinhtrang TEXT," +
                " ngaynop TEXT);";
        db.execSQL(sqlQldv);
        closeDB(db);
    }
    public ArrayList<DoanVien> getAllDoanVien() {
        SQLiteDatabase db = openDB();
        ArrayList<DoanVien> arr = new ArrayList<>();
        String sql = "select * from qldv";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String id = csr.getString(0);
                    String mssv = csr.getString(1);
                    String name = csr.getString(2);
                    String gioitinh = csr.getString(3);
                    String khoa = csr.getString(4);
                    String khoasv = csr.getString(5);
                    String tinhtrang = csr.getString(6);
                    String ngaynop = csr.getString(7);
                    DoanVien doanVien = new DoanVien(id, mssv, name, gioitinh, khoa, khoasv, tinhtrang,ngaynop);
                    arr.add(doanVien);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }
    public ArrayList<DoanVien> getAllDoanVien(String content) {
        SQLiteDatabase db = openDB();
        ArrayList<DoanVien> arr = new ArrayList<>();
        String sql = "select * from qldv where tensv like" + "'%" + content + "%'";
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String id = csr.getString(0);
                    String mssv = csr.getString(1);
                    String name = csr.getString(2);
                    String gioitinh = csr.getString(3);
                    String khoa = csr.getString(4);
                    String khoasv = csr.getString(5);
                    String tinhtrang = csr.getString(6);
                    String ngaynop = csr.getString(7);
                    DoanVien doanVien = new DoanVien(id, mssv, name, gioitinh, khoa, khoasv, tinhtrang,ngaynop);
                    arr.add(doanVien);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr;
    }
    public DoanVien getDoanVien(String idsv) {
        SQLiteDatabase db = openDB();
        ArrayList<DoanVien> arr = new ArrayList<>();
        String sql = "select * from qldv where id = " + idsv;
        Cursor csr = db.rawQuery(sql, null);
        if (csr != null) {
            if (csr.moveToFirst()) {
                do {
                    String id = csr.getString(0);
                    String mssv = csr.getString(1);
                    String name = csr.getString(2);
                    String gioitinh = csr.getString(3);
                    String khoa = csr.getString(4);
                    String khoasv = csr.getString(5);
                    String tinhtrang = csr.getString(6);
                    String ngaynop = csr.getString(7);
                    DoanVien doanVien = new DoanVien(id, mssv, name, gioitinh, khoa, khoasv, tinhtrang,ngaynop);
                    arr.add(doanVien);
                } while (csr.moveToNext());
            }
        }
        closeDB(db);
        return arr.get(0);
    }
    public void insertDv(DoanVien dv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("masv", dv.getMssv());
        contentValues.put("tensv", dv.getTensv());
        contentValues.put("gioitinh", dv.getGioitinh());
        contentValues.put("khoa", dv.getKhoa());
        contentValues.put("khoa_sv", dv.getKhoaSv());
        contentValues.put("tinhtrang", dv.getTinhtrang());
        contentValues.put("ngaynop", dv.getNgaynop());
        SQLiteDatabase db = openDB();
        db.insert("qldv", null, contentValues);
        closeDB(db);
    }
    public void updateDv(DoanVien dv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("masv", dv.getMssv());
        contentValues.put("tensv", dv.getTensv());
        contentValues.put("gioitinh", dv.getGioitinh());
        contentValues.put("khoa", dv.getKhoa());
        contentValues.put("khoa_sv", dv.getKhoaSv());
        contentValues.put("tinhtrang", dv.getTinhtrang());
        contentValues.put("ngaynop", dv.getNgaynop());
        SQLiteDatabase db = openDB();
        db.update("qldv",  contentValues, "id" + " = ?",
                new String[]{dv.id});
        closeDB(db);
    }
    public void deleteDv(String id) {
        SQLiteDatabase db = openDB();
        db.delete("qldv", "id" + " = ?",
                new String[]{id});
    }
}

