package com.darwinpz.instbmv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.darwinpz.instbmv.Adaptador.ViewPageAdapter;
import com.darwinpz.instbmv.Fragmentos.Fragmento_Inicio;
import com.darwinpz.instbmv.Fragmentos.Fragmento_Perfil;
import com.darwinpz.instbmv.Fragmentos.Fragmento_Usuario;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class Principal extends AppCompatActivity {

    public static Activity actividad;

    public static SharedPreferences preferencias;

    public static String rol = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        preferencias = getSharedPreferences("Instbmv",MODE_PRIVATE);

        rol = preferencias.getString("rol","");

        ViewPageAdapter adaptador = new ViewPageAdapter(getSupportFragmentManager(), getLifecycle());

        if(rol.equals("Administrador")) {

            adaptador.addFragment(new Fragmento_Inicio());
            adaptador.addFragment(new Fragmento_Usuario());
            adaptador.addFragment(new Fragmento_Perfil());

            viewPager2.setAdapter(adaptador);
            viewPager2.setOffscreenPageLimit(3);

            new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {

                switch (position) {
                    case 0:
                        tab.setText(R.string.title_home);
                        break;
                    case 1:
                        tab.setText(R.string.title_user);
                        break;
                }

            }).attach();

        }else{

            adaptador.addFragment(new Fragmento_Inicio());
            adaptador.addFragment(new Fragmento_Perfil());

            viewPager2.setAdapter(adaptador);
            viewPager2.setOffscreenPageLimit(2);

            new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {

                switch (position) {
                    case 0:
                        tab.setText(R.string.title_home);
                        break;
                    case 1:
                        tab.setText(R.string.title_profile);
                        break;
                }

            }).attach();

        }

        actividad = this;

    }
}