package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.SurveyRespond;
import com.example.proyectofiscmovil.Models.SurveySection;

import java.util.List;

public class SurveySectionRepository {
    private static SurveySectionRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private SurveySectionRepository(){}

    public static SurveySectionRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new SurveySectionRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<SurveySection> GetAllSurveySection() {
        List<SurveySection> surveySectionList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SurveySectionEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_ID + ", " +
                        SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_DESCRIPTION + ", " +
                        SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID +
                        " FROM " +  SurveyDatabaseContract.SurveySectionEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        SurveySection surveySection = new SurveySection(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_DESCRIPTION)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID)));
                        surveySectionList.add(surveySection);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return surveySectionList;
    }

    public SurveySection GetSurveySection(int surveyId) {
        SurveySection surveySection = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SurveySectionEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_ID + ", " +
                        SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_DESCRIPTION + ", " +
                        SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID +
                        " FROM " +  SurveyDatabaseContract.SurveySectionEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID + " = " + String.valueOf(surveyId);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        surveySection = new SurveySection(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_DESCRIPTION)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return surveySection;
    }

    public SurveySection GetSurveySection(int surveyId, int surveySectionId) {
        SurveySection surveySection = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SurveySectionEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_ID + ", " +
                        SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_DESCRIPTION + ", " +
                        SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID +
                        " FROM " +  SurveyDatabaseContract.SurveySectionEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID + " = " + String.valueOf(surveyId) +
                        " AND " + SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_ID + " = " + String.valueOf(surveySectionId);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        surveySection = new SurveySection(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_DESCRIPTION)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return surveySection;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.SurveySectionEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(SurveySection surveySection)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_ID,surveySection.getId());
        contentValues.put(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_DESCRIPTION,surveySection.getDescription());
        contentValues.put(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID,surveySection.getSurveyId());
        db.insert(SurveyDatabaseContract.SurveySectionEntry.TABLE_NAME,null, contentValues);
    }
}
