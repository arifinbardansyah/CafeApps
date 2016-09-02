package com.cafeapps.model;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<String> latitude = new ArrayList<String>();
    private List<String> longitude = new ArrayList<String>();

    public List<String> getLatitude() {
        return latitude;
    }

    public void setLatitude(List<String> latitude) {
        this.latitude = latitude;
    }

    public List<String> getLongitude() {
        return longitude;
    }

    public void setLongitude(List<String> longitude) {
        this.longitude = longitude;
    }
}
