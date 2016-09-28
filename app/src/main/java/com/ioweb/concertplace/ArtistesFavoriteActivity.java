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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArtistesFavoriteActivity extends ActionBarActivity {

    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[]{DatabaseHelper._ID,
            DatabaseHelper.SUBJECT};

    final int[] to = new int[]{R.id.id, R.id.title};

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
                Toast.makeText(getApplicationContext(), "selected item " + title, Toast.LENGTH_SHORT).show();
                String tabName[] = {title};
                ArrayList<Artiste> favoriSchedul = new ArrayList<Artiste>();
                favoriSchedul = Artiste.getSchedul();

                if (favoriSchedul.isEmpty() || favoriSchedul.size() == 0) {
                    favoriSchedul = Artiste.getListOfArtistes(tabName);
                    if (favoriSchedul.size() == 0 || favoriSchedul.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "L' artiste " + title + " n'a pas des concernts prochainement ", Toast.LENGTH_SHORT).show();
                    } else {
                        Artiste.setArtisteSchedul(favoriSchedul);
                        goToArtistSchedulActivity();
                    }

                } else {
                    ArrayList<Artiste> listOfFavoriActivity = new ArrayList<Artiste>();
                    for (int i = 0; i < favoriSchedul.size(); i++) {
                        if (title.equals(favoriSchedul.get(i).getName())) {
                            listOfFavoriActivity.add(favoriSchedul.get(i));
                        }
                    }
                    if (listOfFavoriActivity.isEmpty() || listOfFavoriActivity.size() == 0) {
                        listOfFavoriActivity = Artiste.getListOfArtistes(tabName);
                        if (listOfFavoriActivity.isEmpty() || listOfFavoriActivity.size() == 0) {
                            Toast.makeText(getApplicationContext(), "L' artiste " + title + " n'a pas des concernts prochainement ", Toast.LENGTH_SHORT).show();
                        } else {
                            Artiste.setArtisteSchedul(listOfFavoriActivity);
                            goToArtistSchedulActivity();
                        }
                    } else {
                        Artiste.setArtisteSchedul(listOfFavoriActivity);
                        goToArtistSchedulActivity();
                    }
                    ;

                }
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.title);

                String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModifyFavoriNameActivity.class);
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("id", id);

                startActivity(modify_intent);
                return true;
            }
        });
    }

    public void goToArtistSchedulActivity(){
        Intent intent = new Intent(getApplicationContext(), ArtisteFavoriteSchedulActivity.class);
        startActivity(intent);
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