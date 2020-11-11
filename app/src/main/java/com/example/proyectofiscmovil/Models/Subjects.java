package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Subjects implements Parcelable {
    private int _Id;
    private int Id;
    private String Name;
    private String Code;

    public Subjects(int _Id, int Id, String name, String code)
    {
        set_Id(_Id);
        setId(Id);
        setName(name);
        setCode(code);
    }

    protected Subjects(Parcel in) {
        set_Id(in.readInt());
        setId(in.readInt());
        Name = in.readString();
        Code = in.readString();
    }

    public static final Creator<Subjects> CREATOR = new Creator<Subjects>() {
        @Override
        public Subjects createFromParcel(Parcel in) {
            return new Subjects(in);
        }

        @Override
        public Subjects[] newArray(int size) {
            return new Subjects[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(get_Id());
        dest.writeInt(getId());
        dest.writeString(Name);
        dest.writeString(Code);
    }

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if(name.trim().equals(""))
        {
            throw new IllegalArgumentException("El nombre de la asignatura no puede ser vacio.");
        }
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        if(code.trim().equals(""))
        {
            throw new IllegalArgumentException("El código de la asignatura no puede ser vacio.");
        }
        Code = code;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
