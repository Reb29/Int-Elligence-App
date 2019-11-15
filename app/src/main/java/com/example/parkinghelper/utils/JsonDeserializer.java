package com.example.parkinghelper.utils;

import com.example.parkinghelper.models.Lot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class JsonDeserializer {

    public List<Lot> deserialize(String jsonString){
        List<Lot> lots = new ArrayList<>();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        lots = gson.fromJson(jsonString, new TypeToken<List<Lot>>(){}.getType());

        return lots;
    }




}
