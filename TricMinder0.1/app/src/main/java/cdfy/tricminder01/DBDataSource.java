package cdfy.tricminder01;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBDataSource {
    private SQLiteDatabase database;
    private DBHandler dbHandler;

    private String[] allColumns = { DBHandler.KEY_ID_PELANGGAN, DBHandler.KEY_NO_METER,
                                    DBHandler.KEY_NAMA, DBHandler.KEY_TARIF, DBHandler.KEY_DAYA};

    public DBDataSource(Context context) {
        dbHandler = new DBHandler(context);
    }

    public void open() throws SQLException {
        database = dbHandler.getWritableDatabase();
    }

    public void close() {
        dbHandler.close();
    }

    public User createUser(String id_pelanggan, String no_meter, String name, String tarif, String daya) {

        // membuat sebuah ContentValues, yang berfungsi
        // untuk memasangkan data dengan nama-nama
        // kolom pada database
        ContentValues values = new ContentValues();
        values.put(DBHandler.KEY_ID_PELANGGAN, id_pelanggan);
        values.put(DBHandler.KEY_NO_METER, no_meter);
        values.put(DBHandler.KEY_NAMA, name);
        values.put(DBHandler.KEY_TARIF, tarif);
        values.put(DBHandler.KEY_DAYA, daya);

        long insertId = database.insert(DBHandler.TABLE_NAME, null, values);  // mengeksekusi perintah SQL insert data yang akan mengembalikan sebuah insert ID

        // setelah data dimasukkan, memanggil
        // perintah SQL Select menggunakan Cursor untuk
        // melihat apakah data tadi benar2 sudah masuk
        // dengan menyesuaikan ID = insertID
        Cursor cursor = database.query(DBHandler.TABLE_NAME, allColumns, DBHandler.KEY_ID_PELANGGAN + " = " + insertId, null, null, null, null);

        cursor.moveToFirst();

        User newUser = cursorToUser(cursor); //mengubah objek pada kursor pertama tadi ke dalam objek barang

        cursor.close();

        return newUser;
    }

    private User cursorToUser(Cursor cursor)
    {
        User user = new User();

        Log.v("info", "The getLONG "+cursor.getLong(0));
        Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));

        /* Set atribut pada objek barang dengan
         * data kursor yang diambil dari database*/
        user.setData(cursor.getString(0), cursor.getString(0), cursor.getString(0), cursor.getString(0), cursor.getString(0));

        //kembalikan sebagai objek barang
        return user;
    }
}
