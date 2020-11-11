package com.example.proyectofiscmovil.DataAccess;
import android.provider.BaseColumns;

public class SurveyDatabaseContract {
    private SurveyDatabaseContract() {} // make non-creatable

    public static final class SurveyEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_SURVEY";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_SURVEY_ID = "id_encuesta";
        public static final String COLUMN_SURVEY_TITLE = "titulo";
        public static final String SQL_DROP_TABLE = "DROP TABLE " + TABLE_NAME;

        public static final String getQName(String columnName) {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_SURVEY_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_TITLE + " TEXT NOT NULL)";
    }

    public static final class SurveySectionEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_SURVEY_SECTION";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_SURVEY_SECTION_ID = "id_seccion";
        public static final String COLUMN_SURVEY_ID = "id_encuesta";
        public static final String COLUMN_SURVEY_SECTION_DESCRIPTION = "descripcion";
        public static final String SQL_DROP_TABLE = "DROP TABLE " + TABLE_NAME;

        public static final String getQName(String columnName) {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_SURVEY_SECTION_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_SECTION_DESCRIPTION + " TEXT NOT NULL)";
    }

    public static final class QuestionEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_QUESTION";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_QUESTION_ID = "id_pregunta";
        public static final String COLUMN_QUESTION_DESCRIPTION = "descrip_preg";
        public static final String COLUMN_QUESTION_CODE = "cod_preg";
        public static final String COLUMN_SURVEY_ID = "id_encuesta";
        public static final String COLUMN_QUESTION_OPTION_ID = "id_seccion";

        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY" +
                        COLUMN_QUESTION_ID + "INTEGER NULL, " +
                        COLUMN_QUESTION_DESCRIPTION + "TEXT NULL, " +
                        COLUMN_QUESTION_CODE + "TEXT NULL, " +
                        COLUMN_SURVEY_ID + "INTEGER NULL, " +
                        COLUMN_QUESTION_OPTION_ID + "INTEGER NULL)";
    }

    public static final class SurveyQuestionOptionEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_SURVEY_QUESTION_OPTION";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_SURVEY_QUESTION_OPTION_OPTION_ID = "id_opcion";
        public static final String COLUMN_SURVEY_QUESTION_OPTION_QUESTION_ID = "id_pregunta";
        public static final String COLUMN_SURVEY_QUESTION_OPTION_DESCRIPTION = "descrip_opcion";
        public static final String SQL_DROP_TABLE = "DROP TABLE " + TABLE_NAME;

        public static final String getQName(String columnName) {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_SURVEY_QUESTION_OPTION_OPTION_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_QUESTION_OPTION_QUESTION_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_QUESTION_OPTION_DESCRIPTION + " TEXT NOT NULL)";
    }

    public static final class SurveyRespondEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_SURVEY_RESPOND";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_SURVEY_RESPOND_ID = "id_respuesta";
        public static final String COLUMN_SURVEY_RESPOND_USER_ID = "id_usuario";
        public static final String COLUMN_SURVEY_RESPOND_SURVEY_ID = "id_encuesta";
        public static final String COLUMN_SURVEY_RESPOND_QUESTION_ID = "id_pregunta";
        public static final String COLUMN_SURVEY_RESPOND_OPTION_ID = "id_opcion";
        public static final String COLUMN_SURVEY_RESPOND_SUBJECT_ID = "id_asignatura";
        public static final String COLUMN_SURVEY_RESPOND_GROUP_ID = "id_grupo";
        public static final String COLUMN_SURVEY_RESPOND_SEMESTER = "semestre";
        public static final String COLUMN_SURVEY_RESPOND_YEAR = "anno";
        public static final String COLUMN_SURVEY_RESPOND_DESCRIPTION = "describ_respuesta";
        public static final String SQL_DROP_TABLE = "DROP TABLE " + TABLE_NAME;

        public static final String getQName(String columnName) {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_SURVEY_RESPOND_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_RESPOND_USER_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_RESPOND_SURVEY_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_RESPOND_QUESTION_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_RESPOND_OPTION_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_RESPOND_SUBJECT_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_RESPOND_GROUP_ID + " INTEGER NULL, " +
                        COLUMN_SURVEY_RESPOND_SEMESTER + " TEXT NULL, " +
                        COLUMN_SURVEY_RESPOND_YEAR + " INTEGER NULL, " +
                        COLUMN_SURVEY_RESPOND_DESCRIPTION + " TEXT NOT NULL)";
    }

    public static final class RoleEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_ROLE";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_ROLE_USER_ID = "id_rol_usuario";
        public static final String COLUMN_ROLE_NAME = "nombre";

        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY" +
                        COLUMN_ROLE_USER_ID + "INTEGER NULL, " +
                        COLUMN_ROLE_NAME + "INTEGER NULL)";
    }

    public static final class CampusEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_CAMPUS";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_CAMPUS_ID = "id_sede";
        public static final String COLUMN_CAMPUS_NAME = "nombre_sede";
        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME +  " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_CAMPUS_ID + " INTEGER NULL, " +
                        COLUMN_CAMPUS_NAME + " TEXT NOT NULL)";
    }

    public static final class CareerEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_CAREER";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_CAREER_ID = "id_carrera";
        public static final String COLUMN_CAREER_NAME = "nombre_carrera";
        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_CAREER_ID + "INTEGER NULL, " +
                        COLUMN_CAREER_NAME + "TEXT NOT NULL)";
    }

    public static final class CampusCareerEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_CAMPUS_CAREER";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_CAMPUS_ID = "id_sede";
        public static final String COLUMN_CAREER_ID = "id_carrera";
        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_CAMPUS_ID + "INTEGER NULL, " +
                        COLUMN_CAREER_ID + "INTEGER NULL)";
    }

    public static final class SubjectEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_SUBJECT";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_SUBJECT_ID = "id_asignatura";
        public static final String COLUMN_SUBJECT_CODE = "cod_asig";
        public static final String COLUMN_SUBJECT_NAME = "nombre";
        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY" +
                        COLUMN_SUBJECT_ID + "INTEGER NULL, " +
                        COLUMN_SUBJECT_CODE + "TEXT NULL, " +
                        COLUMN_SUBJECT_NAME + "TEXT NULL)";
    }

    public static final class GroupEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_GROUP";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_GROUP_ID = "id_grupo";
        public static final String COLUMN_GROUP_COD = "cod_grupo";
        public static final String COLUMN_SHIFT = "turno";
        public static final String COLUMN_SEMESTER = "semestre";
        public static final String COLUMN_YEAR = "anno";
        public static final String COLUMN_CAREER_ID = "id_carrera";
        public static final String COLUMN_CAMPUS_ID = "id_sede";
        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_GROUP_ID + "INTEGER NULL, " +
                        COLUMN_GROUP_COD + "INTEGER NULL, " +
                        COLUMN_SHIFT + "TEXT NOT NULL, " +
                        COLUMN_SEMESTER + "INTEGER NULL, " +
                        COLUMN_YEAR + "INTEGER NULL, " +
                        COLUMN_CAREER_ID + "INTEGER NULL, " +
                        COLUMN_CAMPUS_ID + "INTEGER NULL)";
    }

    public static final class SubjectGroupEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_SUBJECT_GROUP";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_SUBJECT_GROUP_SUBJECT_ID = "id_asignatura";
        public static final String COLUMN_SUBJECT_GROUP_HOUR_CODE = "Cod_hora";
        public static final String COLUMN_SUBJECT_GROUP_GROUP_ID = "nombre";
        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_SUBJECT_GROUP_SUBJECT_ID + "INTEGER NULL, " +
                        COLUMN_SUBJECT_GROUP_HOUR_CODE + "INTEGER NULL," +
                        COLUMN_SUBJECT_GROUP_GROUP_ID + "TEXT NOT NULL)";
    }

    public static final class CareerSubjectEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_CAREER_SUBJECT";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_CAREER_ID = "id_carrera";
        public static final String COLUMN_SUBJECT_ID = "id_asignatura";
        public static final String COLUMN_YEAR = "anno_carrera";
        public static final String COLUMN_SEMESTER = "semestre";
        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY" +
                        COLUMN_CAREER_ID + "INTEGER NULL, " +
                        COLUMN_SUBJECT_ID + "INTEGER NULL, " +
                        COLUMN_YEAR + "INTEGER NULL, " +
                        COLUMN_SEMESTER + "INTEGER NULL)";
    }

    public static final class StudentSubjectGroupEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_STUDENT_SUBJECT_GROUP";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_STUDENT_ID = "id_estudiante";
        public static final String COLUMN_SUBJECT_ID = "id_asignatura";
        public static final String COLUMN_GROUP_ID = "id_grupo";
        public static final String COLUMN_SEMESTER = "semestre";
        public static final String COLUMN_YEAR = "año_Asig";

        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_STUDENT_ID + "INTEGER NULL, " +
                        COLUMN_SUBJECT_ID + "INTEGER NULL, " +
                        COLUMN_GROUP_ID + "INTEGER NULL, " +
                        COLUMN_SEMESTER + "INTEGER NULL, "+
                        COLUMN_YEAR + "INTEGER NULL)";
    }

    public static final class ProfessorSubjectGroupEntry implements BaseColumns {
        public static final String TABLE_NAME = "TBL_PROFESSOR_SUBJECT_GROUP";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_PROFESSOR_ID = "id_profesor";
        public static final String COLUMN_SUBJECT = "id_asignatura";
        public static final String COLUMN_GROUP_ID = "id_grupo";
        public static final String COLUMN_SEMESTER = "semestre";
        public static final String COLUMN_YEAR = "año_Asig";

        public static final String SQL_DROP_TABLE = "DROP TABLE" + TABLE_NAME;

        public static final String getQName(String columnName)
        {
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE" + TABLE_NAME + " (" +
                        COLUMN_ID + "INTEGER PRIMARY KEY, " +
                        COLUMN_PROFESSOR_ID + "INTEGER NULL, " +
                        COLUMN_SUBJECT + "INTEGER NULL, " +
                        COLUMN_GROUP_ID + "INTEGER NULL, " +
                        COLUMN_SEMESTER + "INTEGER NULL, "+
                        COLUMN_YEAR + "INTEGER NULL)";
    }

}
