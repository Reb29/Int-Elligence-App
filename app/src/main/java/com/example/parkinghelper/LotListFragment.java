package com.example.parkinghelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;

import com.example.parkinghelper.models.Lot;
import com.example.parkinghelper.models.LotList;
import com.example.parkinghelper.utils.AsyncResponse;
import com.example.parkinghelper.utils.DatabaseDownloader;
import com.example.parkinghelper.utils.JsonDeserializer;

import java.util.List;

public class LotListFragment extends Fragment implements AsyncResponse {

    private boolean favoriteSelected = false;

    private class LotHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Lot mLot;
        private TextView mLotNameTextView;
        private TextView mCapacityTextView;
        private ImageView mLotFavorite;
        private ConstraintLayout mLayout;

        int alternator = 1;

        public LotHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_lot, parent, false));

            itemView.setOnClickListener(this);

            mLayout = itemView.findViewById(R.id.linearLayout);
            mLotNameTextView = itemView.findViewById(R.id.lot_name);
            mCapacityTextView = itemView.findViewById(R.id.lot_capacity);
            mLotFavorite = itemView.findViewById(R.id.lot_favorite);

        }

        public void bind(Lot lot) {
            mLot = lot;


            mCapacityTextView.setText("Lot Capacity " + mLot.getCurrentCapacity() + "/" + mLot.getMaxCapacity());
            mLotNameTextView.setText("Lot " + mLot.getName());
            mLotFavorite.setVisibility(lot.isFavorite() ? View.VISIBLE : View.INVISIBLE);
        }

        @Override
        public void onClick(View view) {
            Intent intent = LotPagerActivity.newIntent(getActivity(), mLot.getName());
            startActivity(intent);
        }
    }

    private class LotAdapter extends RecyclerView.Adapter<LotHolder> {
        private List<Lot> mLots;

        public LotAdapter(List<Lot> lots) {
            mLots = lots;
        }

        @NonNull
        @Override
        public LotHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new LotHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull LotHolder lotHolder, int i) {
            Lot lot = mLots.get(i);
            lotHolder.bind(lot);
        }

        public void setLots(List<Lot> lots) {
            mLots = lots;
        }

        @Override
        public int getItemCount() {
            return mLots.size();
        }


    }

    private RecyclerView mLotRecyclerView;
    private LotAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lot_list, container, false);
        mLotRecyclerView = v.findViewById(R.id.lot_recycler_view);
        mLotRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_lot_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_favorites:
                favoriteSelected = true;
                updateUI();
                return true;

            case R.id.show_all:
                favoriteSelected = false;
                updateUI();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onEnd(String output) {  //Probably a better way to do this but async is confusing.
        JsonDeserializer jD = new JsonDeserializer();
        List<Lot> lots = jD.deserialize(output);

        LotList lotList = LotList.get(getActivity());

        for (Lot lot : lots) {
            Log.d("FUCK", lot.getName() + " " + lot.getMaxCapacity() + " " + lot.getCurrentCapacity());
            lotList.addLot(lot);
        }
    }


    private void updateUI() {
        DatabaseDownloader dbD = new DatabaseDownloader();
        dbD.response = this;
        dbD.execute();

        LotList lotList = LotList.get(getActivity());
        List<Lot> lots;

        if (favoriteSelected)
            lots = lotList.getFavorites();
        else
            lots = lotList.getLots();


        if (mAdapter == null) {
            mAdapter = new LotAdapter(lots);
            mLotRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setLots(lots);
            mAdapter.notifyDataSetChanged();
        }
    }


}
