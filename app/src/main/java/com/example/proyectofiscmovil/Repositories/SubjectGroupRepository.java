package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.StudentSubjectGroup;
import com.example.proyectofiscmovil.Models.SubjectGroup;
import java.util.List;

public class SubjectGroupRepository {
    private static SubjectGroupRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private SubjectGroupRepository(){}

    public static SubjectGroupRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new SubjectGroupRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<SubjectGroup> GetAllSubjectGroup() {
        List<SubjectGroup> subjectGroupList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.GroupEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_ID + ", " +
                        SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_COD + "," +
                        SurveyDatabaseContract.GroupEntry.COLUMN_SHIFT +
                        " FROM " +  SurveyDatabaseContract.GroupEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        SubjectGroup subjectGroup = new SubjectGroup(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_COD)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.GroupEntry.COLUMN_SHIFT)));
                        subjectGroupList.add(subjectGroup);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return subjectGroupList;
    }

    public SubjectGroup GetSubjectGroup(int subjectId, int groupId) {
        SubjectGroup subjectGroup = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.GroupEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_GROUP_ID + ", " +
                        SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_SUBJECT_ID + ", " +
                        SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_HOUR_CODE +
                        " FROM " +  SurveyDatabaseContract.GroupEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_SUBJECT_ID + " = " + String.valueOf(subjectId) +
                        " AND " + SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_GROUP_ID + " = " + String.valueOf(groupId);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        subjectGroup = new SubjectGroup(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SubjectGroupEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_SUBJECT_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_GROUP_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_HOUR_CODE)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return subjectGroup;
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

    //TODO: Agregar mètodo de insertar registro. Es probable que se necesite modificar la clase model.

}
