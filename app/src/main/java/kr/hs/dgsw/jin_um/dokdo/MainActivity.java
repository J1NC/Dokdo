package kr.hs.dgsw.jin_um.dokdo;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle[], textViewEx[];
    private ImageView imageViewIcon[];
    private HashMap hashMapIcon = new HashMap<String, Integer>();
    private DokdoHelper dokdoHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dokdoHelper = new DokdoHelper(this,"userdb",null,1);
        init();
        btnSetting();
    }

    private void init(){
        textViewTitle = new TextView[5];
        textViewEx = new TextView[5];
        imageViewIcon = new ImageView[5];

        textViewTitle[0] = findViewById(R.id.textViewTitle1);
        textViewTitle[1] = findViewById(R.id.textViewTitle2);
        textViewTitle[2] = findViewById(R.id.textViewTitle3);
        textViewTitle[3] = findViewById(R.id.textViewTitle4);
        textViewTitle[4] = findViewById(R.id.textViewTitle5);

        textViewEx[0] = findViewById(R.id.textViewEx1);
        textViewEx[1] = findViewById(R.id.textViewEx2);
        textViewEx[2] = findViewById(R.id.textViewEx3);
        textViewEx[3] = findViewById(R.id.textViewEx4);
        textViewEx[4] = findViewById(R.id.textViewEx5);

        imageViewIcon[0] = findViewById(R.id.imageViewIcon1);
        imageViewIcon[1] = findViewById(R.id.imageViewIcon2);
        imageViewIcon[2] = findViewById(R.id.imageViewIcon3);
        imageViewIcon[3] = findViewById(R.id.imageViewIcon4);
        imageViewIcon[4] = findViewById(R.id.imageViewIcon5);

        hashMapIcon.put("ic_island", R.drawable.ic_island);
        hashMapIcon.put("ic_road", R.drawable.ic_road);
        hashMapIcon.put("ic_picture", R.drawable.ic_picture);
        hashMapIcon.put("ic_weather", R.drawable.ic_weather);
        hashMapIcon.put("ic_newspaper", R.drawable.ic_newspaper);

        dokdoHelper.initialize();
    }

    private void btnSetting(){
        AssetManager assetManager = getResources().getAssets();

        try{
            AssetManager.AssetInputStream ais = (AssetManager.AssetInputStream)assetManager.open("buttons.json");

            BufferedReader br = new BufferedReader(new InputStreamReader(ais));

            StringBuilder sb = new StringBuilder();

            int bufferSize = 1024 * 1024;

            char readBuf [] = new char[bufferSize];
            int resultSize = 0;

            while((resultSize = br.read(readBuf)) != -1){
                if(resultSize == bufferSize){
                    sb.append(readBuf);
                }else{
                    for(int i = 0 ; i < resultSize ; i ++){
                        sb.append(readBuf[i]);
                    }
                }
            }

            String jString = sb.toString();
            JSONObject jsonObject = new JSONObject(jString);
            JSONArray btnJArr = new JSONArray(jsonObject.getString("buttons"));

            for(int i = 0 ; i < btnJArr.length(); i ++){
                JSONObject temp = btnJArr.getJSONObject(i);
                textViewTitle[i].setText(temp.getString("title").toString());
                textViewEx[i].setText(temp.getString("explain").toString());
                imageViewIcon[i].setImageResource(Integer.valueOf(hashMapIcon.get(temp.getString("icon").toString()).toString()));
            }
         }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void changePage(View v){
        Intent i = new Intent();
        switch(v.getId()){
            case R.id.cardViewIntroduction :
                i = new Intent(MainActivity.this, IntroductionActivity.class);
                break;
            case R.id.cardViewRoad :
                i = new Intent(MainActivity.this, RoadActivity.class);
                break;
            case R.id.cardViewPicture :
                i = new Intent(MainActivity.this, PictureActivity.class);
                break;
            case R.id.cardViewWeather :
                i = new Intent(MainActivity.this, WeatherActivity.class);
                break;
            case R.id.cardViewNews :
                i = new Intent(MainActivity.this, NewsActivity.class);
                break;
        }
        startActivity(i);
    }
}
