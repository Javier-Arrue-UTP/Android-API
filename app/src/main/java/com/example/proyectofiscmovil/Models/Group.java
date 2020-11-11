package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Group implements Parcelable {
    private int _Id;
    private int Id;
    private String Code;
    private int Shift;
    private String Semester;
    private int Year;
    private int CareerId;
    private int CampusId;

    public Group(int id,String code, int shift,String semester, int year, int careerId, int campusId)
    {
        setId(id);
        setCode(code);
        setShift(shift);
        setSemester(semester);
        setYear(year);
        setCareerId(careerId);
        setCampusId(campusId);
    }

    protected Group(Parcel in) {
        _Id = in.readInt();
        setId(in.readInt());
        Code = in.readString();
        Shift = in.readInt();
        Semester = in.readString();
        Year = in.readInt();
        CareerId = in.readInt();
        CampusId = in.readInt();
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel in) {
            return new Group(in);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        if(code.trim().equals(""))
        {
            throw new IllegalArgumentException("El código del grupo no puede ser vacio.");
        }
        Code = code;
    }

    public int getShift() {
        return Shift;
    }

    public void setShift(int shift) {
        Shift = shift;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getCareerId() {
        return CareerId;
    }

    public void setCareerId(int careerId) {
        CareerId = careerId;
    }

    public int getCampusId() {
        return CampusId;
    }

    public void setCampusId(int campusId) {
        CampusId = campusId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_Id);
        dest.writeInt(getId());
        dest.writeString(Code);
        dest.writeInt(Shift);
        dest.writeString(Semester);
        dest.writeInt(Year);
        dest.writeInt(CareerId);
        dest.writeInt(CampusId);
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
