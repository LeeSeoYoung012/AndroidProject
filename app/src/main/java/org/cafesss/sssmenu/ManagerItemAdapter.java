package org.cafesss.sssmenu;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ManagerItemAdapter extends BaseAdapter {
    OrderDBHelper orderDB;
    UserDBHelper userDB;
    String id;
    private Context context;

    private List<User> managerorderList;
    private MyArrayAdapter listAdapter;
    private List<String> list;
    Cursor cursor;

    public ManagerItemAdapter(Context context, List<User> managerorderList) {
        super();
        this.context = context;
        this.managerorderList = managerorderList;
    }

    public int getCount() {
        return managerorderList.size();
    }

    @Override
    public Object getItem(int position) {
        return managerorderList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.order_list_manager, null);
        ListView listView = (ListView) v.findViewById(R.id.listView);
        TextView user = (TextView) v.findViewById(R.id.user);
        TextView phone = (TextView) v.findViewById(R.id.phone);
        Button click = (Button) v.findViewById(R.id.click);

        View v2 = View.inflate(context, R.layout.simple_list_item, null);
        TextView txt=(TextView)v2.findViewById(R.id.txt);

        id = managerorderList.get(position).getId();
        user.setText(String.format("%s(%s)", managerorderList.get(position).getName(), id));
        phone.setText(managerorderList.get(position).getPhone());

        orderDB = new OrderDBHelper(context);
        userDB=new UserDBHelper(context);

        list = new ArrayList<>();
        cursor = orderDB.getNDelListContents(id);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndex("PRODUCT")) +
                    "\n" + "사이즈:" + cursor.getString(cursor.getColumnIndex("SIZE")));
        }
        listAdapter = new MyArrayAdapter(context, list);
        listView.setAdapter(listAdapter);
        setLisetViewHeight(listView,listAdapter.getCount());

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderDB.deleteOrder(id);
                userDB.odelete(id);
                notifyDataSetChanged();
            }

        });

        return v;
    }

private void setLisetViewHeight (ListView listView,int count)
{
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
        return;
        }
        int totalHeight = 0;
        if (count == 0) {
        count = listAdapter.getCount();
        }
        for (int i = 0; i < listAdapter.getCount(); i++) {
        if (i >= count)
        break;
        View listItem = listAdapter.getView(i, null, listView);
        listItem.measure(0, 0);
        totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (count - 1));
        listView.setLayoutParams(params);
        }
}
