package com.ansari.example;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Toolbar toolbar;
Adapter adapter;
List<Model> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        if (toolbar!=null){
            setSupportActionBar(toolbar);
        }

        recyclerView=findViewById(R.id.recycleview);
        adapter=new Adapter(this, (ArrayList<Model>) arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setupdata();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.Search);
        SearchView searchView= (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    public void setupdata(){
        Model model=new Model(R.drawable.ic_launcher_background,"Waseem");
        arrayList.add(model);
        Model model1=new Model(R.drawable.ic_launcher_background,"haider");
        arrayList.add(model1);
        Model model2=new Model(R.drawable.ic_launcher_background,"shakeel");
        arrayList.add(model2);
        Model model3=new Model(R.drawable.ic_launcher_background,"Ahmad");
        arrayList.add(model3);
        Model model4=new Model(R.drawable.ic_launcher_background,"salman");
        arrayList.add(model4);
        Model model5=new Model(R.drawable.ic_launcher_background,"tanveer");
        arrayList.add(model5);
        Model model6=new Model(R.drawable.ic_launcher_background,"haider");
        arrayList.add(model6);
        Model model7=new Model(R.drawable.ic_launcher_background,"software");
        arrayList.add(model7);
        Model model8=new Model(R.drawable.ic_launcher_background,"hacker");
        arrayList.add(model8);
        Model model9=new Model(R.drawable.ic_launcher_background,"salman");
        arrayList.add(model9);
        Model model10=new Model(R.drawable.ic_launcher_background,"nadeem");
        arrayList.add(model10);
        Model model11=new Model(R.drawable.ic_launcher_background,"shoukat");
        arrayList.add(model11);
        Model model12=new Model(R.drawable.ic_launcher_background,"shahzad");
        arrayList.add(model12);
        Model model13=new Model(R.drawable.ic_launcher_background,"hasneen");
        arrayList.add(model13);
        Model model14=new Model(R.drawable.ic_launcher_background,"saqeelen");
        arrayList.add(model14);

    }
}