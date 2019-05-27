package br.edu.ifc.videira.crud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditPersonActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextCpf;
    private Button btnAtualizar;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);

        editTextNome = findViewById(R.id.editTextName);
        editTextCpf = findViewById(R.id.editTextCpf);
        btnAtualizar = findViewById(R.id.btnSave);
        btnDelete = findViewById(R.id.btnDelete);



    }
}
