package com.example.lap2_end.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lap2_end.MainActivity;
import com.example.lap2_end.MyAdapter;
import com.example.lap2_end.R;
import com.example.lap2_end.model.Contact;

import java.util.ArrayList;


public class Sua extends Fragment {

    private View mView;
    ListView listView;
    Button mButtonAdd, mButtonDel;
    MyAdapter myAdapter;
    EditText mEditTextName, mEditTextPhone, mEditTextImg;


    int d = 3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_sua, container, false);

        listView = mView.findViewById(R.id.listView);
        mButtonAdd = mView.findViewById(R.id.buttonAdd);
        mButtonDel = mView.findViewById(R.id.buttonDel);
        mEditTextName = mView.findViewById(R.id.editTextName);
        mEditTextPhone = mView.findViewById(R.id.editTextPhone);
        mEditTextImg = mView.findViewById(R.id.editTexImg);

        //
        ArrayList<Contact> data=MainActivity.data;
        //



        myAdapter = new MyAdapter(getContext(), R.layout.layout_item, data);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener((parent, view, position, id) ->
                {
                    CheckedTextView mCheckedTextView = view.findViewById(R.id.checkBox);
//                    mTextView.setText(mCheckedTextView.isChecked()+"");
                    if (mCheckedTextView.isChecked()) {
                        mCheckedTextView.setChecked(false);
                        data.get(position).setStatus(mCheckedTextView.isChecked());
                        mEditTextName.setText(data.get(position).getName());
                        mEditTextPhone.setText(data.get(position).getPhoneNumber());
                    } else {
                        mCheckedTextView.setChecked(true);
                        data.get(position).setStatus(mCheckedTextView.isChecked());
                        mEditTextName.setText(data.get(position).getName());
                        mEditTextPhone.setText(data.get(position).getPhoneNumber());
                    }
                }
//                android.R.layout.simple_list_item_multiple_choice
        );

        mButtonDel.setOnClickListener(v -> {
            ArrayList<Contact> i = new ArrayList<Contact>();
            for (Contact d : data) {
                if (d.getStatus() == true) {
                    i.add(d);

                }
            }
            data.removeAll(i);
            myAdapter.notifyDataSetChanged();
        });
        mButtonAdd.setOnClickListener(v -> {
            String name = mEditTextName.getText().toString().trim();
            String phone = mEditTextPhone.getText().toString().trim();
            String img = mEditTextImg.getText().toString().trim();
            if (!name.isEmpty() && !phone.isEmpty() && !img.isEmpty()) {
                d++;
                Contact viet = new Contact(d, name, phone, false, img);
                data.add(viet);
                myAdapter.notifyDataSetChanged();

            } else {
                Toast.makeText(getContext(), "không thể thêm khi chưa điền đủ thông tin ", Toast.LENGTH_LONG).show();
            }


        });
        return mView;
    }
}