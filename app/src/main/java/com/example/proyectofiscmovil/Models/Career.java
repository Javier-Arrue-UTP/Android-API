package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Career implements Parcelable {
    private int _Id;
    private int Id;
    private String Name;

    public Career(int _Id, int id, String name)
    {
        set_Id(_Id);
        setId(id);
        setName(name);
    }

    protected Career(Parcel in) {
        set_Id(in.readInt());
        Id = in.readInt();
        Name = in.readString();
    }

    public static final Creator<Career> CREATOR = new Creator<Career>() {
        @Override
        public Career createFromParcel(Parcel in) {
            return new Career(in);
        }

        @Override
        public Career[] newArray(int size) {
            return new Career[size];
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
            throw new IllegalArgumentException("El nombre de la carrera no puede ser vacio.");
        }
        Name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(get_Id());
        dest.writeInt(Id);
        dest.writeString(Name);
    }
}
