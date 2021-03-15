package org.dazmaks.brainfuck;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Interpreter {

    public static String run(String code, String input, View view) {
        try {
            String ocode = optimize(code);

            Tape tape = new Tape();

            int inpcharnum = -1;
            StringBuilder out = new StringBuilder();
            for (int n = 0; n < ocode.length(); n++) {
                switch (ocode.charAt(n)) {
                    case '>':
                        tape.forward();
                        break;
                    case '<':
                        tape.reverse();
                        break;
                    case '+':
                        tape.inc();
                        break;
                    case '-':
                        tape.dec();
                        break;
                    case ',':
                        inpcharnum++;
                        tape.set(input.charAt(inpcharnum));
                        break;
                    case '.':
                        out.append(tape.get());
                        break;
                    case '[':
                        if (tape.get() == 0) {
                            int i = 1;
                            while (i > 0) {
                                ++n;
                                char c = ocode.charAt(n);
                                if (c == '[')
                                    i++;
                                else if (c == ']')
                                    i--;
                            }
                        }
                        break;
                    case ']':
                        if (tape.get() != 0) {
                            int i = 1;
                            while (i > 0) {
                                --n;
                                char c = ocode.charAt(n);
                                if (c == '[')
                                    i--;
                                else if (c == ']')
                                    i++;
                            }
                        }
                        break;
                }
            }
            return out.toString();
        } catch (Exception e) {
            Snackbar.make(view, e.toString(), Snackbar.LENGTH_LONG)
                    .show();
            return "Error";
        }
    }

    private static String optimize(String code) {
        StringBuilder ocode = new StringBuilder();
        for (int i = 0; i < code.length(); i++)
            switch (code.charAt(i)) {
                case '>':
                case '<':
                case ',':
                case '.':
                case '+':
                case '-':
                case '[':
                case ']':
                    ocode.append(code.charAt(i));
                    break;
            }
        return ocode.toString();
    }
}
