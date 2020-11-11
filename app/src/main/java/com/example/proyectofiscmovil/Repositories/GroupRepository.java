package com.example.proyectofiscmovil.Repositories;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.Group;

import java.util.List;

public class GroupRepository {
    private static GroupRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private GroupRepository(){}

    public static GroupRepository getInstance(SurveyDBHelper dbHelper){
        if(ourInstance == null) {
            ourInstance = new GroupRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }


    public List<Group> GetAllGroup() {
        List<Group> groupList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.GroupEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_ID + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_COD + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_SHIFT + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_SEMESTER + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_YEAR + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_CAREER_ID + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_CAMPUS_ID +
                        " FROM " +  SurveyDatabaseContract.GroupEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        Group group = new Group(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_COD)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_SHIFT)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_SEMESTER)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_YEAR)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_CAREER_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_CAMPUS_ID)));
                        groupList.add(group);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return groupList;
    }


    public List<Group> GetByGroupCod(String cod) {
        List<Group> groupList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.GroupEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_ID + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_COD + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_SHIFT + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_SEMESTER + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_YEAR + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_CAREER_ID + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_CAMPUS_ID +
                        " FROM " +  SurveyDatabaseContract.GroupEntry.TABLE_NAME +
                        " WHERE COLUMN_GROUP_COD='"+cod+"'";
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        Group group = new Group(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_COD)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_SHIFT)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_SEMESTER)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_YEAR)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_CAREER_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_CAMPUS_ID)));
                        groupList.add(group);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return groupList;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.GroupEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(Group group)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.GroupEntry.COLUMN_CAMPUS_ID,group.getId());
        contentValues.put(SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_COD,group.getCode());
        contentValues.put(SurveyDatabaseContract.GroupEntry.COLUMN_SHIFT,group.getShift());
        contentValues.put(SurveyDatabaseContract.GroupEntry.COLUMN_SEMESTER,group.getSemester());
        contentValues.put(SurveyDatabaseContract.GroupEntry.COLUMN_YEAR,group.getYear());
        contentValues.put(SurveyDatabaseContract.GroupEntry.COLUMN_CAREER_ID,group.getCareerId());
        contentValues.put(SurveyDatabaseContract.GroupEntry.COLUMN_CAMPUS_ID,group.getCampusId());

        db.insert(SurveyDatabaseContract.GroupEntry.TABLE_NAME,null, contentValues);
    }
}
