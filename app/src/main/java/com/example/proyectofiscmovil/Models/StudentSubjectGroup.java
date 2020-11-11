package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class StudentSubjectGroup implements Parcelable {
    private int _Id;
    private int StudentId;
    private int SubjectId;
    private int GroupId;
    private String Semester;
    private int Year;

    public StudentSubjectGroup(int _Id, int studentId,int subjectId,int groupId, String semester, int year)
    {
        set_Id(_Id);
        setStudentId(studentId);
        setSubjectId(subjectId);
        setGroupId(groupId);
        setSemester(semester);
        setYear(year);
    }

    protected StudentSubjectGroup(Parcel in) {
        set_Id(in.readInt());
        StudentId = in.readInt();
        SubjectId = in.readInt();
        GroupId = in.readInt();
        Semester = in.readString();
        Year = in.readInt();
    }

    public static final Creator<StudentSubjectGroup> CREATOR = new Creator<StudentSubjectGroup>() {
        @Override
        public StudentSubjectGroup createFromParcel(Parcel in) {
            return new StudentSubjectGroup(in);
        }

        @Override
        public StudentSubjectGroup[] newArray(int size) {
            return new StudentSubjectGroup[size];
        }
    };

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    public int getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(int subjectId) {
        SubjectId = subjectId;
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
        dest.writeInt(get_Id());
        dest.writeInt(StudentId);
        dest.writeInt(SubjectId);
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
