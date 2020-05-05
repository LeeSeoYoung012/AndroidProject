package org.cafesss.sssmenu;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReceiptArrayAdapter extends BaseAdapter {
    OrderDBHelper orderDB;
    String orderedtime;
    private Context context;

    private List<String> timeList;
    private MyArrayAdapter listAdapter;
    private List<String> list;
    Cursor cursor;
    String id;

    public  ReceiptArrayAdapter(Context context, List<String> timeList,String id)
    {
        this.context = context;
        this.timeList=timeList;
        this.id=id;
    }

    public int getCount() {
        return timeList.size();
    }

    @Override
    public Object getItem(int position) {
        return timeList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v=View.inflate(context,R.layout.simple_receipt_list,null);
        ListView listView = (ListView) v.findViewById(R.id.listView);
        TextView time = (TextView) v.findViewById(R.id.time);
        orderDB=new OrderDBHelper(context);

        View v2 = View.inflate(context, R.layout.simple_list_item, null);
        TextView txt=(TextView)v2.findViewById(R.id.txt);

        orderedtime = timeList.get(position);
        time.setText(String.format("%s", orderedtime));

        list = new ArrayList<>();
        cursor = orderDB.getTimeListContents(id,orderedtime);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndex("PRODUCT")) +
                            "\n" + "사이즈:" + cursor.getString(cursor.getColumnIndex("SIZE"))+
                            "  수량:"+cursor.getInt(cursor.getColumnIndex("PRODNUM"))+"\n"
                    +"상품가격:"+cursor.getInt(cursor.getColumnIndex("PRICE"))+
                    "  총가격:"+cursor.getInt(cursor.getColumnIndex("TOTALPRICE"))
            );
        }

        listAdapter = new MyArrayAdapter(context, list);
        listView.setAdapter(listAdapter);
        setLisetViewHeight(listView,listAdapter.getCount());

        return v;

    }
    private void setLisetViewHeight (ListView listView, int count)
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
            totalHeight =totalHeight+ listItem.getMeasuredHeight()+8;
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (count - 1));
        listView.setLayoutParams(params);
    }
}



