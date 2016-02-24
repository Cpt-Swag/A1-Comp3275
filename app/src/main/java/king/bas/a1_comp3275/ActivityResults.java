package king.bas.a1_comp3275;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
//        Get values from bundles using keys
        String name = bundle.getString("name");
        String password = bundle.getString("password");

        TextView nombre = (TextView)findViewById(R.id.txt_namer);
        TextView passre = (TextView)findViewById(R.id.txt_passr);

//        values for text view
        nombre.setText(name);
        passre.setText(password);

    }// onCreate

    public void Send (View view){
        Intent i = new Intent(ActivityResults.this, ActivityBundles.class);
        Bundle bundle2 = new Bundle();
        EditText answer = (EditText) findViewById(R.id.txt_ok);
        String ok = answer.getText().toString();

        bundle2.putString("results", ok);
        i.putExtras(bundle2);
        startActivity(i);
    }// Send

}// Activity
