package com.example.hluan.mysecondapp;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hluan on 2/20/2017.
 */

public class matrix {

    private Integer[] Map_i;
    private List<Integer> map;
    private ArrayAdapter<String> _adapter;
    public matrix(GridView gridview) {
        map=new ArrayList<Integer>();
       // _adapter=new SimpleAdapter(this,map,gridview,)

    }
    public void refresh(GridView gridview)
    {

    }

}

