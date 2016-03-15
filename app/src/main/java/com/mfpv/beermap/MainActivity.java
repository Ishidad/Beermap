package com.mfpv.beermap;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> placesAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            String[] data = {
                    "Antares",
                    "Barbaroja",
                    "Basquiat",
                    "Baum",
                    "Beatmemo",
                    "Cadencia",
                    "Collins",
                    "Daniel O.",
                    "Fenicia",
                    "Galgo",
                    "Mandino",
                    "O´Connell´s",
                    "Zodiako"

            };
            List<String> listPlaces = new ArrayList<String>(Arrays.asList(data));

            placesAdapter =
                    new ArrayAdapter<String>(
                            getActivity(),
                            R.layout.list_places,
                            R.id.list_places_textview,
                            listPlaces);

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.places_listview);
            listView.setAdapter(placesAdapter);

            return rootView;
        }
    }
}
