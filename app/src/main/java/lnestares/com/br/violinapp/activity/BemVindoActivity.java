package lnestares.com.br.violinapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import lnestares.com.br.violinapp.CustomApplication;
import lnestares.com.br.violinapp.R;
import lnestares.com.br.violinapp.adapters.ViolinAdapter;
import lnestares.com.br.violinapp.model.Violin;

/**
 * Created by macinbox on 12/03/18.
 */

public class BemVindoActivity extends AppCompatActivity {

    private Toolbar myToolbar;
    private ListView listview;
    private ViolinAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_arrow_back);

        populateViews();
        setAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.action_add:
                startActivity(new Intent(BemVindoActivity.this, AddViolinActivity.class));
                return true;

            case R.id.action_share:
                shareApp();
                return true;

            case R.id.action_settings:
                Toast.makeText(this, "Configurações", Toast.LENGTH_LONG).show();
                return true;

//            case R.id.action_search:
//                Toast.makeText(this, "Pesquisar", Toast.LENGTH_LONG).show();
//                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void populateViews() {
        listview = (ListView) findViewById(R.id.listview);
    }

    private void setAdapter() {
        adapter = new ViolinAdapter(this, 0, CustomApplication.getLstViolins());
        listview.setAdapter(adapter);
    }

    private void shareApp() {
        String shareBody = "Baixe o Violin App nas lojas Google Play! Lista de melhores violinos do mundo!";
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Violin App");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share)));
    }
}
