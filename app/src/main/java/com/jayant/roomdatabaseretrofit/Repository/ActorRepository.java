package com.jayant.roomdatabaseretrofit.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.jayant.roomdatabaseretrofit.Dao.ActorDao;
import com.jayant.roomdatabaseretrofit.Database.ActorDatabase;
import com.jayant.roomdatabaseretrofit.Modal.Actor;

import java.util.List;

public class ActorRepository {

    private final ActorDatabase database;
    private final LiveData<List<Actor>> getAllActors;

    public ActorRepository(Application application)
    {
        database=ActorDatabase.getInstance(application);
        getAllActors = database.actorDao().getAllActors();
    }

    public void insert(List<Actor> actorList){
     new InsertAsyncTask(database).execute(actorList);
    }

    public LiveData<List<Actor>> getAllActors() {
        return getAllActors;
    }

   static class InsertAsyncTask extends AsyncTask<List<Actor>,Void,Void>{

        private final ActorDao actorDao;
         InsertAsyncTask(ActorDatabase actorDatabase) {
             actorDao=actorDatabase.actorDao();
         }

        @Override
        protected Void doInBackground(List<Actor>... lists) {
             actorDao.insert(lists[0]);
            return null;
        }
    }
}
