package com.cleancodeacademy.mobile.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cleancodeacademy.mobile.R;
import com.cleancodeacademy.mobile.ui.presenter.IMainActivityPresenter;
import com.cleancodeacademy.mobile.ui.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivityPresenter.ViewModel {

    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityPresenter = new MainActivityPresenter(this);

        ((Button) findViewById(R.id.btnGetAuthors)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityPresenter.onGetAuthorsButtonClick();
            }
        });
    }

    @Override
    public void showSuccessMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailureMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
