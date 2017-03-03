package androidminiapp_tre7ca_ww6vh.androidminiapp_tre7ca_ww6vh;

/**
 * Code adapted from Professor Sheriff's ListExample code
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Collections;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class  BucketItemAdapter extends
        RecyclerView.Adapter<BucketItemAdapter.ViewHolder> {

    private BucketItem bucket;
    // Store a member variable for the contacts
    public List<BucketItem> mBucketItems;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public BucketItemAdapter(Context context, List<BucketItem> bucketItems) {
        mBucketItems = bucketItems;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    // Usually involves inflating a layout from XML and returning the holder

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public CheckBox checked;
        public TextView dateTextView;
        //private BucketItem currBuck;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView, BucketItem bucket) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.bucket_name);
            dateTextView = (TextView) itemView.findViewById(R.id.bucketDate);
            checked = (CheckBox) itemView.findViewById(R.id.checkBox);
            nameTextView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

        }

    }

    @Override
    public BucketItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View bucketItemView = inflater.inflate(R.layout.content_bucket_list, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(bucketItemView, bucket);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(BucketItemAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final BucketItem bucketItem = mBucketItems.get(position);
        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(bucketItem.getName());
        Log.d("This is the date, ", bucketItem.gettDate());
        viewHolder.dateTextView.setText(bucketItem.gettDate());
        if(!bucketItem.isCompleted()) {
            textView.setClickable(true);
            textView.setActivated(true);
            textView.setEnabled(true);

        }
        viewHolder.checked.setOnCheckedChangeListener(null);
        viewHolder.checked.setChecked(bucketItem.isCompleted());
        viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                bucketItem.setmCompleted(!bucketItem.isCompleted());
                Collections.sort(mBucketItems);
                notifyDataSetChanged();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                Intent mIntent = new Intent(mContext, EditItemActivity.class);
                Log.d("BucketList", "" + bucketItem.getmLatitude());
                mIntent.putExtra("eName", bucketItem.getName());
                mIntent.putExtra("eDesc", bucketItem.getmDescription());
                mIntent.putExtra("eLat", bucketItem.getmLatitude());
                mIntent.putExtra("eLong", bucketItem.getmLongitude());
                mIntent.putExtra("eDate", bucketItem.gettDate());
                ((BucketListActivity)mContext).startActivityForResult(mIntent, 2);

            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        Log.d("test", mBucketItems.size() + "");
        return mBucketItems.size();
    }


}