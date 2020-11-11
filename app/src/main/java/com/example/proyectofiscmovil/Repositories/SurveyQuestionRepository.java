package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.SurveyQuestion;
import com.example.proyectofiscmovil.Models.SurveyQuestionOption;

import java.util.List;

public class SurveyQuestionRepository {
    private static SurveyQuestionRepository ourInstance = null;
    private SurveyDBHelper sQuestionDBHelper = null;

    private SurveyQuestionRepository(){}

    public static SurveyQuestionRepository getInstance(SurveyDBHelper dbHelper){
        if(ourInstance == null) {
            ourInstance = new SurveyQuestionRepository();
        }

        ourInstance.sQuestionDBHelper = dbHelper;
        return ourInstance;
    }


    public List<SurveyQuestion> GetAllSurveyQuestion() {
        List<SurveyQuestion> questionList = null;

        try
        {
            SQLiteDatabase db = ourInstance.sQuestionDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.QuestionEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_ID + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_DESCRIPTION + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_CODE + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_SURVEY_ID + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_OPTION_ID +
                        " FROM " +  SurveyDatabaseContract.QuestionEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        SurveyQuestion question = new SurveyQuestion(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.QuestionEntry.COLUMN_SURVEY_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_DESCRIPTION)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_CODE))
                        );
                        questionList.add(question);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return questionList;
    }


    public List<SurveyQuestion> GetByQuestionCod(String cod) {
        List<SurveyQuestion> questionList = null;

        try
        {
            SQLiteDatabase db = ourInstance.sQuestionDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.QuestionEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_ID + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_DESCRIPTION + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_CODE + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_SURVEY_ID + ", " +
                        SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_OPTION_ID +
                        " FROM " +  SurveyDatabaseContract.QuestionEntry.TABLE_NAME +
                        " WHERE COLUMN_QUESTION_CODE='"+cod+"'";
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        SurveyQuestion question = new SurveyQuestion(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.QuestionEntry.COLUMN_SURVEY_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_DESCRIPTION)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_CODE))
                        );
                        questionList.add(question);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return questionList;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.sQuestionDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.QuestionEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }


}
