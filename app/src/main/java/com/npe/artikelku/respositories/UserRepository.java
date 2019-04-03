package com.npe.artikelku.respositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.npe.artikelku.model.user.UserDao;
import com.npe.artikelku.model.user.UserDatabase;
import com.npe.artikelku.model.user.UserModel;

public class UserRepository {
    private UserDao userDao;
    private LiveData<UserModel> userData;

    public UserRepository(Application application){
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        userDao = userDatabase.userDao();
        if(userDao.getAllUser() != null){
            userData = userDao.getAllUser();
        }
    }

    public LiveData<UserModel> getAllUser(){
        return userData;
    }

    public void insert(UserModel userModel){
        new InsertUserAsyncTask(userDao).execute(userModel);
    }

    private static class InsertUserAsyncTask extends AsyncTask<UserModel, Void, Void>{
        private UserDao userDao;

        public InsertUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            userDao.insert(userModels[0]);
            return null;
        }
    }

    public void update(UserModel userModel){
        new UpdateUserAsyncTask(userDao).execute(userModel);
    }

    private static class UpdateUserAsyncTask extends AsyncTask<UserModel, Void, Void>{
        private UserDao userDao;

        public UpdateUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            userDao.update(userModels[0]);
            return null;
        }
    }

    public void delete(UserModel userModel){
        new DeleteUserAsyncTask(userDao).execute(userModel);
    }

    private static class DeleteUserAsyncTask extends AsyncTask<UserModel, Void, Void>{
        private UserDao userDao;

        public DeleteUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {
            userDao.delete(userModels[0]);
            return null;
        }
    }

    public void deleteAll(){
        new InsertUserAsyncTask(userDao).execute();
    }

    private static class DeleteAllUserAsyncTask extends AsyncTask<Void, Void, Void>{
        private UserDao userDao;

        public DeleteAllUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDao.deleteAllUser();
            return null;
        }
    }

}
