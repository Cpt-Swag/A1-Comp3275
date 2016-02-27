package king.bas.a1_comp3275;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView lv = (ListView) findViewById(R.id.lst_items);
        final String [] items = getResources().getStringArray(R.array.items_available);
        ArrayAdapter adapter = new ItemAdapter(this, items);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Toast item clicked
                        Toast.makeText(CustomAdapter.this, "I like " + items[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
//                        Toast item clicked
                        Toast.makeText(CustomAdapter.this, "I like " + items[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        // Toast item clicked
                        Toast.makeText(CustomAdapter.this, "I like " + items[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
//                        Toast item clicked
                        Toast.makeText(CustomAdapter.this, "I like " + items[position], Toast.LENGTH_SHORT).show();
                        break;

                }//switch

            }// onClick
        }); //clickListner

    }

}
