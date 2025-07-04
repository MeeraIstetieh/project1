package org.example.CliApp;
public class Option extends Titleable {
    private final Runnable runnable;

    public Option(String title, Runnable runnable) {
        super(title);
        this.runnable = runnable;
    }

    void run() {
        runnable.run();
    }

}
