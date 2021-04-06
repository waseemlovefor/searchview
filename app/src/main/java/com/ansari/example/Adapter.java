package com.ansari.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterView> implements Filterable{
    Context context;
    List<Model> modeller;
    List<Model> filteredModel;
    public Adapter(Context context, List<Model> models) {
        this.context = context;
        this.modeller = models;
        this.filteredModel = models;

    }
    @NonNull
    @Override
    public AdapterView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listrecyview,parent,false);
        return new AdapterView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterView holder, int position) {
        holder.textView.setText(filteredModel.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return filteredModel.size();
    }
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();
                if (searchString.isEmpty()) {

                    filteredModel = modeller;

                } else {

                    ArrayList<Model> tempFilteredList = new ArrayList<>();

                    for (Model model : modeller) {

                        // search for user name
                        if (model.getName().toLowerCase().contains(searchString)) {

                            tempFilteredList.add(model);
                        }
                    }
                    filteredModel = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredModel;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredModel = (ArrayList<Model>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class AdapterView extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public AdapterView(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
