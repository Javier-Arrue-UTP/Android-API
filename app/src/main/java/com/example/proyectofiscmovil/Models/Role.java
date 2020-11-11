package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Role implements Parcelable {
    private int _Id;
    private int Id;
    private String Name;

    public Role(int _id, int id, String name)
    {
        set_Id(_id);
        setId(id);
        setName(name);
    }

    protected Role(Parcel in) {
        _Id = in.readInt();
        Id = in.readInt();
        Name = in.readString();
    }

    public static final Creator<Role> CREATOR = new Creator<Role>() {
        @Override
        public Role createFromParcel(Parcel in) {
            return new Role(in);
        }

        @Override
        public Role[] newArray(int size) {
            return new Role[size];
        }
    };

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
        Name = name;
    }
}
