package kr.hs.dgsw.jin_um.dokdo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class IntroductionPlaceActivity extends AppCompatActivity {
    private final int DEPTH = 1;
    private int depth1;
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
        setContentView(R.layout.activity_introduction_place);
        depth1= getIntent().getIntExtra("depth", -1);
        dokdoHelper = new DokdoHelper(this,"userdb",null,1);
        init();
    }

    private void init(){
        textViewExplanation = findViewById(R.id.textViewExIntroductionPlace);
        explanation = dokdoHelper.getExplanation(depth1, DEPTH);
        images = dokdoHelper.getImages(depth1, DEPTH);
        imagesDescription = dokdoHelper.getImageExplanation(depth1, DEPTH);
        viewPager = (ViewPager) findViewById(R.id.imageSliderIntroductionPlace);
        imageAdapter = new ImageAdapter(this, images, imagesDescription);
        viewPager.setAdapter(imageAdapter);
        textViewExplanation.setText(explanation);
    }


}
