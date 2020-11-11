package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.Campus;
import com.example.proyectofiscmovil.Models.Career;
import java.util.List;

public class CareerRepository {
    private static CareerRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private CareerRepository(){}

    public static CareerRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new CareerRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<Career> GetAllCareers() {
        List<Career> careerList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.CareerEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.CareerEntry.COLUMN_CAREER_ID + ", " +
                        SurveyDatabaseContract.CareerEntry.COLUMN_CAREER_NAME +
                        " FROM " +  SurveyDatabaseContract.GroupEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        Career career = new Career(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.CareerEntry.COLUMN_CAREER_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.CareerEntry.COLUMN_CAREER_NAME)));
                        careerList.add(career);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return careerList;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.CareerEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(Career career)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.CareerEntry.COLUMN_CAREER_ID,career.getId());
        contentValues.put(SurveyDatabaseContract.CareerEntry.COLUMN_CAREER_NAME,career.getName());
        db.insert(SurveyDatabaseContract.CareerEntry.TABLE_NAME,null, contentValues);
    }
}
