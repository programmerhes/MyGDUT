package com.huang.kiruma.mygdut.fragment;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huang.kiruma.mygdut.activity.R;
import com.huang.kiruma.mygdut.service.WebService;

/**
 * Created by Lenovo on 2017/9/30.
 */

public class FragmentLibrary extends Fragment {
    private String context;
    private TextView textView;
    private ImageButton imageButton;
    private FragmentManager fragmentManager;
    private WebService webService=null;
    public void setContext(String context){
        this.context=context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library,container,false);
        fragmentManager = getFragmentManager();
        imageButton=(ImageButton)view.findViewById(R.id.search_library);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               webService=new WebService();
//               StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//               StrictMode.setThreadPolicy(policy);
//               webService.postRequest();
//
//                Toast.makeText(getActivity(), "success",
//                        Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }
}
