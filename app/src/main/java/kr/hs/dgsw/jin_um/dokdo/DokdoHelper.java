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
        String sql = "create table dokdo(idx integer primary key, depth1 integer, depth2 integer, title text, explanation text)";
        db.execSQL(sql);
        sql = "create table dokdo_picture(idx integer primary key, depth1 integer, depth2 integer, picture text, explanation text)";
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
        value.put("title", "독도를 소개합니다!");
        value.put("explanation",
                "행정구역\n" +
                "경상북도 울릉군 울릉읍 독도리 1~96번지\n\n" +
                "거리\n" +
                "울릉도에서 동남쪽으로 87.4km,\n" +
                "동해안의 죽변에서는 동쪽으로 216.8km 떨어져 있으며,\n" +
                "맑은날 울릉도에서 독도를 볼 수 있다. 한편\n" +
                "일본에서는 독도와 가장 가까운 오키섬으로부터는\n" +
                "북서쪽으로 157.5km 떨어져있어,\n" +
                "오키섬에서는 독도를 볼수가 없다.\n\n" +
                "구성\n" +
                "화산활동에 의해 생성된 독도는\n" +
                "하나의 섬이 아니라, 동도와 서도 2개의 큰섬과\n" +
                "주위에 89개의 부속도서로 이루어져 있으며, \n" +
                "동도와 서도간 최단거리는 저조시를 기준으로\n" +
                "151m 떨어져 있다.\n\n" +
                "면적\n" +
                "총 면적은 187.554m²에 달하며,\n" +
                "동도 73.297m², 서도 88.740m²,\n" +
                "부속도 25.517m²이며,\n" +
                "대한민국 정부 소유의 국유지이다.");

        db.insert("dokdo",null, value);

        value.put("depth2", 2);
        value.put("explanation",
                "기후\n" +
                        "독도의 기후는 난류의 영향을 많이 받는 전형적인\n" +
                        "해양성 기후로 연평균 기온이 약 12도이며,\n" +
                        "가장 추운 1월 평균 기온이 1도, 가장 더운\n" +
                        "8월 평균 기온이 23도로 비교적 온난한 편이다.\n\n" +
                        "지형 및 지질\n" +
                        "지형\n" +
                        "독도는 해저 약 2000m에서 솟은 용암이 굳어져 형성된\n" +
                        "화산섬으로 신생대 3기 플라이오세 전기부터 후기 사이,\n" +
                        "약 460만년 전부터 250만년 전 사이에 형성되었다.\n" +
                        "울릉도가 약 250만년 전부터 생성된것에 비해\n" +
                        "약 200만년 앞선다.\n" +
                        "지질\n" +
                        "화산활동에 의하여 분출된 알칼리성 화산암으로 현무암과\n" +
                        "조면암으로 구성되어 있다. 토양은 산정상부에서 풍화하여\n" +
                        "생성된 잔적토로서 30도 이상의 급격한 경사를 이루고\n" +
                        "있고, 토성은 사양질이며 흑갈색 또는 암갈색을 띠고 있다.\n\n" +
                        "자연생태\n" +
                        "독도는 화산암체로 이루어져 있어 식물이 잘 자랄 수 있는\n" +
                        "환경은 아니다. 또한 섬의 경사가 심하여 비가 내려도\n" +
                        "빗물이 섬의 비탈을 따라 흘러 버리기 때문에 토양이\n" +
                        "건조한 편이다. 하지만 또 다른 화산지형인 제주도나\n" +
                        "울릉도에 비해 형성시기가 빠르고, 남해와 서해에서는\n" +
                        "볼 수 없는 대양섬으로서생물학적 가치가 높다.\n" +
                        "독도에는 현재 50-60여 종 내외의 식물이 조사되어\n" +
                        "있으며 대부분은 초본이지만 몇몇 목본 식물도\n" +
                        "서식하고 있다.\n" +
                        "독도에서 자생하고 있는 식물종 중 원식생을 유지하는\n" +
                        "식물종은 도깨비 쇠고비, 땅채송화, 해국 등이 있다.\n\n" +
                        "독도는 난류와 한류가 교차하고 있어 다양한 어종이\n" +
                        "모여드는 황금어장을 성하고 있다.\n" +
                        "더욱이 바위마다 미역, 다시마, 파래등의 해조류가\n" +
                        "서식하고 있으며, 대표적인 어류는 오징어, 꽁치, 방어,\n" +
                        "복어, 전어, 가자미 등이 있다. 그외에도 전복, 소라,\n" +
                        "홍합 등의조개류와 해삼, 새우, 홍게 등이 서식하고 있다.");

        db.insert("dokdo",null,value);

        value.put("title", "독도로 가는 방법입니다!");
        value.put("depth1", 2);
        value.put("depth2", 1);
        value.put("explanation",
                "포항<->울릉\n" +
                        "썬플라워호\n" +
                        "포항 출항 : 09:50, 울릉 출항 : 15:30\n" +
                        "소요 시간 : 3시간 10분, 승선 인원 : 920명\n\n" +
                        "아라퀸즈호\n" +
                        "포항 출항 : 12:10, 울릉 출항 : 17:30\n" +
                        "소요 시간 : 3시간 30분, 승선 인원 : 855명\n\n" +
                        "후포<->울릉\n" +
                        "씨플라워2호\n" +
                        "부정기 운행(선사 문의)\n" +
                        "소요 시간 : 3시간 30분, 승선 인원 : 376명\n\n" +
                        "독도편 여객선\n" +
                        "강릉<->울릉\n" +
                        "씨스타1호\n" +
                        "부정기 운행(선사 문의)\n" +
                        "소요 시간 : 2시간 50분, 승선인원 : 443명\n\n" +
                        "씨스타3호\n" +
                        "부정기 운행(선사 문의)\n" +
                        "소요시간 : 3시간, 승선인원 : 587명\n\n" +
                        "유의사항\n" +
                        "여객선 운항시간은 해운사의 사정 및 관광성수기,\n" +
                        "동절기에 따라 변동될 수 있습니다.\n" +
                        "독도 접안 가능여부는 현지 기상상황에 따라\n" +
                        "변동될 수 있습니다.\n\n" +
                        "출발전 반드시 문의\n" +
                        "-독도 체류시간은 20~30분 정도 (동도 선착장)\n" +
                        "-기타 독도입도 관련 자세한 문의사항은\n" +
                        "울릉군 독도 관리 사무소\n" +
                        "054)790-6645~6/www.ulleung.go.kr");

        db.insert("dokdo",null,value);

        value.put("depth2", 2);
        value.put("explanation",
                "독도 입도에 대한 법적근거\n" +
                        "독도는 1982년 천연기념물로 지정, 문화재 보호법에 근거하여\n" +
                        "공개를 제한해 왔으나 제한지역(동도, 서도)중 동도에 한해\n" +
                        "일반인의 출입이 가능하도록 공개제한을 해제함으로써\n" +
                        "입도허가제(승인)를 신고제로 전환\n\n" +
                        "일반관광객\n" +
                        "신청인: 여객선사 예약 ->\n" +
                        "여객선사 : 일괄입도 신고 -> 울릉군 : 신고필증 교부\n\n" +
                        "특수한 목적의 경우\n" +
                        "행사, 집회, 언론사, 취재, 촬영, 학술조사, 숙박, 체류 등\n\n" +
                        "신청인 : 신청서 작성 및 신고 -> 울릉군 : 문화재정협의 및\n" +
                        "신고필증교부 -> 신청인: 입도선편확보\n\n" +
                        "※문화재정협의\n" +
                        "입도인원 초과, 행정/학술/경찰/해양경찰업무\n" +
                        "이외의 숙박 체류\n" +
                        "동도 선착장의 지역에서의 각종 행사 등\n\n" +
                        "※울릉군 승인\n" +
                        "행정/학술/경찰/해양경찰업무의 숙박 체류\n" +
                        "동도 선착장 내 행사");
        db.insert("dokdo", null, value);

        value = new ContentValues();
        value.put("depth1", 1);
        value.put("depth2", 1);

        value.put("picture", "https://img.sbs.co.kr/newimg/news/20180617/201194757_1280.jpg");
        value.put("explanation", "독도의 모습");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "https://pbs.twimg.com/media/CzMvi1oUkAEp2L0.jpg");
        value.put("explanation", "독도와의 거리");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.intodokdo.go.kr/img/04_dokdo/dokdo_map.gif");
        value.put("explanation", "동도와 서도");
        db.insert("dokdo_picture", null, value);

        value.put("depth2", 2);

        value.put("picture", "https://t1.daumcdn.net/cfile/tistory/114D08374FFECC3D28");
        value.put("explanation", "노랑부리백로");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://cfile223.uf.daum.net/image/277CFB39574C4A4505E7D7");
        value.put("explanation", "괭이갈매기");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.ibric.org/upload/board/files/ulleung/ull_3/thumb2/0000753_1.jpg");
        value.put("explanation", "섬장대");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "https://i.ytimg.com/vi/G4UaE1IKqDA/maxresdefault.jpg");
        value.put("explanation", "박주가리");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.ibric.org/upload/board/files/ulleung/ull_3/thumb2/0000923_7.jpg");
        value.put("explanation", "슬패랭이");
        db.insert("dokdo_picture", null, value);

        value.put("depth1", 2);
        value.put("depth2", 1);

        value.put("picture", "http://www.k-dokdo.com/cmsh/k-dokdo.com/new/images/content/img_traffic01.gif");
        value.put("explanation", "울릉도 입도 경로");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/cmsh/k-dokdo.com/new/images/content/img_traffic02.gif");
        value.put("explanation", "독도 입도 경로");
        db.insert("dokdo_picture", null, value);

        value.put("depth2", 2);

        value.put("picture", "https://t1.daumcdn.net/cfile/tistory/2738D0395264EE1604");
        value.put("explanation", "독도 입도 절차");
        db.insert("dokdo_picture", null, value);

        value.put("depth1", 3);
        value.put("depth2", 1);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000003236&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000003473&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000003475&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000646&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000643&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("depth2", 2);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000689&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000687&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000685&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000688&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000003367&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("depth2", 3);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000003364&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000003363&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000003343&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000683&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000668&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("depth2", 4);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000003258&fileSn=1");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000662&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000660&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000663&fileSn=0");
        db.insert("dokdo_picture", null, value);

        value.put("picture", "http://www.k-dokdo.com/icms/file/getImage.do?atchFileId=FILE_000000000000665&fileSn=0");
        db.insert("dokdo_picture", null, value);
    }

    public String getTitle(int depth1, int depth2){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from dokdo where depth1 = " + depth1 + " and depth2 = " + depth2;
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToNext()){
            return cursor.getString(cursor.getColumnIndex("title"));
        }
        return null;
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

    public List<String> getImages(int depth1, int depth2){
        List<String> images = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from dokdo_picture where depth1 = " + depth1 + " and depth2 = " + depth2;
        Cursor cursor = db.rawQuery(sql, null);

        while(cursor.moveToNext()){
            images.add(cursor.getString(cursor.getColumnIndex("picture")));
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
