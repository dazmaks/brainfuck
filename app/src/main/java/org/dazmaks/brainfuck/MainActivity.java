package org.dazmaks.brainfuck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void runClick(View view) {
        TextView txtOut = findViewById(R.id.output);
        EditText edtOut = findViewById(R.id.codeedit);
        txtOut.setText(edtOut.getText().toString());
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
    public void nextInf4Click(View view) {
        setContentView(R.layout.infolayout3);
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