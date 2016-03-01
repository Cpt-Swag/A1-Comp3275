package bas.king.comp3275_a1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityBundles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_bundles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }// onCreate

    public void logIn (View view){
        Intent i = new Intent(ActivityBundles.this, ActivityResults.class);
        Bundle bundle = new Bundle();
        EditText eText = (EditText) findViewById(R.id.txt_name);
        EditText pw = (EditText) findViewById(R.id.txt_pass);
        String name = eText.getText().toString();
        String passw = pw.getText().toString();

        bundle.putString("name", name);
        bundle.putString("password",passw);
        i.putExtras(bundle);
        startActivity(i);
    }// logIn

    public void Resulta (View view){
        Bundle bundle = getIntent().getExtras();
//        Get values from bundles using keys
        String ans = bundle.getString("results");

        TextView result = (TextView)findViewById(R.id.txt_result);

//        values for text view
        result.setText(ans);
    }// logIn

}
