package com.example.projectproto_1;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.database.Cursor;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class fragment_Student_signUp extends Fragment  implements View.OnClickListener{

    Button home, sign_up;
    SQLiteDatabase sq;

    EditText et_rollno, et_name, et_pass;
    String name, pass, rollno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_student_sign_up, container, false);
        sq = getActivity().openOrCreateDatabase("RECORD", Context.MODE_PRIVATE, null);

        home = v.findViewById(R.id.button_1);
        sign_up = v.findViewById(R.id.signup);

        sign_up.setOnClickListener(this);
        home.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        if (view == home) {
            Intent intent = new Intent(getActivity(), login_page.class);
            startActivity(intent);
        } else if (view == sign_up) {
            rollno = et_rollno.getText().toString();
            name = et_name.getText().toString();
            pass = et_pass.getText().toString();

            sq.execSQL("insert into student values('" + rollno + "','" + name + "','" + pass + "')");
            Toast.makeText(getActivity(), "Account Created", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), login_page.class);
            startActivity(intent);
        }
    }
}

