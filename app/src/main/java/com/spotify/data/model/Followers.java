package com.spotify.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import static com.spotify.data.api.Constants.Serialized.HREF;
import static com.spotify.data.api.Constants.Serialized.TOTAL;

/**
 * Created by tecnosim on 1/15/2018.
 */

public class Followers implements Parcelable{

    public static final Creator<Followers> CREATOR = new Creator<Followers>() {
        @Override
        public Followers createFromParcel(Parcel in) {
            return new Followers(in);
        }

        @Override
        public Followers[] newArray(int size) {
            return new Followers[size];
        }
    };

    @SerializedName(HREF) private String href;
    @SerializedName(TOTAL) private int totalFollowers;

    private Followers(Parcel in) {
      this.href = in.readString();
      this.totalFollowers = in.readInt();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.href);
      dest.writeInt(this.totalFollowers);
    }
}
