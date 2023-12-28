package com.example.test;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;


public class ListFragment extends Fragment {

    private View view;


    private TableLayout tableLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list, container, false);

        tableLayout = view.findViewById(R.id.tablelayout);

        ModleConnention modleConnention = new ModleConnention(requireContext());
        List<e> list =  modleConnention.read();
        for (int i = 0; i < list.size(); i++) {
            addTableRow(list.get(i).getString(),list.get(i).getPrice());
        }




        return view;
    }

    private void addTableRow(String name, int price)
    {
        TableRow row = new TableRow(requireActivity());
        TableRow.LayoutParams rowp = new TableRow.LayoutParams(-2, -2);
        row.setLayoutParams(rowp);
        row.setBackgroundColor(Color.WHITE);

        TextView tvName = new TextView(requireActivity());
        TableRow.LayoutParams ll = new TableRow.LayoutParams(-2, -2);
        ll.setMargins(0, 1, 0, 0);
        tvName.setLayoutParams(ll);

        tvName.setText(name);


        tvName.setTextColor(Color.BLACK);
        tvName.setTextSize(26);
        tvName.setGravity(Gravity.CENTER);


        TextView tvPrice = new TextView(requireActivity());
        tvPrice.setLayoutParams(ll);
        tvPrice.setTextColor(Color.BLACK);
        tvPrice.setTextSize(26);
        tvPrice.setGravity(Gravity.CENTER);
        tvPrice.setText("" + price);


        row.addView(tvPrice);
        row.addView(tvName);
        tableLayout.addView(row);
    }
}