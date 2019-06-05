package kr.hs.dgsw.jin_um.dokdo.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.hs.dgsw.jin_um.dokdo.Model.NewsBean;
import kr.hs.dgsw.jin_um.dokdo.R;
import kr.hs.dgsw.jin_um.dokdo.ViewHolder.NewsItemViewHolder;

public class NewsAdapter extends RecyclerView.Adapter<NewsItemViewHolder>  {

    private ArrayList<NewsBean> newsData;

    public NewsAdapter(ArrayList<NewsBean> newsData) {
        this.newsData = newsData;
    }

    @NonNull
    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.recycler_news_item, viewGroup, false);
        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemViewHolder newsItemViewHolder, int i) {
        NewsBean newsBean = newsData.get(i);
        newsItemViewHolder.textViewNewsTitle.setText(newsBean.getNewsTitle());
        newsItemViewHolder.textViewNewsDate.setText(newsBean.getNewsDate());
        newsItemViewHolder.textViewNewsContent.setText(newsBean.getNewsContent());
    }

    @Override
    public int getItemCount() {
        if(newsData == null)
            return 0;
        else
            return newsData.size();
    }
}
