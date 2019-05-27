package br.edu.ifc.videira.crud;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPersonActivity extends AppCompatActivity {
    private Button btnSalvar;
    private EditText eTxtNome;
    private EditText eTxtCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);


        btnSalvar = (Button) findViewById(R.id.btnSave);
        eTxtNome = (EditText) findViewById(R.id.editTextName);
        eTxtCpf = (EditText) findViewById(R.id.editTextCpf);

    }
}
