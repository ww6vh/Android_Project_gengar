package androidminiapp_tre7ca_ww6vh.androidminiapp_tre7ca_ww6vh;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
        EditText longitude = (EditText) findViewById(R.id.edLong);
        EditText latitude = (EditText) findViewById(R.id.edLat);
        DatePicker date = (DatePicker) findViewById(R.id.editdatePicker2);

        name.setText(intent.getStringExtra("eName"));
        description.setText(intent.getStringExtra("eDesc"));
        Log.d("BucketList", "getStringExtra: " + intent.getStringExtra("eLat"));
        Log.d("BucketList", "getDoubleExtra: " + intent.getDoubleExtra("eLat", 0.0));
        longitude.setText("" + intent.getDoubleExtra("eLat", 0.0));
        latitude.setText("" + intent.getDoubleExtra("eLong", 0.0));
        int day = 0;
        int month = 0;
        int year = 0;
        date.updateDate(1995,12,01);
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


    }

    public void editItem(View view) {
        EditText eName = (EditText) findViewById(R.id.editName);
        EditText eDescrip = (EditText) findViewById(R.id.editDescrip);
        EditText eLat = (EditText) findViewById(R.id.edLat);
        EditText eLong = (EditText) findViewById(R.id.edLong);
        DatePicker datePicker = (DatePicker) findViewById(R.id.editdatePicker2);

        String sName = eName.getText().toString();
        String sDescrip = eDescrip.getText().toString();
        String sLat = eLat.getText().toString();
        String sLong = eLong.getText().toString();
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
        String date = month + "-" + day + "-" + year;

        Intent sendInput = new Intent();
        sendInput.putExtra("Name", sName);
        sendInput.putExtra("Desc", sDescrip);
        sendInput.putExtra("Lat", sLat);
        sendInput.putExtra("Long", sLong);
        sendInput.putExtra("Date", date);

        Log.d("MyApp", "sending back " + sLat + " " + sLong);

        setResult(BucketListActivity.RESULT_OK, sendInput);
        finish();
    }

}
