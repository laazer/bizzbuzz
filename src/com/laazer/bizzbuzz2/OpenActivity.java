package com.laazer.bizzbuzz2;

import com.example.bizzbuzz2.R;
import com.laazer.bizzbuzz2.BizzBuzz;
import com.laazer.bizzbuzz2.Instruction;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class OpenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.open, menu);
        return true;
    }
    
    /** action to view instruction page **/
    public void instruct(View view) {
        Intent intent = new Intent(this, Instruction.class);
        startActivity(intent);
    }
    
    /** action to start bizzbuzz **/
    public void play(View view) {
        Intent intent = new Intent(this, BizzBuzz.class);
        startActivity(intent);
    }
    
    /**goes to intructions **/
    public void inst(View view) {
        Intent intent = new Intent(this, Instruction.class);
        startActivity(intent);
    }
    

}
