package lnestares.com.br.violinapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lnestares.com.br.violinapp.R;
import lnestares.com.br.violinapp.model.Violin;

/**
 * Created by macinbox on 27/03/18.
 */

public class ViolinAdapter extends ArrayAdapter<Violin> {
    private ArrayList<Violin> lstViolins;

    public ViolinAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Violin> objects) {
        super(context, resource, objects);

        this.lstViolins = objects;
    }

    @Override
    public int getCount() {
        return lstViolins.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = null;

        if(convertView == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.adapter_violin, parent, false);
        }else {
            v = convertView;
        }

        TextView tvName;
        TextView tvModel;
        TextView tvPrice;

        tvName = (TextView) v.findViewById(R.id.tvName);
        tvModel = (TextView) v.findViewById(R.id.tvModel);
        tvPrice = (TextView) v.findViewById(R.id.tvPrice);

        tvName.setText(lstViolins.get(position).getName());
        tvModel.setText(lstViolins.get(position).getModel());
        tvPrice.setText(lstViolins.get(position).getPrice());

        return  v;
    }
}
