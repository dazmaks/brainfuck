package org.dazmaks.brainfuck;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import static org.dazmaks.brainfuck.Interpreter.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton copyfab = findViewById(R.id.copyfab);
        copyfab.setOnClickListener(view -> {
            EditText edtCode = findViewById(R.id.codeedit);

            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Code:", edtCode.getText().toString());
            clipboard.setPrimaryClip(clip);

            Snackbar.make(view, "Code copied!", Snackbar.LENGTH_LONG)
                    .show();
        });
    }
    @SuppressLint("SetTextI18n")
    public void runClick(View view) {
        TextView txtOut = findViewById(R.id.output);
        EditText edtCode = findViewById(R.id.codeedit);
        EditText edtInp = findViewById(R.id.input);
        String runout = run(edtCode.getText().toString(), edtInp.getText().toString(), view);
        if(runout.equals("")){
            txtOut.setText("Program doesn't use output");
        }else{
            txtOut.setText(runout);
        }
    }

    public void infoClick(View view) {
        setContentView(R.layout.infolayout);
    }
    public void backClick(View view) {
        setContentView(R.layout.activity_main);
    }
    public void nextInfClick(View view) {
        setContentView(R.layout.infolayout2);
    }
    public void nextInf2Click(View view) {
        setContentView(R.layout.infolayout3);
    }
    public void nextInf3Click(View view) {
        setContentView(R.layout.infolayout4);
    }
    public void prevInf2Click(View view) {
        setContentView(R.layout.infolayout);
    }
    public void prevInf3Click(View view) {
        setContentView(R.layout.infolayout2);
    }
    public void prevInf4Click(View view) {
        setContentView(R.layout.infolayout3);
    }

}