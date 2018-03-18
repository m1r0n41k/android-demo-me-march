package com.drondon.androiddebugme.detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.drondon.androiddebugme.R;

import java.util.List;

public class SugarLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_level);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This feature not implemented", Snackbar.LENGTH_LONG)
                        .setAction("Try again", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //ignore
                            }
                        }).show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Generate dummy data
        List<SugarLevel> sugarLevels = DummyContent.getLevels();

        //Create adapter with dummy data
        SugarLevelAdapter levelAdapter = new SugarLevelAdapter(sugarLevels);

        //Set adapter to RecyclerView
        recyclerView.setAdapter(levelAdapter);
    }
}
