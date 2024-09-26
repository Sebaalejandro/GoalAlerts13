package com.example.goalalerts;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private FloatingActionButton fabRefresh;
    private String[] partidos = {"Partido 1", "Partido 2", "Partido 3", "Partido 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        fabRefresh = findViewById(R.id.fabRefresh);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, partidos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String partidoSeleccionado = partidos[position];
                Toast.makeText(MainActivity.this, "Seleccionaste: " + partidoSeleccionado, Toast.LENGTH_SHORT).show();
            }
        });

        fabRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refrescarPartidos();
            }
        });
    }

    private void refrescarPartidos() {
        Toast.makeText(MainActivity.this, "Lista de partidos actualizada", Toast.LENGTH_SHORT).show();
        partidos = new String[]{"Partido 5", "Partido 6", "Partido 7", "Partido 8"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, partidos);
        listView.setAdapter(adapter);
    }
}
