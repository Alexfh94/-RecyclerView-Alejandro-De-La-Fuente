package com.example.tema3ej10;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {
    ArrayList<Contacto> coleccion;
    private OnItemClickListener listener;

    // Interfaz para capturar eventos de click
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    // Setter para el listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ContactoAdapter(ArrayList<Contacto> coleccion) {
        this.coleccion = coleccion;
    }

    @NonNull
    @Override
    public ContactoAdapter.ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdapter.ContactoViewHolder holder, int position) {
        Contacto contacto = coleccion.get(position);
        holder.imageView.setImageResource(contacto.getImagen());
        holder.tv_nombre.setText(contacto.getNombre());
        holder.tv_apellidos.setText(contacto.getApellidos());
        holder.tv_telefono.setText(contacto.getTelefono());
        holder.tv_email.setText(contacto.getEmail());
    }

    @Override
    public int getItemCount() {
        return coleccion.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
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

            // Enlazar el click del elemento
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(v, getAdapterPosition());
                }
            });
        }
    }
}
