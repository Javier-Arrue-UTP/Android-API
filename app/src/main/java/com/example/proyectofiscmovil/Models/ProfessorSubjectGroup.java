package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class ProfessorSubjectGroup implements Parcelable {
    private int _Id;
    private int ProfessorId;
    private int SubjectId;
    private int GroupId;
    private String Semester;
    private int Year;

    public ProfessorSubjectGroup(int professorId, int subjectId, int groupId, String semester, int year)
    {
        setProfessorId(professorId);
        setSubjectId(subjectId);
        setGroupId(groupId);
        setSemester(semester);
        setYear(year);
    }

    protected ProfessorSubjectGroup(Parcel in) {
        _Id = in.readInt();
        SubjectId = in.readInt();
        ProfessorId = in.readInt();
        GroupId = in.readInt();
        Semester = in.readString();
        Year = in.readInt();
    }

    public static final Creator<ProfessorSubjectGroup> CREATOR = new Creator<ProfessorSubjectGroup>() {
        @Override
        public ProfessorSubjectGroup createFromParcel(Parcel in) {
            return new ProfessorSubjectGroup(in);
        }

        @Override
        public ProfessorSubjectGroup[] newArray(int size) {
            return new ProfessorSubjectGroup[size];
        }
    };

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
    }

    public int getProfessorId() {
        return ProfessorId;
    }

    public void setProfessorId(int professorId) {
        ProfessorId = professorId;
    }

    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupId) {
        GroupId = groupId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_Id);
        dest.writeInt(SubjectId);
        dest.writeInt(ProfessorId);
        dest.writeInt(GroupId);
        dest.writeString(Semester);
        dest.writeInt(Year);
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
