package com.rk.social.study.network.ecommerceapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {


    private List<Model> modelList;
    ArrayList<String> getRecentItemList = new ArrayList<>();


    public Adapter(List<Model> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        int itemImage = modelList.get(position).getItemImage();
        String itemPrice = modelList.get(position).getItemPrice();
        String itemProduct = modelList.get(position).getItemProduct();
        holder.setData(itemImage,itemProduct,itemPrice);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        private ImageView itemImage;
        private TextView itemProduct;
        private TextView itemPrice;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.itemImage);
            itemProduct = itemView.findViewById(R.id.itemProduct);
            itemPrice = itemView.findViewById(R.id.itemPrice);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getRecentItemList.add(String.valueOf(modelList.get(getAdapterPosition()).getItemImage()));
                    Log.d("listSize", String.valueOf(getRecentItemList.size()));
                    Log.d("listSize","getDataItem");
                }
            });


        }

        private void setData(int img, String product, String price){
            itemImage.setImageResource(img);
            itemPrice.setText(price);
            itemProduct.setText(product);
        }
    }
}
