package com.example.kaitlynanderson.andevcon2017;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by kaitlynanderson on 6/23/17.
 * Activity showing how a basic Bottom Sheet works. Demonstrates a Coordinator Layout behavior
 * and how that might work right out of the box.
 */

public class BottomSheetActivity extends AppCompatActivity {

    private TextView mSheetOffsetText;

    private TextView mSheetStateText;

    private HashMap<Integer, String> mStateMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_sheet);

        mStateMap = new HashMap<>();
        mStateMap.put(1, "DRAGGING");
        mStateMap.put(2, "SETTLING");
        mStateMap.put(3, "EXPANDED");
        mStateMap.put(4, "COLLAPSED");
        mStateMap.put(5, "HIDDEN");

        mSheetOffsetText = (TextView) findViewById(R.id.text_drawer_offset);
        mSheetStateText = (TextView) findViewById(R.id.text_sheet_state);

        LinearLayout bottomSheet = (LinearLayout) findViewById(R.id.container_bottom_sheet);

        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setHideable(false); // so that it cannot be swiped away
        bottomSheetBehavior.setPeekHeight(
                getResources().getDimensionPixelSize(R.dimen.bottom_sheet_peek_height));
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                String stateText = "Current state is: " + mStateMap.get(newState);
                mSheetStateText.setText(stateText);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                String offsetText = "Sheet Offset is: " + String.valueOf(slideOffset);
                mSheetOffsetText.setText(offsetText);
            }
        });
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        String stateTextInitial = "Current state is: " + mStateMap
                .get(bottomSheetBehavior.getState());
        mSheetStateText.setText(stateTextInitial);
        String sheetOffsetInitial = "Sheet Offset is: 1.0";
        mSheetOffsetText.setText(sheetOffsetInitial);
    }
}
