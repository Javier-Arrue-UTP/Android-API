package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Campus implements Parcelable {
    private int _Id;
    private int Id;
    private String Name;

    public Campus(int _id, int id, String name)
    {
        set_Id(_id);
        setId(id);
        setName(name);
    }

    protected Campus(Parcel in) {
        _Id = in.readInt();
        Id = in.readInt();
        Name = in.readString();
    }

    public static final Creator<Campus> CREATOR = new Creator<Campus>() {
        @Override
        public Campus createFromParcel(Parcel in) {
            return new Campus(in);
        }

        @Override
        public Campus[] newArray(int size) {
            return new Campus[size];
        }
    };

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if(name.trim().equals(""))
        {
            throw new IllegalArgumentException("El nombre de la sede no puede ser vacio.");
        }
        Name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_Id);
        dest.writeInt(Id);
        dest.writeString(Name);
    }
}
