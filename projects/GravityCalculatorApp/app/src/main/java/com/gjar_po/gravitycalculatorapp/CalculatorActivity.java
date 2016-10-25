package com.gjar_po.gravitycalculatorapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    private Spinner mSpinner;
    private EditText mWeightInput;
    private ImageView mPlanetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_spiner);
        mPlanetImage = (ImageView) findViewById(R.id.planet_image);
        mWeightInput = (EditText) findViewById(R.id.weight_input);
        mSpinner = (Spinner) findViewById(R.id.planet);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mPlanetImage.setImageResource(R.drawable.mercury);
                        break;
                    case 1:
                        mPlanetImage.setImageResource(R.drawable.venus);
                        break;
                    case 2:
                        mPlanetImage.setImageResource(R.drawable.mars);
                        break;
                    case 3:
                        mPlanetImage.setImageResource(R.drawable.jupiter);
                        break;
                    case 4:
                        mPlanetImage.setImageResource(R.drawable.saturn);
                        break;
                    case 5:
                        mPlanetImage.setImageResource(R.drawable.uranus);
                        break;
                    case 6:
                        mPlanetImage.setImageResource(R.drawable.neptun);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mPlanetImage.setImageDrawable(null);
            }
        });
        mSpinner.setSelection(0);
        findViewById(R.id.calculate_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(mWeightInput.getText().toString())) {
                    Toast.makeText(CalculatorActivity.this, R.string.weight_not_valid, Toast.LENGTH_LONG).show();
                } else {
                    float weight = Float.parseFloat(mWeightInput.getText().toString());
                    AlertDialog.Builder builder = new AlertDialog.Builder(CalculatorActivity.this);
                    builder.setMessage("Weight on " + mSpinner.getSelectedItem().toString() + " is " + weight)
                            .setTitle("Weight on " + mSpinner.getSelectedItem().toString());
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}
