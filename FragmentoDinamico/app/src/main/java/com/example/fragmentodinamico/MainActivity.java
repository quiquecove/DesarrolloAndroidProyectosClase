package com.example.fragmentodinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
//    FragmentManager fm = getSupportFragmentManager();
//    FragmentTransaction ft = fm.beginTransaction();

    TabLayout tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ft.add(R.id.flContenedor, new Fragment1());
//        ft.addToBackStack(null);
//        ft.commit();
        tb = findViewById(R.id.tabLayout);
        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                switch (tab.getPosition()){
                    case 0:
                        ft.replace(R.id.flContenedor, new Fragment1());
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 1:
                        ft.replace(R.id.flContenedor, new Fragment2());
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                    case 2:
                        ft.replace(R.id.flContenedor, new Fragment3());
                        ft.addToBackStack(null);
                        ft.commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //No se usa
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //No se usa
            }
        });


    }




//public void cambiarFragmento(){
//        ft = fm.beginTransaction();
//        ft.replace(R.id.flContenedor, new CabeceraFragment());
//        ft.addToBackStack(null);
//        ft.commit();
//    }
//

}