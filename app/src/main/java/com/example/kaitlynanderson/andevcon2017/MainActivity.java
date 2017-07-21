package com.example.kaitlynanderson.andevcon2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button bottomSheetButton = (Button) findViewById(R.id.button_coordinator1);
        Button customBottomSheetButton = (Button) findViewById(R.id.button_coordinator2);
        Button collapsingToolbarButton = (Button) findViewById(R.id.button_coordinator3);
        Button percentRelativeLayout = (Button) findViewById(R.id.button_percent_relative_layout);
        Button percentToConstraintButton = (Button) findViewById(R.id.button_percent_to_constraint);
        Button constraintChainButton = (Button) findViewById(R.id.button_constraint_chain);
        Button allTheLayoutsButton = (Button) findViewById(R.id.button_constraint_playground);

        bottomSheetButton.setOnClickListener(this);
        customBottomSheetButton.setOnClickListener(this);
        collapsingToolbarButton.setOnClickListener(this);
        percentRelativeLayout.setOnClickListener(this);
        percentToConstraintButton.setOnClickListener(this);
        constraintChainButton.setOnClickListener(this);
        allTheLayoutsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.button_coordinator1:
                Intent intent = new Intent(this, BottomSheetActivity.class);
                startActivity(intent);
                break;
            case R.id.button_coordinator2:
                Intent intent2 = new Intent(this, CustomBottomSheetActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_coordinator3:
                Intent intent3 = new Intent(this, FABCollapsingToolbarActivity.class);
                startActivity(intent3);
                break;
            case R.id.button_percent_relative_layout:
                Intent intent4 = new Intent(this, PercentRelativeLayoutActivity.class);
                startActivity(intent4);
                break;
            case R.id.button_percent_to_constraint:
                Intent intent5 = new Intent(this, PercentToConstraintActivity.class);
                startActivity(intent5);
                break;
            case R.id.button_constraint_chain:
                Intent intent6 = new Intent(this, ConstraintChainsActivity.class);
                startActivity(intent6);
                break;
            case R.id.button_constraint_playground:
                Intent intent7 = new Intent(this, ConstraintPlaygroundActivity.class);
                startActivity(intent7);
                break;
        }
    }
}
