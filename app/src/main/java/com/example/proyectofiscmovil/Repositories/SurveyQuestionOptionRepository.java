package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.SurveyQuestionOption;

import java.util.List;

public class SurveyQuestionOptionRepository {

    private static SurveyQuestionOptionRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private SurveyQuestionOptionRepository(){}

    public static SurveyQuestionOptionRepository getInstance(SurveyDBHelper dbHelper){
        if(ourInstance == null) {
            ourInstance = new SurveyQuestionOptionRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<SurveyQuestionOption> GetAllSurveyOption() {
        List<SurveyQuestionOption> SurveyList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_OPTION_ID + ", " +
                        SurveyDatabaseContract.SurveyQuestionOptionEntry. COLUMN_SURVEY_QUESTION_OPTION_QUESTION_ID + ", " +
                        SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_DESCRIPTION +
                        " FROM " +  SurveyDatabaseContract.SurveyQuestionOptionEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        SurveyQuestionOption surveyQ = new SurveyQuestionOption(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_DESCRIPTION)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_QUESTION_ID)));
                        SurveyList.add(surveyQ);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return SurveyList;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.SurveyQuestionOptionEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(SurveyQuestionOption surveyQuestionOption)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_OPTION_ID,surveyQuestionOption.getId());
        contentValues.put(SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_DESCRIPTION,surveyQuestionOption.getDescription());
        contentValues.put(SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_QUESTION_ID,surveyQuestionOption.getSurveyQuestionId());

        db.insert(SurveyDatabaseContract.SurveyQuestionOptionEntry.TABLE_NAME,null, contentValues);
    }
}
