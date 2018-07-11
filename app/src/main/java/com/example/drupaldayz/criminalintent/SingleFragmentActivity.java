package com.example.drupaldayz.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Create by Dan Stachlewski on 2/7/18
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    //Subclasses of SingleFragmentActivity will implement the createFragment() Method to return an
    //Instance of the Frag that the Actiovity is Hosting
    //This will save alot of time typing code for creating Frag's
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Set the Activity's View to be inflated from the activity_fragment
        setContentView(R.layout.activity_fragment);

        //Look for the Frag in the Frag Mgr in that container, creating & adding the frag if it doesn't exist
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }


}
