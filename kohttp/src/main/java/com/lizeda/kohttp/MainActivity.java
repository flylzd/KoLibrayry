package com.lizeda.kohttp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.lizeda.kohttp.callback.DownloadCallback;
import com.lizeda.kohttp.callback.ResponseCallback;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button download = (Button) findViewById(R.id.download);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent= new Intent();
//                intent.setAction("android.intent.action.VIEW");
//                Uri content_url = Uri.parse("http://wpa.qq.com/msgrd?v=3&uin=545540328&site=qq&menu=yes");
//                intent.setData(content_url);
//                startActivity(intent);
                String url = "http://121.41.119.107:81/test/1.doc";

                File file = new File(getCacheDir() + "1.doc");
                KOHttpClientManager.download(MainActivity.this, url, new DownloadCallback(file) {

                    @Override
                    public void onProgress(long currentBytes, long contentLength, boolean done) {
                        System.out.println("download currentBytes == " + currentBytes);
                        System.out.println("download contentLength == " + contentLength);
                        System.out.println("download done == " + done);
                    }
                });
            }
        });


        Button upload = (Button) findViewById(R.id.upload);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://yidong.duapp.com/upload.php";
                File file = new File(getCacheDir() + "1.doc");
                RequestParams requestParams = new RequestParams();
                requestParams.file("myFile",file);
                KOHttpClientManager.upload(MainActivity.this, url, requestParams, new ResponseCallback() {
                    @Override
                    public void onProgress(long currentBytes, long contentLength, boolean done) {

                        System.out.println("upload currentBytes == " + currentBytes);
                        System.out.println("upload contentLength == " + contentLength);
                        System.out.println("upload done == " + done);
                    }
                });

//                String url = "http://121.41.119.107:81/test/1.doc";
//                File file = new File(getCacheDir() + "1.doc");
//                KOHttpClientManager.download(MainActivity.this, url, new DownloadCallback(file) {
//
//                    @Override
//                    public void onProgress(long currentBytes, long contentLength, boolean done) {
//                        System.out.println("currentBytes == " + currentBytes);
//                        System.out.println("contentLength == " + contentLength);
//                        System.out.println("done == " + done);
//                    }
//                });
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
