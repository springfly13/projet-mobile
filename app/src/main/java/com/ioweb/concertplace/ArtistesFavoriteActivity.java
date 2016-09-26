package com.ioweb.concertplace;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ArtistesFavoriteActivity extends ActionBarActivity  {

    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.SUBJECT };

    final int[] to = new int[] { R.id.id, R.id.title };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        adapter.notifyDataSetChanged();

        listView.setAdapter(adapter);

        // OnCLickListiner For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView titleTextView = (TextView) view.findViewById(R.id.title);
                String title = titleTextView.getText().toString();
                //Toast.makeText(getApplicationContext(), "selected item "+title , Toast.LENGTH_SHORT).show();

                for (int i=0; i<Artiste.getListOfArtistes().size(); i++){
                    //String searcheName = Artiste.getListOfArtistes().get(i).getName();
                    if (title.equals(Artiste.getListOfArtistes().get(i).getName())) {
                        Artiste.getArtisteSchedul().add(Artiste.getListOfArtistes().get(i));
                       // Toast.makeText(getApplicationContext(), "was added "+Artiste.getArtisteSchedul().get(i).getCity() , Toast.LENGTH_SHORT).show();
                    }
                }
                //Toast.makeText(getApplicationContext(), "selected item "+Artiste.getArtisteSchedul() , Toast.LENGTH_SHORT).show();
                if (Artiste.getArtisteSchedul().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "L' artiste " + title + " n'a pas des concernts prochainement ", Toast.LENGTH_SHORT).show();
                } else {

                    Intent intent2 = new Intent(getApplicationContext(), ArtisteFavoriteSchedulActivity.class);
                    startActivity(intent2);
                }


                //Intent modify_intent = new Intent(getApplicationContext(), ModifyFavoriNameActivity.class);
                //modify_intent.putExtra("title", title);
                //modify_intent.putExtra("desc", desc);
                //modify_intent.putExtra("id", id);

               // startActivity(modify_intent);
            }
        });
        /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                //TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.title);
                //TextView descTextView = (TextView) view.findViewById(R.id.desc);

               // String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();
                // String desc = descTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModifyFavoriNameActivity.class);
                modify_intent.putExtra("title", title);
                //modify_intent.putExtra("desc", desc);
                //modify_intent.putExtra("id", id);

                startActivity(modify_intent);
            }
        }); */

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.title);
                //TextView descTextView = (TextView) view.findViewById(R.id.desc);

                String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();
                // String desc = descTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModifyFavoriNameActivity.class);
               //Toast.makeText(getApplicationContext(), "LE TITRE CHOISI "+title , Toast.LENGTH_SHORT).show();
                modify_intent.putExtra("title", title);
                //modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);

                startActivity(modify_intent);
               return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            Intent add_mem = new Intent(this, AddFavoriActivity.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

}