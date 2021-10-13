package com.rk.social.study.network.ecommerceapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rk.social.study.network.ecommerceapp.Adapter;
import com.rk.social.study.network.ecommerceapp.Model;
import com.rk.social.study.network.ecommerceapp.R;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    SliderLayout sliderLayout;
    private RecyclerView productRecyclerview;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        sliderLayout = root.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        productRecyclerview = root.findViewById(R.id.productRecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        productRecyclerview.setLayoutManager(layoutManager);

        setSliderViews();

        List<Model> modelList = new ArrayList<>();
        modelList.add(new Model(R.drawable.marron_top,"Marron Top","Rs. 555"));
        modelList.add(new Model(R.drawable.oppo,"Oppo","Rs. 22000"));
        modelList.add(new Model(R.drawable.iphone_11_pro,"iPhone","Rs. 117999"));
        modelList.add(new Model(R.drawable.oneplus,"OnePlus Mobile","Rs. 45999"));
        modelList.add(new Model(R.drawable.coffee,"Gold Coffee","Rs. 457"));
        modelList.add(new Model(R.drawable.sunrise_coffee,"Sunrise Instant Coffee","Rs. 259"));
        modelList.add(new Model(R.drawable.kinley_water,"Kinley","Rs. 38"));
        modelList.add(new Model(R.drawable.cococola,"Coco Cola","Rs. 76"));
        modelList.add(new Model(R.drawable.jeans,"Jeans","Rs. 699"));
        modelList.add(new Model(R.drawable.tshirt,"T-Shirt","Rs. 459"));


        Adapter adapter = new Adapter(modelList);
        productRecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return root;
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(getActivity());

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.girl_shopping);
                    sliderView.setDescription("Buy dresses");
//                    sliderView.setImageUrl("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.iphone);
                    sliderView.setDescription("Buy Iphone");
//                    sliderView.setImageUrl("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.arrival_banner);
                    sliderView.setDescription("New Arrival");
//                    sliderView.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.discount_banner);
                    sliderView.setDescription("Big Discount");
//                    sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
//            sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getActivity(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}