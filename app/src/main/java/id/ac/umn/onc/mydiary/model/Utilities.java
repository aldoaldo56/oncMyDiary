package id.ac.umn.onc.mydiary.model;

import android.content.Context;

/**
 * Created by aldo_ on 18/04/2017.
 */

public class Utilities {
    public static int pxToDp(Context c, int px){
        float density = c.getResources().getDisplayMetrics().density;
        int paddingDp = (int)(px * density);
        return paddingDp;
    };
}
