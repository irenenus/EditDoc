package com.example.irenenus.editdoc;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DocActivity extends AppCompatActivity {

    public static final int EDIT_TITLE = 0;
    public static final int EDIT_DOC = 1;
    //modelo
    private String title = "Lorem Ipsum", doc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sagittis, odio eget bibendum faucibus, orci elit aliquam risus, et iaculis risus tortor hendrerit mauris. Fusce luctus justo a iaculis sollicitudin. Sed tempus turpis et arcu lobortis, nec aliquam mauris ultrices. Aliquam nec fermentum nulla. Duis placerat imperdiet dui, vel congue lectus fermentum a. Ut non metus tincidunt, semper nulla sed, ornare sapien. Integer auctor ex turpis, ac malesuada sem aliquam bibendum. Suspendisse potenti. Donec dignissim hendrerit blandit. Cras nec auctor mi, a tristique nunc. Integer sed suscipit augue, vitae pharetra augue. Suspendisse potenti. Phasellus dolor metus, euismod et augue id, pulvinar consectetur ligula. Duis a condimentum sem, sed porttitor sem. Nullam vehicula ipsum nunc, sed egestas odio iaculis tincidunt.";

    // referencias a objetos de la pantalla
    private TextView title_view, doc_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        //obtenemos referencias a los objetos de la pantalla 1 vez
        title_view = findViewById(R.id.title_view);
        doc_view = findViewById(R.id.doc_view);

        // mostramos el modelo

        title_view.setText(title);
        doc_view.setText(doc);
    }

    public void editTitle(View view) {
        // 1) Llamamos a la otra actividad pasando un texto para editar
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("text", title);
        startActivityForResult(intent, EDIT_TITLE);//CTRL+ALT+C per canviar de 0 a una variable
    }

    public void editDoc(View view) {
        // 1) Llamamos a la otra actividad pasando un texto para editar
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("text", doc);
        startActivityForResult(intent, EDIT_DOC);//CTRL+ALT+C per canviar de 0 a una variable
    }

    AlertDialog.Builder builder = new AlertDialog.Builder(this);

    builder.setMessage()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case EDIT_TITLE:
                if (resultCode == RESULT_OK){
                    title = data.getStringExtra("text");
                    //refrescamos la pantalla
                    title_view.setText(title);
                }
                break;

            case EDIT_DOC:
                if (resultCode == RESULT_OK){
                    doc = data.getStringExtra("text");
                    //refrescamos la pantalla
                    doc_view.setText(doc);
                }
                break;
            default:
                 super.onActivityResult(requestCode, resultCode, data);
        }

    }


}

// onBackButtonPressed per quan tiris cap enrere et pregunti si vols guardar canvis