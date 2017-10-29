package com.huang.kiruma.mygdut.activity;

import android.support.v4.app.Fragment;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;


import com.huang.kiruma.mygdut.fragment.FragmentGrade;
import com.huang.kiruma.mygdut.fragment.FragmentLibrary;
import com.huang.kiruma.mygdut.fragment.FragmentMain;
import com.huang.kiruma.mygdut.fragment.FragmentTalk;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


    private FragmentGrade fragmentGrade;
    private FragmentLibrary fragmentLibrary;
    private FragmentTalk fragmentTalk;
    private ImageButton gImageButton;
    private ImageButton lImageButton;
    private ImageButton tImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        bindView();

    }

    public void bindView() {
        gImageButton = (ImageButton) this.findViewById(R.id.grade);
        lImageButton = (ImageButton) this.findViewById(R.id.library);
        tImageButton=(ImageButton)this.findViewById(R.id.talk);
        gImageButton.setOnClickListener(this);
        lImageButton.setOnClickListener(this);
        tImageButton.setOnClickListener(this);
    }

    public void hideAllFragment(FragmentTransaction transaction) {
        if (fragmentGrade != null) {
            transaction.hide(fragmentGrade);

        }
        if (fragmentLibrary != null) {
            transaction.hide(fragmentLibrary);
        }
        if(fragmentTalk!=null){
            transaction.hide(fragmentTalk);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);


        switch (v.getId()) {
            case R.id.grade:
                selected();
                gImageButton.setSelected(true);
                gImageButton.setBackgroundResource(R.drawable.grade4);
                lImageButton.setBackgroundResource(R.drawable.book1);
                tImageButton.setBackgroundResource(R.drawable.talk);
                if (fragmentGrade == null) {
                    fragmentGrade = new FragmentGrade();

                    transaction.add(R.id.content, fragmentGrade);

                } else {

                    transaction.show(fragmentGrade);
                }
                break;
            case R.id.library:
                selected();
                lImageButton.setSelected(true);
                lImageButton.setBackgroundResource(R.drawable.book2);
                gImageButton.setBackgroundResource(R.drawable.grade3);
                tImageButton.setBackgroundResource(R.drawable.talk);
                if (fragmentLibrary == null) {
                    fragmentLibrary = new FragmentLibrary();

                    transaction.add(R.id.content, fragmentLibrary);
                } else {
                    transaction.show(fragmentLibrary);
                }
                break;
            case R.id.talk:
                selected();
                tImageButton.setSelected(true);
                tImageButton.setBackgroundResource(R.drawable.talk2);
                lImageButton.setBackgroundResource(R.drawable.book1);
                gImageButton.setBackgroundResource(R.drawable.grade3);

                if(fragmentTalk==null){
                    fragmentTalk=new FragmentTalk();
                    transaction.add(R.id.content,fragmentTalk);
                }else {
                    transaction.show(fragmentTalk);
                }


        }
        transaction.commit();
    }

    public void selected() {
        gImageButton.setSelected(false);
        lImageButton.setSelected(false);
        tImageButton.setSelected(false);
    }

}
