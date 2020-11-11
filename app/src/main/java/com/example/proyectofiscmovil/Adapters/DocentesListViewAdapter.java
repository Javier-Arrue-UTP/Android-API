package com.example.proyectofiscmovil.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.proyectofiscmovil.Models.Docentes;
import com.example.proyectofiscmovil.R;

import java.util.List;

public class DocentesListViewAdapter extends ArrayAdapter<Docentes> {

    private List<Docentes> lista;

    public DocentesListViewAdapter(Context context, List<Docentes> lista){
        super(context, R.layout.listview_docentes_encuestados,lista);
        this.lista = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_docentes_encuestados,null);

        TextView cedula= (TextView)item.findViewById(R.id.cedulaListView);
        cedula.setText(lista.get(position).getCedula());

        TextView semestre= (TextView)item.findViewById(R.id.semestreListView);
        semestre.setText(lista.get(position).getSemestre());

        TextView asignaturas= (TextView)item.findViewById(R.id.asignaturaListView);
        asignaturas.setText(lista.get(position).getNombreAsignatura());

        TextView codgrupo = (TextView)item.findViewById(R.id.grupoListView);
        codgrupo.setText(lista.get(position).getCodGrupo());



        return item;
    }



}
