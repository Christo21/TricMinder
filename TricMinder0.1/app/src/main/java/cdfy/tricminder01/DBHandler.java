package cdfy.tricminder01;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; // Database Version
    private static final String DATABASE_NAME = "dataPelanggan.db"; // Database Name
    public static final String TABLE_NAME = "pelanggan"; // Contacts table name
    public static final String KEY_ID_PELANGGAN = "idPelanggan";
    public static final String KEY_NO_METER = "noMeter";
    public static final String KEY_NAMA = "Nama";
    public static final String KEY_TARIF = "Tarif";
    public static final String KEY_DAYA = "Daya";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID_PELANGGAN + " VARCHAR(255) PRIMARY KEY, " +
                                                                 KEY_NO_METER + "VARCHAR(255), " +
                                                                 KEY_NAMA +  "VARCHAR(255), " +
                                                                 KEY_TARIF + "VARCHAR(255), " +
                                                                 KEY_DAYA + "VARCHAR(255));";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
//        String sql = "INSERT INTO pelanggan (idPelanggan, nomorMeter, Nama, Tarif, Daya) VALUES ('12345654321', '12345654321', 'Christoper J', 'R1','1000');";
//        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHandler.class.getName(),"Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}













