/**
 * Code adapted from Professor Sheriff's IntentExample code
 */

package androidminiapp_tre7ca_ww6vh.androidminiapp_tre7ca_ww6vh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyApp", "onCreate Add");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

    public void addItem(View view) {
        EditText eName = (EditText) findViewById(R.id.eName);
        EditText eDescrip = (EditText) findViewById(R.id.eDescrip);
        EditText eLat = (EditText) findViewById(R.id.eLat);
        EditText eLong = (EditText) findViewById(R.id.eLong);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker2);

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

        Log.d("MyApp", "sending back " + sName);

        setResult(BucketListActivity.RESULT_OK, sendInput);
        finish();
    }




}
