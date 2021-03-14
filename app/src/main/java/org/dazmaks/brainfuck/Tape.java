package org.dazmaks.brainfuck;

public class Tape {
    private char[] tape;
    private int position;

    private final int usize;

    public Tape() {
        usize = 0x10000;
        initTape();
    }

    private void initTape() {
        tape = new char[usize];
        position = 0;
    }

    public char get() {
        return tape[position];
    }

    public void set(char value) {
        tape[position] = value;
    }

    public void inc() {
        if (tape[position] >= 255) {
            tape[position] = 0;
        } else {
            tape[position]++;
        }
    }

    public void dec() {
        if (tape[position] <= 0) {
            tape[position] = 255;
        } else {
            tape[position]--;
        }
    }

    public void forward() {
        if (position >= (usize - 1)) {
            position = 0;
        } else {
            position++;
        }
    }

    public void reverse() {
        if (position <= 0) {
            position = (usize - 1);
        } else {
            position--;
        }
    }
}