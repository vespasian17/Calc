package ru.startandroid.programcalc;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.balysv.materialripple.MaterialRippleLayout;

import org.mariuszgromada.math.mxparser.Expression;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener{

    Toolbar toolbar;
    Spinner spinnerBases;
    SwitchCompat switchCalc;

    FragmentManager fragManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerBases = (Spinner)findViewById(R.id.spinnerBases);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bases, R.layout.my_spinner_item);
        adapter.setDropDownViewResource(R.layout.my_spinner_item);
        spinnerBases.setAdapter(adapter);
        spinnerBases.setOnItemSelectedListener(this);

        switchCalc = (SwitchCompat)findViewById(R.id.switchCompat);
        switchCalc.setOnCheckedChangeListener(this);

        if(switchCalc.isChecked()){
            spinnerBases.setVisibility(View.VISIBLE);
        }else{
            spinnerBases.setVisibility(View.GONE);
        }

        fragManager = getSupportFragmentManager();
        Fragment fragment = fragManager.findFragmentById(R.id.fragmentContainer);
        if(fragment == null){
            IngenerFragment ingFragment = new IngenerFragment();
            fragManager.beginTransaction()
                        .add(R.id.fragmentContainer, ingFragment)
                        .commit();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            Log.d("onCheckedChanged", "isChecked");
            fragManager.beginTransaction()
                    .replace(R.id.fragmentContainer, ProgramFragment.newInstance("BIN"))
                    .commit();
            spinnerBases.setVisibility(View.VISIBLE);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            Log.d("onCheckedChanged", "notChecked");
            fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, new IngenerFragment())
                        .commit();
            spinnerBases.setVisibility(View.GONE);
            spinnerBases.setSelection(0);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(spinnerBases.getSelectedItem().toString()){
            case "BIN":
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ProgramFragment.newInstance("BIN"))
                        .commit();
                break;
            case "OCT":
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ProgramFragment.newInstance("OCT"))
                        .commit();
                break;
            case "DEC":
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ProgramFragment.newInstance("DEC"))
                        .commit();
                break;
            case "HEX":
                fragManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ProgramFragment.newInstance("HEX"))
                        .commit();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
