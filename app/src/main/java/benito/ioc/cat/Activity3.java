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

        //Obtiene el Intent que inicio esta activity
        Intent intent = getIntent();
        //Obtiene el string contenido en el mensaje del Intent extras usando la variable
        // statica como la llave
        String txt = intent.getStringExtra(Activity2.EXTRA_MESSAGE);
        //Obtiene la referencia del TextView para el mensaje del diseño
        TextView textView = findViewById(R.id.TextView_recibido);
        //Establece el texto TextView en la cadena del Intent extra
        textView.setText(txt);
    }
}