package com.android.taqani.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.taqani.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class makeOrderFragment extends Fragment implements OnMapReadyCallback {

    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private MapView mMapView;
    //To store user Input DAta
    public String phone, model, prolem, problemDiscription;
    EditText problemDescriptionInput;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.make_order_fragment, container, false);



        /* ----------------------- [Start of : components initialisation ] -----------------------*/

        //EditText ( Problem Description )
        problemDescriptionInput = root.findViewById(R.id.editText);
        //create a list of items for the spinner.
        final String[] items0, items1, items2;
        ArrayAdapter < String > adapter0, adapter1, adapter2;

        //Spinners
        //نوع الجوال
        Spinner dropdown0 = root.findViewById(R.id.spinner0);
        items0 = new String[] {
                "تحديد نوع الجوال",
                "ايفون ",
                "سامسونغ",
                "اخرى ... "
        };
        adapter0 = new ArrayAdapter< >(getActivity(), R.layout.spinner_item, items0);
        adapter0.setDropDownViewResource(R.layout.spinner_item_dropdown);
        dropdown0.setAdapter(adapter0);


        //نوع الموديل
        Spinner dropdown1 = root.findViewById(R.id.spinner1);
        items1 = new String[] {
                "تحديد الموديل",
                "ايفون اكس",
                "ايفون 8",
                "اخرى ... "
        };
        adapter1 = new ArrayAdapter < > (getActivity(), R.layout.spinner_item, items1);
        adapter1.setDropDownViewResource(R.layout.spinner_item_dropdown);
        dropdown1.setAdapter(adapter1);


        // نوع المشكلة
        Spinner dropdown2 = root.findViewById(R.id.spinner2);
        items2 = new String[] {
                "تحديد نوع المشكلة",
                "الشاشة لاتعمل",
                "الصوت",
                "اخرى ..."
        };
        adapter2 = new ArrayAdapter < > (getActivity(), R.layout.spinner_item, items2);
        adapter2.setDropDownViewResource(R.layout.spinner_item_dropdown);
        dropdown2.setAdapter(adapter2);


        // Map view
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView = root.findViewById(R.id.mapview);
        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);



        /* ------------------------ [End of : components initialisation ] ------------------------*/


        return root;
    }


    /* ----------------------- [Start of : Map Listener] -----------------------*/
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //marker to map :
        map.addMarker(new MarkerOptions().position(new LatLng(26.313590, 50.206000)).title("مثال عن مكان"));
        //move Camera to the zone :
        float zoomLevel = 15.0f; //This goes up to 21
        LatLng latLng = new LatLng(26.313590, 50.206000);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
    }

    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }



    /* ------------------------ [End of : Map Listener ] ------------------------*/



}