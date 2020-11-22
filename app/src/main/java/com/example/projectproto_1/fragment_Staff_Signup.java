package com.example.projectproto_1;

;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class fragment_Staff_Signup extends Fragment {

    FirebaseAuth firebaseAuth;

    Button sign_up, home;
    EditText mname, memail, mpass, mphone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_staff_signup, container, false);

        sign_up = v.findViewById(R.id.btnSignUp);
        home = v.findViewById(R.id.home);
        mname = v.findViewById(R.id.et_name);
        memail = v.findViewById(R.id.et_email);
        mpass = v.findViewById(R.id.et_password);
        mphone = v.findViewById(R.id.et_phone_no);

        firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getContext(), login_page.class));
        }


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = mname.getText().toString().trim();
                Integer Phone = Integer.parseInt(mphone.getText().toString());
                String Email = memail.getText().toString().trim();
                String Password = mpass.getText().toString().trim();


                if (TextUtils.isEmpty((CharSequence) Name)) {
                    mname.setError("Name Required");
                }
                if (TextUtils.isEmpty((CharSequence) Email)) {
                    memail.setError("Email Required");
                }
                if (Phone < 10 && Phone > 10) {
                    memail.setError("Invalid Phone number");
                }

                if (TextUtils.isEmpty((CharSequence) Password)) {
                    memail.setError("Email Required");
                }

                if (Password.length() < 6) {
                    mpass.setError("Password must be greater than 6 Characters");
                }

                firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getContext(), login_page.class));
                        } else {
                            Toast.makeText(getContext(), "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });
        return v;
    }

}

