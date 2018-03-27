package lnestares.com.br.violinapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lnestares.com.br.violinapp.CustomApplication;
import lnestares.com.br.violinapp.R;
import lnestares.com.br.violinapp.model.Violin;

/**
 * Created by macinbox on 27/03/18.
 */

public class AddViolinActivity extends AppCompatActivity {
    private Toolbar myToolbar;

    private EditText etName;
    private EditText etModel;
    private EditText etPrice;
    private Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_violin);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setTitle("Adicionar Violino");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_arrow_back);

        populateViews();
        registerMainInteractions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem addItem = menu.findItem(R.id.action_add);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        MenuItem shareItem = menu.findItem(R.id.action_share);
        MenuItem settingsItem = menu.findItem(R.id.action_settings);

        addItem.setVisible(false);
        searchItem.setVisible(false);
        shareItem.setVisible(false);
        settingsItem.setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void populateViews() {
        etName = (EditText) findViewById(R.id.etName);
        etModel = (EditText) findViewById(R.id.etModel);
        etPrice = (EditText) findViewById(R.id.etPrice);
        btnSave = (Button) findViewById(R.id.btnSave);
    }

    private boolean hasValidFields() {
        if(etName.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Digite o nome do violino.", Toast.LENGTH_LONG).show();
            return false;
        }

        if(etModel.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Digite o modelo do violino.", Toast.LENGTH_LONG).show();
            return false;
        }

        if(etPrice.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Digite o preço do violino.", Toast.LENGTH_LONG).show();
            return  false;
        }

        return true;
    }

    private void saveViolin() {
        Violin violin = new Violin();
        violin.setName(etName.getText().toString());
        violin.setModel(etModel.getText().toString());
        violin.setPrice(etPrice.getText().toString());

        CustomApplication.getLstViolins().add(violin);
    }

    private void registerMainInteractions() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hasValidFields()) {
                    saveViolin();
                    finish();
                    Toast.makeText(getApplicationContext(), "Item adicionado com sucesso!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
