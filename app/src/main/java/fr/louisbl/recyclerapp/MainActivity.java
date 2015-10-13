package fr.louisbl.recyclerapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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

    private void onAddButtonClick() {
        mDatas.add("Text " + mDatas.size());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAddButton = (FloatingActionButton) findViewById(R.id.addButton);
        mAddButton.setOnClickListener(addListener);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        for (int i = 0; i < 10; i++) {
            mDatas.add("Text " + i);
        }

        mAdapter = new CustomAdapter(mDatas);
        mRecyclerView.setAdapter(mAdapter);
    }
}
