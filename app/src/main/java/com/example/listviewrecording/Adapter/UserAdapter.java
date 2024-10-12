package com.example.listviewrecording.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listviewrecording.Model.UserModel;
import com.example.listviewrecording.R;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    Context context;
    ArrayList<UserModel> arrayList;
    public UserAdapter(Context context,ArrayList<UserModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.user_row_layout,null);
        TextView textName = convertView.findViewById(R.id.txtName);
        TextView textEmail = convertView.findViewById(R.id.txtEmail);

        UserModel userModel = arrayList.get(position);
        textName.setText(userModel.getName());
        textEmail.setText(userModel.getEmail());
        return convertView;
    }
}
