package bas.king.comp3275_a1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static android.support.design.widget.Snackbar.make;

public class ActionBarAndMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_and_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_fave) {
            Toast.makeText(ActionBarAndMenu.this, "You clicked the burga", Toast.LENGTH_SHORT).show();
            return true;
        }// if
        else if (id == R.id.action_chat) {
            Toast.makeText(ActionBarAndMenu.this, "You clicked the chat icon", Toast.LENGTH_SHORT).show();
            return true;
        }// if
        else if (id == R.id.action_trash) {
            Toast.makeText(ActionBarAndMenu.this, "You clicked the trash icon", Toast.LENGTH_SHORT).show();
            return true;
        }// if
        else if (id == R.id.action_login) {
            Toast.makeText(ActionBarAndMenu.this, "You clicked the login icon", Toast.LENGTH_SHORT).show();
            return true;
        }// if
        else if (id == R.id.action_sta) {
            Toast.makeText(ActionBarAndMenu.this, "You clicked the star icon", Toast.LENGTH_SHORT).show();
            return true;
        }// if


        return super.onOptionsItemSelected(item);
    }

}


