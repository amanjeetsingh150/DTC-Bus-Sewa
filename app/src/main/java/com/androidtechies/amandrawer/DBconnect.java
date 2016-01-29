package com.androidtechies.amandrawer;

/**
 * Created by Amanjeet Singh on 12-Aug-15.
 */
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Amanjeet Singh on 17-Jun-15.
 */
public class DBconnect {
    private static final String DB_Name="dtc.db";
    File dbfile;
    private SearchBus c;
    public DBconnect(SearchBus paramContext)
    {
        this.c=paramContext;
    }
    private void copy(File paramFile) throws IOException {
        InputStream localInputStream = this.c.getActivity().getAssets().open("dtcdb.db");
        System.out.println(paramFile.getPath());
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
            if (localInputStream.read(arrayOfByte) <= 0)
            {
                localFileOutputStream.flush();
                localFileOutputStream.close();
                localInputStream.close();
                return;
            }
            localFileOutputStream.write(arrayOfByte);
        }
    }
    public SQLiteDatabase openDatabase()
    {
        this.dbfile=this.c.getActivity().getDatabasePath("dtc.db");
        if(!this.dbfile.exists()){}
        try {
            this.dbfile.getParentFile().mkdir();
            copy(this.dbfile);
            return SQLiteDatabase.openDatabase(this.dbfile.getPath(), null, 268435472);
        }
        catch (IOException localIOException)
        {
            throw new RuntimeException("Error creating source database", localIOException);

        }

    }
}
