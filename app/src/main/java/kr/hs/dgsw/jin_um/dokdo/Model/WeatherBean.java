package kr.hs.dgsw.jin_um.dokdo.Model;

public class WeatherBean {
    private String temperature;
    private String weather;
    private String day;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public WeatherBean(String temperature, String weather) {
        this.temperature = temperature;
        this.weather = weather;
    }

    public WeatherBean(String temperature, String weather,String day) {
        this.temperature = temperature;
        this.weather = weather;
        this.day = day;
    }
}
