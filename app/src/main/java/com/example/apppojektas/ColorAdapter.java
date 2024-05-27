package com.example.apppojektas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ColorAdapter extends BaseAdapter {
    private Context context;
    private List<Colors> colorsList;

    public ColorAdapter(Context context, List<Colors> colorsList) {
        this.context = context;
        this.colorsList = colorsList;
    }

    @Override
    public int getCount() {
        return colorsList != null ? colorsList.size() : 0;
    }

    @Override
    public Integer getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_colors, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.color_name);
        ImageView image = rootView.findViewById(R.id.color_image);

        txtName.setText(colorsList.get(position).getColorName());
        image.setImageResource(colorsList.get(position).getColorImg());

        return rootView;
    }
}
