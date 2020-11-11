package com.example.proyectofiscmovil;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.proyectofiscmovil.DataAccess.SurveyDBHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SurveyDBHelperTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.proyectofiscmovil", appContext.getPackageName());
    }

    @Test
    public void surveyDBHelper_notNull()
    {
        Context context = ApplicationProvider.getApplicationContext();
        SurveyDBHelper surveyDBHelper = new SurveyDBHelper(context);
        surveyDBHelper.close();
        assertNotNull(surveyDBHelper);
    }

    @Test
    public void surveyDBHelper_dbNameIsSurvey()
    {
        Context context = ApplicationProvider.getApplicationContext();
        SurveyDBHelper surveyDBHelper = new SurveyDBHelper(context);
        String dbName = surveyDBHelper.getDatabaseName();
        surveyDBHelper.close();
        assertEquals("The database name is correct.","Survey",dbName);
    }
}
