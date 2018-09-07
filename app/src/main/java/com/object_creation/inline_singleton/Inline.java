package com.object_creation.inline_singleton;

import com.object_creation.inline_singleton.refactor.ConsolePrinter;

public class Inline {

    static private ConsolePrinter consolePrinter = new ConsolePrinter();

    private Inline() {}

    public static void printToConsole(String message) {
        consolePrinter.print(message);
    }

}
