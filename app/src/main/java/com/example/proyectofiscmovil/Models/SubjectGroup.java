package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class SubjectGroup implements Parcelable {
    private int _Id;
    private int SubjectId;
    private int GroupId;
    private int HourCode;

    public SubjectGroup(int _Id, int subjectId, int groupId, int hourCode)
    {
        set_Id(_Id);
        setSubjectId(subjectId);
        setGroupId(groupId);
        setHourCode(hourCode);
    }

    protected SubjectGroup(Parcel in) {
        set_Id(in.readInt());
        SubjectId = in.readInt();
        GroupId = in.readInt();
        HourCode = in.readInt();
    }

    public static final Creator<SubjectGroup> CREATOR = new Creator<SubjectGroup>() {
        @Override
        public SubjectGroup createFromParcel(Parcel in) {
            return new SubjectGroup(in);
        }

        @Override
        public SubjectGroup[] newArray(int size) {
            return new SubjectGroup[size];
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
        dest.writeInt(SubjectId);
        dest.writeInt(GroupId);
        dest.writeInt(HourCode);
    }

    public int getHourCode() {
        return HourCode;
    }

    public void setHourCode(int hourCode) {
        HourCode = hourCode;
    }
}
