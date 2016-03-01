package bas.king.comp3275_a1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ToastnSnackbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toastn_snackbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get from the list of menu items
        ListView lv = (ListView) findViewById(R.id.food_list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Standard Toast
                        Toast.makeText(ToastnSnackbar.this, "i like toast!!!!", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        /* Standard Toast;
                        ** Should appear on screen for an extended period of time
                         */
                        Toast.makeText(ToastnSnackbar.this, "I like toast, Long Toast Style!!!!", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        //Standard Snackbar
                        Snackbar.make(view, "I could use a snack", Snackbar.LENGTH_SHORT)
                                .setAction("Action", null).show();
                        break;
                    case 3:
                        /*
                        ** Snackbar with action
                        * Includes comical message and action
                        * When clicked carries the user back to the home(main) activity
                         */
                        Snackbar.make(view, "You are drunk!", Snackbar.LENGTH_LONG)
                                .setActionTextColor(Color.RED)
                                .setAction("Go Home", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(ToastnSnackbar.this, MainMenu.class);
                                        startActivity(i);
                                    } //onClick
                                }).show();
                        break;

                }//switch

            }// onClick
        }); //clickListner

    }// onCreate

} //Activity
