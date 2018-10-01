package com.example.juanes24.p2labiii;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @SuppressLint("SetTextI18n")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragmentTransaction= fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.nPrincipal:

                    Principal principal= new Principal();
                    fragmentTransaction.replace(R.id.frameLayout,principal).commit();

                    return true;
                case R.id.nAbout:

                    About about= new About();
                    fragmentTransaction.replace(R.id.frameLayout,about).commit();
                    return true;
                            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragmentManager= getSupportFragmentManager();
        fragmentTransaction= fragmentManager.beginTransaction();

        Principal principal= new Principal();
        fragmentTransaction.replace(R.id.frameLayout,principal).commit();
    }

}
