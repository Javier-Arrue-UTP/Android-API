package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class SurveySection implements Parcelable {
    private int _Id;
    private int Id;
    private String Description;
    private int SurveyId;

    public SurveySection(int _id,int id, String description, int surveyId)
    {
        set_Id(_id);
        setId(id);
        setDescription(description);
        setSurveyId(surveyId);
    }

    protected SurveySection(Parcel in) {
        _Id = in.readInt();
        Id = in.readInt();
        Description = in.readString();
        SurveyId = in.readInt();
    }

    public static final Creator<SurveySection> CREATOR = new Creator<SurveySection>() {
        @Override
        public SurveySection createFromParcel(Parcel in) {
            return new SurveySection(in);
        }

        @Override
        public SurveySection[] newArray(int size) {
            return new SurveySection[size];
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getSurveyId() {
        return SurveyId;
    }

    public void setSurveyId(int surveyId) {
        SurveyId = surveyId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_Id);
        dest.writeInt(Id);
        dest.writeString(Description);
        dest.writeInt(SurveyId);
    }
}
