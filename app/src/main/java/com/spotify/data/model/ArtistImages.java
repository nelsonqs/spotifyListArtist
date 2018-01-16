package com.spotify.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import static com.spotify.data.api.Constants.Serialized.HEIGHT;
import static com.spotify.data.api.Constants.Serialized.URL;
import static com.spotify.data.api.Constants.Serialized.WIDTH;

/**
 * Created by tecnosim on 1/15/2018.
 */

public class ArtistImages implements Parcelable {

    public static final Creator<ArtistImages> CREATOR = new Creator<ArtistImages>() {
        public ArtistImages createFromParcel(Parcel in) {
            return new ArtistImages(in);
        }
        public ArtistImages[] newArray(int size) {
            return new ArtistImages[size];
        }
    };

    @SerializedName(HEIGHT) private int height;
    @SerializedName(URL) public String url;
    @SerializedName(WIDTH) private int width;

    protected ArtistImages(Parcel in) {
       this.height = in.readInt();
       this.url = in.readString();
       this.width = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.height);
        dest.writeString(this.url);
        dest.writeInt(this.width);
    }
}
