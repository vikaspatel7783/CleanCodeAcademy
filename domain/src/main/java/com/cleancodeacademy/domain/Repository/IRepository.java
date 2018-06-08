package com.cleancodeacademy.domain.Repository;

import com.cleancodeacademy.domain.models.Author;

import java.util.List;

public interface IRepository {

    public void storeAuthors(List<Author> authors);
}
