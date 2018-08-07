package ru;

public class StubInput implements Input {
    private String[] answ;
    int position = 0;

    StubInput(String[] answers) {
        this.answ = answers;
    }

    public String ask(String quest) {
       return   answ[position++];
    }
}
