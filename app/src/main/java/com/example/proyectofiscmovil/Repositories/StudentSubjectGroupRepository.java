package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.CareerSubject;
import com.example.proyectofiscmovil.Models.StudentSubjectGroup;
import java.util.List;

public class StudentSubjectGroupRepository {
    private static StudentSubjectGroupRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private StudentSubjectGroupRepository(){}

    public static StudentSubjectGroupRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new StudentSubjectGroupRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<StudentSubjectGroup> GetAllStudentSubjectGroup() {
        List<StudentSubjectGroup> studentSubjectGroupList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_STUDENT_ID+ ", " +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SUBJECT_ID + "," +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_GROUP_ID + "," +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SEMESTER + "," +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_YEAR +
                        " FROM " +  SurveyDatabaseContract.StudentSubjectGroupEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        StudentSubjectGroup studentSubjectGroup = new StudentSubjectGroup(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_STUDENT_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SUBJECT_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_GROUP_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SEMESTER)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_YEAR)));
                        studentSubjectGroupList.add(studentSubjectGroup);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return studentSubjectGroupList;
    }

    public StudentSubjectGroup GetStudentSubjectGroup(int studentId, int subjectId, int groupId) {
        StudentSubjectGroup studentSubjectGroup = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_STUDENT_ID + ", " +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SUBJECT_ID + "," +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_GROUP_ID + "," +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SEMESTER + "," +
                        SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_YEAR +
                        " FROM " +  SurveyDatabaseContract.StudentSubjectGroupEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_STUDENT_ID + " = " + String.valueOf(studentId) +
                        " AND " + SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SUBJECT_ID+ " = " + String.valueOf(subjectId) +
                        " AND " + SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_GROUP_ID+ " = " + String.valueOf(groupId);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        studentSubjectGroup = new StudentSubjectGroup(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_STUDENT_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SUBJECT_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_GROUP_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SEMESTER)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_YEAR)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return studentSubjectGroup;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.StudentSubjectGroupEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(StudentSubjectGroup studentSubjectGroup)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_STUDENT_ID,studentSubjectGroup.getStudentId());
        contentValues.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SUBJECT_ID,studentSubjectGroup.getSubjectId());
        contentValues.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_GROUP_ID,studentSubjectGroup.getGroupId());
        contentValues.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SEMESTER,studentSubjectGroup.getSemester());
        contentValues.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_YEAR,studentSubjectGroup.getYear());

        db.insert(SurveyDatabaseContract.StudentSubjectGroupEntry.TABLE_NAME,null, contentValues);
    }
}
