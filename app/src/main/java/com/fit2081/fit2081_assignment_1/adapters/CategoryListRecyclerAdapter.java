package com.fit2081.fit2081_assignment_1.adapters;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit2081.fit2081_assignment_1.R;
import com.fit2081.fit2081_assignment_1.activities.DashboardActivity;
import com.fit2081.fit2081_assignment_1.activities.GoogleMapActivity;
import com.fit2081.fit2081_assignment_1.providers.EventCategory;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CategoryListRecyclerAdapter extends RecyclerView.Adapter<CategoryListRecyclerAdapter.CustomViewHolder>{
    List<EventCategory> data;

    public CategoryListRecyclerAdapter() {}

    @NonNull
    @Override
    public CategoryListRecyclerAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListRecyclerAdapter.CustomViewHolder holder, int position) {
        // Update card view with data
        // get the object at the position
        EventCategory eventCategory = data.get(position);

        // set the data to the view holder
        holder.rvCategoryId.setText(String.valueOf(eventCategory.getCategoryId()));
        holder.rvCategoryName.setText(eventCategory.getCategoryName());
        holder.rvEventCount.setText(String.valueOf(eventCategory.getEventCount()));
        holder.rvCategoryIsActive.setText(eventCategory.isCategoryActive() ? "Active" : "Inactive");
        holder.rvEventLocation.setText(eventCategory.getEventLocation());

        // Listener to navigate to google maps view on click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(v, "Clicked position: " + eventCategory.getCategoryId(), Snackbar.LENGTH_LONG).show();
                // TODO: Implement navigation to google maps view, by passing the location string as intent extra
                String location = eventCategory.getEventLocation();
                Intent intent = new Intent(v.getContext(), GoogleMapActivity.class);
                intent.putExtra("location", location);
                v.getContext().startActivity(intent);
            }
        });
    }

    public void setData(List<EventCategory> data) {
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return this.data != null ? this.data.size() : 0;
    }

    public void updateData(ArrayList<EventCategory> newData) {
        clearData();
        this.data.addAll(newData);
    }

    public void clearData() {
        this.data.clear();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View itemView;
        public TextView rvCategoryId;
        public TextView rvCategoryName;
        public TextView rvEventCount;
        public TextView rvCategoryIsActive;
        public TextView rvEventLocation;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            // Reference fields in the view holder layout (card_layout.xml)
            rvCategoryId = itemView.findViewById(R.id.rv_categoryId);
            rvCategoryName = itemView.findViewById(R.id.rv_categoryName);
            rvEventCount = itemView.findViewById(R.id.rv_eventCount);
            rvCategoryIsActive = itemView.findViewById(R.id.rv_categoryIsActive);
            rvEventLocation = itemView.findViewById(R.id.rv_eventLocation);
        }
    }
}
