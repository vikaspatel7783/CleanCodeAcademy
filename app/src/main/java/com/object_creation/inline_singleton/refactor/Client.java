package com.object_creation.inline_singleton.refactor;

public class Client {

    public void printTheMessage(String message) {
        new ConsolePrinter().print(message);
    }

}
