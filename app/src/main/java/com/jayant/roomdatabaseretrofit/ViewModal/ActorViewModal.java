package com.jayant.roomdatabaseretrofit.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jayant.roomdatabaseretrofit.Modal.Actor;
import com.jayant.roomdatabaseretrofit.Repository.ActorRepository;

import java.util.List;

public class ActorViewModal extends AndroidViewModel {

    private final ActorRepository actorRepository;
    private final LiveData<List<Actor>> getAllActors;

    public ActorViewModal(@NonNull Application application) {
        super(application);
        actorRepository = new ActorRepository(application);
        getAllActors = actorRepository.getAllActors();
    }

    public void insert(List<Actor> list) {
        actorRepository.insert(list);
    }

    public LiveData<List<Actor>> getAllActor()
    {
        return getAllActors;
    }

}
