package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class SurveyQuestionOption implements Parcelable {
    private int _Id;
    private int Id;
    private String Description;
    private int SurveyQuestionId;

    public  SurveyQuestionOption(int id, String description, int surveyQuestionId)
    {
        set_Id(id);
        setDescription(description);
        setSurveyQuestionId(surveyQuestionId);
    }

    protected SurveyQuestionOption(Parcel in) {
        _Id = in.readInt();
        Id = in.readInt();
        Description = in.readString();
        SurveyQuestionId = in.readInt();
    }

    public static final Creator<SurveyQuestionOption> CREATOR = new Creator<SurveyQuestionOption>() {
        @Override
        public SurveyQuestionOption createFromParcel(Parcel in) {
            return new SurveyQuestionOption(in);
        }

        @Override
        public SurveyQuestionOption[] newArray(int size) {
            return new SurveyQuestionOption[size];
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

    public int getSurveyQuestionId() {
        return SurveyQuestionId;
    }

    public void setSurveyQuestionId(int surveyQuestionId) {
        SurveyQuestionId = surveyQuestionId;
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
        dest.writeInt(SurveyQuestionId);
    }
}
