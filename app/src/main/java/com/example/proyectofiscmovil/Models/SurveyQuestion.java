package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

//TODO: Consultar el tipo del campo TypeSurveyQuestion

public class SurveyQuestion implements Parcelable {
    private int _Id;
    private int Id;
    private int SurveyId;
    private String Description;
    private String SurveyQuestionCode;
    private int SectionId;

    public SurveyQuestion(int surveyId, String description, String surveyQuestionCode)
    {
        setSurveyId(surveyId);
        setDescription(description);
        setSurveyQuestionCode(surveyQuestionCode);
    }

    protected SurveyQuestion(Parcel in) {
        _Id = in.readInt();
        Id = in.readInt();
        SurveyId = in.readInt();
        Description = in.readString();
        SurveyQuestionCode = in.readString();
        SectionId = in.readInt();
    }

    public static final Creator<SurveyQuestion> CREATOR = new Creator<SurveyQuestion>() {
        @Override
        public SurveyQuestion createFromParcel(Parcel in) {
            return new SurveyQuestion(in);
        }

        @Override
        public SurveyQuestion[] newArray(int size) {
            return new SurveyQuestion[size];
        }
    };

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public int getSurveyId() {
        return SurveyId;
    }

    public void setSurveyId(int surveyId) {
        SurveyId = surveyId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        if(description.trim().equals(""))
        {
            throw new IllegalArgumentException("La descripción de la pregunta no puede ser vacio.");
        }
        Description = description;
    }

    public String getSurveyQuestionCode() {
        return SurveyQuestionCode;
    }

    public void setSurveyQuestionCode(String surveyQuestionCode) {
        SurveyQuestionCode = surveyQuestionCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_Id);
        dest.writeInt(Id);
        dest.writeInt(SurveyId);
        dest.writeString(Description);
        dest.writeString(SurveyQuestionCode);
        dest.writeInt(SectionId);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getSectionId() {
        return SectionId;
    }

    public void setSectionId(int sectionId) {
        SectionId = sectionId;
    }
}
