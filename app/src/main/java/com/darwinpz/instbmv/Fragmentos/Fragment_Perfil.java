package com.darwinpz.instbmv.Fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.darwinpz.instbmv.R;


public class Fragment_Perfil extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        final View vista = inflater.inflate(R.layout.fragmento_perfil,container,false);

        Toolbar toolbar = (Toolbar) vista.findViewById(R.id.toolbar);

        toolbar.inflateMenu(R.menu.menu_perfil);

        return vista;

    }


}
