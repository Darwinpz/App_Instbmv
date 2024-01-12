package com.darwinpz.instbmv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.os.Bundle;

import com.darwinpz.instbmv.Adaptador.ViewPageAdapter;
import com.darwinpz.instbmv.Fragmentos.Fragment_Perfil;
import com.darwinpz.instbmv.Fragmentos.Fragmento_Inicio;
import com.darwinpz.instbmv.Fragmentos.Fragmento_Usuario;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class Principal extends AppCompatActivity {

    public static Activity actividad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        ViewPageAdapter adaptador = new ViewPageAdapter(getSupportFragmentManager(), getLifecycle());
        adaptador.addFragment(new Fragmento_Inicio());
        adaptador.addFragment(new Fragmento_Usuario());
        adaptador.addFragment(new Fragment_Perfil());

        viewPager2.setAdapter(adaptador);
        viewPager2.setOffscreenPageLimit(3);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {

            switch (position){
                case 0:
                    tab.setText(R.string.title_home);
                    break;
                case 1:
                    tab.setText(R.string.title_user);
                    break;
                case 2:
                    tab.setText(R.string.title_profile);
                    break;
            }

        }).attach();


        actividad = this;

    }
}