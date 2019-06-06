package kr.hs.dgsw.jin_um.dokdo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import kr.hs.dgsw.jin_um.dokdo.Adapter.NewsAdapter;
import kr.hs.dgsw.jin_um.dokdo.Adapter.WeatherAdapter;
import kr.hs.dgsw.jin_um.dokdo.Model.NewsBean;
import kr.hs.dgsw.jin_um.dokdo.Model.WeatherBean;

public class WeatherActivity extends AppCompatActivity {

    private TextView[] textViewStatusAM, textViewStatusPM, textViewDay;
    private ImageView[] imageViewWeatherIconAM, imageViewWeatherIconPM;
    private RecyclerView weatherList;
    private WeatherAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Task weatherTask = new Task();
        weatherTask.execute();

    }

    public class Task extends AsyncTask<Void, Void, List<WeatherBean>>{

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
                for(int i = 0 ; i < elementsTemperature.size() ; i += 2){
                    WeatherBean weatherBean =
                            new WeatherBean(elementsTemperature.get(i).text(), elementsWeather.get(i).text(),
                                    elementsTemperature.get(i+1).text(), elementsWeather.get(i+1).text(),
                                    elementsDay.get(dayCount).text());
                    lists.add(weatherBean);

                    dayCount++;
                }
                return lists;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<WeatherBean> strings) {
            super.onPostExecute(strings);

            adapter = new WeatherAdapter((ArrayList<WeatherBean>) strings);

            LinearLayoutManager layoutManager = new LinearLayoutManager(WeatherActivity.this);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            weatherList = findViewById(R.id.weatherList);
            weatherList.setLayoutManager(layoutManager);
            weatherList.setAdapter(adapter);
        }
    }
}
