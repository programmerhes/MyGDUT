package com.huang.kiruma.mygdut.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.huang.kiruma.mygdut.activity.GradeShowActivity;
import com.huang.kiruma.mygdut.activity.R;
import com.huang.kiruma.mygdut.domain.Grade;
import com.huang.kiruma.mygdut.domain.LoginMessage;
import com.huang.kiruma.mygdut.service.GradeSearch;
import com.huang.kiruma.mygdut.service.JsonHandle;
import com.huang.kiruma.mygdut.service.LoginHandle;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2017/9/30.
 */

public class FragmentGrade extends Fragment implements View.OnClickListener {
    private EditText accountEditText, passwordEditText, codeEditText;
    private ImageView imageView;
    private Button button;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Intent intent;
    private GradeSearch g = new GradeSearch();
    private ArrayList<Grade> grades = null;
    private String session = null;
    private LoginMessage loginMessage = null;
    private JsonHandle jsonHandle = new JsonHandle();



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade, container, false);
        fragmentManager = getFragmentManager();
        accountEditText = (EditText) view.findViewById(R.id.account);
        passwordEditText = (EditText) view.findViewById(R.id.password);
        codeEditText = (EditText) view.findViewById(R.id.code_input);

        imageView = (ImageView) view.findViewById(R.id.code);
        button = (Button) view.findViewById(R.id.login);
        button.setOnClickListener(this);
        imageView.setOnClickListener(this);
        try {
            sendRequest(imageView);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:

                String account = accountEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String code = codeEditText.getText().toString();


                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String message = g.login(code, account, password, session);

                    loginMessage = jsonHandle.doLoginMessageJsonHandle(message);
                    System.out.println(loginMessage.getMsg());

                    if ("y".equals(loginMessage.getStatus())) {

                        grades = g.search(session);

                        intent = new Intent(getActivity(), GradeShowActivity.class);
                        intent.putExtra("grades", grades);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), loginMessage.getMsg(),
                                Toast.LENGTH_SHORT).show();
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            case R.id.code:
                try {

                    sendRequest(imageView);

                } catch (Exception e) {
                    e.printStackTrace();
                }


        }
    }

    public void sendRequest(ImageView imageView){
         Handler handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:

                        session = (String) msg.obj;

                    default:
                        break;
                }
            }

        };

        LoginHandle lh = new LoginHandle(handler);
        lh.setImageView(imageView);
        lh.execute();

    }

}
