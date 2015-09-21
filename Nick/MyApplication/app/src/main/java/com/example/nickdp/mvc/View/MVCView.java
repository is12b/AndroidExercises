package com.example.nickdp.mvc.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TextView;

import com.example.nickdp.mvc.Controller.MVCController;
import com.example.nickdp.mvc.Model.Num;
import com.example.nickdp.mvc.Model.OnChangeListener;
import com.example.nickdp.mvc.R;

public class MVCView extends AppCompatActivity implements OnChangeListener<Num> {

    private Num num;
    private MVCController ctr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = new Num();
        num.addListener(this);
        ctr = new MVCController(num);

        Button btnIncrement = (Button) findViewById(R.id.btnPlus);
        Button btnDecrement = (Button) findViewById(R.id.btnMinus);

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctr.increment();
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctr.decrement();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onChange(final Num model) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateView(model);
            }
        });
    }

    private void updateView(Num model) {
        TextView v = (TextView) findViewById(R.id.txtNum);
        v.setText(Integer.toString(model.getNum()));
    }
}
