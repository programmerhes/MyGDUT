package com.huang.kiruma.mygdut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.huang.kiruma.mygdut.activity.R;
import com.huang.kiruma.mygdut.domain.Grade;

import java.util.List;

/**
 * Created by Lenovo on 2017/10/20.
 */

public class GradeAdapter extends ArrayAdapter<Grade>{
    private int resourceId;

    public  GradeAdapter(Context context, int textViewResourceId, List<Grade> objects){
        super(context,textViewResourceId,objects);
        this.resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
            Grade grade=getItem(position);
            View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            TextView courseName=(TextView)view.findViewById(R.id.course_name);
            TextView courseGrade=(TextView)view.findViewById(R.id.course_grade);
            courseName.setText(grade.getKcmc());
            courseGrade.setText(grade.getZcj());

            return view;
    }


}
