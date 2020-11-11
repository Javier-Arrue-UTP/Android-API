package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class CareerSubject implements Parcelable {
    private int _Id;
    private int CareerId;
    private int SubjectId;
    private int Year;
    private String Semester;

    public CareerSubject(int _Id, int careerId, int subjectId, int year, String semester)
    {
        set_Id(_Id);
        setCareerId(careerId);
        setSubjectId(subjectId);
        setYear(year);
        setSemester(semester);
    }

    protected CareerSubject(Parcel in) {
        set_Id(in.readInt());
        CareerId = in.readInt();
        SubjectId = in.readInt();
        Year = in.readInt();
        Semester = in.readString();
    }

    public static final Creator<CareerSubject> CREATOR = new Creator<CareerSubject>() {
        @Override
        public CareerSubject createFromParcel(Parcel in) {
            return new CareerSubject(in);
        }

        @Override
        public CareerSubject[] newArray(int size) {
            return new CareerSubject[size];
        }
    };

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public int getCareerId() {
        return CareerId;
    }

    public void setCareerId(int careerId) {
        CareerId = careerId;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        if(semester.trim().equals(""))
        {
            throw new IllegalArgumentException("El semestre no puede ser vacio.");
        }
        Semester = semester;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(get_Id());
        dest.writeInt(CareerId);
        dest.writeInt(SubjectId);
        dest.writeInt(Year);
        dest.writeString(Semester);
    }
}
