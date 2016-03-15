package com.mfpv.beermap;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaceList {

    @SerializedName("places")
    private List<Place> items;

    public PlaceList(List<Place> items){
        this.items = items;
    }

    public void setItems(List<Place> items){
        this.items = items;
    }

    public List<Place> getItems(){
        return items;
    }
}
