package androidminiapp_tre7ca_ww6vh.androidminiapp_tre7ca_ww6vh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

import android.app.usage.NetworkStats;
import android.util.Log;

/**
 * Code adapted from Professor Sheriff's ListExample code
 */

public class BucketItem implements Comparable<BucketItem>{
    private String mName;
    private String mDescription;
    private double mLatitude;
    private double mLongitude;
    private boolean mCompleted;
    private String mMonth;
    private String mDay;
    private String mYear;
    private String tDate;

    public BucketItem(String name, String description, double latitude, double longitude,
                      boolean completed, String date) {
        mName = name;
        mDescription = description;
        mLatitude = latitude;
        mLongitude = longitude;
        mCompleted = completed;
        tDate = date;
        String[] dateComps = tDate.split("-");
        mMonth = dateComps[0];
        mDay = dateComps[1];
        mYear = dateComps[2];

    }

    public String getName() {
        return mName;
    }

    public String getmDescription() {return mDescription;}

    public double getmLatitude() {return mLatitude;}

    public double getmLongitude() {return mLongitude;}

    public boolean isCompleted() {
        return mCompleted;
    }

    public String gettDate() {return tDate;}

    public String getmMonth() {return mMonth;}

    public String getmDay() {return mDay;}

    public String getmYear() {return mYear;}

    public void setName(String str) { mName = str;}

    public void setDescription (String str) {mDescription = str;}

    public void setLatitude (Double dble) {mLatitude = dble;}

    public void setLongitude (Double dble) {mLongitude = dble;}

    public void setDate (String str) {
        tDate = str;
        String[] dateComps = tDate.split("-");
        mMonth = dateComps[0];
        mDay = dateComps[1];
        mYear = dateComps[2];
    }

    public void setmCompleted(Boolean done) {
        mCompleted = done;
    }

    private static int lastBucketItemId = 0;

/*    public static ArrayList<BucketItem> createBucketItemList(int numBucketItems) {
        ArrayList<BucketItem> bucketItems = new ArrayList<BucketItem>();
        String description = "";
        double latitude = 0.0;
        double longitude = 0.0;
        Boolean completed = Boolean.FALSE;

        for (int i = 1; i <= numBucketItems; i++) {
            bucketItems.add(new BucketItem("BucketItem " + ++lastBucketItemId, description, latitude, longitude, completed));
        }

        return bucketItems;
    }*/



    public static ArrayList<BucketItem> createInitialBucketList(){
        ArrayList<BucketItem> bucketItems = new ArrayList<BucketItem>();

        String name1 = "steam tunneling";
        String desc1 = "adventure in the steam tunnels";
        double lat1 = 38.0336;
        double lon1 = 78.5080;
        Boolean comp1 = Boolean.FALSE;
        String name2 = "lighting of the lawn";
        String desc2 = "see the lightshow and acappella at lighting of the lawn";
        double lat2 = 38.0336;
        double lon2 = 78.5080;
        String dat1 = "12-01-1995";
        String dat2 = "01-02-2017";

        bucketItems.add(new BucketItem(name1, desc1, lat1, lon1, comp1, dat1));
        bucketItems.add(new BucketItem(name2, desc2, lat2, lon2, comp1, dat2));
        Collections.sort(bucketItems);
        return bucketItems;
    }

    @Override
    public int compareTo(BucketItem B2) {
        if(this.isCompleted() && !B2.isCompleted())
            return 1;
        else if(!this.isCompleted() && B2.isCompleted())
            return -1;
        else {
            if (Integer.parseInt(this.mYear) > Integer.parseInt(B2.mYear))
                return 1;
            else if (Integer.parseInt(this.mYear) < Integer.parseInt(B2.mYear))
                return -1;
            else {
                if (Integer.parseInt(this.mMonth) > Integer.parseInt(B2.mMonth))
                    return 1;
                else if (Integer.parseInt(this.mMonth) < Integer.parseInt(B2.mMonth))
                    return -1;
                else {
                    if (Integer.parseInt(this.mDay) > Integer.parseInt(B2.mDay))
                        return 1;
                    else if (Integer.parseInt(this.mDay) < Integer.parseInt(B2.mDay))
                        return -1;
                    else
                        return 0;
                }
            }
        }
    }
}