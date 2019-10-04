package com.example.parkinghelper.models;


public class Lot {


    private boolean mFavorite;
    private int mMaxCapacity;
    private int mCurrentCapacity;
    private String mLotName;


    public Lot()
    {
    }

    public Lot(String name)
    {
        mLotName = name;
    }

    public Lot(String name, int maxCap)
    {
        mLotName = name;
        mMaxCapacity = maxCap;
    }

    public Lot(String name, int maxCap, int currentCap)
    {
        mLotName = name;
        mMaxCapacity = maxCap;
        mCurrentCapacity = currentCap;
    }

    public boolean isFavorite() {
        return mFavorite;
    }

    public void setFavorite(boolean favorite) {
        mFavorite = favorite;
    }

    public String getImageFilename() {
        return "Lot " + getName() + ".jpg";
    }

    public int getMaxCapacity() {
        return mMaxCapacity;
    }

    public void setMaxCapacity(int mMaxCapacity) {
        this.mMaxCapacity = mMaxCapacity;
    }

    public int getCurrentCapacity() {
        return mCurrentCapacity;
    }

    public void setCurrentCapacity(int mCurrentCapacity) {
        this.mCurrentCapacity = mCurrentCapacity;
    }

    public String getName() {
        return this.mLotName;
    }

    public void setName(String mLotName) {
        this.mLotName = mLotName;
    }

}
