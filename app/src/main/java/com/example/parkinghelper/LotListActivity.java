package com.example.parkinghelper;

import android.support.v4.app.Fragment;

public class LotListActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return new LotListFragment();
    }
}
