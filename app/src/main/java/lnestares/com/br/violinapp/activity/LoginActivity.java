package lnestares.com.br.violinapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import lnestares.com.br.violinapp.R;

/**
 * Created by macinbox on 12/03/18.
 */

public class LoginActivity extends Activity {

    private EditText etUser;
    private EditText etPass;
    private Button btnEnter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        populateViews();
        registerMainInteractions();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void populateViews() {
        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);
        btnEnter = (Button) findViewById(R.id.btnEnter);
    }

    private void registerMainInteractions() {
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!hasFieldsErrors()) {
                    startActivity(new Intent(LoginActivity.this, BemVindoActivity.class));
                }
            }
        });
    }

    private boolean hasFieldsErrors() {
        boolean contemErros = false;

        if(etUser.getText().toString().isEmpty()) {
            contemErros = true;

            Toast.makeText(this, "Por favor digite seu usuário.", Toast.LENGTH_LONG).show();

            return contemErros;
        }

        if(etPass.getText().toString().isEmpty()) {
            contemErros = true;

            Toast.makeText(this, "Por favor digite sua senha.", Toast.LENGTH_LONG).show();

            return contemErros;
        }

        return contemErros;
    }
}
