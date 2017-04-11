package id.ac.umn.onc.mydiary.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import id.ac.umn.onc.mydiary.model.Customer;

/**
 * Created by aldo_ on 31/03/2017.
 */

public class DBAdapter extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myDiaryONC.db";
    private static final String TABLE_CUSTOMER = "customer";
    private static final String TABLE_MEMO = "memo";

    public static final String COLUMN_CUSTOMER_ID = "id";
    public static final String COLUMN_CUSTOMER_EMAIL = "email";
    public static final String COLUMN_CUSTOMER_PASSWORD = "password";
    public static final String COLUMN_CUSTOMER_NAME = "name";

    public static final String COLUMN_MEMO_ID = "id";
    public static final String COLUMN_MEMO_ID_CUSTOMER = "id_customer";
    public static final String COLUMN_MEMO_EMOTION = "emotion";
    public static final String COLUMN_MEMO_NOTE = "note";
    public static final String COLUMN_MEMO_IMAGE = "image";
    public static final String COLUMN_MEMO_DATE = "date";

    SQLiteDatabase db;

    public DBAdapter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CUSTOMER = "";
        db.execSQL(CREATE_TABLE_CUSTOMER);

        String CREATE_TABLE_MEMO = "";
                /*"CREATE TABLE " + TABLE_COURSE + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUMN_COURSE_DESC + " TEXT NOT NULL, "
                        + COLUMN_COURSE_NAME + " TEXT NOT NULL )";*/
        db.execSQL(CREATE_TABLE_MEMO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_CUSTOMER);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_MEMO);
        onCreate(db);
        System.out.println("DBAdapter : " + "Upgrading database from old version" + oldVersion
                + " to " + newVersion + ", which will destroy all old data");
    }

    public void onOpen() {
        super.onOpen(db);
        db = this.getWritableDatabase();
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    public void insertCustomer(Customer customer){
        ContentValues contentValues = new ContentValues();/*
        contentValues.put(COLUMN_USERNAME, account.getUsername());
        contentValues.put(COLUMN_PASSWORD, account.getPassword());
        contentValues.put(COLUMN_NAME, account.getName());
        contentValues.put(COLUMN_ADDRESS, account.getAddress());
        contentValues.put(COLUMN_EMAIL, account.getEmail());*/
        db.insert(TABLE_CUSTOMER, null, contentValues);
    }

    /*
    public Cursor getAllCourse(){
        Cursor cursor = db.query(TABLE_COURSE,
                new String[]{
                        COLUMN_ID,
                        COLUMN_COURSE_NAME,
                        COLUMN_COURSE_DESC
                },
                null, null, null, null, null);
        return cursor;
    }

    public boolean updateCourse(long rowID,String newName, String newDesc){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COURSE_NAME, newName);
        contentValues.put(COLUMN_COURSE_DESC, newDesc);
        return db.update(
                TABLE_COURSE,
                contentValues,
                COLUMN_ID + " = " + rowID,
                null
        ) > 0;
    }

    public boolean deleteCourse(String name){
        boolean result = false;
        String query = "SELECT * FROM " + TABLE_COURSE + " WHERE "
                + COLUMN_COURSE_NAME + "= \"" + name + "\"";
        Cursor cursor = db.rawQuery(query, null);
        Course course = new Course();
        if(cursor.moveToFirst()){
            course.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(
                    TABLE_COURSE,
                    COLUMN_ID + " = ?",
                    new String[]{
                            String.valueOf(course.getId())
                    }
            );
            cursor.close();
            result = true;
        }
        return  result;
    }*/
}
