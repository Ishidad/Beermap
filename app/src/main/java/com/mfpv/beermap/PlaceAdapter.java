package com.mfpv.beermap;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.mfpv.beermap.managers.GsonRequest;
import com.mfpv.beermap.managers.VolleySingleton;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends ArrayAdapter{

    List<Place> list = new ArrayList<>();
    private static final String URL_BASE = "https://raw.githubusercontent.com/Ishidad/Beermap/master/placesId.json";
    private static final String TAG = "PlaceAdapter";
    PlaceList items;

    public PlaceAdapter(Context context, int resource) {

        super(context, resource);

        VolleySingleton.getInstance(getContext()).addToRequestQueue(
                new GsonRequest<PlaceList>(
                        URL_BASE,
                        PlaceList.class,
                        null,
                        new Response.Listener<PlaceList>() {
                            @Override
                            public void onResponse(PlaceList response) {
                                items = response;
                                notifyDataSetChanged();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d(TAG, "Error Volley: " + error.getMessage());
                            }
                        }
                )

        );
    }

    public void add(Place object){
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Place getItem(int position){
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        PlaceHolder placeHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //CELDA o Elemento de la lista
            row = layoutInflater.inflate(R.layout.display_place_row, parent, false);
            placeHolder = new PlaceHolder();
            row.setTag(placeHolder);
        }
        else{
            placeHolder = (PlaceHolder)row.getTag();
        }

        Place place = getItem(position);
        placeHolder.tx_name.setText(place.getName());

        return super.getView(position, convertView, parent);
    }

    static class PlaceHolder {
        public TextView tx_name;
    }

}
