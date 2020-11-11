package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.SurveyRespond;

import java.util.List;

public class SurveyRespondRepository {

    private static SurveyRespondRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private SurveyRespondRepository(){}

    public static SurveyRespondRepository getInstance(SurveyDBHelper dbHelper){
        if(ourInstance == null) {
            ourInstance = new SurveyRespondRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }


    public List<SurveyRespond> GetAllRespondSurvey() {
        List<SurveyRespond> respondList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SurveyRespondEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_USER_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SURVEY_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_QUESTION_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_OPTION_ID +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SUBJECT_ID +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_GROUP_ID +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SEMESTER +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_YEAR +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_DESCRIPTION +
                        " FROM " +  SurveyDatabaseContract.SurveyRespondEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        SurveyRespond respond = new SurveyRespond(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_USER_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SURVEY_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_QUESTION_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_OPTION_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SUBJECT_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_GROUP_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SEMESTER)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_YEAR)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_DESCRIPTION))
                        );
                        respondList.add(respond);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return respondList;
    }


    public List<SurveyRespond> GetBySubAnswersCod(int id_resp, int id_users, int id_survey, int id_answer, int id_option, int id_group) {
        List<SurveyRespond> respondList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SurveyRespondEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_USER_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SURVEY_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_QUESTION_ID + ", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_OPTION_ID +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SUBJECT_ID +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_GROUP_ID +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SEMESTER +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_YEAR +", " +
                        SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_DESCRIPTION +
                        " FROM " +  SurveyDatabaseContract.ProfessorSubjectGroupEntry.TABLE_NAME +
                        " WHERE COLUMN_SURVEY_RESPOND_ID='"+id_resp+"'"+" AND COLUMN_SURVEY_RESPOND_USER_ID='"+id_users
                        +"'"+" AND COLUMN_SURVEY_RESPOND_SURVEY_ID='"+id_survey+"'"+" AND COLUMN_SURVEY_RESPOND_QUESTION_ID='"+id_answer+"'"
                        +" AND COLUMN_SURVEY_RESPOND_OPTION_ID='"+id_option+"'"+" AND COLUMN_SURVEY_RESPOND_GROUP_ID='"+id_group+"'";
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        SurveyRespond respond = new SurveyRespond(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_USER_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SURVEY_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_QUESTION_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_OPTION_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SUBJECT_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_GROUP_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SEMESTER)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_YEAR)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_DESCRIPTION))
                        );
                        respondList.add(respond);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return respondList;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.SurveyRespondEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(SurveyRespond surveyRespond)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_ID,surveyRespond.getId());
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_USER_ID,surveyRespond.getUserId());
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SURVEY_ID,surveyRespond.getSurveyId());
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_QUESTION_ID,surveyRespond.getSurveyQuestionId());
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_OPTION_ID,surveyRespond.getSurveyQuestionOptionId());
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SUBJECT_ID,surveyRespond.getSubjectId());
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_GROUP_ID,surveyRespond.getGroupId());
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SEMESTER,surveyRespond.getSemester());
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_YEAR,surveyRespond.getYear());
        contentValues.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_DESCRIPTION,surveyRespond.getDescription());

        db.insert(SurveyDatabaseContract.SurveyRespondEntry.TABLE_NAME,null, contentValues);
    }
}
