package cdfy.tricminder01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText Number;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Number = (EditText)findViewById(R.id.Number);
        button  = (Button) findViewById(R.id.button_login);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (Number.getText().toString().equals("")) {
                    Toast.makeText(Login.this, "Input Text Kosong..Harap masukkan ID Pelanggan atau No.Meter dengan benar", Toast.LENGTH_SHORT).show();
                } else {
                    if (Number.length() < 11 || Number.length() > 12) {
                        Toast.makeText(Login.this, "Wrong Input", Toast.LENGTH_SHORT).show();
                    } else {
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), IsiDataUser.class);
                            startActivity(i);
                        //}
                    }
                }
            }
        });
    }


}












