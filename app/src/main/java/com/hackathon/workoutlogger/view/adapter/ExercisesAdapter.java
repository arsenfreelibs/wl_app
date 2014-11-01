package com.hackathon.workoutlogger.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hackathon.workoutlogger.R;
import com.hackathon.workoutlogger.models.exercises.Exercises;
import com.hackathon.workoutlogger.models.user.User;

/**
 * Created by AAR on 11/1/14.
 */
public class ExercisesAdapter extends ArrayAdapter<Exercises> {
    Context context;

    public ExercisesAdapter(Context context) {
        super(context, 0);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Exercises exercises = getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.exercises_item, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.exercises_name);
            holder.repeatsCount = (TextView) convertView.findViewById(R.id.exercises_repeats_count);
            holder.time = (TextView) convertView.findViewById(R.id.exercises_time);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        holder.name.setText(exercises.getName());
        holder.repeatsCount.setText("3");
        holder.time.setText("10:00");

        return convertView;
    }

    private class ViewHolder {
        TextView name;
        TextView repeatsCount;
        TextView time;
    }
}
