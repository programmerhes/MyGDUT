package com.huang.kiruma.mygdut.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.huang.kiruma.mygdut.activity.GradeShowActivity;
import com.huang.kiruma.mygdut.activity.R;

/**
 * Created by Lenovo on 2017/9/30.
 */

public class FragmentMain extends Fragment implements View.OnClickListener{
    private EditText accountEditText,passwordEditText;
    private Button button;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Intent intent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade,container,false);
        fragmentManager=getFragmentManager();
        accountEditText=(EditText)view.findViewById(R.id.account);
        passwordEditText=(EditText)view.findViewById(R.id.password);
        button=(Button)view.findViewById(R.id.login);
        button.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v){
        intent=new Intent(getActivity(), GradeShowActivity.class);
        startActivity(intent);
    }

}
