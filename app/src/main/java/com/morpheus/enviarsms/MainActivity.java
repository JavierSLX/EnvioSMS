package com.morpheus.enviarsms;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private static final int REQUEST_CODE = 1;
    private static final String PERMISOS[] = {Manifest.permission.SEND_SMS};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pide los permisos
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, PERMISOS, REQUEST_CODE);

        final EditText edtMensaje = (EditText)findViewById(R.id.edtMensaje);
        Button btEnviar = (Button)findViewById(R.id.btEnviar);

        btEnviar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String mensaje = edtMensaje.getText().toString();
                String numero = "4612578406";
                if(mensaje.length() > 0)
                {
                    //Manda el mensaje
                    SmsManager manager = SmsManager.getDefault();
                    manager.sendTextMessage(numero, null, mensaje, null, null);

                    Toast.makeText(MainActivity.this, "Mensaje enviado!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
