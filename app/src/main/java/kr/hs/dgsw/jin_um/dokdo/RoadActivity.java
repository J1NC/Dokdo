package kr.hs.dgsw.jin_um.dokdo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RoadActivity extends AppCompatActivity {
    private final int NOW_DEPTH = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road);
    }

    public void changeRoad(View v){
        Intent intent = new Intent();

        switch (v.getId()){
            case R.id.cardViewRoadPath : intent =  new Intent(this, RoadPathActivity.class);
                break;
            case R.id.cardViewRoadWay : intent = new Intent(this, RoadWayActivity.class);
                break;
        }
        intent.putExtra("depth", NOW_DEPTH);
        startActivity(intent);
    }
}
