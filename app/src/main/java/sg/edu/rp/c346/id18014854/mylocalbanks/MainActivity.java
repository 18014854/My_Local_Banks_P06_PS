package sg.edu.rp.c346.id18014854.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String clicked;
    String titleWeb;
    String titleContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        titleWeb = getString(R.string.titleWeb);
        titleContact = getString(R.string.titleContact);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, titleWeb);
        menu.add(0, 1, 1, titleContact);

        if (v.getId() == tvDBS.getId()) {
            clicked = "DBS";
        } else if (v.getId() == tvOCBC.getId()) {
            clicked = "OCBC";
        } else if (v.getId() == tvUOB.getId()) {
            clicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
            //code for action
            if (clicked.equals("DBS")) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWeb)));
                startActivity(intentWeb);
            } else if (clicked.equals("OCBC")) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWeb)));
                startActivity(intentWeb);
            } else if (clicked.equals("UOB")) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWeb)));
                startActivity(intentWeb);

                return true; //menu item successfully handled
            }
        } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
            //code for action
            if (clicked.equals("DBS")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.dbsCall)));
                startActivity(intentCall);
            } else if (clicked.equals("OCBC")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbcCall)));
                startActivity(intentCall);
            } else if (clicked.equals("UOB")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uobCall)));
                startActivity(intentCall);


                return true;  //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            titleWeb = getString(R.string.titleWeb);
            titleContact = getString(R.string.titleContact);
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText(getString(R.string.dbsChinese));
            tvOCBC.setText(getString(R.string.ocbcChinese));
            tvUOB.setText(getString(R.string.uobChinese));
            titleWeb = getString(R.string.titleWebChinese);
            titleContact = getString(R.string.titleContactChinese);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
