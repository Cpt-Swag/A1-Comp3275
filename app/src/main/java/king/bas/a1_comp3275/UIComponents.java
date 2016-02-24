package king.bas.a1_comp3275;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UIComponents extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText email;
    RadioGroup sex;
    RadioButton sexBtn;
    TextView saved_uname;
    TextView saved_pword;
    TextView saved_email;
    TextView saved_sex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicomponents);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        username = (EditText)findViewById(R.id.txt_uName); //sets variable to actual Username from text field
        password = (EditText)findViewById(R.id.txt_pWord); //sets variable to actual password from text field
        email = (EditText)findViewById(R.id.txt_email); //sets variable to actual email from text field
        sex =(RadioGroup)findViewById(R.id.rdbtn_sex); //sets variable to actual sex from radio button group

//        Loading
        saved_uname = (TextView) findViewById(R.id.txtV_uName);
        saved_pword = (TextView) findViewById(R.id.txtV_pWord);
        saved_email = (TextView) findViewById(R.id.txtV_email);
        saved_sex = (TextView) findViewById(R.id.txtV_sex);
    }

    /*
    ** When save button pressed should take values from input fields
    *  Then display them in the text below
     */
    public void saved(View view){
        SharedPreferences sp = getApplicationContext().getSharedPreferences("appInfo",MODE_PRIVATE);
        SharedPreferences.Editor eddy = sp.edit();
        eddy.putString("UserName",username.getText().toString());
        eddy.putString("Password", password.getText().toString());
        eddy.putString("Email", email.getText().toString());
//        eddy.putInt("Sex",sex.getCheckedRadioButtonId());

        eddy.commit();
/*
        if (editor.commit()){
            Snackbar.make(view, "Item successfully  added to cart", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }*/

//        Loading Saved Values
        String un = sp.getString("UserName","");
        String pw = sp.getString("Password","");
        String em =sp.getString("Email","");

        int sexId = sex.getCheckedRadioButtonId();
        sexBtn = (RadioButton)findViewById(sexId);

        saved_uname.setText(un);
        saved_pword.setText(pw);
        saved_email.setText(em);
        saved_sex.setText(sexBtn.getText());


    }// view
}// activity
