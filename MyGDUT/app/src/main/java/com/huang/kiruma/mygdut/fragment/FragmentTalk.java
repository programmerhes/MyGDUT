package com.huang.kiruma.mygdut.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.huang.kiruma.mygdut.activity.GradeShowActivity;
import com.huang.kiruma.mygdut.activity.R;
import com.huang.kiruma.mygdut.activity.TalkActivity;
import com.huang.kiruma.mygdut.domain.TalkLoginMessage;
import com.huang.kiruma.mygdut.service.WebService;

/**
 * Created by Lenovo on 2017/10/28.
 */

public class FragmentTalk extends Fragment implements View.OnClickListener{
    private EditText accountEditText, passwordEditText;
    private Button button;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Intent intent;
    private TextView register;
    private WebService webService=null;
    private TalkLoginMessage talkLoginMessage=null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talk, container, false);
        fragmentManager = getFragmentManager();
        accountEditText = (EditText) view.findViewById(R.id.talk_account);
        passwordEditText = (EditText) view.findViewById(R.id.talk_password);
        button=(Button)view.findViewById(R.id.talk_login);
        register=(TextView)view.findViewById(R.id.talk_register);
        button.setOnClickListener(this);
        register.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.talk_login:
                webService=new WebService();
                webService.setUsername(accountEditText.getText().toString());
                webService.setPassword(passwordEditText.getText().toString());
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                talkLoginMessage=webService.postRequest();
                if("200".equals(talkLoginMessage.getCode())){
                    intent = new Intent(getActivity(),TalkActivity.class);
                    intent.putExtra("talkLoginMessage",talkLoginMessage);
                    startActivity(intent);
                }else if("404".equals(talkLoginMessage.getCode())){
                    Toast.makeText(getActivity(),talkLoginMessage.getMsg(),
                        Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.talk_register:
                break;

        }

    }
}
