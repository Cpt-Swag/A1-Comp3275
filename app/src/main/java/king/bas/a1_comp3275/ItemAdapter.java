package king.bas.a1_comp3275;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by King on 27-Feb-16.
 */
public class ItemAdapter extends ArrayAdapter<String> {
    public ItemAdapter(Context context, String [] items){
        super (context, 0, items);
    } //constructor

    @Override
    public View getView(int position, View v, ViewGroup p){
        v = LayoutInflater.from(getContext()).inflate(R.layout.item, null);
        String item = getItem(position);
        String [] itemPrices = getContext().getResources().getStringArray(R.array.itemS_prices);
        TypedArray itemImages = getContext().getResources().obtainTypedArray(R.array.items_images);
//
//            final String [] itemDesc = getContext().getResources().getStringArray(R.array.items_description);
//            final int pos = position;

//        Button button= (Button) v.findViewById(R.id.btn_deets);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewDeets(v,pos);
//            }
//        });
        ((TextView)v.findViewById(R.id.txt_name))
                .setText(item);

        ((TextView)v.findViewById(R.id.txt_price))
                .setText(itemPrices[position]);

        ((ImageView)v.findViewById(R.id.img_icon))
                    .setImageResource(itemImages.getResourceId(position, 0));
        return v;

    }// view


}// class


