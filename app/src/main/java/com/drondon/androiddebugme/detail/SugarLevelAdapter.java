package com.drondon.androiddebugme.detail;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.drondon.androiddebugme.R;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by andriimiroshnychenko on 3/18/18.
 */

public class SugarLevelAdapter extends RecyclerView.Adapter<SugarLevelAdapter.MyViewHolder> {

    private DecimalFormat df = new DecimalFormat("#.##");
    private List<SugarLevel> levels;

    public SugarLevelAdapter(List<SugarLevel> levels) {
        this.levels = levels;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(inflater.inflate(R.layout.item_level, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SugarLevel sugarLevel = levels.get(position);

        holder.date.setText(DateUtils.getRelativeTimeSpanString(sugarLevel.getDate().getTime()));
        holder.level.setText(df.format(sugarLevel.getLevel()));
        holder.status.setBackgroundColor(getColorByStatus(sugarLevel.getStatus()));
    }

    @ColorInt
    private int getColorByStatus(@SugarLevel.Status int status) {
        int color = Color.BLACK;
        switch (status) {
            case SugarLevel.HIGH:
                color = Color.RED;
                break;
            case SugarLevel.LOW:
                color = Color.YELLOW;
                break;
            case SugarLevel.NORMAL:
                color = Color.GREEN;
                break;
            default:
                break;
        }
        return color;
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView level;
        View status;

        MyViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            level = itemView.findViewById(R.id.level);
            status = itemView.findViewById(R.id.status);
        }
    }
}
