package com.example.drupaldayz.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Create by Dan Stachlewski on 29/6/18
 */
//Currently storing a List of Crimes in a Singleton Class = which only allows one instance of itself
//to be created pp. 159
//Create a CrimeLab Class with a private Constructor & a get() Method:
//If the Instance already Exists, then get() returns the Instance.
//If the Instance does not Exist yet, then get() will call the Constructor to create it...
public class CrimeLab {

    //Implement CrimeLab as a singleton with a private Constructor & a get():
    //The s identifies CrimeLab as a Static Variable
    private static CrimeLab sCrimeLab;

    //List<Crime> is an ordered list of Crime Objects which are stored in an Array
    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    //Other classes will not be able to create a CrimeLab, bypasing the get() Method - we are
    //passing the Context Object
    private CrimeLab(Context context){

        //Create an Empty List of Crimes
        mCrimes = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #: " + i);
            crime.setSolved(i % 2 == 0); //Every other Crime is checked as 'Solved'
            mCrimes.add(crime);
            //pp. 188
        }
    }

    //Create 2 Methods:
    //getCrimes() that returns the List
    //getCrime(UUID id) that returns a Crime with a given Id

    public List<Crime>getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime crime:mCrimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }

        return null;
    }
}
