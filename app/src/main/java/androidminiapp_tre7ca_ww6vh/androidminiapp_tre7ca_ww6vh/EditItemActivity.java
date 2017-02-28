package androidminiapp_tre7ca_ww6vh.androidminiapp_tre7ca_ww6vh;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Intent intent = getIntent();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        EditText name = (EditText) findViewById(R.id.editName);
        EditText description = (EditText) findViewById(R.id.editDescrip);
        EditText longitude = (EditText) findViewById(R.id.editLong);
        EditText Latitude = (EditText) findViewById(R.id.editLat);
        DatePicker date = (DatePicker) findViewById(R.id.editdatePicker2);

        name.setText(intent.getStringExtra("Name"));
        description.setText(intent.getStringExtra("Desc"));
        longitude.setText(intent.getStringExtra("Lat"));
        Latitude.setText(intent.getStringExtra("Long"));
        //date.updateDate();
        //date.updateDate(intent.get); = data.getStringExtra("Date");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
