package byteinspace.net.eurexcommunicatordb;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Handler handler = new Handler();
        handler.postDelayed(getNewRunnable(), 4000);




    }

    protected void showNextScreen() {
        Intent intent = new Intent(this, MainPublicActivity.class);
        startActivity(intent);
    }

    private Runnable getNewRunnable() {
        return  new Runnable() {

            @Override
            public void run() {
                showNextScreen();


            }
        };
    }
}
