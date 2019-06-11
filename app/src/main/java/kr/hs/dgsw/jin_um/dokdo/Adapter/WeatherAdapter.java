package kr.hs.dgsw.jin_um.dokdo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.hs.dgsw.jin_um.dokdo.Model.WeatherBean;
import kr.hs.dgsw.jin_um.dokdo.R;
import kr.hs.dgsw.jin_um.dokdo.ViewHolder.WeatherItemViewHolder;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherItemViewHolder>  {

    private ArrayList<WeatherBean> weatherData;

    public WeatherAdapter(ArrayList<WeatherBean> weatherData) {
        this.weatherData = weatherData;
    }

    @NonNull
    @Override
    public WeatherItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.recycler_weather_item, viewGroup, false);
        return new WeatherItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherItemViewHolder weatherItemViewHolder, int i) {
        WeatherBean weatherBean = weatherData.get(i);
        weatherItemViewHolder.textViewWeatherDay.setText(weatherBean.getDay());
        weatherItemViewHolder.textViewWeatherAM.setText(weatherBean.getTemperatureAM());
        weatherItemViewHolder.textViewWeatherPM.setText(weatherBean.getTemperaturePM());
        weatherItemViewHolder.imageViewWeatherAM.setImageResource(getIcon(weatherBean.getWeatherAM()));
        weatherItemViewHolder.imageViewWeatherPM.setImageResource(getIcon(weatherBean.getWeatherPM()));
    }

    @Override
    public int getItemCount() {
        if(weatherData == null)
            return 0;
        else
            return weatherData.size();
    }

    private int getIcon(String weather){
        int id = 0;

        String arr[] = weather.split("강수");
        switch (arr[0].trim()){
            case "맑음" : id = R.drawable.ic_sun;
                break;
            case "구름많음" : id = R.drawable.ic_sun_cloud;
                break;
            case "구름많고 비" :
            case "흐리고 비" :
            case "흐리고 한때 비" : id = R.drawable.ic_rain;
                break;
            case "흐림" : id = R.drawable.ic_cloud;
                break;
        }

        return id;
    }
}
