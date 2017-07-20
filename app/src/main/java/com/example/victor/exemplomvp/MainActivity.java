package com.example.victor.exemplomvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = (LoginFragment) getSupportFragmentManager().getFragments().get(0);
    }

    public void btnLogarOnClick(View view) {
        loginFragment.btnLogarOnClick(view);
    }
}