package kr.hs.dgsw.jin_um.dokdo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import kr.hs.dgsw.jin_um.dokdo.Model.WeatherBean;

public class WeatherActivity extends AppCompatActivity {

    private TextView[] textViewStatusAM, textViewStatusPM, textViewDay;
    private ImageView[] imageViewWeatherIconAM, imageViewWeatherIconPM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        init();

        Task weatherTask = new Task();
        weatherTask.execute();

    }

    private void init(){
        textViewStatusAM = new TextView[7];
        textViewStatusPM = new TextView[7];
        textViewDay = new TextView[7];
        imageViewWeatherIconAM = new ImageView[7];
        imageViewWeatherIconPM = new ImageView[7];

        textViewStatusAM[0] = findViewById(R.id.textViewStatus1AM);
        textViewStatusAM[1] = findViewById(R.id.textViewStatus2AM);
        textViewStatusAM[2] = findViewById(R.id.textViewStatus3AM);
        textViewStatusAM[3] = findViewById(R.id.textViewStatus4AM);
        textViewStatusAM[4] = findViewById(R.id.textViewStatus5AM);
        textViewStatusAM[5] = findViewById(R.id.textViewStatus6AM);
        textViewStatusAM[6] = findViewById(R.id.textViewStatus7AM);

        textViewStatusPM[0] = findViewById(R.id.textViewStatus1PM);
        textViewStatusPM[1] = findViewById(R.id.textViewStatus2PM);
        textViewStatusPM[2] = findViewById(R.id.textViewStatus3PM);
        textViewStatusPM[3] = findViewById(R.id.textViewStatus4PM);
        textViewStatusPM[4] = findViewById(R.id.textViewStatus5PM);
        textViewStatusPM[5] = findViewById(R.id.textViewStatus6PM);
        textViewStatusPM[6] = findViewById(R.id.textViewStatus7PM);

        textViewDay[0] = findViewById(R.id.textViewDay1);
        textViewDay[1] = findViewById(R.id.textViewDay2);
        textViewDay[2] = findViewById(R.id.textViewDay3);
        textViewDay[3] = findViewById(R.id.textViewDay4);
        textViewDay[4] = findViewById(R.id.textViewDay5);
        textViewDay[5] = findViewById(R.id.textViewDay6);
        textViewDay[6] = findViewById(R.id.textViewDay7);

        imageViewWeatherIconAM[0] = findViewById(R.id.imageViewWeatherIcon1AM);
        imageViewWeatherIconAM[1] = findViewById(R.id.imageViewWeatherIcon2AM);
        imageViewWeatherIconAM[2] = findViewById(R.id.imageViewWeatherIcon3AM);
        imageViewWeatherIconAM[3] = findViewById(R.id.imageViewWeatherIcon4AM);
        imageViewWeatherIconAM[4] = findViewById(R.id.imageViewWeatherIcon5AM);
        imageViewWeatherIconAM[5] = findViewById(R.id.imageViewWeatherIcon6AM);
        imageViewWeatherIconAM[6] = findViewById(R.id.imageViewWeatherIcon7AM);

        imageViewWeatherIconPM[0] = findViewById(R.id.imageViewWeatherIcon1PM);
        imageViewWeatherIconPM[1] = findViewById(R.id.imageViewWeatherIcon2PM);
        imageViewWeatherIconPM[2] = findViewById(R.id.imageViewWeatherIcon3PM);
        imageViewWeatherIconPM[3] = findViewById(R.id.imageViewWeatherIcon4PM);
        imageViewWeatherIconPM[4] = findViewById(R.id.imageViewWeatherIcon5PM);
        imageViewWeatherIconPM[5] = findViewById(R.id.imageViewWeatherIcon6PM);
        imageViewWeatherIconPM[6] = findViewById(R.id.imageViewWeatherIcon7PM);
    }

    public class Task extends AsyncTask<Void, Void, List<WeatherBean>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<WeatherBean> strings) {
            super.onPostExecute(strings);
            int amCount = 0;
            int pmCount = 0;
            int id = 0;
            for(int i = 0 ; i < strings.size() ; i++){
                String arr[] = strings.get(i).getWeather().split("강");
                switch (arr[0].trim()){
                    case "맑음" : id = R.drawable.ic_sun;
                                    break;
                    case "구름많음" : id = R.drawable.ic_sun_cloud;
                                        break;
                    case "흐리고 비" :
                    case "흐리고 한때 비" : id = R.drawable.ic_rain;
                                                break;
                    case "흐림" : id = R.drawable.ic_cloud;
                                    break;
                }

                if(i % 2 == 0){
                    textViewStatusAM[amCount].setText(strings.get(i).getTemperature());
                    imageViewWeatherIconAM[amCount].setImageResource(id);
                    textViewDay[amCount++].setText(strings.get(i).getDay());
                } else {
                    imageViewWeatherIconPM[pmCount].setImageResource(id);
                    textViewStatusPM[pmCount++].setText(strings.get(i).getTemperature());
                }
            }
        }

        @Override
        protected List<WeatherBean> doInBackground(Void... voids) {
            try{
                String path = "https://weather.naver.com/rgn/townWetr.nhn?naverRgnCd=04940250";

                Document document = Jsoup.connect(path).get();

                Elements elementsTemperature = document.select("li.nm");
                Elements elementsWeather = document.select("li.info");
                Elements elementsDay = document.select("th");
                List<WeatherBean> lists = new ArrayList<>();

                int dayCount = 0;
                for(int i = 0 ; i < elementsTemperature.size() ; i ++){
                    WeatherBean weatherBean = new WeatherBean(elementsTemperature.get(i).text(), elementsWeather.get(i).text(), elementsDay.get(dayCount).text());
                    lists.add(weatherBean);

                    if(i % 2 != 0){
                        dayCount++;
                    }
                }



                return lists;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
