package com.example.sailik.mytaskenhance_09_feb;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;



public class MainActivity extends AppCompatActivity implements OnClickListener,AdapterView.OnItemSelectedListener {

    private static final String TAG=MainActivity.class.getName();


    private Button mCalculateButton;
    private EditText mNumber1;
    private EditText mNumber2;

    private Spinner mSpinner;
    private Object mOperator;
    private ArrayAdapter<CharSequence> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");

        mCalculateButton = (Button) findViewById(R.id.calculate_button);
        mNumber1 = (EditText) findViewById(R.id.num1_editText);
        mNumber2 = (EditText) findViewById(R.id.num2_editText);

        Spinner mSpinner = (Spinner) findViewById(R.id.spinner_operators);
        mAdapter = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.spinner_operators, android.R.layout.simple_spinner_item);
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner.setAdapter(mAdapter);

        mNumber1.setOnClickListener(MainActivity.this);
        mNumber2.setOnClickListener(MainActivity.this);
        mCalculateButton.setOnClickListener(MainActivity.this);
        mSpinner.setOnItemSelectedListener(this);
    }
        @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.num1_editText:
                    Context c = MainActivity.this;
                    Toast.makeText(c,c.getResources().getString(R.string.numbertype_toast), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.num2_editText:
                    c = MainActivity.this;
                    Toast.makeText(c,c.getResources().getString(R.string.numbertype_toast), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.calculate_button:
                    String numb1 = mNumber1.getText().toString();
                    String numb2 = mNumber2.getText().toString();

                    if(numb1.indexOf('-')==0||numb1.indexOf('-')==-1){
                        if(numb2.indexOf('-')==0||numb2.indexOf('-')==-1){

                        }
                        else{
                            c = MainActivity.this;
                            Toast.makeText(c,c.getResources().getString(R.string.invalidinput_toast),Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        c = MainActivity.this;
                        Toast.makeText(c,c.getResources().getString(R.string.invalidinput_toast),Toast.LENGTH_SHORT).show();
                        break;
                    }

                    if(numb1.equals("")||numb2.equals("")||(numb1.equals("")&&numb2.equals(""))||mOperator.equals("")){
                        if(mOperator.equals("")){

                            c = MainActivity.this;
                            Toast.makeText(c,c.getResources().getString(R.string.nooperator_toast),Toast.LENGTH_SHORT).show();

                        }
                        c = MainActivity.this;
                        Toast.makeText(c,c.getResources().getString(R.string.invalidinput_toast),Toast.LENGTH_SHORT).show();

                    }
//                    if(mOperator.equals("")){
//
//                        c = MainActivity.this;
//                        Toast.makeText(c,c.getResources().getString(R.string.nooperator_toast),Toast.LENGTH_SHORT).show();
//
//                    }

                    else {
                        int num1 = Integer.parseInt(numb1);
                        int num2 = Integer.parseInt(numb2);
                        int result = 0;
                        if(mOperator.equals("+")){
                            result = num1 + num2;
                        }
                        else if(mOperator.equals("-")){
                            result = num1 - num2;
                        }
                        else if(mOperator.equals("*")){
                            result = num1 * num2;
                        }
                        else{
                            result = num1/num2;
                        }

                        c = MainActivity.this;
                        Toast.makeText(c,"result: "+result, Toast.LENGTH_SHORT).show();
                        mNumber1.setText("");
                        mNumber2.setText("");
                }
                break;

            }


        }
     @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        Object operator_symbol= parent.getItemAtPosition(pos);
        if(operator_symbol.equals("ADD")){
            mOperator = "+";
        }
        else if(operator_symbol.equals("SUB")){
             mOperator = "-";
        }
        else if(operator_symbol.equals("MUL")){
             mOperator = "*";
        }
        else if(operator_symbol.equals("DIV")){
             mOperator = "/";
         }
        else{
            Context c = MainActivity.this;
            Toast.makeText(c,c.getResources().getString(R.string.spinnererror_toast), Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        mOperator="";
    }


}

