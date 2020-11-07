package com.example.quanlisv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {
    ArrayList<SinhVien> arr;
    Context ct;
    public SinhVienAdapter(@NonNull Context context, int resource, ArrayList<SinhVien> o) {
        super(context, resource, o);
        this.ct = context;
        this.arr= data.getDt().arrSV;

    }

    public void notifyDataSetChanged(){
        this.arr = data.getDt().arrSV;
        super.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View row = convertView;
       viewHodler v;
       if (row==null){
           LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           row = inflater.inflate(R.layout.item_sinh_vien,null);
           v=new viewHodler(row);
           row.setTag(v);

       } else {
           v=(viewHodler) row.getTag();
       }

       if (arr.size()>0){
           System.out.println("dugh");
           v.setView(arr.get(position));
       }
        return row;
    }
}
    class viewHodler {
    TextView txvTen,txvSDT,txvEmail,txvLop;
    ImageView imgGT;
    public viewHodler(View v){
        txvTen = (TextView)v.findViewById(R.id.txvTen);
        txvSDT = (TextView)v.findViewById(R.id.txvSDT);
        txvEmail = (TextView)v.findViewById(R.id.txvEmail);
        txvLop = (TextView)v.findViewById(R.id.txvLop);
        imgGT = (ImageView) v.findViewById(R.id.imgGT);
    }
    public void setView(SinhVien sv){
        txvTen.setText(sv.getTen());
        txvSDT.setText(sv.getSodt());
        txvLop.setText(sv.getLophoc());
        txvEmail.setText(sv.getEmail());
        System.out.println("dughj"+sv.getGioitinh());

        if(sv.getGioitinh().equals("nu")){
            imgGT.setImageResource(R.drawable.icons_girl);
        }
        else
        {
            imgGT.setImageResource(R.drawable.icons_boy);
        }
    }
    }
