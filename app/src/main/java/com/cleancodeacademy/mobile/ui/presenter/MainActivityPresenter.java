package com.cleancodeacademy.mobile.ui.presenter;

import com.cleancodeacademy.mobile.network.ServiceApi;
import com.cleancodeacademy.mobile.network.impl.RetrofitFactory;
import com.cleancodeacademy.mobile.network.model.Note;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityPresenter implements IMainActivityPresenter.ViewCallback, Callback<Note> {


    private final IMainActivityPresenter.ViewModel viewModel;

    public MainActivityPresenter(IMainActivityPresenter.ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void onGetAuthorsButtonClick() {

        //WelcomeInteractor welcomeInteractor = new WelcomeInteractor();
        //welcomeInteractor.getAuthors(new AuthorsCallback());

        ServiceApi serviceApi = RetrofitFactory.getServiceApi();

        Call<Note> saveNoteCall = serviceApi.saveNote(getNote());

        saveNoteCall.enqueue(this);
    }

    private Note getNote() {
        Note note = new Note();

        note.setTitle("Title-Vikas");
        note.setBody("Body1");
        note.setUserId(1);

        return note;
    }


    @Override
    public void onResponse(Call<Note> call, Response<Note> response) {
        if (response.isSuccessful()) {
            viewModel.showSuccessMessage("Success: "+response.body().getTitle());
        }
    }

    @Override
    public void onFailure(Call<Note> call, Throwable t) {
        t.printStackTrace();
        viewModel.showFailureMessage("Failed");
    }
}
