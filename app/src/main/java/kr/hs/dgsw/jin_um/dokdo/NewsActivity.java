package kr.hs.dgsw.jin_um.dokdo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.hs.dgsw.jin_um.dokdo.Model.NewsBean;
import kr.hs.dgsw.jin_um.dokdo.Model.WeatherBean;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView newsList;
    private NewsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Task newsTask = new Task();
        newsTask.execute();
    }

    public class Task extends AsyncTask<Void, Void, List<NewsBean>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<NewsBean> newsBeans) {
            super.onPostExecute(newsBeans);

            adapter = new NewsAdapter((ArrayList<NewsBean>) newsBeans);

            LinearLayoutManager layoutManager = new LinearLayoutManager(NewsActivity.this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            newsList = findViewById(R.id.newsList);
            newsList.setLayoutManager(layoutManager);
            newsList.setAdapter(adapter);
        }

        @Override
        protected List<NewsBean> doInBackground(Void... voids) {
            try{
                String path = "http://search.chosun.com/search/news.search?query=%EB%8F%85%EB%8F%84&pageno=0&orderby=news&naviarraystr=&kind=&cont1=&cont2=&cont5=&categoryname=&categoryd2=&c_scope=more_news&sdate=&edate=&premium=";
                Document document = Jsoup.connect(path).get();

                Elements elements = document.select("dl.search_news");
                List<NewsBean> newsBeans = new ArrayList<>();
                Log.i("news",elements.size()+"");
                for(int i = 0; i < elements.size() ; i ++){
                    NewsBean newsBean = new NewsBean(elements.get(i).select("a").eq(1).get(0).text(), elements.get(i).select("span.date").get(0).text(), elements.get(i).select("a").eq(2).get(0).text());
                    Log.i("news",newsBean.getNewsDate());
                    newsBeans.add(newsBean);
                }

                return newsBeans;
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
