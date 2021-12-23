package com.dangtrananhtu.qlsv;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class DvAdapter extends RecyclerView.Adapter<DvAdapter.DoanVienViewHolder> {
    Context context;
    ArrayList<DoanVien> list;
    DBHelp dbHelp;
    ActivityResultLauncher<Intent> getContent;
    public DvAdapter(Context context, ArrayList<DoanVien> list,ActivityResultLauncher<Intent> getContent) {
        this.context = context;
        this.list = list;
        dbHelp = new DBHelp(context);
        this.getContent = getContent;
    }
    @NonNull
    @Override
    public DoanVienViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_student, viewGroup, false);
        return new DoanVienViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DoanVienViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindData(list.get(position));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, holder.tvId);
                popupMenu.inflate(R.menu.item_menu);
                popupMenu.setOnMenuItemClickListener(menuItem -> {
                    switch (menuItem.getItemId()) {
                        case R.id.edit:
                            Intent intent = new Intent(context, Add.class);
                            intent.putExtra("edit", true);
                            intent.putExtra("id", list.get(position).id);
                            getContent.launch(intent);
                            break;
                        default:
                            dbHelp.deleteDv(list.get(position).id);
                            list.remove(position);
                            notifyItemRemoved(position);
                            notifyDataSetChanged();
                    }
                    return true;
                });
                popupMenu.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void notifyData(ArrayList<DoanVien> list){
        this.list = list;
        notifyDataSetChanged();
    }
    public class DoanVienViewHolder extends  RecyclerView.ViewHolder{
        private TextView tvId, tvTen, tvngaynop, tvKhoa, tvtinhtrang, tvKhoaSv;
        public DoanVienViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvTen = itemView.findViewById(R.id.tv_ten);
            tvngaynop = itemView.findViewById(R.id.tv_ngaynop);
            tvKhoa = itemView.findViewById(R.id.tv_khoa);
            tvtinhtrang = itemView.findViewById(R.id.tv_tinhtrang);
            tvKhoaSv = itemView.findViewById(R.id.tv_khoa_sv);
        }
        void bindData(DoanVien doanVien) {
            tvId.setText("Mã sv: "+doanVien.mssv);
            tvTen.setText("Họ tên: "+doanVien.tensv);
            tvngaynop.setText("Ngày Nộp: "+doanVien.ngaynop);
            tvKhoa.setText("Khoa: "+doanVien.khoa);
            tvtinhtrang.setText("Tình Trạng: "+doanVien.tinhtrang);
            tvKhoaSv.setText("Khoá: "+doanVien.khoaSv);
        }

    }
}
