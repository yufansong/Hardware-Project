package com.example.baicizhan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private final static int VERSION = 1;
    private final static String DB_NAME = "test6.db";
//    private final static String TABLE_NAME = "word";
//    private final static String CREATE_TBL = "create table if not exists "+TABLE_NAME+"(id integer primary key AUTOINCREMENT, name text, meaning text, book text,ifwrong integer,ifnote integer)";
    private SQLiteDatabase db;
    private Context mContext;

    //SQLiteOpenHelper子类必须要的一个构造函数
    public DBHelper(Context context, String name, CursorFactory factory,int version) {
        //必须通过super 调用父类的构造函数
        super(context, name, factory, version);
    }

    //数据库的构造函数，传递三个参数的
    public DBHelper(Context context, String name, int version){
        this(context, name, null, version);
    }

    //数据库的构造函数，传递一个参数的， 数据库名字和版本号都写死了
    public DBHelper(Context context){
        this(context, DB_NAME, null, VERSION);
    }

    // 回调函数，第一次创建时才会调用此函数，创建一个数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        System.out.println("Create Database");
        String cmd="create table if not exists word(id integer primary key AUTOINCREMENT, name text, meaning text, book text,ifwrong integer,ifnote integer)";
        db.execSQL(cmd);
        cmd="create table if not exists user(id integer primary key AUTOINCREMENT, nameid text, email text, password text)";
        db.execSQL(cmd);
    }

    //回调函数，当你构造DBHelper的传递的Version与之前的Version调用此函数
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("update Database");
        String cmd="DROP TABLE IF EXISTS word";
        db.execSQL(cmd);
        cmd="DROP TABLE IF EXISTS user";
        db.execSQL(cmd);
        onCreate(db);
    }

    //插入方法
    public void insert(ContentValues values,String TableName){
        //获取SQLiteDatabase实例
        SQLiteDatabase db = getWritableDatabase();
        //插入数据库中
        db.insert(TableName, null, values);
        db.close();
    }

    //查询方法
    public Cursor query(String TableName){
        SQLiteDatabase db = getReadableDatabase();
        //获取Cursor
        Cursor c = db.query(TableName, null, null, null, null, null, null, null);
        return c;

    }

    //根据唯一标识id  来删除数据
    public void delete(int id,String TableName){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TableName, "id=?", new String[]{String.valueOf(id)});
    }


    //更新数据库的内容
    public void update(ContentValues values, String whereClause, String[]whereArgs,String TableName){
        SQLiteDatabase db = getWritableDatabase();
        db.update(TableName, values, whereClause, whereArgs);
    }

    public String getDBPath(){
        return mContext.getDatabasePath(DB_NAME).getPath();
    }

    //关闭数据库
    public void close(){
        if(db != null){
            db.close();
        }
    }

}