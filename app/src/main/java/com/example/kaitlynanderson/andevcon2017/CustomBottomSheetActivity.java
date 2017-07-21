package com.example.kaitlynanderson.andevcon2017;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by kaitlynanderson on 7/4/17.
 * This activity demonstrates what happens when you take a coordinatorLayout behavior and tweak it
 * to be your own
 */

public class CustomBottomSheetActivity extends AppCompatActivity{

    private TextView mSheetOffsetText;

    private TextView mSheetStateText;

    private HashMap<Integer, String> mStateMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_bottom_sheet);

        mStateMap = new HashMap<>();
        mStateMap.put(1, "DRAGGING");
        mStateMap.put(2, "SETTLING");
        mStateMap.put(3, "ANCHOR POINT");
        mStateMap.put(4, "EXPANDED");
        mStateMap.put(5, "COLLAPSED");
        mStateMap.put(6, "HIDDEN");


        mSheetOffsetText = (TextView) findViewById(R.id.text_drawer_offset);
        mSheetStateText = (TextView) findViewById(R.id.text_sheet_state);

        NestedScrollView bottomSheet = (NestedScrollView) findViewById(R.id.container_bottom_sheet);

        CustomBottomSheetBehavior bottomSheetBehavior = CustomBottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setHideable(false); // so that it cannot be swiped away
        bottomSheetBehavior.setPeekHeight(
                getResources().getDimensionPixelSize(R.dimen.bottom_sheet_peek_height));
        bottomSheetBehavior.setAnchorPoint(R.dimen.bottom_sheet_anchor_point);
        bottomSheetBehavior.addBottomSheetCallback(
                new CustomBottomSheetBehavior.BottomSheetCallback(){
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet,
                            @BottomSheetBehavior.State int newState) {
                        String stateText = "Current state is: " + mStateMap.get(newState);
                        mSheetStateText.setText(stateText);

                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        String offsetText = "Sheet Offset is: " + String
                                .valueOf(slideOffset);
                        mSheetOffsetText.setText(offsetText);
                    }
                });
        bottomSheetBehavior.setState(CustomBottomSheetBehavior.STATE_ANCHOR_POINT);
        String stateTextInitial = "Current state is: " + mStateMap
                .get(bottomSheetBehavior.getState());
        mSheetStateText.setText(stateTextInitial);
        String sheetOffsetInitial = "Sheet Offset is: 1.0";
        mSheetOffsetText.setText(sheetOffsetInitial);


    }
}
