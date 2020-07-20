package com.example.movie_project2.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "movietable")
public class FavouriteMovie implements Parcelable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movie")
    private String moviename;
    @NonNull
    private String url;
    private String description;
    public String rdate;
    private float rating;
   @Ignore
    protected FavouriteMovie(Parcel in) {
        moviename = in.readString();
        url = in.readString();
        description = in.readString();
        rdate = in.readString();
        rating = in.readFloat();
        ytid = in.readString();
    }
    @Ignore
    public static final Creator<FavouriteMovie> CREATOR = new Creator<FavouriteMovie>() {
        @Override
        public FavouriteMovie createFromParcel(Parcel in) {
            return new FavouriteMovie(in);
        }

        @Override
        public FavouriteMovie[] newArray(int size) {
            return new FavouriteMovie[size];
        }
    };

    @NonNull
    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(@NonNull String moviename) {
        this.moviename = moviename;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    public void setUrl(@NonNull String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getYtid() {
        return ytid;
    }

    public void setYtid(String ytid) {
        this.ytid = ytid;
    }

    public FavouriteMovie(@NonNull String moviename, @NonNull String url, String description, String rdate, float rating, String ytid) {
        this.moviename = moviename;
        this.url = url;
        this.description = description;
        this.rdate = rdate;
        this.rating = rating;
        this.ytid = ytid;
    }
     @Ignore
    public FavouriteMovie() {
    }

    private String ytid;

    @Ignore
    @Override
    public int describeContents() {
        return 0;
    }
    @Ignore
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(moviename);
        parcel.writeString(url);
        parcel.writeString(description);
        parcel.writeString(rdate);
        parcel.writeFloat(rating);
        parcel.writeString(ytid);
    }
}
