package com.example.plantapi;

import android.os.Parcel;
import android.os.Parcelable;

public class Plants implements Parcelable {

    String name;

    public Plants(String name) {
        this.name = name;
    }



    protected Plants(Parcel in) {

        name = in.readString();
    }

    public static final Creator<Plants> CREATOR = new Creator<Plants>() {
        @Override
        public Plants createFromParcel(Parcel in) {
            return new Plants(in);
        }

        @Override
        public Plants[] newArray(int size) {
            return new Plants[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(name);
    }
}
