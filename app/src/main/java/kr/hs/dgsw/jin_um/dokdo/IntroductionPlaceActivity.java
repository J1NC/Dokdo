package kr.hs.dgsw.jin_um.dokdo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class IntroductionPlaceActivity extends AppCompatActivity {
    private final int NOW_DEPTH = 1;
    private int PREV_DEPTH;
    private DokdoHelper dokdoHelper;
    private TextView textViewExplanation;
    private String explanation;
    private ImageAdapter imageAdapter;
    private ViewPager viewPager;
    private List<Integer> images;
    private List<String> imagesDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_explanation);
        PREV_DEPTH = getIntent().getIntExtra("depth", -1);
        dokdoHelper = new DokdoHelper(this,"userdb",null,1);
        init();
    }

    private void init(){
        textViewExplanation = findViewById(R.id.textViewDetailEx);
        explanation = dokdoHelper.getExplanation(PREV_DEPTH, NOW_DEPTH);
        images = dokdoHelper.getImages(PREV_DEPTH, NOW_DEPTH);
        imagesDescription = dokdoHelper.getImageExplanation(PREV_DEPTH, NOW_DEPTH);
        viewPager = (ViewPager) findViewById(R.id.imageSliderDetail);
        imageAdapter = new ImageAdapter(this, images, imagesDescription);
        viewPager.setAdapter(imageAdapter);
        textViewExplanation.setText(explanation);
    }
}
