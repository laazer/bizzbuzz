package com.laazer.bizzbuzz2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bizzbuzz2.R;
import com.laazer.games.*;

public class BizzBuzz extends Activity {
    
    private Buzzer buzzer = new Buzzer(4, 3);
    private static final String WRONG = "Incorect!";
    private static final String BIZZ = "bizz";
    private static final String BUZZ = "buzz";
    private static final String BIZZBUZZ = "bizzbuzz";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bizz_buzz);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.open, menu);
        return true;
    }
    
    /** set the answer viewtext */
    public void setAnswer(String ans) {
        TextView curAns = (TextView) findViewById(R.id.answer);
        curAns.setText(ans);
    }
    
    private void ansBtnEvent(String ans) {
        boolean check = buzzer.play(ans);
        if(check) {
            this.setAnswer(ans);
        }
        else {
            //TODO: fix with reset button
            this.buzzer.reset();
            this.setAnswer(WRONG);}
    }
    
    /** on click bizz action */
    public void clickBizz(View view) {
        this.ansBtnEvent(BIZZ);
    }

    /** on click buzz action */
    public void clickBuzz(View view) {
        this.ansBtnEvent(BUZZ);
    }
    
    /** on click bizzbuzz action */
    public void clickBizzBuzz(View view) {
        this.ansBtnEvent(BIZZBUZZ);
    }

    /** number entry button action */
    public void numEntry(View view){
        EditText entry = (EditText) findViewById(R.id.number_entry);
        this.ansBtnEvent(entry.getText().toString());
        entry.setText("");
    }
}
