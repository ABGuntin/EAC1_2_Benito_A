package benito.ioc.cat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class Activity2 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "benito.ioc.cat.MESSAGE";
    private EditText mWebEditText;
    private EditText mPhoneEditText;
    private EditText mShareEditText;
    private EditText mSendEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mWebEditText = findViewById(R.id.web_edittext);
        mPhoneEditText = findViewById(R.id.phone_edittext);
        mShareEditText = findViewById(R.id.text_edittext);
        mSendEditText = findViewById(R.id.sendText_edittext);
    }

    public void openWebsite(View view) {
        String url = mWebEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);

    }

    public void openPhone(View view) {
        String phoneNumber = mPhoneEditText.getText().toString();
        Uri phoneUri = Uri.parse(phoneNumber);
        Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);
        startActivity(intent);

    }

    public void shareText(View view) {
        String txt = mShareEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Compartir este texto con: ")
                .setText(txt)
                .startChooser();

    }

    public void sendText(View view) {
        Intent intent = new Intent(this, Activity3.class);
        String txt = mSendEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, txt);
        startActivity(intent);

    }
}