package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.DatabaseDataWorker;
import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.CampusCareer;

import java.util.List;

public class CampusCareerRepository {
    private static CampusCareerRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private CampusCareerRepository(){}

    public static CampusCareerRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new CampusCareerRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<CampusCareer> GetAllCampusCareer() {
        List<CampusCareer> campusCareerList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.CampusCareerEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAMPUS_ID + ", " +
                        SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAREER_ID +
                        " FROM " +  SurveyDatabaseContract.CampusCareerEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        CampusCareer campusCareer = new CampusCareer(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusCareerEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAMPUS_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAREER_ID)));
                        campusCareerList.add(campusCareer);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return campusCareerList;
    }

    public CampusCareer GetRole(int campusId, int careerId) {
        CampusCareer campusCareer = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.CampusCareerEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAMPUS_ID + ", " +
                        SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAREER_ID +
                        " FROM " +  SurveyDatabaseContract.CampusCareerEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAMPUS_ID + " = " + String.valueOf(campusId) +
                        " AND " + SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAREER_ID + " = " + String.valueOf(careerId);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        campusCareer = new CampusCareer(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusCareerEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAMPUS_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAREER_ID)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return campusCareer;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.CampusCareerEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(CampusCareer campusCareer)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAMPUS_ID,campusCareer.getCampusId());
        contentValues.put(SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAREER_ID,campusCareer.getCareerId());
        db.insert(SurveyDatabaseContract.CampusCareerEntry.TABLE_NAME,null, contentValues);
    }
}
