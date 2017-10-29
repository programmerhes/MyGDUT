package com.huang.kiruma.mygdut.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.huang.kiruma.mygdut.adapter.GradeAdapter;
import com.huang.kiruma.mygdut.domain.Grade;

import java.util.ArrayList;


public class GradeShowActivity extends AppCompatActivity {

    private ArrayList<Grade> grades=null;
    GradeAdapter adapter=null;
    ListView listView=null;
    TextView gpa=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_grade_show);
        Intent intent=getIntent();
        grades=(ArrayList<Grade>)intent.getSerializableExtra("grades");
        adapter=new GradeAdapter(GradeShowActivity.this,R.layout.grade_item,grades);
        gpa=(TextView)this.findViewById(R.id.gpa);
        listView=(ListView)this.findViewById(R.id.listview);
        gpa.setText(this.calculate());
        listView.setAdapter(adapter);

    }

    public String calculate(){

        Double personGpa=0.0;
        Double allGpa=0.0;
        Double gpa;
        for(Grade grade:grades){
            personGpa+=Double.valueOf(grade.getCjjd())*Double.valueOf(grade.getXf());
            allGpa+=Double.valueOf(grade.getXf());

        }
        gpa=personGpa/allGpa;


        return String.format("%.2f", gpa);
    }


}
