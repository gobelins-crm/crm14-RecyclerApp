package fr.louisbl.recyclerapp;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private FloatingActionButton mAddButton;
    private ArrayList<String> mDatas = new ArrayList<>();
    private FloatingActionButton.OnClickListener addListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onAddButtonClick();
        }
    };

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Initial data
        for (int i = 0; i < 10; i++) {
            mDatas.add("Text " + i);
        }


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAddButton = (FloatingActionButton) view.findViewById(R.id.addButton);
        mAddButton.setOnClickListener(addListener);

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SimpleTextAdapter(mDatas);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private void onAddButtonClick() {
        mDatas.add("Text " + mDatas.size());
        // re-render the list
        mAdapter.notifyDataSetChanged();
    }

}
