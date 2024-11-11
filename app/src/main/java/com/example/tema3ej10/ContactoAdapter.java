package com.example.tema3ej10;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{
    ArrayList<Contacto> coleccion;

    public ContactoAdapter(ArrayList<Contacto> coleccion) {
        this.coleccion = coleccion;
    }

    @NonNull
    @Override
    public ContactoAdapter.ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactoAdapter.ContactoViewHolder ContactoViewHolder =
                new ContactoViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha,parent,false)
                );
        return ContactoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdapter.ContactoViewHolder holder, int position) {
        Contacto Contacto = coleccion.get(position);
        holder.imageView.setImageResource(Contacto.getImagen());
        holder.tv_nombre.setText(Contacto.getNombre());
        holder.tv_apellidos.setText(Contacto.getApellidos());
        holder.tv_telefono.setText(Contacto.getTelefono());
        holder.tv_email.setText(Contacto.getEmail());


    }

    @Override
    public int getItemCount() {
        return coleccion.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_nombre;
        TextView tv_apellidos;
        TextView tv_telefono;
        TextView tv_email;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tv_nombre = itemView.findViewById(R.id.tv_nombre);
            tv_apellidos = itemView.findViewById(R.id.tv_apellidos);
            tv_telefono = itemView.findViewById(R.id.tv_telefono);
            tv_email = itemView.findViewById(R.id.tv_email);
        }
    }
}