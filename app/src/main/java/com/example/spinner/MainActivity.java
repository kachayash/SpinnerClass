package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private String selectstate , selectcity;
    private  Spinner sstate,scity;
    private ArrayAdapter<CharSequence> stateAdapter , cityAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sstate = findViewById(R.id.spinner_state);
        scity=findViewById(R.id.spinner_city);
        stateAdapter=ArrayAdapter.createFromResource(this,R.array.array_state,R.layout.spinner_layout);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sstate.setAdapter(stateAdapter);


        sstate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                scity=findViewById(R.id.spinner_city);
                selectstate=sstate.getSelectedItem().toString();
                int parentID= parent.getId();
                if(parentID == R.id.spinner_state){
                    switch (selectstate){
                        case "Select State": cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),

                                R.array.defult_city,R.layout.spinner_layout);
                        break;

                        case "Gujarat":cityAdapter = ArrayAdapter.createFromResource(parent.getContext(),

                                R.array.gujrat_city,R.layout.spinner_layout);
                        break;
                        default:break;
                         
                    }
                    cityAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                    scity.setAdapter(cityAdapter);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}