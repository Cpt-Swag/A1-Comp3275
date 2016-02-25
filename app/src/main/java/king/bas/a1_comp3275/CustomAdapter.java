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

    class ItemAdapter extends ArrayAdapter<String> {

        public ItemAdapter(Context context, String [] items){
            super (context, 0, items);
        } //constructor

        @Override
        public View getView(final int position, View v, ViewGroup p){
            v = LayoutInflater.from(getContext()).inflate(R.layout.item, p);
            String item = getItem(position);
            String [] itemPrices = getContext().getResources().getStringArray(R.array.itemS_prices);
            TypedArray itemImages = getContext().getResources().obtainTypedArray(R.array.items_images);
            final String [] itemDesc = getContext().getResources().getStringArray(R.array.items_description);

            ((Button) v.findViewById(R.id.btn_deets))
                        .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(CustomAdapter.this, itemDesc[position], Toast.LENGTH_SHORT).show();
                        }
                    });

            ((TextView)v.findViewById(R.id.txt_name))
                    .setText(item);

            ((TextView)v.findViewById(R.id.txt_price))
                    .setText(itemPrices[position]);

            ((ImageView)v.findViewById(R.id.img_icon))
                    .setImageResource(itemImages.getResourceId(position, 0));
            return v;

        }// view

    }

}
