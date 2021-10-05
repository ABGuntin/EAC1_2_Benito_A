package benito.ioc.cat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    Cuando un usuario apreta el boton, este conduce a una activity nueva (a la activity2)
     */
    public void pressButton(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}