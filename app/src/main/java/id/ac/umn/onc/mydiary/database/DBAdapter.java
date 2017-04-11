package id.ac.umn.onc.mydiary.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import id.ac.umn.onc.mydiary.model.Customer;
import id.ac.umn.onc.mydiary.model.Memo;

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
        String CREATE_TABLE_CUSTOMER = "CREATE TABLE "+ TABLE_CUSTOMER +"("
                + COLUMN_CUSTOMER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_CUSTOMER_EMAIL + " TEXT UNIQUE, "
                + COLUMN_CUSTOMER_PASSWORD + " TEXT NOT NULL, "
                + COLUMN_CUSTOMER_NAME + " TEXT NOT NULL )";
        db.execSQL(CREATE_TABLE_CUSTOMER);

        String CREATE_TABLE_MEMO = "CREATE TABLE " + TABLE_MEMO + "("
                + COLUMN_MEMO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_MEMO_ID_CUSTOMER + "INTEGER, "
                + COLUMN_MEMO_EMOTION + " TEXT NOT NULL, "
                + COLUMN_MEMO_NOTE + " TEXT NOT NULL, "
                + COLUMN_MEMO_IMAGE + " BLOB, "
                + COLUMN_MEMO_DATE + " DATE NOT NULL, "
                + "FOREIGN KEY ("+COLUMN_MEMO_ID_CUSTOMER+") REFERENCES "+TABLE_CUSTOMER+"("+COLUMN_CUSTOMER_ID+")";

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
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CUSTOMER_ID, customer.getId());
        contentValues.put(COLUMN_CUSTOMER_EMAIL, customer.getEmail());
        contentValues.put(COLUMN_CUSTOMER_PASSWORD, customer.getPassword());
        contentValues.put(COLUMN_CUSTOMER_NAME, customer.getName());
        db.insert(TABLE_CUSTOMER, null, contentValues);
    }

    public void insertMemo (Memo memo){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MEMO_ID, memo.getId());
        contentValues.put(COLUMN_MEMO_ID_CUSTOMER, memo.getIdCustomer());
        contentValues.put(COLUMN_MEMO_EMOTION, memo.getEmotion());
        contentValues.put(COLUMN_MEMO_NOTE, memo.getNote());
        contentValues.put(COLUMN_MEMO_IMAGE, memo.getImage());
        contentValues.put(COLUMN_MEMO_DATE, memo.getDate());
        db.insert(TABLE_MEMO, null, contentValues);
    }


    public Cursor getAllCustomer(){
        Cursor cursor = db.query(TABLE_CUSTOMER,
                new String[]{
                        COLUMN_CUSTOMER_ID,
                        COLUMN_CUSTOMER_EMAIL,
                        COLUMN_CUSTOMER_PASSWORD,
                        COLUMN_CUSTOMER_NAME
                },
                null, null, null, null, null);
        return cursor;
    }

    public Cursor getAllMemo(){
        Cursor cursor = db.query(TABLE_MEMO,
                new String[]{
                        COLUMN_MEMO_ID,
                        COLUMN_MEMO_ID_CUSTOMER,
                        COLUMN_MEMO_EMOTION,
                        COLUMN_MEMO_NOTE,
                        COLUMN_MEMO_IMAGE,
                        COLUMN_MEMO_DATE
                },
                null, null, null, null, null);
        return cursor;
    }

    public boolean updateCustomer(long rowID,String newEmail, String newPassword, String newName){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CUSTOMER_EMAIL, newEmail);
        contentValues.put(COLUMN_CUSTOMER_PASSWORD, newPassword);
        contentValues.put(COLUMN_CUSTOMER_NAME, newName);
        return db.update(
                TABLE_CUSTOMER,
                contentValues,
                COLUMN_CUSTOMER_ID + " = " + rowID,
                null
        ) > 0;
    }
    /*
    public boolean updateMemo(long rowID,String newEmotion, String newNote, String newImage){

    }*/

    public boolean deleteMemo(Integer id){
        boolean result = false;
        String query = "SELECT * FROM " + TABLE_MEMO + " WHERE "
                + COLUMN_MEMO_ID + "= \"" + id + "\"";
        Cursor cursor = db.rawQuery(query, null);
        Memo memo = new Memo();
        if(cursor.moveToFirst()){
            memo.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(
                    TABLE_MEMO,
                    COLUMN_MEMO_ID + " = ?",
                    new String[]{
                            String.valueOf(memo.getId())
                    }
            );
            cursor.close();
            result = true;
        }
        return  result;
    }

    public boolean deleteCustomer(Integer id){
        boolean result = false;
        String query = "SELECT * FROM " + TABLE_CUSTOMER + " WHERE "
                + COLUMN_CUSTOMER_ID + "= \"" + id + "\"";
        Cursor cursor = db.rawQuery(query, null);
        Customer customer = new Customer();
        if(cursor.moveToFirst()){
            customer.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(
                    TABLE_CUSTOMER,
                    COLUMN_CUSTOMER_ID + " = ?",
                    new String[]{
                            String.valueOf(customer.getId())
                    }
            );
            cursor.close();
            result = true;
        }
        return result;
    }

}
