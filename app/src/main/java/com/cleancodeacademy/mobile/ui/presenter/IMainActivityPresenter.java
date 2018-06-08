package com.cleancodeacademy.mobile.ui.presenter;

public interface IMainActivityPresenter {

    interface ViewModel {

        void showSuccessMessage(String message);

        void showFailureMessage(String message);
    }

    interface ViewCallback {

        void onGetAuthorsButtonClick();
    }

}
