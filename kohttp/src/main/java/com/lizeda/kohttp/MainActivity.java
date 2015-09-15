package com.lizeda.kohttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.lizeda.kohttp.callback.DownloadCallback;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://h.hiphotos.baidu.com/image/pic/item/fc1f4134970a304e725fc8fad3c8a786c9175cb4.jpg";

//        File file = new File("name4.jpg");
        File file = new File(getCacheDir() + "name4.jpg");
        KOHttpClientManager.download(MainActivity.this, url, new DownloadCallback(file) {

            @Override
            public void onProgress(long currentBytes, long contentLength, boolean done) {
                System.out.println("currentBytes == " + currentBytes);
                System.out.println("contentLength == " + contentLength);
                System.out.println("done == " + done);
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
}
