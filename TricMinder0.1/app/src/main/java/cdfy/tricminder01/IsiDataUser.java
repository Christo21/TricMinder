package cdfy.tricminder01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class IsiDataUser extends AppCompatActivity {
    private Spinner Unit;
    EditText input;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isidata);
        Unit = (Spinner) findViewById(R.id.unit);
        button = (Button)findViewById(R.id.button_lanjut);
        input = (EditText)findViewById(R.id.penggunaan);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (input.getText().toString().equals("")) {
                    Toast.makeText(IsiDataUser.this, "Input Text Kosong..Tolong masukan besar kWh atau Rupiah", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(getApplicationContext(), System.class);
                    startActivity(i);
                }
            }
        });
    }
}













