package com.npe.artikelku.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.npe.artikelku.R;
import com.npe.artikelku.adapter.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DompetFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public DompetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dompet, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.vp_viewPager_dompet);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        return view;
    }
    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new DompetRiwayatFragment(),"riwayat");
        adapter.addFragment(new DompetStatusFragment(),"status");
        adapter.addFragment(new DompetCairkanFragment(),"cairkan");

        viewPager.setAdapter(adapter);
    }
}
