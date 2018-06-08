package com.cleancodeacademy.domain.interactor;

import com.cleancodeacademy.domain.models.Author;

import java.util.ArrayList;
import java.util.List;

public class WelcomeInteractor implements IWelcomeInteractor {

    @Override
    public void getAuthors(GetAuthorsCallback authorsCallback) {

        // fetch data from network

        List<Author> authors = new ArrayList<>();
        authors.add(new Author());
        authors.add(new Author());
        authors.add(new Author());

        authorsCallback.onResponse(authors);
    }
}
