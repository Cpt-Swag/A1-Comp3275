package king.bas.a1_comp3275;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by King on 24-Feb-16.
 */


public class ItemAdapter extends ArrayAdapter<String> {

    public ItemAdapter(Context context, String [] items){
        super (context, 0, items);
    } //constructor
    @Override
    public View getView(int position, View v, ViewGroup p){

        v = LayoutInflater.from(getContext()).inflate(R.layout.item, p);
        String item = getItem(position);
        String [] itemPrices = getContext().getResources()
                .getStringArray(R.array.itemS_prices);
        TypedArray itemImages = getContext().getResources()
                .obtainTypedArray(R.array.items_images);
        ((TextView)v.findViewById(R.id.txt_name))
                .setText(item);
        ((TextView)v.findViewById(R.id.txt_price))
                .setText(itemPrices[position]);
        ((ImageView)v.findViewById(R.id.img_icon))
                .setImageResource(itemImages.getResourceId(position, 0));
        return v;

    }

}
