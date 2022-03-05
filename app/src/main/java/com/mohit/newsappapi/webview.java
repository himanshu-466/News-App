package com.mohit.newsappapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {
    Toolbar toolbar;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        toolbar = findViewById(R.id.toolbar2);
        webview = findViewById(R.id.webview);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url);



    }
}