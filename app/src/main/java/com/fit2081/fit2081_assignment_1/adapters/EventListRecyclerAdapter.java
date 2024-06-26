package com.fit2081.fit2081_assignment_1.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit2081.fit2081_assignment_1.R;
import com.fit2081.fit2081_assignment_1.activities.EventGoogleResult;
import com.fit2081.fit2081_assignment_1.providers.Event;

import java.util.List;

public class EventListRecyclerAdapter extends RecyclerView.Adapter<EventListRecyclerAdapter.CustomViewHolder>{
    List<Event> data;
    public EventListRecyclerAdapter() {}

    @NonNull
    @Override
    public EventListRecyclerAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_card_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventListRecyclerAdapter.CustomViewHolder holder, int position) {
        // Update card view with data
        // get the object at the position
        Event event = this.data.get(position);

        // set the data to the view holder
        holder.rv_eventId.setText(String.valueOf(event.getEventId()));
        holder.rv_eventCategoryId.setText(String.valueOf(event.getCategoryId()));
        holder.rv_eventName.setText(event.getEventName());
        holder.rv_ticketsAvailable.setText(String.valueOf(event.getTicketsAvailable()));
        holder.rv_eventIsActive.setText(event.isEventActive() ? "Active" : "Inactive");

        // Listens to click on card views
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EventGoogleResult.class);
                intent.putExtra("eventName", event.getEventName());
                v.getContext().startActivity(intent);
//                Toast.makeText(v.getContext(), event.getEventName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setData(List<Event> data) {
        this.data = data;
    }

//    public void updateData(ArrayList<Event> newData) {
//        clearData();
//        this.data.addAll(newData);
//    }

//    public void clearData() {
//        this.data.clear();
//    }

    @Override
    public int getItemCount() {
        return this.data != null ? this.data.size() : 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public TextView rv_eventId;
        public TextView rv_eventCategoryId;
        public TextView rv_eventName;
        public TextView rv_ticketsAvailable;
        public TextView rv_eventIsActive;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_eventId = itemView.findViewById(R.id.rv_eventId);
            rv_eventCategoryId = itemView.findViewById(R.id.rv_eventCategoryId);
            rv_eventName = itemView.findViewById(R.id.rv_eventName);
            rv_ticketsAvailable = itemView.findViewById(R.id.rv_ticketsAvailable);
            rv_eventIsActive = itemView.findViewById(R.id.rv_eventIsActive);
        }
    }
}
