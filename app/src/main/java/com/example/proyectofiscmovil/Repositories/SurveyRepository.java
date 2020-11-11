package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.Role;
import com.example.proyectofiscmovil.Models.Survey;
import com.example.proyectofiscmovil.Models.Subjects;

import java.util.List;

import javax.security.auth.Subject;

public class SurveyRepository {
    private static SurveyRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private SurveyRepository(){}

    public static SurveyRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new SurveyRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<Survey> GetAllSurvey() {
        List<Survey> surveyList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SurveyEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_ID + ", " +
                        SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_TITLE +
                        " FROM " +  SurveyDatabaseContract.SurveyEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        Survey survey = new Survey(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_TITLE)));
                        surveyList.add(survey);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return surveyList;
    }

    public Survey GetSurvey(int surveyId) {
        Survey survey = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SurveyEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_ID + ", " +
                        SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_TITLE +
                        " FROM " +  SurveyDatabaseContract.SurveyEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_ID + " = " + String.valueOf(surveyId);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        survey = new Survey(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_TITLE)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return survey;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.SurveyEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(Survey survey)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_ID,survey.getId());
        contentValues.put(SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_TITLE,survey.getTitle());

        db.insert(SurveyDatabaseContract.SurveyEntry.TABLE_NAME,null, contentValues);
    }
}
