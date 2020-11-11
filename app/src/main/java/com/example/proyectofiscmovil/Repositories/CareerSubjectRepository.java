package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.Career;
import com.example.proyectofiscmovil.Models.CareerSubject;
import java.util.List;

public class CareerSubjectRepository {
    private static CareerSubjectRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private CareerSubjectRepository(){}

    public static CareerSubjectRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new CareerSubjectRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<CareerSubject> GetAllCareerSubject() {
        List<CareerSubject> careerSubjectList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.CareerSubjectEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.CareerSubjectEntry.COLUMN_CAREER_ID + ", " +
                        SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SUBJECT_ID + "," +
                        SurveyDatabaseContract.CareerSubjectEntry.COLUMN_YEAR + "," +
                        SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SEMESTER +
                        " FROM " +  SurveyDatabaseContract.CareerSubjectEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        CareerSubject careerSubject = new CareerSubject(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_CAREER_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SUBJECT_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_YEAR)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SEMESTER)));
                        careerSubjectList.add(careerSubject);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return careerSubjectList;
    }

    public CareerSubject GetSubjectGroup(int careerId, int subjectId) {
        CareerSubject careerSubject = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.CareerSubjectEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.CareerSubjectEntry.COLUMN_CAREER_ID + ", " +
                        SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SUBJECT_ID + "," +
                        SurveyDatabaseContract.CareerSubjectEntry.COLUMN_YEAR + "," +
                        SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SEMESTER +
                        " FROM " +  SurveyDatabaseContract.CareerSubjectEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.CareerSubjectEntry.COLUMN_CAREER_ID + " = " + String.valueOf(careerId) +
                        " AND " + SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SUBJECT_ID+ " = " + String.valueOf(subjectId);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        careerSubject = new CareerSubject(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_CAREER_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SUBJECT_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_YEAR)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SEMESTER)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return careerSubject;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.CareerSubjectEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(CareerSubject careerSubject)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_CAREER_ID,careerSubject.getCareerId());
        contentValues.put(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SUBJECT_ID,careerSubject.getSubjectId());
        contentValues.put(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_YEAR,careerSubject.getYear());
        contentValues.put(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SEMESTER,careerSubject.getSemester());
        db.insert(SurveyDatabaseContract.CareerSubjectEntry.TABLE_NAME,null, contentValues);
    }
}
