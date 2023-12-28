package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ModleConnention
{
    public static MyDatabaseHelper databaseHelper;
    public ModleConnention(Context context){
        databaseHelper = new MyDatabaseHelper(context);

    }

    public void add(EditText name , EditText price, Fragment activity){
        ListFragment f = new ListFragment();
        activity.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.secondFragment,f).addToBackStack(null).commit();
        databaseHelper.addProduct(name.getText().toString(),Integer.parseInt(price.getText().toString()));
    }

    public List<e> read()
    {
        Cursor c = databaseHelper.readAllData();
        List<e> eList = new ArrayList<>();
        int n = c.getCount();
        c.moveToFirst();
        for (int i = 0; i < n; i++)
        {
            String name = c.getString(1);
            int price = c.getInt(2);
            e a = new e(name,price);
            eList.add(a);
            c.moveToNext();
        }
        return eList;
    }


}
