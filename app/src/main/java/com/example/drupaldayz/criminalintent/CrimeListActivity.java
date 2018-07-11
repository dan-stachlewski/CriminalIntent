package com.example.drupaldayz.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Create by Dan Stachlewski on 2/7/18
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}
