package com.example.drupaldayz.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//This Activity is capable of Hosting a a support fragment
//Hosting UI Fragments, an Activity must:
// - define a spot in the Activity Layout for the Frag's View
// - manage the lifecycle of the Frag's Instance
// Frag's are the Activity's Internal business, as Frag's lifecycle methods are called by the hosting Activity

//Now we need to extend the SingleFragmentActivity as it has the logic that will return an
//Instance of the Frag the Activity is Hosting
public class CrimeActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}




//public class CrimeActivity extends AppCompatActivity {

    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment);
        //Frag's can't display views on their own - we need to add CrimeFragment to Crime Activity:
        //Frag Mgr is resp for managing your Frag's & adding their Views to the Activity's View Heirarchy
        //Call an Instance of Fragment Manager
        //FragmentManager fm = getSupportFragmentManager();
        //Give Frag Mgr a Frag to Manage:
        //Tells the Frag Mgr where the Activity's View in the Frag's View should appear
        //used as a Unique id for a Frag in the Frag Mgrs list
        //Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        //If there is no Frag, start a Frag Transaction = add, remove, attach, detach or replace
        //Frags in the Frag List: The below code creates and commits a FRAGMENT TRANSACTION
        //Create a NEW Frag Transaction, inc one add operation in it & the commit it.
        //if(fragment == null){
            //fragment = new CrimeFragment();
            //fm.beginTransaction()
                    //passes the resource ID of the Frag container (FrameLayout defined in
                    //activity_fragment.xmlxml) & newly create CrimeFragment
                    //.add(R.id.fragment_container, fragment)
                    //.commit();
        //}
    //}
//}


