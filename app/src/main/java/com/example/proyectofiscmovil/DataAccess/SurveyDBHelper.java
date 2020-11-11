package com.example.proyectofiscmovil.DataAccess;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SurveyDBHelper extends SQLiteOpenHelper {
    private final static  int mVersion = 1;
    private final static String mDatabaseName = "Survey";

    public SurveyDBHelper(@Nullable Context context) {
        super(context, mDatabaseName, null, mVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) throws SQLException{
        try
        {
            db.execSQL(SurveyDatabaseContract.SurveyEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.SurveySectionEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.SurveyRespondEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.SurveyQuestionOptionEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.QuestionEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.CampusEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.CareerEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.CampusCareerEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.SubjectGroupEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.GroupEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.SubjectEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.CareerSubjectEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.StudentSubjectGroupEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.ProfessorSubjectGroupEntry.SQL_CREATE_TABLE);
            db.execSQL(SurveyDatabaseContract.RoleEntry.SQL_CREATE_TABLE);

            DatabaseDataWorker worker = new DatabaseDataWorker(db);
            worker.insertCampusEntries();
            worker.insertCampusCareerEntries();
            worker.insertCareersEntries();
            worker.insertCareerSubjectEntries();
            worker.insertGroupEntries();
            worker.insertProfessorSubjectGroupEntries();
            worker.insertRoleEntries();
            worker.insertStudentSubjectGroupEntries();
            worker.insertSubjectEntries();
            worker.insertSurveyEntries();
            worker.insertQuestionEntries();
            worker.insertSurveyQuestionOptionEntries();
            worker.insertSurveyRespondEntries();
            worker.insertSurveySectionEntries();
        }
        catch (SQLException sqlException)
        {
            String message = "Ha ocurrido un error creando la base de datos. El script no es valido. ";
            Log.e("ERROR", message + sqlException.getMessage());
            throw new SQLException("Ha ocurrido un error creando la base de datos. El script no es valido.",sqlException);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try
        {
            if(oldVersion < newVersion)
            {
                db.execSQL(SurveyDatabaseContract.SurveyEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.SurveyEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.SurveySectionEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.SurveySectionEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.SurveyRespondEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.SurveyRespondEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.SurveyQuestionOptionEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.SurveyQuestionOptionEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.QuestionEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.QuestionEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.CampusEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.CampusEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.CampusCareerEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.CampusCareerEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.CareerEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.CareerEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.SubjectGroupEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.SubjectGroupEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.GroupEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.GroupEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.SubjectEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.SubjectEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.CareerSubjectEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.CareerSubjectEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.StudentSubjectGroupEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.StudentSubjectGroupEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.ProfessorSubjectGroupEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.ProfessorSubjectGroupEntry.SQL_CREATE_TABLE);

                db.execSQL(SurveyDatabaseContract.RoleEntry.SQL_DROP_TABLE);
                db.execSQL(SurveyDatabaseContract.RoleEntry.SQL_CREATE_TABLE);

            }
        }
        catch (Exception exception)
        {
            String message = "Ha ocurrido un error actualizando la base de datos. ";
            Log.e("ERROR", message + exception.getMessage());
        }
    }
}
