package com.example.praneethagangisetty.fragment_ex;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {
    Intent intent;
    WebView webView;
    String url_tab;
    TextView no_url;
    public TabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab, container, false);
        webView=view.findViewById(R.id.webview);
        no_url=view.findViewById(R.id.no_url);
        intent=getActivity().getIntent();
        if(intent.getStringExtra("url")!=null){
            url_tab=intent.getStringExtra("url");
            webView.loadUrl(url_tab);
        }
        else{
            webView.setVisibility(View.GONE);
            no_url.setVisibility(View.VISIBLE);
        }
        return view;
    }

}
