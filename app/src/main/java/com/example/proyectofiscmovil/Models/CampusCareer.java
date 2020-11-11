package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class CampusCareer implements Parcelable {
    private int _Id;
    private int CampusId;
    private int CareerId;

    public CampusCareer(int _id, int campusId, int careerId)
    {
        set_Id(_id);
        setCampusId(campusId);
        setCareerId(careerId);
    }

    protected CampusCareer(Parcel in) {
        _Id = in.readInt();
        CampusId = in.readInt();
        CareerId = in.readInt();
    }

    public static final Creator<CampusCareer> CREATOR = new Creator<CampusCareer>() {
        @Override
        public CampusCareer createFromParcel(Parcel in) {
            return new CampusCareer(in);
        }

        @Override
        public CampusCareer[] newArray(int size) {
            return new CampusCareer[size];
        }
    };

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public int getCampusId() {
        return CampusId;
    }

    public void setCampusId(int campusId) {
        CampusId = campusId;
    }

    public int getCareerId() {
        return CareerId;
    }

    public void setCareerId(int careerId) {
        CareerId = careerId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_Id);
        dest.writeInt(CampusId);
        dest.writeInt(CareerId);
    }
}
