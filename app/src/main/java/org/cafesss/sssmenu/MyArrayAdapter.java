package org.cafesss.sssmenu;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyArrayAdapter extends BaseAdapter {
        private Context context;
        private List<String> list;

        public MyArrayAdapter(Context context, List<String> list)
        {
            this.context = context;
            this.list=list;
        }

        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View v=View.inflate(context,R.layout.simple_list_item,null);
            TextView txt=(TextView)v.findViewById(R.id.txt) ;
            txt.setText(list.get(position));
            return v;
        }


    }

