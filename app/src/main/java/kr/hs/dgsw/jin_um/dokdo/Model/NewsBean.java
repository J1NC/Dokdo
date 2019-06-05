package kr.hs.dgsw.jin_um.dokdo.Model;

public class NewsBean {
    private String newsTitle;
    private String newsDate;
    private String newsContent;

    public NewsBean(String newsTitle, String newsDate, String newsContent) {
        this.newsTitle = newsTitle;
        this.newsDate = newsDate;
        this.newsContent = newsContent;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}
