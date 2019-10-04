package com.example.parkinghelper;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;


public class LotActivity extends SingleFragmentActivity {

    private static final String EXTRA_LOT_NAME = "lot_name";

    @Override
    public Fragment createFragment() {
        String lotName = (String) getIntent().getSerializableExtra(EXTRA_LOT_NAME);

        return LotFragment.newInstance(lotName);
    }

    public static Intent newIntent(Context packageContext, String lotName) {
        Intent intent = new Intent(packageContext, LotActivity.class);
        intent.putExtra(EXTRA_LOT_NAME, lotName);

        return intent;
    }
}
