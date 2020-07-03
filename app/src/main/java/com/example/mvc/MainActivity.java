package com.example.mvc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.View {


    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private Recyclerviewadapter recyclerviewadapter;
    private List<Testmodel> testModels;
    private Presenter presenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        showLoader();

        presenter = new Presenter(this);

        presenter.getTests("Nm0ZoMmAaGfOkGiGpBbhigbC92J2", "D47N8Uw56RbQmiJmFjHwoTM2ML03");
    }

    private void initView() {

        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        testModels = new ArrayList<>();
        recyclerviewadapter = new Recyclerviewadapter(this, testModels);
        recyclerView.setAdapter(recyclerviewadapter);
    }


    @Override
    public void fetchedTestmodel(boolean status, List<Testmodel> testmodels){
        this.testModels.addAll(testmodels);

        Log.d(TAG, "fetchedTestmodel: "+testModels.toString());

        recyclerviewadapter = new Recyclerviewadapter(this, this.testModels);
        recyclerView.setAdapter(recyclerviewadapter);

        hideLoader();
    }

    public void showLoader(){
        recyclerView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideLoader(){
        // show data
        // hide progress
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}