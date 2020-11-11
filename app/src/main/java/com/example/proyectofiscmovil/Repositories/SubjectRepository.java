package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.Role;
import com.example.proyectofiscmovil.Models.Subjects;

import java.util.List;

public class SubjectRepository {
    private static SubjectRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private SubjectRepository(){}

    public static SubjectRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new SubjectRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<Subjects> GetAllSubjects() {
        List<Subjects> subjectsList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SubjectEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_ID + ", " +
                        SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_CODE + "," +
                        SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_NAME +
                        " FROM " +  SurveyDatabaseContract.SubjectEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        Subjects subjects = new Subjects(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SubjectEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_CODE)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_NAME)));
                        subjectsList.add(subjects);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return subjectsList;
    }

    public Subjects GetSubjectByCode(int subjectCod) {
        Subjects subjects = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.SubjectEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_ID + ", " +
                        SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_CODE +
                        SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_NAME +
                        " FROM " +  SurveyDatabaseContract.SubjectEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_CODE + " = " + String.valueOf(subjectCod);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        subjects = new Subjects(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SubjectEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_CODE)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_NAME)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return subjects;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.SubjectEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(Subjects subjects)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_ID,subjects.getId());
        contentValues.put(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_CODE,subjects.getCode());
        contentValues.put(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_NAME,subjects.getName());

        db.insert(SurveyDatabaseContract.SubjectEntry.TABLE_NAME,null, contentValues);
    }
}
