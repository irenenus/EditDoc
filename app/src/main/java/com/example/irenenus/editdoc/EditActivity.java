package com.example.irenenus.editdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    // referencias a objetos de la pantalla

    private EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // 2) obtenemos los datos de la llamada:
        // inicializamos la caja de texto con el texto a editar

       Intent intent = getIntent();
       String texto_a_editar = intent.getStringExtra("text"); // etiqeta de texto a editar
        edit_text = findViewById(R.id.edit_text);
        edit_text.setText(texto_a_editar);
    }

    public void onSave(View view) {
        // 3) devolvemos como resultado el texto editado
        String texto_editado = edit_text.getText().toString();
        Intent data = new Intent();
        data.putExtra("text", texto_editado);
        setResult(RESULT_OK, data); // si poses cancel en comptes de ok seria com donar-li al botó d'enrere
        finish();

    }
}
