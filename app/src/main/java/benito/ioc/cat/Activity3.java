package benito.ioc.cat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        String txt = intent.getStringExtra(Activity2.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.TextView_recibido);
        textView.setText(txt);
    }
}