package com.npe.artikelku.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.npe.artikelku.model.user.UserModel;
import com.npe.artikelku.respositories.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<UserModel> users;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        if(userRepository.getAllUser() != null){
            users = userRepository.getAllUser();
        }
    }

    public void insert(UserModel userModel){
        userRepository.insert(userModel);
    }

    public void update(UserModel userModel){
        userRepository.update(userModel);
    }

    public void delete(UserModel userModel){
        userRepository.delete(userModel);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

    public LiveData<UserModel>getAllUser(){
        return users;
    }
}
