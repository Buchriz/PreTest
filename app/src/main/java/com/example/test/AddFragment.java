package com.example.test;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddFragment extends Fragment {

   private View view;

   private EditText etName, etPrice;
   private Button btn;

   private MyDatabaseHelper databaseHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add, container, false);

        etName = view.findViewById(R.id.etName);
        etPrice = view.findViewById(R.id.etPrice);
        databaseHelper = new MyDatabaseHelper(requireContext());

        ModleConnention modleConnention = new ModleConnention(requireContext());
        btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (etName.getText().toString().length() == 0 || etPrice.getText().toString().length() == 0)
                {
                    Toast.makeText(requireContext(), "Enter Name or Price", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    modleConnention.add(etName, etPrice, AddFragment.this);
                }
            }
        });


        return view;
    }
}