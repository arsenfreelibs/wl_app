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
            holder = createViewHolder(convertView, exercises);

            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        holder.setValues(exercises);

        return convertView;
    }

    private ViewHolder createViewHolder(View convertView, Exercises exercises) {

        if (exercises.getType() == Exercises.BASE_TYPE){
            ViewHolder holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.exercises_name);
            return holder;
        }
        if (exercises.getType() == Exercises.ONLY_TIME_TYPE){
            ViewHolderOnlyTime holder = new ViewHolderOnlyTime();
            holder.name = (TextView) convertView.findViewById(R.id.exercises_name);
            holder.repeatsCount = (TextView) convertView.findViewById(R.id.exercises_repeats_count);
            holder.time = (TextView) convertView.findViewById(R.id.exercises_time);
            return holder;
        }

        return null;
    }

    private class ViewHolder {
        TextView name;

        void setValues(Exercises exercises){
            name.setText(exercises.getName());
        }
    }

    private class ViewHolderOnlyTime extends ViewHolder {
        TextView repeatsCount;
        TextView time;

        void setValues(Exercises exercises){
            super.setValues(exercises);
            repeatsCount.setText("123");
            time.setText("15:00");
        }
    }
}
