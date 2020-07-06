package com.android.taqani.ui.liked;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.taqani.R;
import com.android.taqani.fani.faniDetails;
import com.android.taqani.model.RepairmanModel;
import com.android.taqani.ui.notifications.NotificationsViewModel;



public class liked extends Fragment {

    GridView gridview ;


    //profile images test :
    int[] profileImage = {
            R.drawable.man0,R.drawable.man1,R.drawable.ma2 ,
            R.drawable.ma3,R.drawable.man4,R.drawable.man5,
            R.drawable.man0,R.drawable.man1,R.drawable.ma2,
            R.drawable.ma3,R.drawable.man4,R.drawable.man5

    };

    //repairman names test :
    String[] namesList = {
            "عبد العزيز", "عبد الله مبارك", "محمد أحمد",
            "أكرم مهند", "فهد عبد الله", "مسعود ساعدي",
            "عبد العزيز", "عبد الله مبارك", "محمد أحمد",
            "أكرم مهند", "فهد عبد الله", "مسعود ساعدي"



    };

    //repairman jobtitleTest test :
    String[] joblist = {
            "فني موبايل", "فني موبايل", "فني موبايل",
            "فني موبايل", "فني موبايل", "فني موبايل",
            "فني موبايل", "فني موبايل", "فني موبايل",
            "فني موبايل", "فني موبايل", "فني موبايل"



    };

    //evaluation  test :
    int[] evaluation = {
            5,3,5,
            2,4,5,
            5,3,5,
            2,4,5,
    };

    //repairman Distance test :
    String[] distances = {
            "2", "45", "120",
            "90", "55", "4.5",
            "2", "45", "120",
            "90", "55", "4.5",
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_liked, container, false);

//Initialisation :

        gridview = root.findViewById(R.id.gridview);

        //Loading Images :
        CustomAdapter customAdapter = new CustomAdapter();
        gridview.setAdapter(customAdapter);
        //When Click On Image :
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                RepairmanModel repairmanModel = new RepairmanModel(profileImage[i],namesList[i],joblist[i],evaluation[i],distances[i]);
                //SecondActivity(repairmanModel);
                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, new faniDetails()).commit();


            }
        });

        return root;
    }



    //gridView Adapter :
    //Class Of Custom Adapter :
    private class CustomAdapter  extends BaseAdapter {


        @Override
        public int getCount() {
            return namesList.length ;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            @SuppressLint({"InflateParams", "ViewHolder"}) View view1 = getLayoutInflater().inflate(R.layout.row_repairman_cardview,null);

            ImageView image = view1.findViewById(R.id.images);
            image.setImageResource(profileImage[i]);

            TextView name = view1.findViewById(R.id.remarman_nameTv);
            name.setText(namesList[i]);

            TextView joblists = view1.findViewById(R.id.remarman_jobTv);
            joblists.setText(joblist[i]);

            TextView distance = view1.findViewById(R.id.remarman_locationTv);
            distance.setText(distances[i]+" كم");

            //rating
            ImageView ratings = view1.findViewById(R.id.ratingImage);
            switch (evaluation[i]){
                case 1 :
                    ratings.setImageResource(R.drawable.rating1);
                    break;
                case 2 :
                    ratings.setImageResource(R.drawable.rating2);
                    break;
                case 3 :
                    ratings.setImageResource(R.drawable.rating3);
                    break;
                case 4 :
                    ratings.setImageResource(R.drawable.rating4);
                    break;
                case 5 :
                    ratings.setImageResource(R.drawable.rating5);
                    break;


            }


            return view1;
        }


    }
}