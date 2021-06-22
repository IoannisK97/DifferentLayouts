package com.example.jandroid.differentlayouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    private AnimalAdapter anAdapter;
    private RecyclerView recyclerView;


    String[] categories= {"Linear Vertical", "Linear Horizontal","Grid"};
    ArrayAdapter <String> spinnerAdapter;
    String record="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sp=(Spinner) findViewById(R.id.spinner1);
        spinnerAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,categories);
        sp.setAdapter(spinnerAdapter);



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        anAdapter = new AnimalAdapter(prepareAnimalData());
        final RecyclerView.LayoutManager[] anLayoutManager = {new LinearLayoutManager(getApplicationContext())};
        recyclerView.setLayoutManager(anLayoutManager[0]);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(anAdapter);
        recyclerView.setAdapter(anAdapter);
        prepareAnimalData();
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        record="Vertical";
                        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                        anAdapter = new AnimalAdapter(prepareAnimalData());
                        anLayoutManager[0] = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(anLayoutManager[0]);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(anAdapter);
                        recyclerView.setAdapter(anAdapter);
                        prepareAnimalData();
                        break;

                    case 1:
                        record="Horizontal";
                        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                        anAdapter = new AnimalAdapter(prepareAnimalData());
                        anLayoutManager[0]    = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                        recyclerView.setLayoutManager(anLayoutManager[0]);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(anAdapter);
                        recyclerView.setAdapter(anAdapter);
                        prepareAnimalData();
                        break;

                    case 2:
                        record="Grid";
                        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                        anAdapter = new AnimalAdapter(prepareAnimalData());
                        anLayoutManager[0] = new GridLayoutManager(getApplicationContext(),3);
                        recyclerView.setLayoutManager(anLayoutManager[0]);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(anAdapter);
                        recyclerView.setAdapter(anAdapter);
                        prepareAnimalData();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }




        }
        );







    }

    private List<Animal> prepareAnimalData() {
        List<Animal> animalList = new ArrayList<>();

        Animal animal = new Animal("bear", R.drawable.bear);
        animalList.add(animal);

        animal = new Animal("deer", R.drawable.deer);
        animalList.add(animal);

        animal = new Animal("fox", R.drawable.fox);
        animalList.add(animal);

        animal = new Animal("lion", R.drawable.lion);
        animalList.add(animal);

        animal = new Animal("penguin", R.drawable.penguin);
        animalList.add(animal);

        animal = new Animal("rabbit", R.drawable.rabbit);
        animalList.add(animal);

        animal = new Animal("tiger", R.drawable.tiger);
        animalList.add(animal);

        animal=new Animal("parrot",R.drawable.parrot);
        animalList.add(animal);

        animal=new Animal("koala",R.drawable.koala);
        animalList.add(animal);


        return animalList;
    }
}