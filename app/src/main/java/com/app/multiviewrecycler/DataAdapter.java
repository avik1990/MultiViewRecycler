package com.app.multiviewrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyHolder> implements SectionIndexer {
    List<Data> dataList;
    private List<Integer> mSectionPositions;
    Context context;

    public DataAdapter(Context context, List<Data> dataList) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Data data = dataList.get(position);
        holder.title.setText(data.getTitle());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public Object[] getSections() {
        List<String> sections = new ArrayList<>();
        mSectionPositions = new ArrayList<>();
        for (int i = 0, size = dataList.size(); i < size; i++) {
            String section = String.valueOf(dataList.get(i).getTitle().charAt(0)).toUpperCase();
            if (!sections.contains(section)) {
                sections.add(section);
                mSectionPositions.add(i);
            }
        }
        return sections.toArray(new String[0]);
    }

    @Override
    public int getPositionForSection(int i) {
        return mSectionPositions.get(i);
    }

    @Override
    public int getSectionForPosition(int i) {
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
        }
    }
}