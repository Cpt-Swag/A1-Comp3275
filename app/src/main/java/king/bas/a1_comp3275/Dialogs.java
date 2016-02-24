package king.bas.a1_comp3275;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.app.AlertDialog;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Dialogs extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get from the list of menu items
        ListView lv = (ListView) findViewById(R.id.dialog_list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        /* Standard Alert Dialog
                        ** Contains toast that reiterates users choice
                         */
                        AlertDialog alertDialog = new AlertDialog.Builder(Dialogs.this).create();
                        alertDialog.setTitle("Alert Dialog");
                        alertDialog.setMessage("You are entering the matrix");

//                        Button to exit dialog; activates pnClick
                        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_SHORT).show();
                            }// onClick
                        });

                        alertDialog.show();
                        break;
                    case 1:
                        /* Confirmation Dialog;
                        ** Gives option of closing activity and going to home (main) activity
                         */
                        AlertDialog.Builder popUp = new AlertDialog.Builder(Dialogs.this);
                        popUp.setTitle("Confirm Dialog");
                        popUp.setMessage("Do you want to go Home?");
                        popUp.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(Dialogs.this, MainMenu.class);
                                startActivity(i);
                            }// onClick
                        });
//                        Closes dialog if no pressed
                        popUp.setNegativeButton("No", null);

                        AlertDialog alert = popUp.create();
                        alert.show();
                        break;
                    case 2:
//                        Allows the user to select a date from a dialog pop up
                        AlertDialog.Builder popDate = new AlertDialog.Builder(Dialogs.this);
                        pickDate(popDate);

                        break;
                    case 3:
                        /*
                        ** Presents a list of items within a dialog
                        * It allows the user to select a single value from the list
                        **/
                        singleChoice();


                        break;
                    case 4:
                        /*
                        ** Presents a list of items within a dialog
                        * It allows the user to select multiple items from the list
                        **/
                        multiChoice();
                        break;

                }//switch

            }// onClick
        }); //clickListner
    }// onCreate

    // Actual logic for the method that allows user to make single choice
    public void singleChoice(){
        final CharSequence[] snacks = {"KitKat", "Lollipop","Marshmallow","Jelly Bean","Frozen Yogurt"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Dialogs.this); // creates the dialog pop up
        builder.setTitle("Snack")
//                Radio buttons are used for single choices
                .setSingleChoiceItems(snacks, 1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int item) {
                        Toast.makeText(getApplicationContext(), snacks[item], Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setPositiveButton("Ok", null);
        builder.create().show();
    }// ShowAlertDialogWithListview

    public void multiChoice() {
        final CharSequence[] items = {"Red", "Green", "Blue"};
        final boolean [] selected = {false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(Dialogs.this);
        builder.setTitle("Pick colors")
//        Check boxes are used for multiple choice options
                .setMultiChoiceItems(items, selected, new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialogInterface, int item, boolean b) {
                        Log.d("Myactivity", String.format("%s: %s", items[item], b));
                    }
                });
        builder.setPositiveButton("Ok", null);
        builder.create().show();
    }// multiChoice

    //DatePicker logic uses Sthe calendar object class
    public void pickDate(AlertDialog.Builder buil){
        Calendar cali = Calendar.getInstance();
//        The following lines should auto select the current date
        int year = cali.get(Calendar.YEAR);
        int month = cali.get(Calendar.MONTH);
        int day = cali.get(Calendar.DAY_OF_MONTH);

//        Should pass values to pop up dialog
        DatePickerDialog caliDialog = new DatePickerDialog(Dialogs.this,listener,year, month, day ); //Passes the year, month and day to the Listener event to be outputted to the user
        caliDialog.show();
    }// datePicker


    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int mon, int dated) {
            // mon is offset by 1 to accommodate for value starting at 0,
            // meaning realistic date
            mon += 1;
            // Should output selected date
            Toast.makeText(Dialogs.this,dated + "/" + mon + "/" + year,Toast.LENGTH_SHORT).show();
//            Toast.makeText(Dialogs.this,dayOfMonth + "/" + mon + "/" + year,Toast.LENGTH_SHORT).show();
        } //onDateSet
    }; // Listener


} //Activity
