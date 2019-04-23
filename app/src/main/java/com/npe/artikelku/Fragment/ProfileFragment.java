package com.npe.artikelku.Fragment;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.npe.artikelku.Activity.EditProfileActivity;
import com.npe.artikelku.Activity.EditRekeningActivity;
import com.npe.artikelku.Activity.GantiPasswordActivity;
import com.npe.artikelku.Activity.LoginActivity;
import com.npe.artikelku.R;
import com.npe.artikelku.viewmodel.UserViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        CardView editProfile = (CardView) v.findViewById(R.id.card_editProfile_profileFragment);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        CardView gantiProfile = (CardView) v.findViewById(R.id.card_gantiPassword_profileFragment);
        gantiProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GantiPasswordActivity.class);
                startActivity(intent);
            }
        });

        CardView editRekening = (CardView) v.findViewById(R.id.card_editRekening_proflieFragment);
        editRekening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditRekeningActivity.class);
                startActivity(intent);
            }
        });

        CardView logout = v.findViewById(R.id.card_editProfile_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logut();
            }
        });


        return v;
    }

    private void logut() {
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.deleteAll();

        //to login
        toLogin();
    }

    private void toLogin() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        getActivity().finish();
    }

}
