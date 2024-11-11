package com.example.tema3ej10;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ContactoAdapter.OnItemClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Crear conjunto de datos
        ArrayList<Contacto> ContactoArrayList = new ArrayList<>(Arrays.asList(new Contacto[]{
                new Contacto("Pedro", "Perez Lopez", "Pedroperlop@gmail.com", "666537234", R.drawable.cara1),
                new Contacto("Juan", "Garcia Marquez", "juangm@gmail.com", "667845912", R.drawable.cara2),
                new Contacto("Laura", "Hernandez Ortiz", "laurahe@gmail.com", "666235784", R.drawable.cara4),
                new Contacto("Ana", "Lopez Gonzalez", "analg@gmail.com", "677345672", R.drawable.cara4),
                new Contacto("Carlos", "Fernandez Diaz", "carlosfd@gmail.com", "665434123", R.drawable.cara3),
                new Contacto("Maria", "Rodriguez Sanchez", "mariars@gmail.com", "666987654", R.drawable.cara4),
                new Contacto("Luis", "Martinez Ruiz", "luismr@gmail.com", "667123456", R.drawable.cara1),
                new Contacto("Elena", "Moreno Perez", "elenamp@gmail.com", "676543987", R.drawable.cara4),
                new Contacto("Diego", "Ramirez Lopez", "diegorl@gmail.com", "664328901", R.drawable.cara2),
                new Contacto("Sara", "Gomez Torres", "saragt@gmail.com", "668789012", R.drawable.cara4),
                new Contacto("Pedro", "Perez Lopez", "Pedroperlop@gmail.com", "666537234", R.drawable.cara1),
                new Contacto("Juan", "Garcia Marquez", "juangm@gmail.com", "667845912", R.drawable.cara2),
                new Contacto("Laura", "Hernandez Ortiz", "laurahe@gmail.com", "666235784", R.drawable.cara4),
                new Contacto("Ana", "Lopez Gonzalez", "analg@gmail.com", "677345672", R.drawable.cara4),
                new Contacto("Carlos", "Fernandez Diaz", "carlosfd@gmail.com", "665434123", R.drawable.cara3),
                new Contacto("Maria", "Rodriguez Sanchez", "mariars@gmail.com", "666987654", R.drawable.cara4),
                new Contacto("Luis", "Martinez Ruiz", "luismr@gmail.com", "667123456", R.drawable.cara1),
                new Contacto("Elena", "Moreno Perez", "elenamp@gmail.com", "676543987", R.drawable.cara4),
                new Contacto("Diego", "Ramirez Lopez", "diegorl@gmail.com", "664328901", R.drawable.cara2),
                new Contacto("Sara", "Gomez Torres", "saragt@gmail.com", "668789012", R.drawable.cara4)
        }));


        // Crear el adaptador y establecer el listener
        ContactoAdapter contactoAdapter = new ContactoAdapter(ContactoArrayList);
        contactoAdapter.setOnItemClickListener(this); // Establecemos el listener

        // Instanciar el RecyclerView
        RecyclerView rvContactos = findViewById(R.id.rv_contactos);

        // Configurar el LayoutManager
        rvContactos.setLayoutManager(new LinearLayoutManager(this));

        // Asignar el adaptador al RecyclerView
        rvContactos.setAdapter(contactoAdapter);
    }

    // Implementación de la interfaz OnItemClickListener
    @Override
    public void onItemClick(View view, int position) {
        Contacto contacto = ((ContactoAdapter) ((RecyclerView) findViewById(R.id.rv_contactos)).getAdapter()).coleccion.get(position);
        String mensaje = "Contacto: " + contacto.getNombre() + " " + contacto.getApellidos() +
                "\nTel: " + contacto.getTelefono() +
                " Email: " + contacto.getEmail();
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}