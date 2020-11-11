package com.example.proyectofiscmovil.Models;
import android.os.Parcel;
import android.os.Parcelable;

public class Survey implements Parcelable {
    private int _Id;
    private int Id;
    private String Title;

    public Survey(int _id, int id, String title)
    {
        set_Id(_id);
        setId(id);
        setTitle(title);
    }

    protected Survey(Parcel in) {
        _Id = in.readInt();
        Id = in.readInt();
        Title = in.readString();
    }

    public static final Creator<Survey> CREATOR = new Creator<Survey>() {
        @Override
        public Survey createFromParcel(Parcel in) {
            return new Survey(in);
        }

        @Override
        public Survey[] newArray(int size) {
            return new Survey[size];
        }
    };

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        if(title.trim().equals(""))
        {
            throw new IllegalArgumentException("El titulo de la encuesta no puede ser vacio.");
        }
        Title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_Id);
        dest.writeInt(Id);
        dest.writeString(Title);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
