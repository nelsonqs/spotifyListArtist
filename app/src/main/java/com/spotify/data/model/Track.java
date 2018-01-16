package com.spotify.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import static com.spotify.data.api.Constants.Serialized.ALBUM;
import static com.spotify.data.api.Constants.Serialized.NAME;
import static com.spotify.data.api.Constants.Serialized.PREVIEW_URL;
import static com.spotify.data.api.Constants.Serialized.TRACK_NUMBER;

/**
 * Created by tecnosim on 1/15/2018.
 */

public class Track implements Parcelable {

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    @SerializedName(NAME) public String name;
    @SerializedName(PREVIEW_URL) public String preview_url;
    @SerializedName(TRACK_NUMBER) private int track_number;
    @SerializedName(ALBUM) public Album album;


    protected Track(Parcel in) {
        this.name = in.readString();
        this.preview_url = in.readString();
        this.track_number = in.readInt();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.preview_url);
        dest.writeInt(this.track_number);
    }
}
