package com.cs250.joanne.myfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class ItemFrag extends Fragment {

    private MyDBadapter dbAdapt;  // ref to our database
    private TextView tv;
    private Button btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.item_frag, container, false);

        // create or get database
        dbAdapt = MyDBadapter.getInstance(getActivity().getApplicationContext());
        dbAdapt.open();

        tv = (EditText) view.findViewById(R.id.item_text);
        btn = (Button) view.findViewById(R.id.add_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item myitem = new Item(tv.getText().toString());
                dbAdapt.insertItem(myitem);
                Toast.makeText(getActivity().getApplicationContext(), "added item", LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
