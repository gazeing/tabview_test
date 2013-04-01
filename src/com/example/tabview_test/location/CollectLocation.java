package com.example.tabview_test.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

public class CollectLocation {
	
	
	public Location getLocation(Context context) {  
        LocationManager locMan = (LocationManager) context  
                .getSystemService(Context.LOCATION_SERVICE);  
        if (locMan == null)
        	return null;
        Location location = locMan  
                .getLastKnownLocation(LocationManager.GPS_PROVIDER);  
        if (location == null) {  
            location = locMan  
                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);  
        }  
        return location;  
    }  
	
	public String getLocationString(Context context) {
		return getLocation(context).toString();
	}

}
