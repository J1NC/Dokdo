package kr.hs.dgsw.jin_um.dokdo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IntroductionPlaceActivity extends AppCompatActivity {
    private final int DEPTH = 1;
    private int depth1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_place);
        depth1= getIntent().getIntExtra("depth", -1);
    }

    
}
