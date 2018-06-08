package com.cleancodeacademy.domain.interactor;

import com.cleancodeacademy.domain.models.Author;

import java.util.List;

public interface IWelcomeInteractor {

    interface GetAuthorsCallback {

        void onResponse(List<Author> authors);

        void onFail(Throwable t);
    }

    void getAuthors(GetAuthorsCallback authorsCallback);

}
