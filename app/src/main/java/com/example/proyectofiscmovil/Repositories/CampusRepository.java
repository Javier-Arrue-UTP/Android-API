package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.Campus;
import com.example.proyectofiscmovil.Models.CampusCareer;

import java.util.List;

public class CampusRepository {
    private static CampusRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private CampusRepository(){}

    public static CampusRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new CampusRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<Campus> GetAllCampus() {
        List<Campus> campusList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.CampusEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_ID + ", " +
                        SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_NAME +
                        " FROM " +  SurveyDatabaseContract.CampusEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        Campus campus = new Campus(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_NAME)));
                        campusList.add(campus);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return campusList;
    }

    public Campus GetCampus(int campusId) {
        Campus campus = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.CampusEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_ID + ", " +
                        SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_NAME +
                        " FROM " +  SurveyDatabaseContract.CampusEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_ID + " = " + String.valueOf(campusId);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        campus = new Campus(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_NAME)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return campus;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.CampusEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(Campus campus)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_ID,campus.getId());
        contentValues.put(SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_NAME,campus.getName());
        db.insert(SurveyDatabaseContract.CampusEntry.TABLE_NAME,null, contentValues);
    }
}
