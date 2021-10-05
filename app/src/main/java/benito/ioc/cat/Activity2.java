package benito.ioc.cat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class Activity2 extends AppCompatActivity {

    //Se añade una constante publica para definir la llave del Intent extra Bundle
    public static final String EXTRA_MESSAGE = "benito.ioc.cat.MESSAGE";
    //Para capturar los editText
    private EditText mWebEditText;
    private EditText mPhoneEditText;
    private EditText mShareEditText;
    private EditText mSendEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //para obterner la referencia del EditText y asignarla a la variable privada
        mWebEditText = findViewById(R.id.web_edittext);
        mPhoneEditText = findViewById(R.id.phone_edittext);
        mShareEditText = findViewById(R.id.text_edittext);
        mSendEditText = findViewById(R.id.sendText_edittext);
    }

    /*
    Cuando el usuario apreta el boton, este la lleva al una pagina web definida en el EditText
     */
    public void openWebsite(View view) {
        //Obtiene la URL
        String url = mWebEditText.getText().toString();
        //Analiza la URI y crea el Intent
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        //Inicia la activity con el Intent
        startActivity(intent);

    }

    /*
    Cuando el usuario apreta el boton, este abre las llamadas con el número de teléfono del EditText
     */
    public void openPhone(View view) {
        //Obtiene el número de teléfono
        String phoneNumber = mPhoneEditText.getText().toString();
        //Analiza la URI y crea el Intent
        Uri phoneUri = Uri.parse(phoneNumber);
        Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);
        //Inicia la activity con el Intent
        startActivity(intent);

    }

    /*
    Cuando el usuario apreta el boton, este comparte el texto con otras aplicaciones
     */
    public void shareText(View view) {
        //Obtiene el texto a compartir
        String txt = mShareEditText.getText().toString();
        //Selecciona el tipo de texto
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Compartir este texto con: ")
                .setText(txt)
                .startChooser();

    }

    /*
    Cuando el usuario apreta el boton, se envia el texto a otra aplicacion, en este caso Activity3
     */
    public void sendText(View view) {
        //Inicia el Intent
        Intent intent = new Intent(this, Activity3.class);
        //Se obtiene el texto a enviar como un string
        String txt = mSendEditText.getText().toString();
        /*se agrega la cadena al Intent como extra con la constante EXTRA_MESSAGE como clave y
         la clave como valor*/
        intent.putExtra(EXTRA_MESSAGE, txt);
        //Inicia la activity con el Intent
        startActivity(intent);

    }
}