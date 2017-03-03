package androidminiapp_tre7ca_ww6vh.androidminiapp_tre7ca_ww6vh;

/**
 * Code adapted from Professor Sheriff's ListExample code
 * Code adapted from Professor Sheriff's IntentExample code
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

import java.net.URI;

public class BucketListActivity extends AppCompatActivity {

    ArrayList<BucketItem> bucketItems;
    EditText nameField;
    RecyclerView rvBucketItems;
    BucketItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Bucket List");

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        /*
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do something you want
            }
        */
        rvBucketItems = (RecyclerView) findViewById(R.id.rvBucketItems);
        //nameField = (EditText) findViewById(R.id.bucketItemName);
        bucketItems = BucketItem.createInitialBucketList();
        Collections.sort(bucketItems);
        adapter = new BucketItemAdapter(this, bucketItems);
        rvBucketItems.setAdapter(adapter);
        rvBucketItems.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.addBucketItemButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Add a new BucketItem", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                startAddItemActivity(view);
            }
        });
    }

    public void addBucketItem(View view, String description, double latitude, double longitude, Boolean completed, String date) {
        // Make sure it is a name
        if(nameField.getText().toString() != null && !nameField.getText().toString().equals("")) {
            // Log the action
            Log.d("BucketList", "addBucketItem " + nameField.getText().toString());
            // Make a new bucketItem
            bucketItems.add(new BucketItem(nameField.getText().toString(), description, latitude, longitude, completed, date));
            // Get the adapter that manages the data set and let it know something new was added
            rvBucketItems.getAdapter().notifyDataSetChanged();
            // Blank the name field
            nameField.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bucket_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if(resultCode == AddItemActivity.RESULT_OK) {
                Log.d("MyApp", "Name: " + data.getStringExtra("Name"));
                String sName = data.getStringExtra("Name");
                String sDescrip = data.getStringExtra("Desc");
                double sLat =  Double.parseDouble(data.getStringExtra("Lat"));
                double sLong = Double.parseDouble(data.getStringExtra("Long"));
                String sDate = data.getStringExtra("Date");
                BucketItem A = new BucketItem(sName, sDescrip, sLat, sLong, Boolean.FALSE, sDate);
                bucketItems.add(A);
                Collections.sort(bucketItems);
                adapter.notifyDataSetChanged();
            }
        }
        if(resultCode == 2) {
            if(resultCode == EditItemActivity.RESULT_OK) {
                Log.d("MyApp", "Name: " + data.getStringExtra("Name"));
                String sName = data.getStringExtra("Name");
                String sDescrip = data.getStringExtra("Desc");
                double sLat =  Double.parseDouble(data.getStringExtra("Lat"));
                double sLong = Double.parseDouble(data.getStringExtra("Long"));
                String sDate = data.getStringExtra("Date");

                //BucketItem A = new BucketItem(sName, sDescrip, sLat, sLong, Boolean.FALSE, sDate);
                //bucketItems.add(A);
                adapter.notifyDataSetChanged();
            }
        }
    }

    public void startAddItemActivity(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivityForResult(intent, 1);
    }

}
