package com.mfpv.beermap;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.widget.ListView;

import com.mfpv.beermap.data.PlacesContract;
import com.mfpv.beermap.data.PlacesDBHelper;

import java.util.ArrayList;
import java.util.List;

public class BackgorudTask extends AsyncTask<String, Place, String> {
    Context context;
    PlaceAdapter placeAdapter;
    Activity activity;
    ListView listView;

    BackgorudTask(Context context){
        this.context = context;
        activity = (Activity)context;
    }

    @Override
    protected String doInBackground(String... params){

        String method = params[0];
        PlacesDBHelper bdOperations = new PlacesDBHelper(context);

        if(method.equals("get_info")){

            listView = (ListView)activity.findViewById(R.id.places_listview);

            SQLiteDatabase db = bdOperations.getReadableDatabase();
            Cursor cursor = bdOperations.getInformation(db);
            placeAdapter = new PlaceAdapter(context, R.layout.display_place_row);
            List<Place> placeList = new ArrayList<>();
            String id = "", name = "";
            while (cursor.moveToNext()){
                id = cursor.getString(cursor.getColumnIndex(PlacesContract.LocationEntry.COLUMN_PLACE_ID));
                name = cursor.getString(cursor.getColumnIndex(PlacesContract.LocationEntry.COLUMN_PLACE_NAME));
                Place place = new Place(id, name);
                placeList.add(place);
            }

            // TODO set the list to the placeAdapter

            return "get_info";
        }

        return null;
    }

    protected void onProgress(Place... values){
        placeAdapter.add(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("get_info")){
            listView.setAdapter(placeAdapter);
        }
    }
}
