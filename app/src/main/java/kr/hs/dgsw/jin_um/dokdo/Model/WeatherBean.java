package kr.hs.dgsw.jin_um.dokdo.Model;

public class WeatherBean {
    private String temperatureAM;
    private String weatherAM;
    private String temperaturePM;
    private String weatherPM;
    private String day;

    public String getTemperatureAM() {
        return temperatureAM;
    }

    public void setTemperatureAM(String temperatureAM) {
        this.temperatureAM = temperatureAM;
    }

    public String getWeatherAM() {
        return weatherAM;
    }

    public void setWeatherAM(String weatherAM) {
        this.weatherAM = weatherAM;
    }

    public String getTemperaturePM() {
        return temperaturePM;
    }

    public void setTemperaturePM(String temperaturePM) {
        this.temperaturePM = temperaturePM;
    }

    public String getWeatherPM() {
        return weatherPM;
    }

    public void setWeatherPM(String weatherPM) {
        this.weatherPM = weatherPM;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public WeatherBean(String temperatureAM, String weatherAM, String temperaturePM, String weatherPM, String day) {
        this.temperatureAM = temperatureAM;
        this.weatherAM = weatherAM;
        this.temperaturePM = temperaturePM;
        this.weatherPM = weatherPM;
        this.day = day;
    }
}
