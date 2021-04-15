package com.example.exercisepertama;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class LihatData extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener  {

    SearchView searchView;
    private ListView list;
    private ListViewAdapter adapter;
    String[] listnama;

    public static ArrayList<com.example.exercisepertama.className> classNamaArrayList = new ArrayList<com.example.exercisepertama.className>();
    Bundle bundle = new Bundle();
    Intent intent;
    String Kontak;

    ArrayAdapter<String > arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchView = findViewById(R.id.searchView);
        listnama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul",
                "Intan", "Vina", "Gita", "Vian", "Lutfi" };

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,listnama);
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();



        for (int i = 0; i < listnama.length; i++) {
            com.example.exercisepertama.className classNama = new com.example.exercisepertama.className(listnama[i]);
            classNamaArrayList.add(classNama);
            adapter = new ListViewAdapter(this);
            list.setAdapter(arrayAdapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Kontak = classNamaArrayList.get(position).getName();
                    bundle.putString("a", Kontak.trim());

                    PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                    pm.setOnMenuItemClickListener(LihatData.this);
                    pm.inflate(R.menu.popup_menu);
                    pm.show();
                }
            });
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    LihatData.this.arrayAdapter.getFilter().filter(query);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    LihatData.this.arrayAdapter.getFilter().filter(newText);
                    return false;
                }
            });
        }
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), DetailKontak.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                String nomor_kontak = Kontak.trim();
                String Nomor = "";

                if (nomor_kontak == "Inayah"){
                    Nomor = "082187483247";
                }
                else if (nomor_kontak == "Ilham"){
                    Nomor = "082131214243";
                }
                else if (nomor_kontak == "Eris"){
                    Nomor = "081231342355";
                }
                else if (nomor_kontak == "Fikri"){
                    Nomor = "083124565767";
                }
                else if (nomor_kontak == "Maul"){
                    Nomor = "08122777222";
                }
                else if (nomor_kontak == "Intan"){
                    Nomor = "082214325346";
                }
                else if (nomor_kontak == "Vina"){
                    Nomor = "082143242355";
                }
                else if (nomor_kontak == "Gita"){
                    Nomor = "0835253463654";
                }
                else if (nomor_kontak == "Lutfi"){
                    Nomor = "0822525436757";
                }
                else if (nomor_kontak == "Vian"){
                    Nomor = "0821252534656";
                }

                Toast.makeText(getApplicationContext(),Nomor, Toast.LENGTH_LONG).show();
                break;

        }
        return false;

    }

}