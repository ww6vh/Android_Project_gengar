package androidminiapp_tre7ca_ww6vh.androidminiapp_tre7ca_ww6vh;

/**
 * Code adapted from Professor Sheriff's ListExample code
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class BucketItemAdapter extends
        RecyclerView.Adapter<BucketItemAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public CheckBox checked;
        public TextView dateTextView;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.bucketItem_name);
            //dateTextView = (TextView) itemView.findViewById(R.id.datePicker2);
            checked = (CheckBox) itemView.findViewById(R.id.checkBox);

        }
    }

    // Store a member variable for the contacts
    private List<BucketItem> mBucketItems;
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
    @Override
    public BucketItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View bucketItemView = inflater.inflate(R.layout.content_bucket_list, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(bucketItemView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(BucketItemAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        BucketItem bucketItem = mBucketItems.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(bucketItem.getName());
        if(!bucketItem.isCompleted()) {
            textView.setClickable(false);
            textView.setActivated(false);
            textView.setEnabled(false);

        }
        
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        Log.d("test", mBucketItems.size()+"");
        return mBucketItems.size();
    }
}