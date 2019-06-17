package kr.hs.dgsw.jin_um.dokdo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PictureActivity extends AppCompatActivity {
    private final int NOW_DEPTH = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
    }

    public void changeTabPicture(View v){
        Intent intent = new Intent();

        switch (v.getId()){
            case R.id.cardViewPictureScenery : intent =  new Intent(this, PictureSceneryActivity.class);
                break;
            case R.id.cardViewPictureOcean : intent = new Intent(this, PictureOceanActivity.class);
                break;
            case R.id.cardViewPictureAnimal : intent = new Intent(this, PictureAnimalActivity.class);
                break;
            case R.id.cardViewPicturePlant : intent = new Intent(this, PicturePlantActivity.class);
                break;
        }
        intent.putExtra("depth", NOW_DEPTH);
        startActivity(intent);
    }
}
