package cdfy.tricminder01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class System extends AppCompatActivity {
    ProgressBar credit;
    Button button_riwayat;
    Button button_topup;
    TextView id_pelanggan;
    ImageButton button_setting;
    DBDataSource dbDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        id_pelanggan = (TextView) findViewById(R.id.id_pelanggan);

        dbDataSource = new DBDataSource(this);
        dbDataSource.open();

        User user = null;

        String id = "123456789012";
        String no = "09876543212";
        String nama = "Christo";
        String tarif = "R1";
        String daya = "1000";
        user = dbDataSource.createUser(id, no, nama, tarif, daya);
        credit = (ProgressBar) findViewById(R.id.progressBar1);










        new Thread(new Runnable() {

            @Override
            public void run() {
                credit.setProgress(20);
            }
        }).start();

        button_riwayat = (Button) findViewById(R.id.button_history);
        button_riwayat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Riwayat.class);
                startActivity(i);
            }
        });
        button_topup = (Button) findViewById(R.id.topup);
        button_topup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), TopUp.class);
                startActivity(i);
            }
        });
        button_setting = (ImageButton) findViewById(R.id.setting);
        button_setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i = new Intent(getApplicationContext(), Setting.class);
                startActivity(i);
            }
        });
    }
}







