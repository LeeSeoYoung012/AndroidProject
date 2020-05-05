package org.cafesss.sssmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private List<User> userList;

    public UserListAdapter(Context context, List<User> userList)
    {
        super();
        this.context = context;
        this.userList = userList;
    }

    public int getCount() {
        return userList.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v=View.inflate(context,R.layout.user_list_item,null);
        TextView userId=(TextView)v.findViewById(R.id.user_list_id);
        TextView userName=(TextView)v.findViewById(R.id.user_list_name);
        TextView userAge=(TextView)v.findViewById(R.id.user_list_age);
        TextView userPhone=(TextView)v.findViewById(R.id.user_list_phone);

        userId.setText(userList.get(position).getId());
        userName.setText(userList.get(position).getName());
        userAge.setText(userList.get(position).getAge());
        userPhone.setText(userList.get(position).getPhone());

        return v;
    }


}