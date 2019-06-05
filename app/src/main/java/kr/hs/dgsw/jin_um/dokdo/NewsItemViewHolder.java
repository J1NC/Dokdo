package kr.hs.dgsw.jin_um.dokdo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NewsItemViewHolder extends RecyclerView.ViewHolder {
    TextView textViewNewsTitle, textViewNewsDate, textViewNewsContent;
    public NewsItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewNewsTitle = itemView.findViewById(R.id.textViewNewsTitle);
        textViewNewsDate = itemView.findViewById(R.id.textViewNewsDate);
        textViewNewsContent = itemView.findViewById(R.id.textViewNewsContent);
    }
}
