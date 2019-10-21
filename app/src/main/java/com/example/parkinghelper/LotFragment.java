package com.example.parkinghelper;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.Switch;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.parkinghelper.models.Lot;
import com.example.parkinghelper.models.LotList;
import com.example.parkinghelper.utils.ImageUtils;
import java.io.File;


public class LotFragment extends Fragment {

    private static final String ARG_LOT_NAME = "lot_name";

    private Lot mLot;

    private TextView mCapacityTextView;
    private TextView mLotNameTextView;
    private Switch mSwitch;
    private ImageView mImageView;
    private File mImageFile;


    public static LotFragment newInstance(String lotName) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_LOT_NAME, lotName);

        LotFragment fragment = new LotFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String lotName = (String) getArguments().getSerializable(ARG_LOT_NAME);
        mLot = LotList.get(getActivity()).getLot(lotName);
        mImageFile = LotList.get(getActivity()).getImageFile(mLot);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lot, container, false);

        mCapacityTextView = v.findViewById(R.id.lot_capacity_fragment);
        mLotNameTextView = v.findViewById(R.id.lot_name_fragment);

        mCapacityTextView.setText("Lot Capacity " + mLot.getCurrentCapacity() + "/" + mLot.getMaxCapacity());
        mLotNameTextView.setText("Lot " + mLot.getName());

        mSwitch = v.findViewById(R.id.lot_favorite);
        mSwitch.setChecked(mLot.isFavorite());
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mLot.setFavorite(mSwitch.isChecked());
            }
        });

        mImageView = v.findViewById(R.id.lot_imageView);
        ViewTreeObserver observer = mImageView.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                updatePhotoView();
            }
        });
        return v;
    }



    @Override
    public void onPause() {
        super.onPause();

        LotList.get(getActivity()).updateLot(mLot);
    }


    public void updatePhotoView(){
        if(mImageView != null && mImageFile.exists()){
            Bitmap bitmap = ImageUtils.getScaledBitmap(mImageFile.getPath(), mImageView.getMeasuredWidth(), mImageView.getMeasuredHeight());
            mImageView.setImageBitmap(bitmap);
        }
    }

}