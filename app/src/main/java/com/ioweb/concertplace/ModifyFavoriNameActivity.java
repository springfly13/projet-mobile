package com.ioweb.concertplace;

/**
 * Created by anupamchugh on 19/10/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyFavoriNameActivity extends Activity implements OnClickListener {

    private EditText titleText;
    private Button updateBtn, deleteBtn;
    private EditText descText;

    private long _id;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modifier le nom");

        setContentView(R.layout.activity_modify_record);

        dbManager = new DBManager(this);
        dbManager.open();

        titleText = (EditText) findViewById(R.id.subject_edittext);
        //descText = (EditText) findViewById(R.id.description_edittext);

        updateBtn = (Button) findViewById(R.id.btn_update);
        deleteBtn = (Button) findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("title");
        //String desc = intent.getStringExtra("desc");

        _id = Long.parseLong(id);

        titleText.setText(name);
       // descText.setText(desc);

        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                String title = titleText.getText().toString();
                //String desc = descText.getText().toString();

                dbManager.update(_id, title);
                //Toast.makeText(this, "Vous avez modifié un nom", Toast.LENGTH_SHORT).show();
                this.returnHome();
                Toast.makeText(this, "Vous avez modifié un nom", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_delete:
                dbManager.delete(_id);
                this.returnHome();
                Toast.makeText(this, "Vous avez supprimé un nom", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), ArtistesFavoriteActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
