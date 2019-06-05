package kr.hs.dgsw.jin_um.dokdo.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kr.hs.dgsw.jin_um.dokdo.R;

public class WeatherItemViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewWeatherDay, textViewWeatherAM, textViewWeatherPM;
    public ImageView imageViewWeatherAM, imageViewWeatherPM;
    public WeatherItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewWeatherDay = itemView.findViewById(R.id.textViewWeatherDay);
        textViewWeatherAM = itemView.findViewById(R.id.textViewStatusAM);
        textViewWeatherPM = itemView.findViewById(R.id.textViewStatusPM);
        imageViewWeatherAM = itemView.findViewById(R.id.imageViewWeatherIconAM);
        imageViewWeatherPM = itemView.findViewById(R.id.imageViewWeatherIconPM);
    }
}
