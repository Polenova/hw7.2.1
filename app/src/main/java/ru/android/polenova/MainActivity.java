package ru.android.polenova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button button = findViewById(R.id.button);
        textEdit = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToPlace();
            }
        });
    }

    private void sendToPlace() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String strInfo = textEdit.getText().toString();
        if ("".equals(strInfo)) {
            Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_SHORT).show();
        } else {
            boolean charBoolean = false;
            char[] chars = strInfo.toCharArray();
            for (char element: chars) {
                charBoolean = Character.isLetter(element);
            }
            if (charBoolean == true) {
                intent.setData(Uri.parse(getString(R.string.place) + strInfo));
            } else {
                intent.setData(Uri.parse(getString(R.string.coordinate) + strInfo));
            }
            startActivity(intent);
        }
    }
}
