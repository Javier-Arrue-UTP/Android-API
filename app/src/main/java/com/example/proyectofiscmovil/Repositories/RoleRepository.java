package com.example.proyectofiscmovil.Repositories;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;
import com.example.proyectofiscmovil.DataAccess.SurveyDatabaseContract;
import com.example.proyectofiscmovil.Models.ProfessorSubjectGroup;
import com.example.proyectofiscmovil.Models.Role;

import java.util.List;

public class RoleRepository {
    private static RoleRepository ourInstance = null;
    private SurveyDBHelper mSurveyDBHelper = null;

    private RoleRepository(){}

    public static RoleRepository getInstance(SurveyDBHelper dbHelper) {
        if(ourInstance == null) {
            ourInstance = new RoleRepository();
        }

        ourInstance.mSurveyDBHelper = dbHelper;
        return ourInstance;
    }

    public List<Role> GetAllRole() {
        List<Role> roleList = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.RoleEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_USER_ID + ", " +
                        SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_NAME +
                        " FROM " +  SurveyDatabaseContract.RoleEntry.TABLE_NAME;
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        Role role = new Role(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.RoleEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_USER_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_NAME)));
                        roleList.add(role);
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return roleList;
    }

    public Role GetRole(int roleUserid) {
        Role role = null;

        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getReadableDatabase();
            if(db != null)
            {
                String query = "SELECT " + SurveyDatabaseContract.RoleEntry.COLUMN_ID + ", " +
                        SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_USER_ID + ", " +
                        SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_NAME +
                        " FROM " +  SurveyDatabaseContract.RoleEntry.TABLE_NAME +
                        " WHERE " + SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_USER_ID + " = " + String.valueOf(roleUserid);
                Cursor c = db.rawQuery(query,null);

                if (c.moveToFirst()){
                    do {
                        role = new Role(
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.RoleEntry.COLUMN_ID)),
                                c.getInt(c.getColumnIndex(SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_USER_ID)),
                                c.getString(c.getColumnIndex(SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_NAME)));
                    } while(c.moveToNext());
                }
                c.close();
            }
        }
        catch (Exception error)
        {
            throw error;
        }
        return role;
    }

    public void DeleteRecord() {
        try
        {
            SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();
            if(db != null)
            {
                db.delete(SurveyDatabaseContract.RoleEntry.TABLE_NAME,null,null);
            }
        }
        catch (Exception error)
        {
            throw error;
        }
    }

    public void CreateRecord(Role role)
    {
        SQLiteDatabase db = ourInstance.mSurveyDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_USER_ID,role.getId());
        contentValues.put(SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_NAME,role.getName());

        db.insert(SurveyDatabaseContract.RoleEntry.TABLE_NAME,null, contentValues);
    }
}
