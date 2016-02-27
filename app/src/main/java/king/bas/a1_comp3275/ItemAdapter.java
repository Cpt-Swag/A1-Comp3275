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
 * Created by King on 27-Feb-16.
 */
public class ItemAdapter extends ArrayAdapter<String> {
    public final Context context;
    public ItemAdapter(Context context, String [] items){
        super (context, 0, items);
        this.context = context;
    } //constructor

    @Override
    public View getView(int position, View v, ViewGroup p){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = LayoutInflater.from(getContext()).inflate(R.layout.item, null);
        String item = getItem(position);
        String [] itemPrices = getContext().getResources().getStringArray(R.array.itemS_prices);
        TypedArray itemImages = getContext().getResources().obtainTypedArray(R.array.items_images);
            /*
            final String [] itemDesc = getContext().getResources().getStringArray(R.array.items_description);

            ((Button) v.findViewById(R.id.btn_deets))
                        .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(CustomAdapter.this, itemDesc[position], Toast.LENGTH_SHORT).show();
                        }
                    });
*/
        ((TextView)v.findViewById(R.id.txt_name))
                .setText(item);

        ((TextView)v.findViewById(R.id.txt_price))
                .setText(itemPrices[position]);

        ((ImageView)v.findViewById(R.id.img_icon))
                    .setImageResource(itemImages.getResourceId(position, 0));
        return v;

    }// view

}
