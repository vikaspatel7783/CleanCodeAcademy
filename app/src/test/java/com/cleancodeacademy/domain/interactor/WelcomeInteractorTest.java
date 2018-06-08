package com.cleancodeacademy.domain.interactor;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(JUnit4.class)
public class WelcomeInteractorTest {

    @Mock
    WelcomeInteractor welcomeInteractor;

    @Test
    public void testWelcomeInteractorRuns() {

        MockitoAnnotations.initMocks(this);
    }
}
