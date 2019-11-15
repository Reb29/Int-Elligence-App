package com.example.parkinghelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.parkinghelper.models.Lot;
import com.example.parkinghelper.models.LotList;

import java.util.List;

public class LotPagerActivity extends AppCompatActivity {

    private static final String EXTRA_LOT_NAME = "lot_name";

    private List<Lot> mLots;
    private ViewPager mViewPager;

    public static Intent newIntent(Context packageContext, String lotName){
        Intent intent = new Intent(packageContext, LotPagerActivity.class);
        intent.putExtra(EXTRA_LOT_NAME, lotName);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot_pager);



        String lotName = (String) getIntent().getSerializableExtra(EXTRA_LOT_NAME);

        mViewPager = findViewById(R.id.lot_view_pager);
        mLots = LotList.get(this).getLots();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Lot lot = mLots.get(position);
                return LotFragment.newInstance(lot.getName());
            }

            @Override
            public int getCount() {
                return mLots.size();
            }
        });

        for(int i = 0; i < mLots.size(); ++i)
        {
            if(mLots.get(i).getName().equals(lotName))
            {
                mViewPager.setCurrentItem(i);

                break;
            }
        }
    }
}
