package robertbeckwith.uiuctransfer;

/**
 * Created by rjbec on 5/6/2017.
 */
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TableRow;
import android.widget.TableLayout;

import java.util.ArrayList;

public class TransfersAdapter extends ArrayAdapter<Transfers> {
    Context context;
    private ArrayList<Transfers> transferArray;
    private int counter = 0;

    public TransfersAdapter(Context context, int textViewResourceId, ArrayList<Transfers> items, int counter) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.transferArray = items;
        this.counter = counter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TableRow row;
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.transfers, null);
        }

        final Transfers transfers = transferArray.get(position);
        if (transfers != null) {
            row = (TableRow) v.findViewById(R.id.table);

            //onclick of one of the table rows
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getId() == R.id.table) {
                        TextView description = (TextView) v.findViewById((R.id.name));
                        TextView majors = (TextView) v.findViewById(R.id.ssHum);
                        if (!description.getText().toString().equals(transfers.getName() + ": " + transfers.getDescription())) { // checks if the textview has already been expanded
                            description.setText(String.valueOf(transfers.getName() + ": " + transfers.getDescription())); // if it hasn't been replaced already display the description
                            counter++;
                            if (!(transfers.getMajors() == null))
                                majors.setText(String.valueOf(transfers.getMajors()));
                            row.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.translucent_orange));
                        } else {
                            // set the name back to the name of the class and the color back to the original
                            if (transfers.getTransferStatus() != null)
                                majors.setText(String.valueOf(transfers.getTransferStatus()));
                            description.setText(String.valueOf(transfers.getName()));
                            row.setBackgroundColor(0x00000000);
                        }


                    }
                }
            });
            TextView symbol = (TextView) v.findViewById(R.id.symbol);
            TextView name = (TextView) v.findViewById(R.id.name);
            TextView code = (TextView) v.findViewById(R.id.code);
            TextView ssHum = (TextView) v.findViewById(R.id.ssHum);
            TextView westerneastern = (TextView) v.findViewById(R.id.westerneastern);
            symbol.setText(String.valueOf(transfers.getSymbol()));
            name.setText(String.valueOf(transfers.getName()));

            //added space onto the area for classes so there would be space for on click expansion
            if (transfers.getCode() != 0)
                code.setText(String.valueOf(transfers.getCode()));
            else
                code.setText("");

            //checks if it is reading ss/hum data or engineering class data
            if (transfers.getUiucsymbol() == null)
            // engineering classes data
            {
                //ssHum.setLayoutParams(new TableLayout.LayoutParams(1,1));
                ssHum.setText(String.valueOf(transfers.getTransferStatus()));
                westerneastern.setText(" ");
                LayoutParams params = (LayoutParams) ssHum.getLayoutParams();
                params.width = 200;//getResources().getDimensionPixelSize(R.dimen.text_view_width);
                ssHum.setLayoutParams(params);
            } else {
                // sshum data
                ssHum.setText(String.valueOf(transfers.getSsHum()));
                westerneastern.setText(String.valueOf(transfers.getWesterneastern()));
            }
        }
        return v;
    }
}

