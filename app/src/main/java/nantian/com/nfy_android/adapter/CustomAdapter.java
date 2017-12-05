package nantian.com.nfy_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nantian.com.nfy_android.R;
import nantian.com.nfy_android.dto.Fixform;

/**
 * Created by xiaochunyuan on 17/12/4.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context = null;

    private List<Fixform> fixforms = null;

    @Override
    public int getCount() {
        return fixforms.size();
    }

    @Override
    public Fixform getItem(int position) {
        return fixforms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_cell, null);

        if (convertView == null) {
            convertView = view;

        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.tv_phone);
        TextView tvLoation = (TextView) convertView.findViewById(R.id.tv_loation);


        Fixform fixform =  getItem(position);

        tvName.setText(fixform.getName());
        tvLoation.setText(fixform.getLocation());
        tvPhone.setText(fixform.getPhone());


        return convertView;
    }


    public CustomAdapter(Context context) {

        this.context = context;
         fixforms = new ArrayList<>();

    }




    public void addFixForm(Fixform fixform)
    {

        fixforms.add(fixform);
        notifyDataSetChanged();

    }
//    public void fristAdd(Fixform fixform)
//    {
//      fixforms.add(fixform);
//
//        notifyDataSetChanged();
//
//    }

}
