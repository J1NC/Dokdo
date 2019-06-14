package kr.hs.dgsw.jin_um.dokdo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntroductionActivity extends AppCompatActivity {
    private final int DEPTH = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
    }

    public void changeTabIntroduction(View v){
        Intent intent = new Intent();

        switch (v.getId()){
            case R.id.cardViewIntroductionPlace : intent =  new Intent(this, IntroductionPlaceActivity.class);
            break;
            case R.id.cardViewIntroductionView : intent = new Intent(this, IntroductionViewActivity.class);
            break;
        }
        intent.putExtra("depth", DEPTH);
        startActivity(intent);
    }
}
