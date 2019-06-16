package kr.hs.dgsw.jin_um.dokdo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DokdoHelper extends SQLiteOpenHelper {

    public DokdoHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table dokdo(idx integer primary key, depth1 integer, depth2 integer, explanation text)";
        db.execSQL(sql);
        sql = "create table dokdo_picture(idx integer primary key, depth1 integer, depth2 integer, picture biginteger, explanation text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table dokdo";
        db.execSQL(sql);
        sql = "drop table dokdo_picture";
        db.execSQL(sql);
        onCreate(db);
    }

    public void initialize(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("dokdo", null, null);
        db.delete("dokdo_picture", null, null);
        ContentValues value = new ContentValues();

        value.put("depth1", 1);
        value.put("depth2", 1);
        value.put("explanation", "행정구역: 경상북도 울릉군 울릉읍 독도리 1~96번지\n\n" +
                "거리 : 울릉도에서 동남쪽으로 87.4km,\n" +
                "동해안의 죽변에서는 동쪽으로 216.8km 떨어져 있으며,\n" +
                "맑은날 울릉도에서 독도를 볼 수 있다. 한편\n" +
                "일본에서는 독도와 가장 가까운 오키섬으로부터는\n" +
                "북서쪽으로 157.5km 떨어져있어,\n" +
                "오키섬에서는 독도를 볼수가 없다.\n\n" +
                "구성 : 화산활동에 의해 생성된 독도는\n" +
                "하나의 섬이 아니라, 동도와 서도 2개의 큰섬과\n" +
                "주위에 89개의 부속도서로 이루어져 있으며, \n" +
                "동도와 서도간 최단거리는 저조시를 기준으로\n" +
                "151m 떨어져 있다.\n\n" +
                "면적 : 총 면적은 187.554m²에 달하며,\n" +
                "동도 73.297m², 서도 88.740m²,\n" +
                "부속도 25.517m²이며,\n" +
                "대한민국 정부 소유의 국유지이다.");

        db.insert("dokdo",null, value);

        value = new ContentValues();

        value.put("depth1", 1);
        value.put("depth2", 1);
        value.put("picture", R.drawable.introduction_place_image_1);
        value.put("explanation", "독도의 모습");
        db.insert("dokdo_picture", null, value);

        value.put("picture", R.drawable.introduction_place_image_2);
        value.put("explanation", "독도와의 거리");
        db.insert("dokdo_picture", null, value);

        value.put("picture", R.drawable.introduction_place_image_3);
        value.put("explanation", "동도와 서도");
        db.insert("dokdo_picture", null, value);
    }

    public String getExplanation(int depth1, int depth2){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from dokdo where depth1 = " + depth1 + " and depth2 = " + depth2;
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToNext()){
            return cursor.getString(cursor.getColumnIndex("explanation"));
        }
        return null;
    }

    public List<Integer> getImages(int depth1, int depth2){
        List<Integer> images = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from dokdo_picture where depth1 = " + depth1 + " and depth2 = " + depth2;
        Cursor cursor = db.rawQuery(sql, null);

        while(cursor.moveToNext()){
            images.add(cursor.getInt(cursor.getColumnIndex("picture")));
        }
        return images;
    }

    public List<String> getImageExplanation(int depth1, int depth2){
        List<String> imagesDescription = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from dokdo_picture where depth1 = " + depth1 + " and depth2 = " + depth2;
        Cursor cursor = db.rawQuery(sql, null);

        while(cursor.moveToNext()){
            imagesDescription.add(cursor.getString(cursor.getColumnIndex("explanation")));
        }
        return imagesDescription;
    }
}
