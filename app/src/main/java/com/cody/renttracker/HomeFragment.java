package com.cody.renttracker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CodyF on 1/22/2017.
 */

public class HomeFragment extends Fragment {

    private RecyclerView mMonthRecyclerView;
    private List<Tenant> mTenants;
    private HomeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_month, container, false);
        mMonthRecyclerView = (RecyclerView) v.findViewById(R.id.month_recycler_view);
        mMonthRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //TODO Reterieve List of Tenants

        mAdapter = new HomeAdapter(mTenants);
        mMonthRecyclerView.setAdapter(mAdapter);
        return v;

    }// end onCreateView

    /*
    Home Holder class, class represents 1 view of the home recycler View
     */
    private class HomeHolder extends RecyclerView.ViewHolder{
        public TextView mMonthName;
        public HomeHolder(View v){
            super(v);
            mMonthName = (TextView) v.findViewById(R.id.month_name_text_view);

        }
    }
    /*
    HomeAdapter Class, adapter for home fragment recycler View
     */
    private class HomeAdapter extends RecyclerView.Adapter<HomeHolder>{
        // Set member attributes
        private List<Tenant> mTenants;

        // Constructor takes in the list of tenants
        public HomeAdapter(List<Tenant> aTenants){
            mTenants = aTenants;
        }
        @Override
        public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.month_container,parent,false);
            return new HomeHolder(v);
        }

        @Override
        public void onBindViewHolder(HomeHolder holdView, int position){

        }

        @Override
        public int getItemCount(){
            return mTenants.size();
        }

    } // end HomeAdapter Class
}// end HomeFragment