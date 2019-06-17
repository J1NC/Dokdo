package kr.hs.dgsw.jin_um.dokdo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends PagerAdapter {
    private List<Integer> images;
    private List<String> imagesDescription;
    private LayoutInflater layoutInflater;
    private Context context;

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((ConstraintLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.slider, container, false);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageViewSlider);
        TextView textView = (TextView) v.findViewById(R.id.textViewDescriptSlider);
        imageView.setImageResource(images.get(position));
        if(imagesDescription.size() != 0)
        textView.setText(imagesDescription.get(position));
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.invalidate();
    }

    public ImageAdapter(Context context, List<Integer> images, List<String> imagesDescription){
        this.context = context;
        this.images = images;
        this.imagesDescription = imagesDescription;
    }
}
