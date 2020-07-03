package com.example.mvc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.MyviewHolder> {

    private Context context;
    private List<Testmodel> testmodels;

    public Recyclerviewadapter(Context context, List<Testmodel> testmodels){
        this.context = context;
        this.testmodels = testmodels;
    }


    @NonNull
    @Override
    public Recyclerviewadapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_row,parent, false);

        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerviewadapter.MyviewHolder holder, int position) {


        Testmodel testmodel = testmodels.get(position);

        holder.testName.setText(testmodel.getTestName());
        holder.testPrice.setText(testmodel.getTestPrice());
        holder.testType.setText(testmodel.getType());
        holder.testUID.setText(testmodel.getTestuid());

    }

    @Override
    public int getItemCount() {
        return testmodels.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        private TextView testName;
        private TextView testPrice;
        private TextView testType;
        private TextView testUID;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            testName = itemView.findViewById(R.id.testName);
            testPrice = itemView.findViewById(R.id.testPrice);
            testType = itemView.findViewById(R.id.testType);
            testUID = itemView.findViewById(R.id.testUID);
        }
    }

    public void setData(List<Testmodel> testmodelList){
        this.testmodels.addAll(testmodelList);
        notifyDataSetChanged();
    }
}
