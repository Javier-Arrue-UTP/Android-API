package com.example.proyectofiscmovil.DataAccess;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    //Tabla Sede
    public void insertCampusEntries()
    {
        try
        {
            insertCampusEntry(1, "Campus Victor Levi Sasso");
            insertCampusEntry(2, "Centro Regional de Azuero");
            insertCampusEntry(3, "Centro Regional de Bocas del Toro");
            insertCampusEntry(4, "Centro Regional de Chiriquí");
            insertCampusEntry(5, "Centro Regional de Coclé");
            insertCampusEntry(6, "Centro Regional de Colón");
            insertCampusEntry(7, "Centro Regional de Veraguas");
            insertCampusEntry(8, "Centro Regional de Panama Oeste");
        }
        catch (Exception error)
        {
            throw error;
        }
    }
    private void insertCampusEntry(int id_sede, String nombre_sede)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_ID, id_sede);
            values.put(SurveyDatabaseContract.CampusEntry.COLUMN_CAMPUS_NAME, nombre_sede);

            mDb.insert(SurveyDatabaseContract.CampusEntry.TABLE_NAME, null, values);
        }
        catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Carrera
    public void insertCareersEntries()
    {
        try
        {
            insertCareerEntry(1, "Licenciatura de Software");
            insertCareerEntry(2, "Licenciatura en Redes Informáticas");
            insertCareerEntry(3, "Licenciatura en Ingeniería de Sistemas y Computación");
            insertCareerEntry(4, "Licenciatura en Ingeniería de Sistemas de Información");
            insertCareerEntry(5, "Licenciatura en Ingeniería de Software");
            insertCareerEntry(6, "Licenciatura en Informática Aplicada a la Educación");
            insertCareerEntry(7, "Técnico en Informática para la Gestión Empresarial");
        }
        catch (Exception error){throw error;}
    }
    public void insertCareerEntry(int id_carrera, String nombre_carrera)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.CareerEntry.COLUMN_CAREER_ID, id_carrera);
            values.put(SurveyDatabaseContract.CareerEntry.COLUMN_CAREER_NAME, nombre_carrera);
            mDb.insert(SurveyDatabaseContract.CareerEntry.TABLE_NAME, null, values);
        }
        catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Sede_Carrera
    public void insertCampusCareerEntries()
    {
        try
        {
            insertCampusCareerEntry(1,1);
            insertCampusCareerEntry(2,1);
            insertCampusCareerEntry(3,1);
            insertCampusCareerEntry(4,1);
            insertCampusCareerEntry(5,1);
            insertCampusCareerEntry(1,2);
            insertCampusCareerEntry(2,2);
            insertCampusCareerEntry(3,2);
            insertCampusCareerEntry(4,2);
            insertCampusCareerEntry(5,2);
            insertCampusCareerEntry(1,3);
            insertCampusCareerEntry(2,3);
            insertCampusCareerEntry(3,3);
            insertCampusCareerEntry(4,3);
            insertCampusCareerEntry(5,3);
            insertCampusCareerEntry(1,4);
            insertCampusCareerEntry(2,4);
            insertCampusCareerEntry(3,4);
            insertCampusCareerEntry(4,4);
            insertCampusCareerEntry(5,4);
            insertCampusCareerEntry(1,5);
            insertCampusCareerEntry(2,5);
            insertCampusCareerEntry(3,5);
            insertCampusCareerEntry(4,5);
            insertCampusCareerEntry(5,5);
            insertCampusCareerEntry(1,6);
            insertCampusCareerEntry(2,6);
            insertCampusCareerEntry(3,6);
            insertCampusCareerEntry(4,6);
            insertCampusCareerEntry(5,6);
            insertCampusCareerEntry(1,7);
            insertCampusCareerEntry(2,7);
            insertCampusCareerEntry(3,7);
            insertCampusCareerEntry(4,7);
            insertCampusCareerEntry(5,7);
            insertCampusCareerEntry(1,8);
            insertCampusCareerEntry(2,8);
            insertCampusCareerEntry(3,8);
            insertCampusCareerEntry(4,8);
            insertCampusCareerEntry(5,8);
        }catch(Exception error){throw error;}
    }
    public void insertCampusCareerEntry(int id_carrera, int id_sede)
    {
        try
        {
            ContentValues values = new ContentValues();

            values.put(SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAREER_ID, id_carrera);
            values.put(SurveyDatabaseContract.CampusCareerEntry.COLUMN_CAMPUS_ID, id_sede);

            mDb.insert(SurveyDatabaseContract.CampusCareerEntry.TABLE_NAME, null, values);
        }catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//


    //Tabla Grupo
    public void insertGroupEntries()
    {
        try
        {
            insertGroupEntry(1, "1LS121", 'M', "I semestre", "2020", 1, 1);
            insertGroupEntry(2, "1LS122", 'M', "I semestre", "2020", 1, 1);
            insertGroupEntry(3, "1LS123", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(4, "1LS123", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(5, "1LS132", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(6, "1SL141", 'M', "I semestre", "2020", 1, 1);
            insertGroupEntry(7, "1LS142", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(8, "1LS201", 'N', "I semestre", "2020", 1, 1);
            insertGroupEntry(9, "1LS202", 'N', "I semestre", "2020", 1, 1);
            insertGroupEntry(10, "1LS221", 'N', "I semestre", "2020", 1, 1);
            insertGroupEntry(11, "1LS122", 'N', "I semestre", "2020", 1, 1);
            insertGroupEntry(12, "1LS231", 'N', "I semestre", "2020", 1, 1);
            insertGroupEntry(13, "1LS232", 'N', "I semestre", "2020", 1, 1);
            insertGroupEntry(14, "1LS241", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(15, "1lS242", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(16, "1LS701", 'M', "I semestre", "2020", 1, 1);
            insertGroupEntry(17, "1LS702", 'M', "I semestre", "2020", 1, 1);
            insertGroupEntry(18, "1LS703", 'M', "I semestre", "2020", 1, 1);
            insertGroupEntry(19, "1LS704", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(20, "1LS705", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(21, "1LS706", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(22, "VLS231", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(23, "VLS311", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(24, "VLS321", 'V', "I semestre", "2020", 1, 1);
            insertGroupEntry(25, "VLS331", 'M', "I semestre", "2020", 1, 1);
            insertGroupEntry(26, "VLS341", 'M', "I semestre", "2020", 1, 1);
            insertGroupEntry(27, "7LS221", 'N', "I semestre", "2020", 1, 2);
            insertGroupEntry(28, "7LS231", 'N', "I semestre", "2020", 1, 2);
            insertGroupEntry(29, "7LS231", 'N', "I semestre", "2020", 1, 2);
            insertGroupEntry(30, "7LS901", 'N', "I semestre", "2020", 1, 2);
            insertGroupEntry(31, "8LS201", 'N', "I semestre", "2020", 1, 3);
            insertGroupEntry(32, "2LS211", 'N', "I semestre", "2020", 1, 4);
            insertGroupEntry(33, "2LS212", 'N', "I semestre", "2020", 1, 4);
            insertGroupEntry(34, "2LS221", 'N', "I semestre", "2020", 1, 4);
            insertGroupEntry(35, "2LS231", 'N', "I semestre", "2020", 1, 4);
            insertGroupEntry(36, "2LS241", 'N', "I semestre", "2020", 1, 4);
            insertGroupEntry(37, "6LS121", 'M', "I semestre", "2020", 1, 5);
            insertGroupEntry(38, "6LS131", 'M', "I semestre", "2020", 1, 5);
            insertGroupEntry(39, "6LS141", 'M', "I semestre", "2020", 1, 5);
            insertGroupEntry(40, "6LS701", 'M', "I semestre", "2020", 1, 5);
            insertGroupEntry(41, "5LS201", 'N', "I semestre", "2020", 1, 6);
            insertGroupEntry(42, "5LS221", 'N', "I semestre", "2020", 1, 6);
            insertGroupEntry(43, "5LS231", 'N', "I semestre", "2020", 1, 6);
            insertGroupEntry(44, "5LS241", 'N', "I semestre", "2020", 1, 6);
            insertGroupEntry(45, "4LS121", 'V', "I semestre", "2020", 1, 7);
            insertGroupEntry(46, "4LS131", 'M', "I semestre", "2020", 1, 7);
            insertGroupEntry(47, "4LS141", 'V', "I semestre", "2020", 1, 7);
            insertGroupEntry(48, "4LS701", 'M', "I semestre", "2020", 1, 7);
            insertGroupEntry(49, "9LS121", 'V', "I semestre", "2020", 1, 8);
            insertGroupEntry(50, "9LS131", 'V', "I semestre", "2020", 1, 8);
            insertGroupEntry(51, "9LS221", 'N', "I semestre", "2020", 1, 8);
            insertGroupEntry(52, "9LS231", 'N', "I semestre", "2020", 1, 8);
            insertGroupEntry(53, "9LS241", 'N', "I semestre", "2020", 1, 8);
            insertGroupEntry(54, "9LS701", 'V', "I semestre", "2020", 1, 8);
            insertGroupEntry(55, "9LS901", 'N', "I semestre", "2020", 1, 8);
            insertGroupEntry(56, "11R121", 'M', "I semestre", "2020", 2, 1);
            insertGroupEntry(57, "11R141", 'M', "I semestre", "2020", 2, 1);
            insertGroupEntry(58, "11R222", 'N', "I semestre", "2020", 2, 1);
            insertGroupEntry(59, "11R242", 'N', "I semestre", "2020", 2, 1);
            insertGroupEntry(60, "V1R321", 'M', "I semestre", "2020", 2, 1);
            insertGroupEntry(61, "11R122", 'V', "I semestre", "2020", 2, 1);
            insertGroupEntry(62, "11R201", 'N', "I semestre", "2020", 2, 1);
            insertGroupEntry(63, "11R231", 'N', "I semestre", "2020", 2, 1);
            insertGroupEntry(64, "11R701", 'M', "I semestre", "2020", 2, 1);
            insertGroupEntry(65, "V1R331", 'M', "I semestre", "2020", 2, 1);
            insertGroupEntry(66, "11R131", 'M', "I semestre", "2020", 2, 1);
            insertGroupEntry(67, "11R202", 'N', "I semestre", "2020", 2, 1);
            insertGroupEntry(68, "11R232", 'N', "I semestre", "2020", 2, 1);
            insertGroupEntry(69, "11R702", 'V', "I semestre", "2020", 2, 1);
            insertGroupEntry(70, "V1R332", 'M', "I semestre", "2020", 2, 1);
            insertGroupEntry(71, "11R132", 'V', "I semestre", "2020", 2, 1);
            insertGroupEntry(72, "11R221", 'N', "I semestre", "2020", 2, 1);
            insertGroupEntry(73, "11R241", 'N', "I semestre", "2020", 2, 1);
            insertGroupEntry(74, "V1R311", 'M', "I semestre", "2020", 2, 1);
            insertGroupEntry(75, "V1R421", 'N', "I semestre", "2020", 2, 1);
            insertGroupEntry(76, "71R901", 'N', "I semestre", "2020", 2, 2);
            insertGroupEntry(77, "81R231", 'N', "I semestre", "2020", 2, 3);
            insertGroupEntry(78, "21R211", 'N', "I semestre", "2020", 2, 4);
            insertGroupEntry(79, "21R221", 'N', "I semestre", "2020", 2, 4);
            insertGroupEntry(80, "21R231", 'N', "I semestre", "2020", 2, 4);
            insertGroupEntry(81, "21R241", 'N', "I semestre", "2020", 2, 4);
            insertGroupEntry(82, "V1R241", 'N', "I semestre", "2020", 2, 4);
            insertGroupEntry(83, "61R221", 'N', "I semestre", "2020", 2, 5);
            insertGroupEntry(84, "61R231", 'N', "I semestre", "2020", 2, 5);
            insertGroupEntry(85, "61R901", 'N', "I semestre", "2020", 2, 5);
            insertGroupEntry(86, "51R201", 'N', "I semestre", "2020", 2, 6);
            insertGroupEntry(87, "51R221", 'N', "I semestre", "2020", 2, 6);
            insertGroupEntry(88, "41R701", 'N', "I semestre", "2020", 2, 7);
            insertGroupEntry(89, "91R221", 'N', "I semestre", "2020", 2, 8);
            insertGroupEntry(90, "91R231", 'N', "I semestre", "2020", 2, 8);
            insertGroupEntry(91, "91R901", 'N', "I semestre", "2020", 2, 8);
            insertGroupEntry(92, "1IL121", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(93, "1IL122", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(94, "1IL123", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(95, "1IL124", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(96, "1IL125", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(97, "1IL131", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(98, "1IL132", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(99, "1IL133", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(100, "1IL134", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(101, "1IL141", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(102, "1IL142", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(103, "1IL143", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(104, "1IL144", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(105, "1IL151", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(106, "1IL152", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(107, "1IL153", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(108, "1IL251", 'N', "I semestre", "2020", 3, 1);
            insertGroupEntry(109, "1IL701", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(110, "1IL702", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(111, "1IL703", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(112, "1IL704", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(113, "1IL705", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(114, "VIL131", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(115, "VIL321", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(116, "VIL331", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(117, "VIL341", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(118, "VIL342", 'M', "I semestre", "2020", 3, 1);
            insertGroupEntry(119, "7IL131", 'M', "I semestre", "2020", 3, 2);
            insertGroupEntry(120, "7IL141", 'M', "I semestre", "2020", 3, 2);
            insertGroupEntry(121, "1IL151", 'M', "I semestre", "2020", 3, 2);
            insertGroupEntry(122, "1IL701", 'M', "I semestre", "2020", 3, 2);
            insertGroupEntry(123, "2IL111", 'M', "I semestre", "2020", 3, 4);
            insertGroupEntry(124, "2IL112", 'M', "I semestre", "2020", 3, 4);
            insertGroupEntry(125, "21L121", 'M', "I semestre", "2020", 3, 4);
            insertGroupEntry(126, "2IL131", 'M', "I semestre", "2020", 3, 4);
            insertGroupEntry(127, "2IL141", 'M', "I semestre", "2020", 3, 4);
            insertGroupEntry(128, "2IL251", 'N', "I semestre", "2020", 3, 4);
            insertGroupEntry(129, "2IL331", 'M', "I semestre", "2020", 3, 4);
            insertGroupEntry(130, "5IL701", 'V', "I semestre", "2020", 3, 6);
            insertGroupEntry(131, "4IL121", 'M', "I semestre", "2020", 3, 7);
            insertGroupEntry(132, "4IL131", 'M', "I semestre", "2020", 3, 7);
            insertGroupEntry(133, "4IL141", 'V', "I semestre", "2020", 3, 7);
            insertGroupEntry(134, "4IL151", 'M', "I semestre", "2020", 3, 7);
            insertGroupEntry(135, "4IL701", 'M', "I semestre", "2020", 3, 7);
            insertGroupEntry(136, "9IL121", 'M', "I semestre", "2020", 3, 8);
            insertGroupEntry(137, "9IL131", 'M', "I semestre", "2020", 3, 8);
            insertGroupEntry(138, "9IL141", 'M', "I semestre", "2020", 3, 8);
            insertGroupEntry(139, "9IL701", 'M', "I semestre", "2020", 3, 8);
            insertGroupEntry(140, "1IF121", 'M', "I semestre", "2020", 4, 1);
            insertGroupEntry(141, "1IF122", 'V', "I semestre", "2020", 4, 1);
            insertGroupEntry(142, "1IF131", 'M', "I semestre", "2020", 4, 1);
            insertGroupEntry(143, "1IF141", 'V', "I semestre", "2020", 4, 1);
            insertGroupEntry(144, "1IF251", 'V', "I semestre", "2020", 4, 1);
            insertGroupEntry(145, "1IF701", 'M', "I semestre", "2020", 4, 1);
            insertGroupEntry(146, "VIF341", 'V', "I semestre", "2020", 4, 1);
            insertGroupEntry(147, "2IF111", 'M', "I semestre", "2020", 4, 4);
            insertGroupEntry(148, "2IF121", 'M', "I semestre", "2020", 4, 4);
            insertGroupEntry(149, "2IF131", 'M', "I semestre", "2020", 4, 4);
            insertGroupEntry(150, "2IF141", 'M', "I semestre", "2020", 4, 4);
            insertGroupEntry(151, "2IF251", 'N', "I semestre", "2020", 4, 4);
            insertGroupEntry(152, "1SF701", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(153, "1SF702", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(154, "1SF703", 'V', "I semestre", "2020", 5, 1);
            insertGroupEntry(155, "1SF121", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(156, "1SF122", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(157, "1SF123", 'V', "I semestre", "2020", 5, 1);
            insertGroupEntry(158, "1SF131", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(159, "1SF132", 'v', "I semestre", "2020", 5, 1);
            insertGroupEntry(160, "1SF141", 'v', "I semestre", "2020", 5, 1);
            insertGroupEntry(161, "1SF142", 'V', "I semestre", "2020", 5, 1);
            insertGroupEntry(162, "1SF251", 'N', "I semestre", "2020", 5, 1);
            insertGroupEntry(163, "1SF111", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(164, "1SF112", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(165, "1SF113", 'V', "I semestre", "2020", 5, 1);
            insertGroupEntry(166, "1SF121", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(167, "1SF122", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(168, "1SF123", 'V', "I semestre", "2020", 5, 1);
            insertGroupEntry(169, "1SF131", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(170, "1SF132", 'M', "I semestre", "2020", 5, 1);
            insertGroupEntry(171, "1SF133", 'V', "I semestre", "2020", 5, 1);
            insertGroupEntry(172, "1SF241", 'N', "I semestre", "2020", 5, 1);
            insertGroupEntry(173, "1SF242", 'N', "I semestre", "2020", 5, 1);
        }
        catch (Exception error){throw error;}
    }
    public void insertGroupEntry(int id_grupo, String cod_grupo, char turno, String semestre, String año, int id_carrera, int id_sede)
    {
        try
        {
            ContentValues values = new ContentValues();

            values.put(SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_ID, id_grupo);
            values.put(SurveyDatabaseContract.GroupEntry.COLUMN_GROUP_COD, cod_grupo);
            values.put(SurveyDatabaseContract.GroupEntry.COLUMN_SHIFT, (byte) turno);
            values.put(SurveyDatabaseContract.GroupEntry.COLUMN_SEMESTER, semestre);
            values.put(SurveyDatabaseContract.GroupEntry.COLUMN_YEAR, año);
            values.put(SurveyDatabaseContract.GroupEntry.COLUMN_CAREER_ID, id_carrera);
            values.put(SurveyDatabaseContract.GroupEntry.COLUMN_CAMPUS_ID, id_sede);

            mDb.insert(SurveyDatabaseContract.GroupEntry.TABLE_NAME, null, values);
        }
        catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Encuenta
    public void insertSurveyEntries()
    {
        try
        {
            insertSurveyEntry(1, "Encuesta Profesor");
            insertSurveyEntry(2, "Encuesta Estudiante");
            insertSurveyEntry(3, "Encuesta Egresado");
            insertSurveyEntry(4, "Encuesta Empresario");
        }
        catch (Exception error){throw error;}
    }
    public void insertSurveyEntry(int id_encuesta, String titulo)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_ID, id_encuesta);
            values.put(SurveyDatabaseContract.SurveyEntry.COLUMN_SURVEY_TITLE, titulo);

            mDb.insert(SurveyDatabaseContract.SurveyEntry.TABLE_NAME, null, values);
        }
        catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Seccion_E
    public void insertSurveySectionEntries()
    {
        try
        {
            insertSurveySectionEntry(1, "Sección A: Generales Profesor", 1);
            insertSurveySectionEntry(2, "Sección B: Calificar Grupo", 1);
            insertSurveySectionEntry(3, "Sección A: Información General", 2);
            insertSurveySectionEntry(4, "Sección B: Sobre la Asignatura", 2);
            insertSurveySectionEntry(5, "Sección C: Cantidad de Evaluaciones Realizadas", 2);
            insertSurveySectionEntry(6, "Sección D: Servicios Académicos", 2);
            insertSurveySectionEntry(7, "Sección A: Generales Demográficos", 3);
            insertSurveySectionEntry(8, "Sección B: Generales de Contacto", 3);
            insertSurveySectionEntry(9, "Sección A: Datos Generales de la empresa", 4);
            insertSurveySectionEntry(10, "Sección B: Perfil Profesional", 4);
            insertSurveySectionEntry(11, "Sección C: Datos generales de la persona que llena la encuesta", 4);
        }
        catch (Exception error)
        {
            throw error;
        }
    }
    public void insertSurveySectionEntry(int id_seccion, String descripcion, int id_encuesta)
    {
        try
        {
            ContentValues values = new ContentValues();

            values.put(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_ID, id_seccion);
            values.put(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_SECTION_DESCRIPTION, descripcion);
            values.put(SurveyDatabaseContract.SurveySectionEntry.COLUMN_SURVEY_ID, id_encuesta);

            mDb.insert(SurveyDatabaseContract.SurveySectionEntry.TABLE_NAME, null, values);
        }
        catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Respuesta
    public void insertSurveyRespondEntries()
    {
        try
        {
            insertSurveyRespondEntry(1,16,1, 35, 130, "6", 123, 5, "I semestre", 2020-07-02);
            insertSurveyRespondEntry(2,36,3, 1, 1, null, 0, 0, null, 2020-07-02);
            insertSurveyRespondEntry(3,40,3, 1, 1, null, 0, 0, null, 2020-07-02);
            insertSurveyRespondEntry(4,40,3, 2, 4, null, 0, 0, null, 2020-07-02);
        }
        catch (Exception error){throw error;}
    }
    public void insertSurveyRespondEntry(int id_respuesta, int id_usuario, int id_encuesta, int id_pregunta, int id_opcion, String descrip_respuesta, int id_asignatura, int id_grupo, String semestre, int anno)
    {
        try
        {
            ContentValues values = new ContentValues();

            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_ID,id_respuesta);
            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_USER_ID,id_usuario);
            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SURVEY_ID,id_encuesta);
            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_QUESTION_ID,id_pregunta);
            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_OPTION_ID,id_opcion);
            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_DESCRIPTION,descrip_respuesta);
            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SUBJECT_ID,id_asignatura);
            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_GROUP_ID,id_grupo);
            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_SEMESTER,semestre);
            values.put(SurveyDatabaseContract.SurveyRespondEntry.COLUMN_SURVEY_RESPOND_YEAR,anno);

            mDb.insert(SurveyDatabaseContract.SurveyRespondEntry.TABLE_NAME, null, values);
        }
        catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Opciones
    public void insertSurveyQuestionOptionEntries()
    {
        try
        {
            insertSurveyQuestionOptionEntry(1, "Masculino", 1);
            insertSurveyQuestionOptionEntry(2, "Femenino", 1);
            insertSurveyQuestionOptionEntry(3, "Campus Metropolitano Víctor Levi Sasso", 2);
            insertSurveyQuestionOptionEntry(4, "CR de Azuero", 2);
            insertSurveyQuestionOptionEntry(5, "CR de Bocas del Toro", 2);
            insertSurveyQuestionOptionEntry(6, "CR de Chiriquí", 2);
            insertSurveyQuestionOptionEntry(7, "CR de Coclé", 2);
            insertSurveyQuestionOptionEntry(8, "CR de Colón", 2);
            insertSurveyQuestionOptionEntry(9, "CR de Panamá Oeste", 2);
            insertSurveyQuestionOptionEntry(10, "CR de Veraguas", 2);
            insertSurveyQuestionOptionEntry(11, "Escriba el año de su promoción ejemplo: 1996", 3);
            insertSurveyQuestionOptionEntry(12, "Campus Metropolitano Víctor Levi Sasso", 4);
            insertSurveyQuestionOptionEntry(13, "CR de Azuero", 4);
            insertSurveyQuestionOptionEntry(14, "CR de Bocas del Toro", 4);
            insertSurveyQuestionOptionEntry(15, "CR de Chiriquí", 4);
            insertSurveyQuestionOptionEntry(16, "CR de Coclé", 4);
            insertSurveyQuestionOptionEntry(17, "CR de Colón", 4);
            insertSurveyQuestionOptionEntry(18, "CR de Panamá Oeste", 4);
            insertSurveyQuestionOptionEntry(19, "CR de Veraguas", 4);
            insertSurveyQuestionOptionEntry(20, "Introduzca el correo electrónico y vuelva a escribirlo para validar", 5);
            insertSurveyQuestionOptionEntry(21, "Escriba su número celular de la siguiente manera: 6666-5555", 6);
            insertSurveyQuestionOptionEntry(22, "Introduzca el nombre de su lugar de Residencial", 7);
            insertSurveyQuestionOptionEntry(23, "Introduzca el nombre de su lugar de trabajo", 8);
            insertSurveyQuestionOptionEntry(24, "Escriba su número de trabajo de la siguiente manera: 560-3600", 9);
            insertSurveyQuestionOptionEntry(25, "2000", 10);
            insertSurveyQuestionOptionEntry(26, "2001", 10);
            insertSurveyQuestionOptionEntry(27, "2002", 10);
            insertSurveyQuestionOptionEntry(28, "2003", 10);
            insertSurveyQuestionOptionEntry(29, "2004", 10);
            insertSurveyQuestionOptionEntry(30, "2005", 10);
            insertSurveyQuestionOptionEntry(31, "2006", 10);
            insertSurveyQuestionOptionEntry(32, "2007", 10);
            insertSurveyQuestionOptionEntry(33, "2008", 10);
            insertSurveyQuestionOptionEntry(34, "2009", 10);
            insertSurveyQuestionOptionEntry(35, "2010", 10);
            insertSurveyQuestionOptionEntry(36, "2011", 10);
            insertSurveyQuestionOptionEntry(37, "2012", 10);
            insertSurveyQuestionOptionEntry(38, "2013", 10);
            insertSurveyQuestionOptionEntry(39, "Sí", 11);
            insertSurveyQuestionOptionEntry(40, "No", 11);
            insertSurveyQuestionOptionEntry(41, "Licenciatura en Ingeniería de Sistemas de Información", 12);
            insertSurveyQuestionOptionEntry(42, "Licenciatura en Ingeniería de Software", 12);
            insertSurveyQuestionOptionEntry(43, "Licenciatura en Desarrollo de Software", 12);
            insertSurveyQuestionOptionEntry(44, "Licenciatura en Informática Aplicada a la Educación", 12);
            insertSurveyQuestionOptionEntry(45, "Licenciatura en Redes Informáticas", 12);
            insertSurveyQuestionOptionEntry(46, "Técnico en Informática para la Gestión Empresarial", 12);
            insertSurveyQuestionOptionEntry(47, "Otro", 12);
            insertSurveyQuestionOptionEntry(48, "3-2.50", 13);
            insertSurveyQuestionOptionEntry(49, "1.75-2.49", 13);
            insertSurveyQuestionOptionEntry(50, "1.00-1.74", 13);
            insertSurveyQuestionOptionEntry(51, "Campus Metropolitano Víctor Levi Sasso", 14);
            insertSurveyQuestionOptionEntry(52, "CR de Azuero", 14);
            insertSurveyQuestionOptionEntry(53, "CR de Bocas del Toro", 14);
            insertSurveyQuestionOptionEntry(54, "CR de Chiriquí", 14);
            insertSurveyQuestionOptionEntry(55, "CR de Coclé", 14);
            insertSurveyQuestionOptionEntry(56, "CR de Colón", 14);
            insertSurveyQuestionOptionEntry(57, "CR de Panamá Oeste", 14);
            insertSurveyQuestionOptionEntry(58, "CR de Veraguas", 14);
            insertSurveyQuestionOptionEntry(59, "Recursos Propios", 15);
            insertSurveyQuestionOptionEntry(60, "Recursos Familiares", 15);
            insertSurveyQuestionOptionEntry(61, "Beca Local o Internacional", 15);
            insertSurveyQuestionOptionEntry(62, "Intercambio Estudiantil", 15);
            insertSurveyQuestionOptionEntry(63, "Sí", 16);
            insertSurveyQuestionOptionEntry(64, "No", 16);
            insertSurveyQuestionOptionEntry(65, "Exoneración de matricula", 17);
            insertSurveyQuestionOptionEntry(66, "Compra de texto y materiales de trabajo", 17);
            insertSurveyQuestionOptionEntry(67, "Trabajo compensatorio de matricula", 17);
            insertSurveyQuestionOptionEntry(68, "Ayuda económica para transporte", 17);
            insertSurveyQuestionOptionEntry(69, "Crédito de librería", 17);
            insertSurveyQuestionOptionEntry(70, "Ayuda económica de alimentación", 17);
            insertSurveyQuestionOptionEntry(71, "Otro", 17);
            insertSurveyQuestionOptionEntry(72, "Disponibilidad de laboratorios", 18);
            insertSurveyQuestionOptionEntry(73, "Existencia de espacios para desarrollar sus actividades de estudio", 18);
            insertSurveyQuestionOptionEntry(74, "Acceso y capacitación para el uso de la red de Internet", 18);
            insertSurveyQuestionOptionEntry(75, "Disponibilidad de equipo audiovisual", 18);
            insertSurveyQuestionOptionEntry(76, "Calidad de las instalaciones en edificios", 18);
            insertSurveyQuestionOptionEntry(77, "Equipamiento en aulas", 18);
            insertSurveyQuestionOptionEntry(78, "Servicios de bibliotecas e instalaciones", 18);
            insertSurveyQuestionOptionEntry(79, "Acesso a becas", 18);
            insertSurveyQuestionOptionEntry(80, "Acceso a actividades culturales", 18);
            insertSurveyQuestionOptionEntry(81, "Acceso y uso de gimnasio", 18);
            insertSurveyQuestionOptionEntry(82, "Trámites administrativos", 18);
            insertSurveyQuestionOptionEntry(83, "Centro de Idiomas", 18);
            insertSurveyQuestionOptionEntry(84, "Formación en investigación", 19);
            insertSurveyQuestionOptionEntry(85, "Formación en Metodología de la Investigación", 20);
            insertSurveyQuestionOptionEntry(86, "Sí", 21);
            insertSurveyQuestionOptionEntry(87, "No", 21);
            insertSurveyQuestionOptionEntry(88, "Escriba su titulo ejemplo: Lic. Desarrollo de Software", 22);
            insertSurveyQuestionOptionEntry(89, "Sí", 23);
            insertSurveyQuestionOptionEntry(90, "No", 23);
            insertSurveyQuestionOptionEntry(91, "Medio Tiempo", 24);
            insertSurveyQuestionOptionEntry(92, "Tiempo Completo", 24);
            insertSurveyQuestionOptionEntry(93, "Sí", 25);
            insertSurveyQuestionOptionEntry(94, "No", 25);
            insertSurveyQuestionOptionEntry(95, "El trabajo que desempeña está relacionado con el programa de estudio", 26);
            insertSurveyQuestionOptionEntry(96, "Gremios", 27);
            insertSurveyQuestionOptionEntry(97, "Municipio", 27);
            insertSurveyQuestionOptionEntry(98, "Gobierno", 27);
            insertSurveyQuestionOptionEntry(99, "Empresa Privada", 27);
            insertSurveyQuestionOptionEntry(100, "Ongs", 27);

            insertSurveyQuestionOptionEntry(101, "Comunidades", 27);
            insertSurveyQuestionOptionEntry(102, "Otro", 27);
            insertSurveyQuestionOptionEntry(103, "Participa de forma activa en la especificación, análisis, diseño e implementación de soluciones tecnológicas en inteligencia artificial.", 28);
            insertSurveyQuestionOptionEntry(104, "Aplica los principios del pensamiento sistémico en la caracterización, modelado y desarrollo de diversos sistemas.", 28);
            insertSurveyQuestionOptionEntry(105, "Conceptualiza, analiza, modela y simula problemas organizacionales complejos e implementa soluciones integrales a los mismos.", 28);
            insertSurveyQuestionOptionEntry(106, "Construye modelos e imágenes por computador que permiten la creación de ambientes interactivos en 3D.", 28);
            insertSurveyQuestionOptionEntry(107, "Aplica los principios de los sistemas robóticos en el analisis, diseño, contrucción e implementación de soluciones tecnológicas.", 28);
            insertSurveyQuestionOptionEntry(108, "Participa de forma activa en la especificación, análisis, diseño e implementación de videojuegos para diversas interfaces de usuario.", 28);
            insertSurveyQuestionOptionEntry(109, "Promueve la generación de empleo con innovación, creatividad y emprendimiento; enfrentando los restos de mercado cambiante.", 28);
            insertSurveyQuestionOptionEntry(110, "Otro", 28);
            insertSurveyQuestionOptionEntry(111, "Aspectos Teóricos", 29);
            insertSurveyQuestionOptionEntry(112, "Aspectos Prácticos", 29);
            insertSurveyQuestionOptionEntry(113, "Investigación", 29);
            insertSurveyQuestionOptionEntry(114, "Llenar los 5 campos con las asignaturas", 30);
            insertSurveyQuestionOptionEntry(115, "Llenar los 3 campos con los temas de importancia", 31);
            insertSurveyQuestionOptionEntry(116, "Satisfacción con respecto a su plan de estudio o formación", 32);
            insertSurveyQuestionOptionEntry(117, "Sí", 33);
            insertSurveyQuestionOptionEntry(118, "No", 33);
            insertSurveyQuestionOptionEntry(119, "Congresos", 34);
            insertSurveyQuestionOptionEntry(120, "Seminarios", 34);
            insertSurveyQuestionOptionEntry(121, "Ferias", 34);
            insertSurveyQuestionOptionEntry(122, "Educación Continua ", 34);
            insertSurveyQuestionOptionEntry(123, "Convenios", 34);
            insertSurveyQuestionOptionEntry(124, "Actividades Culturales", 34);
            insertSurveyQuestionOptionEntry(125, "Sociales y deportivas", 34);
            insertSurveyQuestionOptionEntry(126, "Redes Sociales", 34);
            insertSurveyQuestionOptionEntry(127, "TV", 34);
            insertSurveyQuestionOptionEntry(128, "Periódicos", 34);
            insertSurveyQuestionOptionEntry(129, "Otro", 34);
            insertSurveyQuestionOptionEntry(130, "Escriba los temas que no se dieron", 35);
            insertSurveyQuestionOptionEntry(131, "Escriba el porcentaje del cumplimiento del curso", 36);
            insertSurveyQuestionOptionEntry(132, "Métodos expositivos", 37);
            insertSurveyQuestionOptionEntry(133, "Métodos expositivos", 37);
            insertSurveyQuestionOptionEntry(134, "Métodos basados en la demostración práctica ", 37);
            insertSurveyQuestionOptionEntry(135, "Métodos basados en el trabajo de grupo(Talleres/Practicas)", 37);
            insertSurveyQuestionOptionEntry(136, "Tutorías", 37);
            insertSurveyQuestionOptionEntry(137, "Estudios de casos ", 37);
            insertSurveyQuestionOptionEntry(138, "Resolucion de problemas ", 37);
            insertSurveyQuestionOptionEntry(139, "Laboratorios ", 37);
            insertSurveyQuestionOptionEntry(140, "Otros escriba", 37);
            insertSurveyQuestionOptionEntry(141, "Proyectos", 38);
            insertSurveyQuestionOptionEntry(142, "Laboratorios ", 38);
            insertSurveyQuestionOptionEntry(143, "Giras técnicas", 38);
            insertSurveyQuestionOptionEntry(144, "Investigaciones", 38);
            insertSurveyQuestionOptionEntry(145, "Síntesis y/o resúmenes", 38);
            insertSurveyQuestionOptionEntry(146, "Presentación orales(charlas)", 38);
            insertSurveyQuestionOptionEntry(147, "Resolucion de problemas ", 38);
            insertSurveyQuestionOptionEntry(148, "Mapas conceptuales / cuadros ", 38);
            insertSurveyQuestionOptionEntry(149, "Ejercicios escritos", 38);
            insertSurveyQuestionOptionEntry(150, "Lecturas", 38);
            insertSurveyQuestionOptionEntry(151, "Portafolio estudiantil ", 38);
            insertSurveyQuestionOptionEntry(152, "Estudios de casos ", 38);
            insertSurveyQuestionOptionEntry(153, "Ensayos(artículos)", 38);
            insertSurveyQuestionOptionEntry(154, "Trabajo en equipo", 38);
            insertSurveyQuestionOptionEntry(155, "Blogs", 38);
            insertSurveyQuestionOptionEntry(156, "Foros virtuales o chats", 38);
            insertSurveyQuestionOptionEntry(157, "Otros escriba", 38);
            insertSurveyQuestionOptionEntry(158, "Conferencias", 39);
            insertSurveyQuestionOptionEntry(159, "Seminarios", 39);
            insertSurveyQuestionOptionEntry(160, "Congresos", 39);
            insertSurveyQuestionOptionEntry(161, "Servicio social", 39);
            insertSurveyQuestionOptionEntry(162, "Ferias", 39);
            insertSurveyQuestionOptionEntry(163, "Exposiciones", 39);
            insertSurveyQuestionOptionEntry(164, "Asistente de investigación", 39);
            insertSurveyQuestionOptionEntry(165, "Giras ", 39);
            insertSurveyQuestionOptionEntry(166, "Pasantía en empresas", 39);
            insertSurveyQuestionOptionEntry(167, "Cultura y/o deporte", 39);
            insertSurveyQuestionOptionEntry(168, "Grupo de investigación", 39);
            insertSurveyQuestionOptionEntry(169, "Jamboree", 39);
            insertSurveyQuestionOptionEntry(170, "Trabajo social", 39);
            insertSurveyQuestionOptionEntry(171, "Otros escriba", 39);
            insertSurveyQuestionOptionEntry(172, "Tablero", 40);
            insertSurveyQuestionOptionEntry(173, "Videos", 40);
            insertSurveyQuestionOptionEntry(174, "Tablero difital", 40);
            insertSurveyQuestionOptionEntry(175, "Software usado", 40);
            insertSurveyQuestionOptionEntry(176, "Presentaciones(archivos.ppt)", 40);
            insertSurveyQuestionOptionEntry(177, "Referencias bibliograficas", 40);
            insertSurveyQuestionOptionEntry(178, "Folletos del docente", 40);
            insertSurveyQuestionOptionEntry(179, "Otros escriba", 40);
            insertSurveyQuestionOptionEntry(180, "Asisten normalmente a clase.", 41);
            insertSurveyQuestionOptionEntry(181, "Cumplen los distintos compromisos de la clase.", 41);
            insertSurveyQuestionOptionEntry(182, "Conocen el programa del curso desde el principio del semestre.", 41);
            insertSurveyQuestionOptionEntry(183, "Dan seguimiento al cronograma del curso durante el semestre.", 41);
            insertSurveyQuestionOptionEntry(184, "Manifiesta entusiasmo-profesor es fluida y espontánea, creando un clima de confianza y respeto.", 41);
            insertSurveyQuestionOptionEntry(185, "Dedican tiempo del extra-aula a la materia.", 41);
            insertSurveyQuestionOptionEntry(186, "Utilizan materiales de apoyo adicionales al de la materia.", 41);
            insertSurveyQuestionOptionEntry(187, "Utilizan herramientas tecnológicas como: Pág.Web, cursos en línea, simuladores.", 41);
            insertSurveyQuestionOptionEntry(188, "Son respetuosos entre compañeros.", 41);
            insertSurveyQuestionOptionEntry(189, "Muestran interés hacia la consulta de la bibliof¡grafía de referencia asignada.", 41);
            insertSurveyQuestionOptionEntry(190, "Muestra interés en prepararse adecuadamente para las pruebas.", 41);
            insertSurveyQuestionOptionEntry(191, "Actitud hacia la investigación de los temas tratados.", 41);
            insertSurveyQuestionOptionEntry(192, "Son puntuales en la entrega de trabajos.", 41);
            insertSurveyQuestionOptionEntry(193, "Muestran orden en interés durante el periodo de la clase.", 41);
            insertSurveyQuestionOptionEntry(194, "Totalmente satisfecho", 42);
            insertSurveyQuestionOptionEntry(195, "Satisfecho", 42);
            insertSurveyQuestionOptionEntry(196, "Apenas satisfecho", 42);
            insertSurveyQuestionOptionEntry(197, "Insatisfecho", 42);
            insertSurveyQuestionOptionEntry(198, "totalmente Insatisfecho", 42);
            insertSurveyQuestionOptionEntry(199, "No(Pase a pregunta N°4)", 43);
            insertSurveyQuestionOptionEntry(200, "Si(Pase a la pregunta N°5)", 43);

            insertSurveyQuestionOptionEntry(201, "Razonamiento en la matemática", 44);
            insertSurveyQuestionOptionEntry(202, "Pre-requisito del curso", 44);
            insertSurveyQuestionOptionEntry(203, "Lectura comprensiva", 44);
            insertSurveyQuestionOptionEntry(204, "RazonamientO Verbal", 44);
            insertSurveyQuestionOptionEntry(205, "Otros escriba", 44);
            insertSurveyQuestionOptionEntry(206, "escriba su sugerencia o comentario de la asignatura", 45);
            insertSurveyQuestionOptionEntry(207, "Campus Metropolitano Víctor Levi Sasso", 46);
            insertSurveyQuestionOptionEntry(208, "CR de Azuero", 46);
            insertSurveyQuestionOptionEntry(209, "CR de Bocas del Toro", 46);
            insertSurveyQuestionOptionEntry(210, "CR de Chiriquí", 46);
            insertSurveyQuestionOptionEntry(211, "CR de Coclé", 46);
            insertSurveyQuestionOptionEntry(212, "CR de Colón", 46);
            insertSurveyQuestionOptionEntry(213, "CR de Panamá Oeste", 46);
            insertSurveyQuestionOptionEntry(214, "CR de Veraguas", 46);
            insertSurveyQuestionOptionEntry(215, "Licenciatura en Ingeniería de Sistemas de Información", 47);
            insertSurveyQuestionOptionEntry(216, "Licenciatura en Ingeniería de Sistemas y Computación", 47);
            insertSurveyQuestionOptionEntry(217, "Licenciatura en Ingeniería de Software", 47);
            insertSurveyQuestionOptionEntry(218, "Licenciatura en Desarrollo de Software", 47);
            insertSurveyQuestionOptionEntry(219, "Licenciatura en Informática Aplicada a la Educación", 47);
            insertSurveyQuestionOptionEntry(220, "Licenciatura en Informática para la Gestión Empresarial", 47);
            insertSurveyQuestionOptionEntry(221, "I Semestre", 48);
            insertSurveyQuestionOptionEntry(222, "II Semestre", 48);
            insertSurveyQuestionOptionEntry(223, "Verano", 48);
            insertSurveyQuestionOptionEntry(224, "METODOLOGÍA DE INVESTIGACIÓN EN ING.", 49);
            insertSurveyQuestionOptionEntry(225, "ESTRUCTURAS DISCRETAS PARA LA COMP.", 49);
            insertSurveyQuestionOptionEntry(226, "HERRAMIENTAS APLIC. A LA INTEL. ARTIF.", 49);
            insertSurveyQuestionOptionEntry(227, "HERRAMIENTAS DE COMPUTACIÓN GRÁFICA", 49);
            insertSurveyQuestionOptionEntry(228, "ANIMACIÓN DIGITAL Y VIDEO JUEGOS", 49);
            insertSurveyQuestionOptionEntry(229, "TÓPICOS ESPECIALES I", 49);
            insertSurveyQuestionOptionEntry(230, "INGENIERÍA DE SISTEMAS ROBÓTICOS", 49);
            insertSurveyQuestionOptionEntry(231, "MODELADO Y SIMULACIÓN", 49);
            insertSurveyQuestionOptionEntry(232, "TÓPICOS ESPECIALES II", 49);
            insertSurveyQuestionOptionEntry(233, "MÉTODOS NUMÉRICOS PARA ING.", 49);
            insertSurveyQuestionOptionEntry(234, "ESTRUCTURA DE DATOS I", 49);
            insertSurveyQuestionOptionEntry(235, "ESTRUCTURA DE DATOS II", 49);
            insertSurveyQuestionOptionEntry(236, "INGENIERÍA DE SISTEMAS DINÁMICOS", 49);
            insertSurveyQuestionOptionEntry(237, "INTELIGENCIA ARTIFICIAL", 49);
            insertSurveyQuestionOptionEntry(238, "SISTEMAS BASADOS EN EL CONOCIMIENTO", 49);
            insertSurveyQuestionOptionEntry(239, "LENGUAJE FORMALES, AUTÓMATAS Y COMPIL.", 49);
            insertSurveyQuestionOptionEntry(240, "TRABAJO DE GRADUACIÓN I", 49);
            insertSurveyQuestionOptionEntry(241, "TRABAJO DE GRADUACIÓN II", 49);
            insertSurveyQuestionOptionEntry(242, "CÁLCULO I", 49);
            insertSurveyQuestionOptionEntry(243, "REDACCIÓN DE INFORMES Y EXPRESIÓN ORAL", 49);
            insertSurveyQuestionOptionEntry(244, "INGLÉS CONVERSACIONAL", 49);
            insertSurveyQuestionOptionEntry(245, "DIBUJO ASISTIDO POR COMPUTADORAS", 49);
            insertSurveyQuestionOptionEntry(246, "TÓPICOS DE GEOGRAFÍA E HISTORIA DE PANAMÁ", 49);
            insertSurveyQuestionOptionEntry(247, "CÁLCULO II", 49);
            insertSurveyQuestionOptionEntry(248, "CÁLCULO III", 49);
            insertSurveyQuestionOptionEntry(249, "INTRODUCCIÓN A LA QUÍMICA", 49);
            insertSurveyQuestionOptionEntry(250, "ECUACIONES DIFERENCIALES ORDINARIAS", 49);
            insertSurveyQuestionOptionEntry(251, "FÍSICA I (MECÁNICA)", 49);
            insertSurveyQuestionOptionEntry(252, "ESTADÍSTICA CON APOYO INFORMÁTICO", 49);
            insertSurveyQuestionOptionEntry(253, "FÍSICA II (ELECTRICIDAD Y MAGNESTISMO)", 49);
            insertSurveyQuestionOptionEntry(254, "MATEMÁTICAS SUPERIORES PARA ING.", 49);
            insertSurveyQuestionOptionEntry(255, "FORMACIÓN DE EMPRENDEDORES", 49);
            insertSurveyQuestionOptionEntry(256, "MECÁNICA", 49);
            insertSurveyQuestionOptionEntry(257, "ELECTRÓNICA BÁSICA", 49);
            insertSurveyQuestionOptionEntry(258, "CIRCUITOS LÓGICOS", 49);
            insertSurveyQuestionOptionEntry(259, "GERENCIA DE RECURSOS HUMANOS", 49);
            insertSurveyQuestionOptionEntry(260, "INGENIERÍA AMBIENTAL", 49);
            insertSurveyQuestionOptionEntry(261, "POLÍTICA Y LEGISLACIÓN INFORMÁTICA", 49);
            insertSurveyQuestionOptionEntry(262, "ORG. Y ARQUITECTURA DE COMPUTADORA", 49);
            insertSurveyQuestionOptionEntry(263, "SISTEMAS OPERATIVOS", 49);
            insertSurveyQuestionOptionEntry(264, "REDES INFORMÁTICAS", 49);
            insertSurveyQuestionOptionEntry(265, "SEGURIDAD EN TECNOLOGÍA DE COMPUTACIÓN", 49);
            insertSurveyQuestionOptionEntry(266, "FORM. Y EVALUACIÓN DE PROY. INFORMÁTICOS", 49);
            insertSurveyQuestionOptionEntry(267, "INTERACCIÓN HUMANO COMPUTADOR (HCI)", 49);
            insertSurveyQuestionOptionEntry(268, "INGENIERÍA DE SOFTWARE", 49);
            insertSurveyQuestionOptionEntry(269, "INGENIERÍA DE SOFTWARE II", 49);
            insertSurveyQuestionOptionEntry(270, "DESARROLLO LÓGICO Y ALGORITMOS", 49);
            insertSurveyQuestionOptionEntry(271, "HERRAMIENTAS DE PROGRAMACIÓN APLICADA I", 49);
            insertSurveyQuestionOptionEntry(272, "HERRAMIENTAS DE PROGRAMACIÓN APLICADA II", 49);
            insertSurveyQuestionOptionEntry(273, "HERRAMIENTAS DE PROGRAMACIÓN APLICADA III", 49);
            insertSurveyQuestionOptionEntry(274, "HERRAMIENTAS DE PROGRAMACIÓN APLICADAS IV", 49);
            insertSurveyQuestionOptionEntry(275, "TECNOLOGÍA DE INFORMACIÓN Y COMUNICACIÓN", 49);
            insertSurveyQuestionOptionEntry(276, "SISTEMAS COLABORATIVOS", 49);
            insertSurveyQuestionOptionEntry(277, "BASE DE DATOS I", 49);
            insertSurveyQuestionOptionEntry(278, "BASE DE DATOS II", 49);
            insertSurveyQuestionOptionEntry(279, "Introduzca el grupo", 50);
            insertSurveyQuestionOptionEntry(280, "Semana1", 51);
            insertSurveyQuestionOptionEntry(281, "Semana2", 51);
            insertSurveyQuestionOptionEntry(282, "Semana3", 51);
            insertSurveyQuestionOptionEntry(283, "Semana4", 51);
            insertSurveyQuestionOptionEntry(284, "Semana5", 51);
            insertSurveyQuestionOptionEntry(285, "Semana6", 51);
            insertSurveyQuestionOptionEntry(286, "Semana7", 51);
            insertSurveyQuestionOptionEntry(287, "Semana8", 51);
            insertSurveyQuestionOptionEntry(288, "Semana9", 51);
            insertSurveyQuestionOptionEntry(289, "Semana10", 51);
            insertSurveyQuestionOptionEntry(290, "Semana11", 51);
            insertSurveyQuestionOptionEntry(291, "Semana12", 51);
            insertSurveyQuestionOptionEntry(292, "Semana13", 51);
            insertSurveyQuestionOptionEntry(293, "Semana14", 51);
            insertSurveyQuestionOptionEntry(294, "Semana15", 51);
            insertSurveyQuestionOptionEntry(295, "Semana16", 51);
            insertSurveyQuestionOptionEntry(296, "I año", 52);
            insertSurveyQuestionOptionEntry(297, "II año", 52);
            insertSurveyQuestionOptionEntry(298, "III año", 52);
            insertSurveyQuestionOptionEntry(299, "IV año", 52);
            insertSurveyQuestionOptionEntry(300, "V año", 52);

            insertSurveyQuestionOptionEntry(301, "Otros", 52);
            insertSurveyQuestionOptionEntry(302, "Escriba el nombre del Profesor (Primer Nombre y Primer Apellido)", 53);
            insertSurveyQuestionOptionEntry(303, "Plan de Contenido", 54);
            insertSurveyQuestionOptionEntry(304, "Cronograma de la Asignatura", 54);
            insertSurveyQuestionOptionEntry(305, "Cuadro de Calificaciones", 54);
            insertSurveyQuestionOptionEntry(306, "Otros", 54);
            insertSurveyQuestionOptionEntry(307, "Escriba el nombre del tema dado", 55);
            insertSurveyQuestionOptionEntry(308, "Clases Magistrales", 56);
            insertSurveyQuestionOptionEntry(309, "Exposición DialogadaExposición Dialogada", 56);
            insertSurveyQuestionOptionEntry(310, "Demostraciones Prácticas", 56);
            insertSurveyQuestionOptionEntry(311, "Talleres/Prácticas", 56);
            insertSurveyQuestionOptionEntry(312, "Tutorías", 56);
            insertSurveyQuestionOptionEntry(313, "Estudios de Casos", 56);
            insertSurveyQuestionOptionEntry(314, "Resolución de Problemas", 56);
            insertSurveyQuestionOptionEntry(315, "Laboratorios", 56);
            insertSurveyQuestionOptionEntry(316, "Giras Técnicas", 56);
            insertSurveyQuestionOptionEntry(317, "Portafolio Estudiantil", 56);
            insertSurveyQuestionOptionEntry(318, "Proyectos", 56);
            insertSurveyQuestionOptionEntry(319, "Investigaciones", 56);
            insertSurveyQuestionOptionEntry(320, "Síntesis y/o Resúmenes", 56);
            insertSurveyQuestionOptionEntry(321, "Presentaciones Orales (Charlas)", 56);
            insertSurveyQuestionOptionEntry(322, "Mapas Conceptuales", 56);
            insertSurveyQuestionOptionEntry(323, "Ejercicios Escritos", 56);
            insertSurveyQuestionOptionEntry(324, "Ensayos (artículos)", 56);
            insertSurveyQuestionOptionEntry(325, "Foros o chats", 56);
            insertSurveyQuestionOptionEntry(326, "Lecturas", 56);
            insertSurveyQuestionOptionEntry(327, "Blogs", 56);
            insertSurveyQuestionOptionEntry(328, "Otros", 56);
            insertSurveyQuestionOptionEntry(329, "Ciclos de conferencias", 57);
            insertSurveyQuestionOptionEntry(330, "Seminarios", 57);
            insertSurveyQuestionOptionEntry(331, "Charlas", 57);
            insertSurveyQuestionOptionEntry(332, "Ferias", 57);
            insertSurveyQuestionOptionEntry(333, "Congresos", 57);
            insertSurveyQuestionOptionEntry(334, "Talleres", 57);
            insertSurveyQuestionOptionEntry(335, "Ninguna", 57);
            insertSurveyQuestionOptionEntry(336, "Otros", 57);
            insertSurveyQuestionOptionEntry(337, "Clases Magistrales", 58);
            insertSurveyQuestionOptionEntry(338, "Exposición Dialogada", 58);
            insertSurveyQuestionOptionEntry(339, "Demostraciones Prácticas", 58);
            insertSurveyQuestionOptionEntry(340, "Talleres/Prácticas", 58);
            insertSurveyQuestionOptionEntry(341, "Tutorías", 58);
            insertSurveyQuestionOptionEntry(342, "Estudios de Casos", 58);
            insertSurveyQuestionOptionEntry(343, "Resolución de Problemas", 58);
            insertSurveyQuestionOptionEntry(344, "Laboratorios", 58);
            insertSurveyQuestionOptionEntry(345, "Giras Técnicas", 58);
            insertSurveyQuestionOptionEntry(346, "Portafolio Estudiantil", 58);
            insertSurveyQuestionOptionEntry(347, "Proyectos", 58);
            insertSurveyQuestionOptionEntry(348, "Investigaciones", 58);
            insertSurveyQuestionOptionEntry(349, "Síntesis y/o Resúmenes", 58);
            insertSurveyQuestionOptionEntry(350, "Presentaciones Orales (Charlas)", 58);
            insertSurveyQuestionOptionEntry(351, "Mapas Conceptuales", 58);
            insertSurveyQuestionOptionEntry(352, "Ejercicios Escritos", 58);
            insertSurveyQuestionOptionEntry(353, "Ensayos (artículos)", 58);
            insertSurveyQuestionOptionEntry(354, "Foros o chats", 58);
            insertSurveyQuestionOptionEntry(355, "Lecturas", 58);
            insertSurveyQuestionOptionEntry(356, "Blogs", 58);
            insertSurveyQuestionOptionEntry(357, "Otros", 58);
            insertSurveyQuestionOptionEntry(358, "Introduzca la cantidad de parciales", 59);
            insertSurveyQuestionOptionEntry(359, "Introduzca la cantidad de laboratorios", 60);
            insertSurveyQuestionOptionEntry(360, "Introduzca la cantidad de proyectos", 61);
            insertSurveyQuestionOptionEntry(361, "Introduzca la cantidad de tareas", 62);
            insertSurveyQuestionOptionEntry(362, "Introduzca la cantidad de quices", 63);
            insertSurveyQuestionOptionEntry(363, "Introduzca la cantidad de talleres/Prácticas", 64);
            insertSurveyQuestionOptionEntry(364, "Otros", 65);
            insertSurveyQuestionOptionEntry(365, "Introduzca cantidad de investigaciones", 66);
            insertSurveyQuestionOptionEntry(366, "Proceso de Matrícula a estudiante de pregrado", 67);
            insertSurveyQuestionOptionEntry(367, "Proceso de Retiro e inclusión", 67);
            insertSurveyQuestionOptionEntry(368, "Recepción, archivo y /o actualización de expedientes estudiantiles", 67);
            insertSurveyQuestionOptionEntry(369, "Trámite de carta excusa", 67);
            insertSurveyQuestionOptionEntry(370, "Exámenes Final Extraordinario y Rehabilitación", 67);
            insertSurveyQuestionOptionEntry(371, "Cambio de carrera, facultad o centro regional", 67);
            insertSurveyQuestionOptionEntry(372, "Trámite de Convalidación", 67);
            insertSurveyQuestionOptionEntry(373, "Matrícula 2 materias de Maestría como opción del trabajo de Graduación", 67);
            insertSurveyQuestionOptionEntry(374, "Otros", 67);
            insertSurveyQuestionOptionEntry(375, "Escriba el tramite realizado correspondiente a la opción anterior", 68);
            insertSurveyQuestionOptionEntry(376, "Proceso de Matrícula a estudiante de pregrado", 69);
            insertSurveyQuestionOptionEntry(377, "Proceso de Retiro e inclusión", 69);
            insertSurveyQuestionOptionEntry(378, "Recepción, archivo y /o actualización de expedientes estudiantiles", 69);
            insertSurveyQuestionOptionEntry(379, "Trámite de carta excusa", 69);
            insertSurveyQuestionOptionEntry(380, "Exámenes semestrales Extraordinario y Rehabilitación", 69);
            insertSurveyQuestionOptionEntry(381, "Cambio de carrera, facultad o centro regional", 69);
            insertSurveyQuestionOptionEntry(382, "Trámite de convalidación", 69);
            insertSurveyQuestionOptionEntry(383, "Matrícula 2 materias de Maestría como opción del trabajo de Graduación", 69);
            insertSurveyQuestionOptionEntry(384, "Otros", 69);
            insertSurveyQuestionOptionEntry(385, "Escriba el tramite realizado correspondiente a la opción anterior", 70);
            insertSurveyQuestionOptionEntry(386, "Pública", 71);
            insertSurveyQuestionOptionEntry(387, "Privada", 71);
            insertSurveyQuestionOptionEntry(388, "ONG", 71);
            insertSurveyQuestionOptionEntry(389, "Otro", 71);
            insertSurveyQuestionOptionEntry(390, "Micro empresa (hasta la suma de B/.150,000.00)", 72);
            insertSurveyQuestionOptionEntry(391, "Pequeña (desde B/.150,001.00 hasta B/.1,000,000.00)", 72);
            insertSurveyQuestionOptionEntry(392, "Mediana (desde B/.1, 000,001 hasta B/.2, 500,000)", 72);
            insertSurveyQuestionOptionEntry(393, "Grande (de B/.2, 500,001 en adelante)", 72);
            insertSurveyQuestionOptionEntry(394, "Agropecuaria", 73);
            insertSurveyQuestionOptionEntry(395, "Asuntos Legales", 73);
            insertSurveyQuestionOptionEntry(396, "Comercio", 73);
            insertSurveyQuestionOptionEntry(397, "Educación", 73);
            insertSurveyQuestionOptionEntry(398, "Industria Manufacturera", 73);
            insertSurveyQuestionOptionEntry(399, "Logística", 73);
            insertSurveyQuestionOptionEntry(400, "Minera", 73);

            insertSurveyQuestionOptionEntry(401, "Tecnologías de Información y Comunicación", 73);
            insertSurveyQuestionOptionEntry(402, "Turismo", 73);
            insertSurveyQuestionOptionEntry(403, "Asesorías / Consultorías", 73);
            insertSurveyQuestionOptionEntry(404, "Banca / Seguros", 73);
            insertSurveyQuestionOptionEntry(405, "Construcción", 73);
            insertSurveyQuestionOptionEntry(406, "Gubernamental", 73);
            insertSurveyQuestionOptionEntry(407, "Inmobiliarias", 73);
            insertSurveyQuestionOptionEntry(408, "Marítima y Portuaria", 73);
            insertSurveyQuestionOptionEntry(409, "Pesca", 73);
            insertSurveyQuestionOptionEntry(410, "Transporte (aéreo, marítimo, terrestre)", 73);
            insertSurveyQuestionOptionEntry(411, "Otro", 73);
            insertSurveyQuestionOptionEntry(412, "Introduzca el nombre de su empresa y organización", 74);
            insertSurveyQuestionOptionEntry(413, "Menos de 10", 75);
            insertSurveyQuestionOptionEntry(414, "10 a 20", 75);
            insertSurveyQuestionOptionEntry(415, "21 a 49", 75);
            insertSurveyQuestionOptionEntry(416, "50 a 99", 75);
            insertSurveyQuestionOptionEntry(417, "100 a 199", 75);
            insertSurveyQuestionOptionEntry(418, "200 a 249", 75);
            insertSurveyQuestionOptionEntry(419, "250 a 499", 75);
            insertSurveyQuestionOptionEntry(420, "500 a 999", 75);
            insertSurveyQuestionOptionEntry(421, "1000 a 2000", 75);
            insertSurveyQuestionOptionEntry(422, "Más de 2001", 75);
            insertSurveyQuestionOptionEntry(423, "Sí", 76);
            insertSurveyQuestionOptionEntry(424, "No", 76);
            insertSurveyQuestionOptionEntry(425, "Introduzca su explicación", 77);
            insertSurveyQuestionOptionEntry(426, "Ingeniero de Sistemas Computacionales", 78);
            insertSurveyQuestionOptionEntry(427, "Ingeniero de Sistemas de Información", 78);
            insertSurveyQuestionOptionEntry(428, "Ingeniero de Sistemas y Computación", 78);
            insertSurveyQuestionOptionEntry(429, "Licenciado en Desarrollo de Software", 78);
            insertSurveyQuestionOptionEntry(430, "Licenciado en Redes Informáticas", 78);
            insertSurveyQuestionOptionEntry(431, "1 a 2", 79);
            insertSurveyQuestionOptionEntry(432, "3 a 5", 79);
            insertSurveyQuestionOptionEntry(433, "6 a 8", 79);
            insertSurveyQuestionOptionEntry(434, "9 a 10", 79);
            insertSurveyQuestionOptionEntry(435, "Más de 10", 79);
            insertSurveyQuestionOptionEntry(436, "Muy Superior", 80);
            insertSurveyQuestionOptionEntry(437, "Superior", 80);
            insertSurveyQuestionOptionEntry(438, "Similar", 80);
            insertSurveyQuestionOptionEntry(439, "Inferior", 80);
            insertSurveyQuestionOptionEntry(440, "Muy Inferior", 80);
            insertSurveyQuestionOptionEntry(441, "Creatividad e innovación", 81);
            insertSurveyQuestionOptionEntry(442, "Proactividad", 81);
            insertSurveyQuestionOptionEntry(443, "Preparación técnica", 81);
            insertSurveyQuestionOptionEntry(444, "Colaboración", 81);
            insertSurveyQuestionOptionEntry(445, "Responsabilidad en el trabajo", 81);
            insertSurveyQuestionOptionEntry(446, "Habilidades para la expresión oral y escrita", 81);
            insertSurveyQuestionOptionEntry(447, "Capacidad de comunicación en un segundo idioma", 81);
            insertSurveyQuestionOptionEntry(448, "Capacidad de trabajar bajo presión", 81);
            insertSurveyQuestionOptionEntry(449, "Habilidad para trabajar independiente", 81);
            insertSurveyQuestionOptionEntry(450, "Capacidad para trabajar en equipo", 81);
            insertSurveyQuestionOptionEntry(451, "Habilidad en resolver problemas de manera integral", 81);
            insertSurveyQuestionOptionEntry(452, "Habilidad en el uso de herramientas informáticas", 81);
            insertSurveyQuestionOptionEntry(453, "Adaptabilidad", 81);
            insertSurveyQuestionOptionEntry(454, "Capacidad de Liderazgo", 81);
            insertSurveyQuestionOptionEntry(455, "Administración de Proyectos", 82);
            insertSurveyQuestionOptionEntry(456, "Actividades Operativas", 82);
            insertSurveyQuestionOptionEntry(457, "Análisis / Diseño de Sistemas", 82);
            insertSurveyQuestionOptionEntry(458, "Auditoría de Sistemas", 82);
            insertSurveyQuestionOptionEntry(459, "Capacitación", 82);
            insertSurveyQuestionOptionEntry(460, "Construcción de Sistemas", 82);
            insertSurveyQuestionOptionEntry(461, "Consultoría Informática", 82);
            insertSurveyQuestionOptionEntry(462, "Dirección", 82);
            insertSurveyQuestionOptionEntry(463, "Diseño de Aplicaciones", 82);
            insertSurveyQuestionOptionEntry(464, "Ingeniería de Sistemas Robóticos", 82);
            insertSurveyQuestionOptionEntry(465, "Investigación", 82);
            insertSurveyQuestionOptionEntry(466, "Pronóstico y Simulación", 82);
            insertSurveyQuestionOptionEntry(467, "Prueba / Testing", 82);
            insertSurveyQuestionOptionEntry(468, "Redes y Comunicaciones", 82);
            insertSurveyQuestionOptionEntry(469, "Seguridad Informática", 82);
            insertSurveyQuestionOptionEntry(470, "Soporte a Usuarios", 82);
            insertSurveyQuestionOptionEntry(471, "Soporte Técnico", 82);
            insertSurveyQuestionOptionEntry(472, "Otro", 82);
            insertSurveyQuestionOptionEntry(473, "Administración de Redes", 83);
            insertSurveyQuestionOptionEntry(474, "Arquitectura de Computadoras", 83);
            insertSurveyQuestionOptionEntry(475, "Base de Datos", 83);
            insertSurveyQuestionOptionEntry(476, "Ciencia de los datos (Minería de datos)", 83);
            insertSurveyQuestionOptionEntry(477, "Computación Gráfica", 83);
            insertSurveyQuestionOptionEntry(478, "Construcción de Compiladores", 83);
            insertSurveyQuestionOptionEntry(479, "Desarrollo de Software", 83);
            insertSurveyQuestionOptionEntry(480, "Ingeniería de Requerimientos", 83);
            insertSurveyQuestionOptionEntry(481, "Inteligencia Artificial", 83);
            insertSurveyQuestionOptionEntry(482, "Inteligencia de Negocios", 83);
            insertSurveyQuestionOptionEntry(483, "Modelado de Sistemas", 83);
            insertSurveyQuestionOptionEntry(484, "Predicción de Datos (Analítica)", 83);
            insertSurveyQuestionOptionEntry(485, "Programación para Android", 83);
            insertSurveyQuestionOptionEntry(486, "Programación para entornos Web", 83);
            insertSurveyQuestionOptionEntry(487, "Robótica", 83);
            insertSurveyQuestionOptionEntry(488, "Seguridad Informática", 83);
            insertSurveyQuestionOptionEntry(489, "Simulación de Sistemas", 83);
            insertSurveyQuestionOptionEntry(490, "Sistemas Basados en el Conocimiento", 83);
            insertSurveyQuestionOptionEntry(491, "Sistemas Operativos", 83);
            insertSurveyQuestionOptionEntry(492, "Otro", 83);
            insertSurveyQuestionOptionEntry(493, "Introduzca las areas de conocimiento ", 84);
            insertSurveyQuestionOptionEntry(494, "Introduzca las certificaciones", 85);
            insertSurveyQuestionOptionEntry(495, "Índroduzca las recomendaciones", 86);
            insertSurveyQuestionOptionEntry(496, "Masculino", 87);
            insertSurveyQuestionOptionEntry(497, "Femenino", 87);
            insertSurveyQuestionOptionEntry(498, "Técnico Superior", 88);
            insertSurveyQuestionOptionEntry(499, "Licenciatura", 88);
            insertSurveyQuestionOptionEntry(500, "Ingeniería", 88);

            insertSurveyQuestionOptionEntry(501, "Especialización", 88);
            insertSurveyQuestionOptionEntry(502, "Maestría", 88);
            insertSurveyQuestionOptionEntry(503, "Doctorado", 88);
            insertSurveyQuestionOptionEntry(504, "Otro", 88);
            insertSurveyQuestionOptionEntry(505, "Vicepresidente (Ejecutivo)", 89);
            insertSurveyQuestionOptionEntry(506, "Gerente", 89);
            insertSurveyQuestionOptionEntry(507, "Responsable de Departamento", 89);
            insertSurveyQuestionOptionEntry(508, "Responsable de área/proyecto", 89);
            insertSurveyQuestionOptionEntry(509, "Directivo de Recursos Humanos", 89);
            insertSurveyQuestionOptionEntry(510, "Otro", 89);
        }
        catch (Exception error){throw error;}

    }
    public void insertSurveyQuestionOptionEntry(int id_opcion, String descrip_opcion, int id_pregunta)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_OPTION_ID,id_opcion);
            values.put(SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_DESCRIPTION,descrip_opcion);
            values.put(SurveyDatabaseContract.SurveyQuestionOptionEntry.COLUMN_SURVEY_QUESTION_OPTION_QUESTION_ID,id_pregunta);

            mDb.insert(SurveyDatabaseContract.SurveyQuestionOptionEntry.TABLE_NAME, null, values);
        }
        catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Preguntas
    public void insertQuestionEntries()
    {
        try
        {
            insertQuestionEntry(1, "sexo", "A1", 3, 7);
            insertQuestionEntry(2, "Seleccione el campus al cual pertenece", "A2", 3, 7);
            insertQuestionEntry(3, "Promoción", "A3", 3, 7);
            insertQuestionEntry(4, "Indique el Centro Regional donde inicio su carrera, seleccione de la lista", "A4", 3, 7);
            insertQuestionEntry(5, "Correo", "B1", 3, 8);
            insertQuestionEntry(6, "Celular", "B2", 3, 8);
            insertQuestionEntry(7, "Tel.Residencial", "B3", 3, 8);
            insertQuestionEntry(8, "Lugar de Trabajo", "B4", 3, 8);
            insertQuestionEntry(9, "Tel.Trabajo", "B5", 3, 8);
            insertQuestionEntry(10, "¿Año en que ingresó a la Facultad de Ingenería de Sistemas Computacionales?", "B6", 3, 8);
            insertQuestionEntry(11, "Antes de su ingreso el programa de Lic. En Ingeniería dde Sistemas y Computación¿Estuvo en otra carrera de la Facultad de Ingeniería de Sistemas Computacionales u otra Facultad?", "B7", 3, 8);
            insertQuestionEntry(12, "Indique cual carrera de la Facultad de Ingenería de Sistemas Computacionales inicio su carrera u otra facultad", "B8", 3, 8);
            insertQuestionEntry(13, "Indique su índice de graduación", "B9", 3, 8);
            insertQuestionEntry(14, "¿Sede en la que aprobó su último año de estudio?", "B10", 3, 8);
            insertQuestionEntry(15, "¿Cómo financió sus estudios?", "B11", 3, 8);
            insertQuestionEntry(16, "¿Recibió apoyo de la Universidad para realizar sus estudios universitarios", "B12", 3, 8);
            insertQuestionEntry(17, "¿Qué tipo de apoyo recibió?", "B13", 3, 8);
            insertQuestionEntry(18, "¿Cómo Valora las condiciones de infraestructura y/o servicios durante la carrera?", "B14", 3, 8);
            insertQuestionEntry(19, "¿Cómo Valora la formación en investigación recibida durante sus estudios universitarios?", "B15", 3, 8);
            insertQuestionEntry(20, "Mi formación en Metodología de la Investigación ha resultado", "B16", 3, 8);

            insertQuestionEntry(21, "¿Es su primer título obtenido?", "B17", 3, 8);
            insertQuestionEntry(22, "Escriba su primer titulo", "B18", 3, 8);
            insertQuestionEntry(23, "¿Trabajó durante su permanencia en el programa de estudio?", "B19", 3, 8);
            insertQuestionEntry(24, "En caso de afirmativo a la pregunta anterior indique:", "B20", 3, 8);
            insertQuestionEntry(25, "¿Trabaja Acualmente?", "B21", 3, 8);
            insertQuestionEntry(26, "Indique si el trabajo que desempeña actualmente está relacionado con el programa de estudio", "B22", 3, 8);
            insertQuestionEntry(27, "¿En qué sector (grupo de interés) usted trabaja?", "B23", 3, 8);
            insertQuestionEntry(28, "De acuerdo al perfil de Egreso del programa, seleccione las funciones que desempeñas acutalmente en su trabajo", "B24", 3, 8);
            insertQuestionEntry(29, "¿Cuál es su opinión de la enseñanza recibida en relación con los siguientes aspectos?", "B25", 3, 8);
            insertQuestionEntry(30, "Escriba cinco(5) asignaturas, en orden de importancia, que usted considera le han aportado más en su ejercicio profesional.", "B26", 3, 8);
            insertQuestionEntry(31, "Escriba tres(3) temas en orden de importancia que usted recomendaría agregar al plan de estudio de la carrera.", "B27", 3, 8);
            insertQuestionEntry(32, "¿En general, cuál es su grado de satisfación con respecto a su plan de estudio o formación? Tome en cuenta todas las actividades profesionales que usted realiza.", "B28", 3, 8);
            insertQuestionEntry(33, "Ha recibido usted información sobre los programas de estudios para graduados que ofrece la Facultad de Ingeniería de Sistemas Computacionales", "B29", 3, 8);
            insertQuestionEntry(34, "Una vez culminado sus estudios, a través de que alternativa usted ha mantenido vínculo con la universidad", "B30", 3, 8);
            insertQuestionEntry(35, "¿Cuántos temas no se cubrieron ?", "A1", 1, 1);
            insertQuestionEntry(36, "¿En qué porcentajes se ha cumplido con el  programa de la asignatura?", "A2", 1, 1);
            insertQuestionEntry(37, "¿Cuáles de las siguientes metodologías de enseñanzas utilizo en esta asgnatura durante el semestre?", "A3", 1, 1);
            insertQuestionEntry(38, "¿Cuáles de las siguientes estrategias de aprendizaje utilizo en esta asgnatura durante el semestre?", "A4", 1, 1);
            insertQuestionEntry(39, "¿Cuáles de las siguientes actividades ha participado  su grupo durante el semestre ", "A5", 1, 1);
            insertQuestionEntry(40, "¿Cuáles de los siguientes materiales didácticos utilizo usted en clase?", "A6", 1, 1);

            insertQuestionEntry(41, "indique el nivel global de comportamiento de los estudiantes", "B1", 1, 2);
            insertQuestionEntry(42, "¿Cuál es su nivel de satisfacción general con este grupo?", "B2", 1, 2);
            insertQuestionEntry(43, "¿considera usted que la mayoria de los estudiantes estaban preparados para recibir el curso?", "B3", 1, 2);
            insertQuestionEntry(44, "identifique el o las áreas donde sitió deficiencia en el grupo puede escoger 3 en orden de deficiencia ", "B4", 1, 2);
            insertQuestionEntry(45, "¿tiene algún otro comentario o sugerencia de mejora para esta asignatura?", "B5", 1, 2);
            insertQuestionEntry(46, "Seleccione el campus al cual pertenece", "A1", 2, 3);
            insertQuestionEntry(47, "Carrera", "A2", 2, 3);
            insertQuestionEntry(48, "Semestre", "A3", 2, 3);
            insertQuestionEntry(49, "Asignatura", "A4", 2, 3);
            insertQuestionEntry(50, "Grupo", "A5", 2, 3);
            insertQuestionEntry(51, "Semana", "A6", 2, 3);
            insertQuestionEntry(52, "Año Estudio", "A7", 2, 3);
            insertQuestionEntry(53, "Nombre del Profesor", "A8", 2, 3);
            insertQuestionEntry(54, "El Profesor(a) entregó", "B1", 2, 4);
            insertQuestionEntry(55, "Tema que están dando actualmente", "B2", 2, 4);
            insertQuestionEntry(56, "¿Qué actividades de las listadas a continuación el docente utilizó en el curso?", "B3", 2, 4);
            insertQuestionEntry(57, "¿En qué otras actividades participó durante el semestre y fue de interés para su carrera?", "B4", 2, 4);
            insertQuestionEntry(58, "¿Qué actividades de las listadas a continuación siente usted que ha sido efectiva para su aprendizaje?", "B5", 2, 4);
            insertQuestionEntry(59, "Parciales", "C1", 2, 5);
            insertQuestionEntry(60, "Laboratorios", "C2", 2, 5);

            insertQuestionEntry(61, "Proyectos", "C3", 2, 5);
            insertQuestionEntry(62, "Tareas", "C4", 2, 5);
            insertQuestionEntry(63, "Quices", "C5", 2, 5);
            insertQuestionEntry(64, "Talleres/Prácticas", "C6", 2, 5);
            insertQuestionEntry(65, "Otros", "C7", 2, 5);
            insertQuestionEntry(66, "Investigaciones", "C8", 2, 5);
            insertQuestionEntry(67, "Califique la orientación o apoyo recibido por el personal de la Facultad en relación con los siguientes trámites.", "D1", 2, 6);
            insertQuestionEntry(68, "Especifique el tramite:", "D2", 2, 6);
            insertQuestionEntry(69, "Califique el tiempo tomado para el trámite recibido por el personal de la Facultad en relación a los siguientes trámites.", "D3", 2, 6);
            insertQuestionEntry(70, "Especifique el tramite:", "D4", 2, 6);
            insertQuestionEntry(71, "Tipo de empresa", "A1", 4, 9);
            insertQuestionEntry(72, "Clasificación de la empresa u organización dependiendo de su facturación anual:", "A2", 4, 9);
            insertQuestionEntry(73, "¿A cuál de los siguientes sectores pertenece su empresa u organización?", "A3", 4, 9);
            insertQuestionEntry(74, "¿En base al sector al que pertenece su empresa u organización, qué actividades ustedes realizan?", "A4", 4, 9);
            insertQuestionEntry(75, "Número de empleados de la empresa u organización:", "A5", 4, 9);
            insertQuestionEntry(76, "¿Cuenta con algún(os) egresados de la Facultad de Ingeniería de Sistemas Computacionales?", "A6", 4, 9);
            insertQuestionEntry(77, "Si su respuesta fue no, explique el porqué.", "A7", 4, 9);
            insertQuestionEntry(78, "Indique los egresados de que carrera. (Marcar más de una alternativa si fuese necesario)", "A8", 4, 9);
            insertQuestionEntry(79, "Si la respuesta fue Ingeniero de Sistemas y Computación, indique cuántos.", "A9", 4, 9);
            insertQuestionEntry(80, "¿Considera usted que la preparación de los egresados de la Facultad de Ingeniería de Sistemas Computacionales de la Universidad Tecnológica de Panamá, en términos profesionales con relación a los egresados de otras instituciones educativas es?", "B1", 4, 10);

            insertQuestionEntry(81, "En el siguiente cuadro usted encontrará una serie de criterios para evaluar aspectos específicos de los atributos y de las habilidades y destrezas que se espera posean los/as egresados/as de esta carrera.", "B2", 4, 10);
            insertQuestionEntry(82, "¿Qué funciones profesionales actualmente realizan los egresados de la Carrera de Ingeniería de Sistemas y Computación en su Empresa o Institución? (Marcar más de una alternativa si fuese necesario)", "B3", 4, 10);
            insertQuestionEntry(83, "¿Para el desempeño de la labor en su empresa u organización, qué áreas de conocimiento considera Usted deben poseer los Ingenieros de Sistemas y Computación? (Marcar más de una alternativa si fuese necesario)", "B4", 4, 10);
            insertQuestionEntry(84, "¿Qué otras áreas de conocimiento consideran usted que son relevantes en su empresa u organización?", "B5", 4, 10);
            insertQuestionEntry(85, "¿Qué certificaciones de tecnología para Usted son importantes en la empresa u organización?", "B6", 4, 10);
            insertQuestionEntry(86, "Agradecemos sus sugerencias y/o recomendaciones para mejorar el plan de estudio de la Carrera de Ingeniería de Sistemas y Computación.", "B7", 4, 10);
            insertQuestionEntry(87, "sexo", "C1", 4, 11);
            insertQuestionEntry(88, "Título/s universitarios que posee: (Marcar más de una alternativa si fuere necesario)", "C2", 4, 11);
            insertQuestionEntry(89, "Indicar el cargo profesional que ocupa en la Empresa o Institución en la cual labora.", "C3", 4, 11);
        }catch (Exception error){throw error;}
    }
    public void insertQuestionEntry(int id_pregunta, String descrip_preg, String cod_preg, int id_encuesta, int id_seccion)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_ID, id_pregunta);
            values.put(SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_DESCRIPTION, descrip_preg);
            values.put(SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_CODE, cod_preg);
            values.put(SurveyDatabaseContract.QuestionEntry.COLUMN_SURVEY_ID, id_encuesta);
            values.put(SurveyDatabaseContract.QuestionEntry.COLUMN_QUESTION_OPTION_ID, id_seccion);
            mDb.insert(SurveyDatabaseContract.QuestionEntry.TABLE_NAME, null, values);
        }catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Asignatura
    public void insertCampusSubjectsEntries()
    {
        try
        {
            insertCampusSubjectsEntry(1, "8402", "ADMINISTRACION FINANCIERA");
            insertCampusSubjectsEntry(2, "861", "ADMINISTRACIÓN DE SISTEMAS OPERATIVOS");
            insertCampusSubjectsEntry(3, "300", "ADMINISTRACIÓN DE REDES");
            insertCampusSubjectsEntry(4, "485", "ADMINISTRACIÓN Y ADQUISICIONES DE TIC");
            insertCampusSubjectsEntry(5, "8372", "ANALISIS Y DISEÑO DE REDES");
            insertCampusSubjectsEntry(6, "668", "ANÁLISIS Y DISEÑO DE ALGORÍTMOS");
            insertCampusSubjectsEntry(7, "846", "ANÁLISIS DE RIESGOS DE TI");
            insertCampusSubjectsEntry(8, "700", "ANIMACIÓN Y PRODUCCIÓN DIGITAL");
            insertCampusSubjectsEntry(9, "754", "ANIMACIÓN DIGITAL Y VIDEO JUEGOS");
            insertCampusSubjectsEntry(10, "705", "APLICACIONES PARA AMBIENTES DISTRIBUIDOS");
            insertCampusSubjectsEntry(11, "860", "ARQUITECTURA DE PROTOCOLOS");
            insertCampusSubjectsEntry(12, "685", "ARQUITECTURA Y DISEÑO DEL SOFTWARE");
            insertCampusSubjectsEntry(13, "763", "AUDITORÍA DE REDES");
            insertCampusSubjectsEntry(14, "8398", "BASE DE DATOS I");
            insertCampusSubjectsEntry(15, "856", "BASE DE DATOS I");
            insertCampusSubjectsEntry(16, "8399", "BASE DE DATOS II");
            insertCampusSubjectsEntry(17, "857", "BASE DE DATOS II");
            insertCampusSubjectsEntry(18, "7987", "CALCULO I");
            insertCampusSubjectsEntry(19, "7988", "CÁLCULO II");
            insertCampusSubjectsEntry(20, "8322", "CÁLCULO III");

            insertCampusSubjectsEntry(21, "8419", "CALIDAD DE SOFTWARE");
            insertCampusSubjectsEntry(22, "692", "CALIDAD DE SOFTWARE");
            insertCampusSubjectsEntry(23, "8365", "CIRCUITOS LÓGICOS");
            insertCampusSubjectsEntry(24, "755", "CIRCUITOS LÓGICOS");
            insertCampusSubjectsEntry(25, "8356", "CONTABILIDAD GENERAL");
            insertCampusSubjectsEntry(26, "8360", "COMUNICACIÓN ORAL Y ESCRITA");
            insertCampusSubjectsEntry(27, "8363", "COMUNICACIÓN DE DATOS");
            insertCampusSubjectsEntry(28, "697", "COMPUTACIÓN GRÁFICA Y VISUAL");
            insertCampusSubjectsEntry(29, "370", "CONTABILIDAD FINANCIERA");
            insertCampusSubjectsEntry(30, "762", "CONTROL DE COSTOS Y PRESUPUESTO");
            insertCampusSubjectsEntry(31, "8392", "DESARROLLO DE SOFTWARE I");
            insertCampusSubjectsEntry(32, "8393", "DESARROLLO DE SOFTWARE II");
            insertCampusSubjectsEntry(33, "8396", "DESARROLLO DE SOFTWARE III");
            insertCampusSubjectsEntry(34, "8397", "DESARROLLO DE SOFTWARE IV");
            insertCampusSubjectsEntry(35, "8400", "DESARROLLO DE SOFTWARE V");
            insertCampusSubjectsEntry(36, "8401", "DESARROLLO DE SOFTWARE VI");
            insertCampusSubjectsEntry(37, "8408", "DESARROLLO DE SOFTWARE VIII");
            insertCampusSubjectsEntry(38, "8407", "DESARROLLO DE SOFTWARE VII");
            insertCampusSubjectsEntry(39, "8409", "DESARROLLO DE SOFTWARE IX");
            insertCampusSubjectsEntry(40, "369", "DESARROLLO DE SOFTWARE ORIENTADA A OBJ.");

            insertCampusSubjectsEntry(41, "695", "DESARROLLO DE SOFTW. PARA PLATAF. MÓVIL.");
            insertCampusSubjectsEntry(42, "741", "DESARROLLO LÓGICO Y ALGORITMOS");
            insertCampusSubjectsEntry(43, "855", "DIBUJO ASISTIDO POR COMPUTADORAS");
            insertCampusSubjectsEntry(44, "487", "DISEÑO Y EVALUACIÓN DE INTERFACES");
            insertCampusSubjectsEntry(45, "8011", "ECOLOGÍA GENERAL");
            insertCampusSubjectsEntry(46, "8404", "ECONOMIA");
            insertCampusSubjectsEntry(47, "709", "ECUACIONES DIFERENCIALES ORDINARIAS");
            insertCampusSubjectsEntry(48, "8381", "ETICA PROFESIONAL Y DERECHO");
            insertCampusSubjectsEntry(49, "8367", "ESTADISTICA Y PROBABILIDAD");
            insertCampusSubjectsEntry(50, "669", "ESTADÍSTICA CON APOYO INFORMÁTICO");
            insertCampusSubjectsEntry(51, "8528", "ESTRUCTURA DE DATOS");
            insertCampusSubjectsEntry(52, "8362", "ESTRUCTURA DE DATOS I");
            insertCampusSubjectsEntry(53, "8394", "ESTRUCTURA DE DATOS II");
            insertCampusSubjectsEntry(54, "746", "ESTRUCTURAS DISCRETAS PARA LA COMP");
            insertCampusSubjectsEntry(55, "684", "ESTRUCTURA Y REPRESENTACIÓN DE DATOS");
            insertCampusSubjectsEntry(56, "798", "EVALUACIÓN DE PROY. DE TECN. DE INFORM.");
            insertCampusSubjectsEntry(57, "845", "ESTAND. MOD. Y POL. DE SEG. APL. A TI");
            insertCampusSubjectsEntry(58, "8319", "FÍSICA I (MECÁNICA)");
            insertCampusSubjectsEntry(59, "8320", "FÍSICA II (ELECTRICIDAD Y MAGNESTISMO)");
            insertCampusSubjectsEntry(60, "8472", "FORMACIÓN DE EMPRENDEDORES");

            insertCampusSubjectsEntry(61, "704", "FORMACIÓN EMPRESARIAL");
            insertCampusSubjectsEntry(62, "747", "FORM. Y EVALUACIÓN DE PROY. INFORMÁTICOS");
            insertCampusSubjectsEntry(63, "682", "FUNDAMENTOS DE PROGRAMACIÓN");
            insertCampusSubjectsEntry(64, "368", "FUNDAMENTOS DE SIST. DE INFORMACIÓN");
            insertCampusSubjectsEntry(65, "598", "FUNDAMENTOS DE ELECTRICIDAD");
            insertCampusSubjectsEntry(66, "839", "FUND. DE ARQUITECTURA EMPRESARIAL DE TI");
            insertCampusSubjectsEntry(67, "8469", "GERENCIA DE PROYECTOS INFORMÁTICOS");
            insertCampusSubjectsEntry(68, "694", "GERENCIA DE PROY. DE DESARR. DE SOFTWARE");
            insertCampusSubjectsEntry(69, "8729", "GERENCIA DE RECURSOS TECN.DE INF.Y COM");
            insertCampusSubjectsEntry(70, "8418", "GERENCIAS DE RECURSOS HUMANOS");
            insertCampusSubjectsEntry(71, "698", "GESTIÓN DE LA INFORMACIÓN");
            insertCampusSubjectsEntry(72, "589", "GLOBALIZACIÓN DEL SOFTWARE");
            insertCampusSubjectsEntry(73, "750", "HERRAMIENTAS APLIC. A LA INTEL. ARTIF");
            insertCampusSubjectsEntry(74, "751", "HERRAMIENTAS DE COMPUTACIÓN GRÁFICA");
            insertCampusSubjectsEntry(75, "743", "HERRAMIENTAS DE PROGRAMACIÓN APLICADA I");
            insertCampusSubjectsEntry(76, "745", "HERRAMIENTAS DE PROGRAMACIÓN APLICADA II");
            insertCampusSubjectsEntry(77, "748", "HERRAMIENTAS DE PROGRAMACIÓN APLICADA III");
            insertCampusSubjectsEntry(78, "757", "HERRAMIENTAS DE PROGRAMACIÓN APLICADA IV");
            insertCampusSubjectsEntry(79, "5002", "IMPLEMENTACIÓN DE BASE DE DATOS I");
            insertCampusSubjectsEntry(80, "5003", "IMPLEMENTACIÓN DE BASE DE DATOS I");

            insertCampusSubjectsEntry(81, "8355", "INGLES I");
            insertCampusSubjectsEntry(82, "593", "INGLES I");
            insertCampusSubjectsEntry(83, "8403", "INGLES II");
            insertCampusSubjectsEntry(84, "603", "INGLES II");
            insertCampusSubjectsEntry(85, "859", "INGLES TÉCNICO I");
            insertCampusSubjectsEntry(86, "752", "INGLES TÉCNICO II");
            insertCampusSubjectsEntry(87, "371", "INGENIERÍA DE SOFTWARE I");
            insertCampusSubjectsEntry(88, "8581", "INGENIERÍA DE SOFTWARE I");
            insertCampusSubjectsEntry(89, "8457", "INGENIERÍA DE SOFTWARE II");
            insertCampusSubjectsEntry(90, "753", "INGENIERÍA DE SOFTWARE II");
            insertCampusSubjectsEntry(91, "488", "INGENIERÍA DE SOFTWARE APLICADA");
            insertCampusSubjectsEntry(92, "8451", "INGENIERÍA DE SISTEMAS DINÁMICOS");
            insertCampusSubjectsEntry(93, "680", "INGENIERÍA DE REQUISITOS");
            insertCampusSubjectsEntry(94, "8461", "INGENIERÍA AMBIENTAL");
            insertCampusSubjectsEntry(95, "690", "INGENIERÍA WEB");
            insertCampusSubjectsEntry(96, "8405", "INVESTIGACION DE OPERACIONES");
            insertCampusSubjectsEntry(97, "489", "INVESTIGACION DE OPERACIONES");
            insertCampusSubjectsEntry(98, "744", "INGLÉS CONVERSACIONAL");
            insertCampusSubjectsEntry(99, "758", "INGENIERÍA DE SISTEMAS ROBÓTICOS");
            insertCampusSubjectsEntry(100, "8452", "INTELIGENCIA ARTIFICIAL");

            insertCampusSubjectsEntry(101, "608", "INTRODUCCIÓN A LA QUÍMICA");
            insertCampusSubjectsEntry(102, "5000", "INTRODUCCIÓN A LA TEORÍA COMPUTACIONAL");
            insertCampusSubjectsEntry(103, "600", "INTRODUCCIÓN A LA INGENIERÍA DE SOFTWARE");
            insertCampusSubjectsEntry(104, "688", "INTERACCIÓN HUMANO COMPUTADOR (HCI)");
            insertCampusSubjectsEntry(105, "1194", "INTERACCIÓN HUMANO COMPUTADOR (HCI)");
            insertCampusSubjectsEntry(106, "486", "INFRAESTRUCTURA COMPUTACIONAL DE TI");
            insertCampusSubjectsEntry(107, "847", "INFORMÁTICA FORENSE Y EL TRAT. DE LA INF");
            insertCampusSubjectsEntry(108, "840", "INT. DE NEG. COMO ESTRATEGIA DE LA ORG.");
            insertCampusSubjectsEntry(109, "8462", "LENGUAJE FORMALES, AUTÓMATAS Y COMPIL");
            insertCampusSubjectsEntry(110, "693", "LENG. FORMALES AUTÓMATAS Y PROC. DE LENG");
            insertCampusSubjectsEntry(111, "8054", "MATEMÁTICA I");
            insertCampusSubjectsEntry(112, "8059", "MATEMÁTICA II");
            insertCampusSubjectsEntry(113, "8066", "MATEMÁTICA III");
            insertCampusSubjectsEntry(114, "131", "MATEMÁTICA BÁSICA");
            insertCampusSubjectsEntry(115, "8321", "MATEMÁTICAS SUPERIORES PARA ING");
            insertCampusSubjectsEntry(116, "696", "MANTENIMIENTO Y PRUEBAS DE SOFTWARE");
            insertCampusSubjectsEntry(117, "8375", "METODOLOGÍA DE LA INVESTIGACIÓN");
            insertCampusSubjectsEntry(118, "703", "METODOLOGÍA DE INVESTIGACIÓN EN ING");
            insertCampusSubjectsEntry(119, "7722", "MÉTODOS NUMÉRICOS PARA ING");
            insertCampusSubjectsEntry(120, "759", "MODELADO Y SIMULACIÓN");

            insertCampusSubjectsEntry(121, "8582", "MECANICA");
            insertCampusSubjectsEntry(122, "687", "ORG. Y ARQUITECTURA DE COMPUTADORA");
            insertCampusSubjectsEntry(123, "8480", "ORGANIZACION Y ARG. DE COMP. I");
            insertCampusSubjectsEntry(124, "8734", "ORGANIZACION Y ARG. DE COMP. II");
            insertCampusSubjectsEntry(125, "740", "POLÍTICA Y LEGISLACIÓN INFORMÁTICA");
            insertCampusSubjectsEntry(126, "707", "PRÁCTICA PROFESIONAL DE ING. DE SOFTWARE");
            insertCampusSubjectsEntry(127, "130", "PRE-CALCULO");
            insertCampusSubjectsEntry(128, "5001", "PRINCIPIOS DE PROGRAMACIÓN");
            insertCampusSubjectsEntry(129, "699", "PROTOCOLOS DE COMUNICACIÓN");
            insertCampusSubjectsEntry(130, "8354", "PROGRAMACIÓN APLICADA I");
            insertCampusSubjectsEntry(131, "8358", "PROGRAMACIÓN APLICADA II");
            insertCampusSubjectsEntry(132, "683", "PROGRAMACIÓN DE SOFTWARE I");
            insertCampusSubjectsEntry(133, "686", "PROGRAMACIÓN DE SOFTWARE II");
            insertCampusSubjectsEntry(134, "858", "PROBABILIDAD Y ESTADÍSTICA PARA ING.");
            insertCampusSubjectsEntry(135, "838", "PROYECTO DE NEGOCIO PARA AMBIENTES WEB");
            insertCampusSubjectsEntry(136, "742", "REDACCIÓN DE INFORMES Y EXPRESIÓN ORAL");
            insertCampusSubjectsEntry(137, "8371", "REDES DE AREA LOCAL");
            insertCampusSubjectsEntry(138, "8410", "REDES DE COMPUTADORAS");
            insertCampusSubjectsEntry(139, "691", "REDES DE COMPUTADORAS");
            insertCampusSubjectsEntry(140, "761", "REDES INFORMÁTICAS");

            insertCampusSubjectsEntry(141, "8379", "REDES PARA MULTIMEDIOS");
            insertCampusSubjectsEntry(142, "8387", "REDES MOVILES E INALÁMBRICAS");
            insertCampusSubjectsEntry(143, "195", "RELACIONES HUMANAS Y SUPERV. DE PERSONAL");
            insertCampusSubjectsEntry(144, "706", "SALUD PARA EL EJERCICIO PROFESIONAL");
            insertCampusSubjectsEntry(145, "8470", "SEGURIDAD EN TECNOLOGÍA DE COMPUTACIÓN");
            insertCampusSubjectsEntry(146, "8411", "SEGURIDAD EN LOS SISTEMAS DE INFORMACION");
            insertCampusSubjectsEntry(147, "701", "SEGURIDAD EN APLICACIONES DE SOFTWARE");
            insertCampusSubjectsEntry(148, "8376", "SEGURIDAD Y PRIVACIDAD EN REDES I");
            insertCampusSubjectsEntry(149, "8385", "SEGURIDAD Y PRIVACIDAD EN REDES II");
            insertCampusSubjectsEntry(150, "104", "SEMINARIO DE INDUC. A LA VIDA EST.UNIV.");
            insertCampusSubjectsEntry(151, "299", "SISTEMAS DE INFORMACION");
            insertCampusSubjectsEntry(152, "8414", "SISTEMAS DE INFORMACION GERENCIAL");
            insertCampusSubjectsEntry(153, "8455", "SISTEMAS BASADOS EN EL CONOCIMIENTO");
            insertCampusSubjectsEntry(154, "8361", "SISTEMAS COLABORATIVOS");
            insertCampusSubjectsEntry(155, "8416", "SISTEMAS GRAFICOS");
            insertCampusSubjectsEntry(156, "689", "SISTEMAS OPERATIVOS");
            insertCampusSubjectsEntry(157, "8357", "SISTEMAS OPERATIVOS I");
            insertCampusSubjectsEntry(158, "8366", "SISTEMAS OPERATIVOS II");
            insertCampusSubjectsEntry(159, "8382", "SISTEMAS OPERATIVOS III");
            insertCampusSubjectsEntry(160, "8475", "SISTEMAS DE BASE DE DATOS I");

            insertCampusSubjectsEntry(161, "8477", "SISTEMAS DE BASE DE DATOS II");
            insertCampusSubjectsEntry(162, "841", "SISTEMAS EMPRESARIALES DE TI");
            insertCampusSubjectsEntry(163, "8456", "SIMULACIÓN DE SISTEMAS");
            insertCampusSubjectsEntry(164, "199", "TECNOLOGÍA DE BASE DE DATOS");
            insertCampusSubjectsEntry(165, "8353", "TECNOLOGÍA DE INFORMACIÓN Y COMUNICACIÓN");
            insertCampusSubjectsEntry(166, "8488", "TELEINFORMÁTICA");
            insertCampusSubjectsEntry(167, "756", "TÓPICOS ESPECIALES I");
            insertCampusSubjectsEntry(168, "760", "TÓPICOS ESPECIALES II");
            insertCampusSubjectsEntry(169, "8718", "TÓPICOS DE GEOGRAFÍA E HISTORIA DE PANAMÁ");
            insertCampusSubjectsEntry(170, "599", "TRABAJO EN EQUIPO Y LIDERAZGO");
            insertCampusSubjectsEntry(171, "8415", "TRABAJO DE GRADUACIÓN I");
            insertCampusSubjectsEntry(172, "8420", "TRABAJO DE GRADUACIÓN II");
            insertCampusSubjectsEntry(173, "8467", "TRABAJO DE GRADUACIÓN I");
            insertCampusSubjectsEntry(174, "8473", "TRABAJO DE GRADUACIÓN II");
            insertCampusSubjectsEntry(175, "8386", "TRABAJO DE GRADUACIÓN I");
            insertCampusSubjectsEntry(176, "8391", "TRABAJO DE GRADUACIÓN II");
            insertCampusSubjectsEntry(177, "8489", "TRABAJO DE GRADUACIÓN I");
            insertCampusSubjectsEntry(178, "8490", "TRABAJO DE GRADUACIÓN II");
        }catch (Exception error){throw error;}
    }
    public void insertCampusSubjectsEntry(int id_asignatura, String cod_asignatura, String nombre)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_ID, id_asignatura);
            values.put(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_CODE, cod_asignatura);
            values.put(SurveyDatabaseContract.SubjectEntry.COLUMN_SUBJECT_NAME, nombre);
            mDb.insert(SurveyDatabaseContract.SubjectEntry.TABLE_NAME, null, values);
        }catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Asignatura_Grupo
    public void insertSubjectEntries()
    {
        try
        {
            insertSubjectEntry(35, 5, "733");
            insertSubjectEntry(35, 6, "738");
            insertSubjectEntry(35, 13, "743");
            insertSubjectEntry(35, 14, "748");
            insertSubjectEntry(36, 5, "734");
            insertSubjectEntry(36, 6, "739");
            insertSubjectEntry(36, 13, "744");
            insertSubjectEntry(36, 14, "749");
            insertSubjectEntry(89, 5, "736");
            insertSubjectEntry(89, 6, "741");
            insertSubjectEntry(89, 13, "746");
            insertSubjectEntry(89, 14, "751");
            insertSubjectEntry(96, 5, "735");
            insertSubjectEntry(96, 6, "740");
            insertSubjectEntry(96, 13, "745");
            insertSubjectEntry(96, 14, "750");
            insertSubjectEntry(123, 5, "737");
            insertSubjectEntry(123, 6, "742");
            insertSubjectEntry(123, 13, "747");
            insertSubjectEntry(123, 14, "752");
        }catch (Exception error){throw error;}
    }
    public void insertSubjectEntry(int id_asignatura, int id_grupo, String codhora)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_SUBJECT_ID, id_asignatura);
            values.put(SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_GROUP_ID, id_grupo);
            values.put(SurveyDatabaseContract.SubjectGroupEntry.COLUMN_SUBJECT_GROUP_HOUR_CODE, codhora);
            mDb.insert(SurveyDatabaseContract.SubjectGroupEntry.TABLE_NAME, null, values);
        }catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla carrera_asignatura
    public void insertCareerSubjectEntries()
    {
        try
        {
            insertCareerSubjectEntry(1, 114, "I año", "Verano");
            insertCareerSubjectEntry(1, 150, "I año", "Verano");
            insertCareerSubjectEntry(1, 45, "I año", "I semestre");
            insertCareerSubjectEntry(1, 111, "I año", "I semestre");
            insertCareerSubjectEntry(1, 165, "I año", "I semestre");
            insertCareerSubjectEntry(1, 81, "I año", "I semestre");
            insertCareerSubjectEntry(1, 26, "I año", "I semestre");
            insertCareerSubjectEntry(1, 31, "I año", "I semestre");
            insertCareerSubjectEntry(1, 154, "I año", "II semestre");
            insertCareerSubjectEntry(1, 112, "I año", "II semestre");
            insertCareerSubjectEntry(1, 32, "I año", "II semestre");
            insertCareerSubjectEntry(1, 52, "I año", "II semestre");
            insertCareerSubjectEntry(1, 83, "I año", "II semestre");
            insertCareerSubjectEntry(1, 169, "I año", "II semestre");
            insertCareerSubjectEntry(1, 33, "I año", "I semestre");
            insertCareerSubjectEntry(1, 113, "II año", "I semestre");
            insertCareerSubjectEntry(1, 60, "II año", "I semestre");
            insertCareerSubjectEntry(1, 53, "II año", "I semestre");
            insertCareerSubjectEntry(1, 14, "II año", "I semestre");
            insertCareerSubjectEntry(1, 34, "II año", "II semestre");

            insertCareerSubjectEntry(1, 89, "II año", "II semestre");
            insertCareerSubjectEntry(1, 16, "II año", "II semestre");
            insertCareerSubjectEntry(1, 49, "II año", "II semestre");
            insertCareerSubjectEntry(1, 25, "II año", "II semestre");
            insertCareerSubjectEntry(1, 96, "III año", "I semestre");
            insertCareerSubjectEntry(1, 89, "III año", "I semestre");
            insertCareerSubjectEntry(1, 35, "III año", "I semestre");
            insertCareerSubjectEntry(1, 36, "III año", "I semestre");
            insertCareerSubjectEntry(1, 122, "III año", "I semestre");
            insertCareerSubjectEntry(1, 37, "III año", "II semestre");
            insertCareerSubjectEntry(1, 138, "III año", "II semestre");
            insertCareerSubjectEntry(1, 38, "III año", "II semestre");
            insertCareerSubjectEntry(1, 152, "III año", "II semestre");
            insertCareerSubjectEntry(1, 156, "IV año", "II semestre");
            insertCareerSubjectEntry(1, 46, "IV año", "I semestre");
            insertCareerSubjectEntry(1, 1, "IV año", "I semestre");
            insertCareerSubjectEntry(1, 39, "IV año", "I semestre");
            insertCareerSubjectEntry(1, 146, "IV año", "I semestre");
            insertCareerSubjectEntry(1, 117, "IV año", "I semestre");
            insertCareerSubjectEntry(1, 171, "IV año", "II semestre ");

            insertCareerSubjectEntry(1, 151, "IV año", "II semestre");
            insertCareerSubjectEntry(1, 67, "IV año", "II semestre");
            insertCareerSubjectEntry(1, 48, "IV año", "II semestre");
            insertCareerSubjectEntry(1, 69, "IV año", "II semestre");
            insertCareerSubjectEntry(1, 21, "IV año", "II semestre");
            insertCareerSubjectEntry(1, 172, "IV año", "II semestre");

            insertCareerSubjectEntry(5, 127, "I año", "Verano");
            insertCareerSubjectEntry(5, 150, "I año", "Verano");
            insertCareerSubjectEntry(5, 18, "I año", "I semestre");
            insertCareerSubjectEntry(5, 136, "I año", "I semestre");

            insertCareerSubjectEntry(5, 72, "I año", "I semestre");
            insertCareerSubjectEntry(5, 81, "I año", "I semestre");
            insertCareerSubjectEntry(5, 43, "I año", "I semestre");
            insertCareerSubjectEntry(5, 102, "I año", "I semestre");
            insertCareerSubjectEntry(5, 19, "I año", "II semestre");
            insertCareerSubjectEntry(5, 103, "I año", "II semestre");
            insertCareerSubjectEntry(5, 101, "I año", "II semestre");
            insertCareerSubjectEntry(5, 20, "I año", "II semestre");
            insertCareerSubjectEntry(5, 128, "I año", "II semestre");
            insertCareerSubjectEntry(5, 170, "I año", "II semestre");

            insertCareerSubjectEntry(5, 47, "II año", "I semestre");
            insertCareerSubjectEntry(5, 58, "II año", "I semestre");
            insertCareerSubjectEntry(5, 55, "II año", "I semestre");
            insertCareerSubjectEntry(5, 132, "II año", "I semestre");
            insertCareerSubjectEntry(5, 93, "II año", "I semestre");
            insertCareerSubjectEntry(5, 93, "II año", "I semestre");
            insertCareerSubjectEntry(5, 115, "II año", "II semestre");
            insertCareerSubjectEntry(5, 79, "II año", "II semestre");
            insertCareerSubjectEntry(5, 59, "II año", "II semestre");
            insertCareerSubjectEntry(5, 6, "II año", "II semestre");
            insertCareerSubjectEntry(5, 12, "II año", "II semestre");
            insertCareerSubjectEntry(5, 104, "II año", "II semestre");
            insertCareerSubjectEntry(5, 50, "III año", "I semestre");
            insertCareerSubjectEntry(5, 133, "III año", "I semestre");
            insertCareerSubjectEntry(5, 119, "III año", "I semestre");
            insertCareerSubjectEntry(5, 21, "III año", "I semestre");
            insertCareerSubjectEntry(5, 122, "III año", "I semestre");
            insertCareerSubjectEntry(5, 79, "III año", "I semestre");
            insertCareerSubjectEntry(5, 94, "III año", "II semestre");
            insertCareerSubjectEntry(5, 156, "III año", "II semestre");

            insertCareerSubjectEntry(5, 95, "III año", "II semestre");
            insertCareerSubjectEntry(5, 138, "III año", "II semestre");
            insertCareerSubjectEntry(5, 116, "III año", "II semestre");
            insertCareerSubjectEntry(5, 110, "III año", "II semestre");
            insertCareerSubjectEntry(5, 68, "IV año", "I semestre");
            insertCareerSubjectEntry(5, 41, "IV año", "I semestre");
            insertCareerSubjectEntry(5, 169, "IV año", "I semestre");
            insertCareerSubjectEntry(5, 28, "IV año", "I semestre");
            insertCareerSubjectEntry(5, 71, "IV año", "I semestre");
            insertCareerSubjectEntry(5, 129, "IV año", "I semestre");
            insertCareerSubjectEntry(5, 8, "IV año", "II semestre");
            insertCareerSubjectEntry(5, 147, "IV año", "II semestre");
            insertCareerSubjectEntry(5, 167, "IV año", "II semestre");
            insertCareerSubjectEntry(5, 118, "IV año", "II semestre");
            insertCareerSubjectEntry(5, 61, "IV año", "II semestre");
            insertCareerSubjectEntry(5, 171, "IV año", "II semestre");
            insertCareerSubjectEntry(5, 172, "V año", "I semestre");
            insertCareerSubjectEntry(5, 10, "V año", "I semestre");
            insertCareerSubjectEntry(5, 144, "V año", "I semestre");
            insertCareerSubjectEntry(5, 126, "V año", "I semestre");

            insertCareerSubjectEntry(5, 168, "V año", "I semestre");
            insertCareerSubjectEntry(5, 125, "V año", "I semestre");


        }catch (Exception error){throw error;}
    }
    public void insertCareerSubjectEntry(int id_carrera, int id_asignatura, String año_carrera, String semestre)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_CAREER_ID, id_carrera);
            values.put(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SUBJECT_ID, id_asignatura);
            values.put(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_CAREER_ID, año_carrera);
            values.put(SurveyDatabaseContract.CareerSubjectEntry.COLUMN_SEMESTER, semestre);
            mDb.insert(SurveyDatabaseContract.CareerSubjectEntry.TABLE_NAME, null, values);
        }catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla estudiante_asignatura_grupo
    public void insertStudentSubjectGroupEntries()
    {
        try
        {
            insertStudentSubjectGroupEntry(1, 5, 35, "I semestre", 2020);
            insertStudentSubjectGroupEntry(1, 5, 36, "I semestre", 2020);
            insertStudentSubjectGroupEntry(1, 5, 89, "I semestre", 2020);
            insertStudentSubjectGroupEntry(1, 5, 96, "I semestre", 2020);
            insertStudentSubjectGroupEntry(1, 5, 123, "I semestre", 2020);

            insertStudentSubjectGroupEntry(2, 5, 35, "I semestre", 2020);
            insertStudentSubjectGroupEntry(2, 5, 36, "I semestre", 2020);
            insertStudentSubjectGroupEntry(2, 5, 89, "I semestre", 2020);
            insertStudentSubjectGroupEntry(2, 5, 96, "I semestre", 2020);
            insertStudentSubjectGroupEntry(2, 5, 123, "I semestre", 2020);

            insertStudentSubjectGroupEntry(3, 6, 35, "I semestre", 2020);
            insertStudentSubjectGroupEntry(3, 6, 36, "I semestre", 2020);
            insertStudentSubjectGroupEntry(3, 6, 89, "I semestre", 2020);
            insertStudentSubjectGroupEntry(3, 6, 96, "I semestre", 2020);
            insertStudentSubjectGroupEntry(3, 6, 123, "I semestre", 2020);

            insertStudentSubjectGroupEntry(4, 6, 35, "I semestre", 2020);
            insertStudentSubjectGroupEntry(4, 6, 36, "I semestre", 2020);
            insertStudentSubjectGroupEntry(4, 6, 89, "I semestre", 2020);
            insertStudentSubjectGroupEntry(4, 6, 96, "I semestre", 2020);
            insertStudentSubjectGroupEntry(4, 6, 123, "I semestre", 2020);
//---------------
            insertStudentSubjectGroupEntry(5, 13, 35, "I semestre", 2020);
            insertStudentSubjectGroupEntry(5, 13, 36, "I semestre", 2020);
            insertStudentSubjectGroupEntry(5, 13, 89, "I semestre", 2020);
            insertStudentSubjectGroupEntry(5, 13, 96, "I semestre", 2020);
            insertStudentSubjectGroupEntry(5, 13, 123, "I semestre", 2020);

            insertStudentSubjectGroupEntry(6, 13, 35, "I semestre", 2020);
            insertStudentSubjectGroupEntry(6, 13, 36, "I semestre", 2020);
            insertStudentSubjectGroupEntry(6, 13, 89, "I semestre", 2020);
            insertStudentSubjectGroupEntry(6, 13, 96, "I semestre", 2020);
            insertStudentSubjectGroupEntry(6, 13, 123, "I semestre", 2020);

            insertStudentSubjectGroupEntry(7, 14, 35, "I semestre", 2020);
            insertStudentSubjectGroupEntry(7, 14, 36, "I semestre", 2020);
            insertStudentSubjectGroupEntry(7, 14, 89, "I semestre", 2020);
            insertStudentSubjectGroupEntry(7, 14, 96, "I semestre", 2020);
            insertStudentSubjectGroupEntry(7, 14, 123, "I semestre", 2020);

            insertStudentSubjectGroupEntry(8, 14, 35, "I semestre", 2020);
            insertStudentSubjectGroupEntry(8, 14, 36, "I semestre", 2020);
            insertStudentSubjectGroupEntry(8, 14, 89, "I semestre", 2020);
            insertStudentSubjectGroupEntry(8, 14, 96, "I semestre", 2020);
            insertStudentSubjectGroupEntry(8, 14, 123, "I semestre", 2020);

            insertStudentSubjectGroupEntry(9, 5, 35, "I semestre", 2020);
            insertStudentSubjectGroupEntry(9, 5, 36, "I semestre", 2020);
            insertStudentSubjectGroupEntry(9, 5, 89, "I semestre", 2020);
            insertStudentSubjectGroupEntry(9, 5, 96, "I semestre", 2020);
            insertStudentSubjectGroupEntry(9, 5, 123, "I semestre", 2020);
        }catch (Exception error){throw error;}
    }
    public void insertStudentSubjectGroupEntry(int id_estudiante, int id_grupo, int id_asignatura, String semestre, int año_Asig)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_STUDENT_ID, id_estudiante);
            values.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_GROUP_ID, id_grupo);
            values.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SUBJECT_ID, id_asignatura);
            values.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_SEMESTER, semestre);
            values.put(SurveyDatabaseContract.StudentSubjectGroupEntry.COLUMN_YEAR, año_Asig);
            mDb.insert(SurveyDatabaseContract.StudentSubjectGroupEntry.TABLE_NAME, null, values);
        }catch (Exception error){throw error;}
    }
    //--------------------------------semestre en la tabla de la bd fisc es tipo String, pero aca la tienes de tipo int---------------------------------------//

    //Tabla profesor_asignatura_grupo
    public void insertProfessorSubjectGroupEntries()
    {
        try
        {
            insertProfessorSubjectGroupEntry(1, 5, 123, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(2, 5, 35, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(3, 5, 36, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(4, 5, 89, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(5, 5, 96, "I semestre", 2020);

            insertProfessorSubjectGroupEntry(6, 6, 123, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(7, 6, 35, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(8, 6, 36, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(9, 6, 89, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(5, 6, 96, "I semestre", 2020);

            insertProfessorSubjectGroupEntry(1, 13, 123, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(2, 13, 35, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(3, 13, 36, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(4, 13, 89, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(5, 13, 96, "I semestre", 2020);

            insertProfessorSubjectGroupEntry(6, 14, 123, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(7, 14, 35, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(8, 14, 36, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(9, 14, 89, "I semestre", 2020);
            insertProfessorSubjectGroupEntry(5, 14, 96, "I semestre", 2020);


        }catch (Exception error){throw error;}
    }
    public void insertProfessorSubjectGroupEntry(int id_profesor, int id_grupo, int id_asignatura, String semestre, int año_Asig)
    {
        try
        {
            ContentValues values = new ContentValues();
            values.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID, id_profesor);
            values.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID, id_grupo);
            values.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID, id_asignatura);
            values.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID, semestre);
            values.put(SurveyDatabaseContract.ProfessorSubjectGroupEntry.COLUMN_PROFESSOR_ID, año_Asig);
            mDb.insert(SurveyDatabaseContract.ProfessorSubjectGroupEntry.TABLE_NAME, null, values);
        }catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

    //Tabla Rol
    public void insertRoleEntries()
    {
        try
        {
            insertRoleEntry(1, "Administrador del Sistema");
            insertRoleEntry(2, "Decano");
            insertRoleEntry(3, "Vicedecano Académico");
            insertRoleEntry(4, "Vicedecano de Investigación Postgrado y Extensión");
            insertRoleEntry(5, "Jefe de Departamento");
            insertRoleEntry(6, "Coordinador de Carrera");
            insertRoleEntry(7, "Secretaria de Vicedecano");
            insertRoleEntry(8, "Profesores");
            insertRoleEntry(9, "Estudiantes");
            insertRoleEntry(10, "Egresados");
            insertRoleEntry(11, "Empresarios");
        }catch (Exception error){throw error;}
    }
    public void insertRoleEntry(int id_rol_usuario, String nombre)
    {
        try
        {
            ContentValues values = new ContentValues();

            values.put(SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_USER_ID, id_rol_usuario);
            values.put(SurveyDatabaseContract.RoleEntry.COLUMN_ROLE_NAME, nombre);

            mDb.insert(SurveyDatabaseContract.RoleEntry.TABLE_NAME, null, values);
        }catch (Exception error){throw error;}
    }
    //-----------------------------------------------------------------------//

}
