package com.example.tringapps.list_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by TRINGAPPS on 03/11/2015.
 */
public class ContactAdapter extends BaseAdapter {
    private ArrayList<Contacts> arraylist=new ArrayList<Contacts>();
    private Context context;
    private static class MyHolder{
        public TextView id,name;
        MyHolder(View v)
        {
            id=(TextView)v.findViewById(R.id.idtext);
            name=(TextView)v.findViewById(R.id.nametext);
        }
    }
    ContactAdapter(Context context,ArrayList<Contacts> arraylist)
    {
        this.context=context;
        this.arraylist =arraylist ;
    }
    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
   @Override
    public View getView(int position, View view, ViewGroup parent) {
       MyHolder holder;
       if(view==null)
            {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.contactsinfo, parent, false);
                holder=new MyHolder(view);
                view.setTag(holder);
            }
        else
            {
                holder=(MyHolder)view.getTag();
            }
        Contacts contacts=(Contacts)getItem(position);
        holder.name.setText(contacts.getName());
        holder.id.setText(contacts.getId());
        return view;
    }
}
