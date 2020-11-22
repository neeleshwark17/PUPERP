package com.example.projectproto_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import java.net.Inet4Address;

public class login_page extends AppCompatActivity  {

    private Button login;
    private TextView signup;

    private TextView google_SignUp;
    private ImageView google;

    private TextInputLayout wrapperEmail;
    private TextInputLayout wrapperPassword;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        wrapperEmail = findViewById(R.id.editTextEmail);
        wrapperPassword = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.button_login);
        google_SignUp = findViewById(R.id.google_login);
        google = findViewById(R.id.google);
        signup=findViewById(R.id.button_signUp);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.profile) {
                    Toast.makeText(login_page.this, "PROFILE", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.exit) {
                    Toast.makeText(login_page.this, "EXIT", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.three) {
                    Toast.makeText(login_page.this, "THREE", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.four) {
                    Toast.makeText(login_page.this, "FOUR", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login_page.this,Sign_Up.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_c) {
        getMenuInflater().inflate(R.menu.c_menu, menu_c);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings) {
            Toast.makeText(this, "SETTINGS", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.help) {
            Toast.makeText(this, "HELP", Toast.LENGTH_SHORT).show();
        }
        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }


}


