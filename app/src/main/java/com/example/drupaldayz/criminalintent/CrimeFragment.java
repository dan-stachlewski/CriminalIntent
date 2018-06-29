package com.example.drupaldayz.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Create by Dan Stachlewski on 29/6/18
 */
//This is a Controller that Interacts with the Model & the View Objects - its job is to present the
//details of a specific Crime & update those details as the User changes them
//Most of the Controller work will be done by the Fragments in the Fragment Lifecycle Methods - which
//correspond to the Activity's Methods
public class CrimeFragment extends Fragment {

    //Add Member variable for Crime Instance
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckbox;

    //Add an Implementation of the Fragment.onCreate(Bundle); - a public method b/c it needs to be
    //accesible by any Activity that hosts the Frag (short for Fragment)
    //The Bundle is used to 'Save' & 'Retrieve' the Frag's State
    //This Method DOES NOT inflate the Frag's View
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create an Instance of a 'New Crime'
        mCrime = new Crime();
    }

    //To Create & Configure the the Frag's View - use the following Frag Lifecycle Method:
    //Use layoutInflater Method to Inflate the Frag's View, pass in the layout recourse ID fragment_crime,
    //the view's parent, we passed false b/c we ill add the view in Activity's code
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);


        //Wiring the widgets within the fragment:
        mSolvedCheckbox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });

        mDateButton = (Button)v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //********************
        //Make sure this return v is placed at the bottom of the wired widgets.
        //********************
        return v;
    }
}
