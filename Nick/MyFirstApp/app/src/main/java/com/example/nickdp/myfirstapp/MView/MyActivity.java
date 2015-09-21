package com.example.nickdp.myfirstapp.MView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nickdp.myfirstapp.MController.Controller;
import com.example.nickdp.myfirstapp.MModel.Message;
import com.example.nickdp.myfirstapp.R;

public class MyActivity extends AppCompatActivity implements OnChangeListener<Message> {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    private Message msg;
    private Controller ctr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        msg = new Message();
        msg.addListener(this);
        ctr = new Controller(msg);

        Button btnSend = (Button) findViewById(R.id.button_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

    }

    private void sendMessage(View v){
        EditText editText = (EditText) findViewById(R.id.edit_message);
        ctr.appendMessage(editText.getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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
    public void onChange(final Message model) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MyActivity.this, DisplayMessageActivity.class);
                intent.putExtra(EXTRA_MESSAGE, model.getMessage());
                startActivity(intent);
            }
        });
    }
}
