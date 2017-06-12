package com.cody.renttracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import android.util.Log;
/**
 * Created by CodyF on 1/22/2017.
 */

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    private RecyclerView mMonthRecyclerView;
    private HomeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_month, container, false);
        mMonthRecyclerView = (RecyclerView) v.findViewById(R.id.month_recycler_view);
        mMonthRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.i(TAG,"In HomeFrag onCreateView");
        updateMonthList();

        return v;

    }// end onCreateView

    private void updateMonthList(){
        MonthLab monthLab = MonthLab.get(getActivity());
        List<Month> months = monthLab.getMonths();
        Log.i(TAG,"Retreiving months. List size is " + months.size());
        if(mAdapter == null){
            mAdapter = new HomeAdapter(months);
            mMonthRecyclerView.setAdapter(mAdapter);
        }
        else{
            mAdapter.setMonths(months);
            mAdapter.notifyDataSetChanged();
        }
    }// end updateMonthList

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume(){
        super.onResume();
        updateMonthList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }
    /*
    Home Holder class, class represents 1 view of the home recycler View
     */
    private class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mMonthTextView;
        private Month mMonth;
        public HomeHolder(View v){
            super(v);
            mMonthTextView = (TextView) v.findViewById(R.id.month_name_text_view);
        }

        public void bindMonth(Month aMonth){
            mMonth = aMonth;
            mMonthTextView.setText(mMonth.getMonthName());
        }

        @Override
        public void onClick(View v){
            // add click functionality
        }
    }
    /*
    HomeAdapter Class, adapter for home fragment recycler View
     */
    private class HomeAdapter extends RecyclerView.Adapter<HomeHolder>{
        // Set member attributes
        private List<Month> mMonths;

        // Constructor takes in the list of tenants
        public HomeAdapter(List<Month> aMonths){
            mMonths = aMonths;
        }
        @Override
        public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.month_container,parent,false);
            Log.i(TAG,"Inflating the recycler viewer");
            return new HomeHolder(v);
        }

        @Override
        public void onBindViewHolder(HomeHolder holdView, int position){
            Month month = mMonths.get(position);
            holdView.bindMonth(month);
            Log.i(TAG,"Binding months");
        }

        @Override
        public int getItemCount(){
            return mMonths.size();
        }

        public void setMonths(List<Month> aMonths){mMonths = aMonths;}

    } // end HomeAdapter Class

}// end HomeFragment