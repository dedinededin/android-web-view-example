package com.example.student.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView textView;
    WebView myWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt_msg);
        myWeb = findViewById(R.id.my_web);

        myWeb.getSettings().setJavaScriptEnabled(true);
        myWeb.setWebViewClient(new WebViewClient());
//        myWeb.loadUrl("http://www.bilgi.edu.tr");

        myWeb.loadUrl("file:///android_asset/hello.html");

        registerForContextMenu(myWeb);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.web_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return optionsForMenu(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.web_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return optionsForMenu(item);
    }

    private boolean optionsForMenu(MenuItem item){
        switch (item.getItemId()) {
            case R.id.back_page:
                myWeb.goBack();
                break;
            case R.id.forward:
                myWeb.goForward();
                break;
            case R.id.reload:
                myWeb.reload();
                break;
            case R.id.zoom_in:
                myWeb.zoomIn();
                break;
            case R.id.zoom_out:
                myWeb.zoomOut();
                break;
        }
        return true;
    }
}
