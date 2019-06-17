package kr.hs.dgsw.jin_um.dokdo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class PictureSceneryActivity extends AppCompatActivity {
    private final int NOW_DEPTH = 1;
    private int PREV_DEPTH;
    private DokdoHelper dokdoHelper;
    private ImageAdapter imageAdapter;
    private ViewPager viewPager;
    private List<Integer> images;
    private List<String> imagesDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gallery);
        PREV_DEPTH = getIntent().getIntExtra("depth", -1);
        dokdoHelper = new DokdoHelper(this,"userdb",null,1);
        init();
    }

    private void init(){
        viewPager = (ViewPager) findViewById(R.id.imageSliderDetailGallery);

        images = dokdoHelper.getImages(PREV_DEPTH, NOW_DEPTH);
        imageAdapter = new ImageAdapter(this, images, null);
        viewPager.setAdapter(imageAdapter);
    }
}