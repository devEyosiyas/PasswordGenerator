package dev.eyosiyas.passwordgenerator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dev.eyosiyas.passwordgenerator.model.ClipBoardHelper;
import dev.eyosiyas.passwordgenerator.model.PasswordGenerator;

public class MainActivity extends AppCompatActivity {
    private Button btnCopy;
    private TextView txtPassword;
    private ClipBoardHelper helper;
    private PasswordGenerator generator;
    private NumberPicker passwordLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGenerate = findViewById(R.id.btnGenerate);
        btnCopy = findViewById(R.id.btnCopy);
        txtPassword = findViewById(R.id.txtPassword);
        passwordLength = findViewById(R.id.numberPicker);

        helper = new ClipBoardHelper(this);
        generator = new PasswordGenerator();

        initNumberPicker();

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtPassword.setText(generator.generate(passwordLength.getValue()));
                if (txtPassword.getText().toString().isEmpty())
                    btnCopy.setEnabled(false);
                else
                    btnCopy.setEnabled(true);
            }
        });

        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.setClipboard(txtPassword.getText().toString());
            }
        });
    }

    private void initNumberPicker() {
        passwordLength.setMinValue(8);
        passwordLength.setMaxValue(32);
    }
}