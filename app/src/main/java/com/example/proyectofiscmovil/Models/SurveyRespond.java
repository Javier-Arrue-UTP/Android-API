package com.example.proyectofiscmovil.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class SurveyRespond implements Parcelable {
    private int _Id;
    private int Id;
    private int UserId;
    private int SurveyId;
    private int SurveyQuestionId;
    private int SurveyQuestionOptionId;
    private int SubjectId;
    private int GroupId;
    private String Semester;
    private int Year;
    private String Description;

    public SurveyRespond(int id, int userId, int surveyId,int surveyQuestionId,int surveyQuestionOptionId,int subjectId,int groupId,String semester,int year, String description)
    {
        setId(id);
        setUserId(userId);
        setSurveyId(surveyId);
        setSurveyQuestionId(surveyQuestionId);
        setSurveyQuestionOptionId(surveyQuestionOptionId);
        setSubjectId(subjectId);
        setGroupId(groupId);
        setSemester(semester);
        setYear(year);
        setDescription(description);
    }

    protected SurveyRespond(Parcel in) {
        _Id = in.readInt();
        Id = in.readInt();
        UserId = in.readInt();
        SurveyId = in.readInt();
        SurveyQuestionId = in.readInt();
        SurveyQuestionOptionId = in.readInt();
        SubjectId = in.readInt();
        GroupId = in.readInt();
        Semester = in.readString();
        Year = in.readInt();
        Description = in.readString();
    }

    public static final Creator<SurveyRespond> CREATOR = new Creator<SurveyRespond>() {
        @Override
        public SurveyRespond createFromParcel(Parcel in) {
            return new SurveyRespond(in);
        }

        @Override
        public SurveyRespond[] newArray(int size) {
            return new SurveyRespond[size];
        }
    };

    public int get_Id() {
        return _Id;
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        if(description.trim().equals(""))
        {
            throw new IllegalArgumentException("La descripción de la respuesta no puede ser vacio.");
        }
        Description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getSurveyId() {
        return SurveyId;
    }

    public void setSurveyId(int surveyId) {
        SurveyId = surveyId;
    }

    public int getSurveyQuestionId() {
        return SurveyQuestionId;
    }

    public void setSurveyQuestionId(int surveyQuestionId) {
        SurveyQuestionId = surveyQuestionId;
    }

    public int getSurveyQuestionOptionId() {
        return SurveyQuestionOptionId;
    }

    public void setSurveyQuestionOptionId(int surveyQuestionOptionId) {
        SurveyQuestionOptionId = surveyQuestionOptionId;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_Id);
        dest.writeInt(Id);
        dest.writeInt(UserId);
        dest.writeInt(SurveyId);
        dest.writeInt(SurveyQuestionId);
        dest.writeInt(SurveyQuestionOptionId);
        dest.writeInt(SubjectId);
        dest.writeInt(GroupId);
        dest.writeString(Semester);
        dest.writeInt(Year);
        dest.writeString(Description);
    }
}
