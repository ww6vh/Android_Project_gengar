package androidminiapp_tre7ca_ww6vh.androidminiapp_tre7ca_ww6vh;

import java.util.ArrayList;

/**
 * Code adapted from Professor Sheriff's ListExample code
 */

public class BucketItem {
    private String mName;
    private String mDescription;
    private double mLatitude;
    private double mLongitude;
    private boolean mCompleted;

    public BucketItem(String name, String description, double latitude, double longitude,
                      boolean completed) {
        mName = name;
        mDescription = description;
        mLatitude = latitude;
        mLongitude = longitude;
        mCompleted = completed;
    }

    public String getName() {
        return mName;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    private static int lastBucketItemId = 0;

    public static ArrayList<BucketItem> createBucketItemList(int numBucketItems) {
        ArrayList<BucketItem> bucketItems = new ArrayList<BucketItem>();
        String description = "";
        double latitude = 0.0;
        double longitude = 0.0;
        Boolean completed = Boolean.FALSE;

        for (int i = 1; i <= numBucketItems; i++) {
            bucketItems.add(new BucketItem("BucketItem " + ++lastBucketItemId, description, latitude, longitude, completed));
        }

        return bucketItems;
    }
}