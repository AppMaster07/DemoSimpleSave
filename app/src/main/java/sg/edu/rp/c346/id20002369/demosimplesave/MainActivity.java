package sg.edu.rp.c346.id20002369.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        // S1: Obtain the SharedPreference instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // S2: Retrieve the saved data from the SharedPreferences
        // with a default value if no matching data
        String msg = prefs.getString("greetings","No greetings name");
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Step 1: Obtain the SharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        // S2: Create a SharedPreferences Editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        // S3: Set a key-value pair in the editor
        prefEdit.putString("greetings", "Hello!");
        // S4: Call commit() to save the changes made to the SharedPreference
        prefEdit.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}