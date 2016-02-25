package king.bas.a1_comp3275;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get from the list of menu items
        ListView lv = (ListView) findViewById(R.id.menu_list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = null;
                switch(position){
                    case 0:
                        i = new Intent(MainMenu.this, UIComponents.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(MainMenu.this, Layouts.class);
                        startActivity(i);
                        break;
                    case 2:
                        i = new Intent(MainMenu.this, Dialogs.class);
                        startActivity(i);
                        break;
                    case 3:
                        i = new Intent(MainMenu.this, ToastnSnackbar.class);
                        startActivity(i);
                        break;
                    case 4:
                        i = new Intent(MainMenu.this, ActivityBundles.class);
                        startActivity(i);
                        break;
                    case 5:
                        i = new Intent(MainMenu.this, ActivityResults.class);
                        startActivity(i);
                        break;
                    case 6:
                        i = new Intent(MainMenu.this, CustomAdapter.class);
                        startActivity(i);
                        break;
                    case 7:
                        i = new Intent(MainMenu.this, Fragment.class);
                        startActivity(i);
                        break;
                    case 8:
                        i = new Intent(MainMenu.this, ActionBarAndMenu.class);
                        startActivity(i);
                        break;
                    case 9:
                        i = new Intent(MainMenu.this, MasterDetailLayout.class);
                        startActivity(i);
                        break;

                }// switch

            }// onItemClickListener

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
