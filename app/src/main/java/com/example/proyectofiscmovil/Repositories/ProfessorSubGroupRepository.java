package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.ProfessorSubjectGroup;

import java.util.List;

public class ProfessorSubGroupRepository {

    private static ProfessorSubGroupRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private ProfessorSubGroupRepository(){}

    public static ProfessorSubGroupRepository getInstance(SurveyDBHelper dbHelper){
        if(ourInstance == null) {
            ourInstance = new ProfessorSubGroupRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }


    public List<ProfessorSubjectGroup> GetAllSubGroup() {
        List<ProfessorSubjectGroup> professorList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SUBJECT + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_GROUP_ID + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SEMESTER + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_YEAR +
                        " FROM " +  SurveyDatabaseContract.ProfessorSubjectGroupEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        ProfessorSubjectGroup professor = new ProfessorSubjectGroup(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SUBJECT)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_GROUP_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SEMESTER)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_YEAR))
                        );
                        professorList.add(professor);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return professorList;
    }


    public List<ProfessorSubjectGroup> GetBySubGroupCod(int idprof, int idasig, int idgrupo) {
        List<ProfessorSubjectGroup> subGroupList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SUBJECT + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_GROUP_ID + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SEMESTER + ", " +
                        SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_YEAR +
                        " FROM " +  SurveyDatabaseContract.ProfessorSubjectGroupEntry.TABLE_NAME +
                        " WHERE COLUMN_PROFESSOR_ID='"+idprof+"'"+" AND COLUMN_SUBJECT='"+idasig
                        +"'"+" AND COLUMN_GROUP_ID='"+idgrupo+"'";
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        ProfessorSubjectGroup professor = new ProfessorSubjectGroup(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SUBJECT)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_GROUP_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SEMESTER)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_YEAR))
                        );
                        subGroupList.add(professor);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return subGroupList;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.ProfessorSubjectGroupEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(ProfessorSubjectGroup professorSubjectGroup)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID,professorSubjectGroup.getProfessorId());
        contentValues.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SUBJECT,professorSubjectGroup.getSubjectId());
        contentValues.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_GROUP_ID,professorSubjectGroup.getGroupId());
        contentValues.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_SEMESTER,professorSubjectGroup.getSemester());
        contentValues.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_YEAR,professorSubjectGroup.getYear());

        db.insert(SurveyDatabaseContract.ProfessorSubjectGroupEntry.TABLE_NAME,null, contentValues);
    }
}
