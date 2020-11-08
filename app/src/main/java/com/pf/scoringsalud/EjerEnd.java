package com.pf.scoringsalud;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pf.scoringsalud.Factorys.FactoryPuntuable;
import com.pf.scoringsalud.Puntuable.Actividad;



public class EjerEnd extends Fragment {

 Button end;
 Actividad a;
 String dato;
 TextView tv_ejerend_descripcion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ejer_end, container, false);
        tv_ejerend_descripcion = (TextView) view.findViewById(R.id.tv_ejerend_descripcion);

        end= view.findViewById(R.id.end);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postPuntuable();
                ListaEjercicios ed= new ListaEjercicios();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.ejerEnd, ed );
                transaction.commit();
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //recupero datos del fragment
        getParentFragmentManager().setFragmentResultListener("eje_end", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                tv_ejerend_descripcion.setText("ACAAAA");
                recuperarDato(result.getString("key").toString());
                a = (Actividad) FactoryPuntuable.actividad(dato);
                if(a==null){
                    tv_ejerend_descripcion.setText("NULL");
                }else{
                    tv_ejerend_descripcion.setText("Has completado ¡"+a.getNombre()+"!¡Sumaste " + a.getPuntosOtorgables()+ " puntos!");
                }

            }
        });

    }

    private void recuperarDato(String dato){
        this.dato=dato;

    }

    private void postPuntuable(){

    }
}