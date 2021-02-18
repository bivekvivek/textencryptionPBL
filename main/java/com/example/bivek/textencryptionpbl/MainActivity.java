package com.example.bivek.textencryptionpbl;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button CopyText , button4;
    TextView endec;
    EditText entertxt;
    RadioButton radioOne;
    RadioButton radioTwo;
    EditText resultxt;
    TextInputEditText passwtext;
    int sdkVer = Build.VERSION.SDK_INT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
        this.entertxt = (EditText) findViewById(R.id.enteredText);
        this.passwtext = (TextInputEditText) findViewById(R.id.passText);
        this.resultxt = (EditText) findViewById(R.id.encrdecrText);
        this.radioOne = (RadioButton) findViewById(R.id.radioEncrypt);
        this.radioTwo = (RadioButton) findViewById(R.id.radioDecrypt);
        this.CopyText = (Button) findViewById(R.id.CopyButton);
        this.endec = (TextView) findViewById(R.id.EncDec);
        this.button4 = (Button) findViewById(R.id.button4);
    }
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are You Sure?");
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


    public void onStart(View v) {
        if (this.radioOne.isChecked()) {
            if (this.entertxt.getText().toString().length() == 0) {
                this.entertxt.setError("Please Enter Text");
            } else if (this.passwtext.getText().toString().length() == 0) {
                this.passwtext.setError("Please Enter Password");
            } else if (this.passwtext.getText().toString().length() < 6) {
                this.passwtext.setError("Password must be 6 symbols");
            } else if (this.radioOne.isChecked()) {
                this.resultxt.setText("");
                EncryptText();
            }
        }
        if (!this.radioTwo.isChecked()) {
            return;
        }
        if (this.entertxt.getText().toString().length() == 0) {
            this.entertxt.setError("Please Enter Text");
        } else if (this.passwtext.getText().toString().length() == 0) {
            this.passwtext.setError("Please Enter Password");
        } else if (this.passwtext.getText().toString().length() < 6) {
            this.passwtext.setError("Password must be 6 symbols");
        } else if (this.radioTwo.isChecked()) {
            this.resultxt.setText("");
            CheckPassword();
        }
    }

    private void EncryptText() {
        int answer = 0;
        String[][] bivcode;
        bivcode = new String[70][];
        bivcode[0] = new String[]{"x", "X", "l", "L", "G", "v", "W", "3", "m", ".", "v", "6", "c", "8", "9", "X", "B", "G", "2", "y", "p", "e", "Y", "J", "O", ",", "1", "Z", "R", ",", "a", "v", "C", "g", "M", ",", "Y", "2", ",", "5", " ", "x", "6", "y", "z", "W", "3", "?", "t", "O", "b", "g", "M", "K", "5", " ", "A", "x", "m", "a", "E", "S", "T", "3", "V", " ", "d", "b", "j", "a"};
        bivcode[1] = new String[]{"F", "5", "A", "g", "N", "D", "R", "I", "i", "L", "5", "1", "b", "J", "w", "u", "G", "j", "y", "O", "j", "e", "7", "F", "N", "x", "r", "8", "P", "R", "k", "H", "T", "d", "m", "W", "z", "3", "9", "n", "5", "z", "s", "w", "5", "t", "0", "e", "u", "f", "D", "x", "M", "B", "D", "b", "v", "x", "Q", "w", "x", "b", "U", "l", "7", " ", "E", "E", "7", "8"};
        bivcode[2] = new String[]{"M", "K", "e", "0", "7", "e", ",", "p", "Z", "y", "X", "6", "s", "z", "S", "V", "e", "6", "j", "z", "?", "e", "u", "d", "b", "H", "i", "c", "3", "q", "X", "u", "K", "D", ",", "e", "t", "P", "s", " ", "c", "U", "3", "o", "r", "B", "7", "g", ",", "y", " ", "V", "g", "I", "f", "S", "P", "t", "1", "E", "b", "x", "i", "f", "K", "7", "p", "q", "O", "x"};
        bivcode[3] = new String[]{"o", "C", "P", "8", "!", "5", "f", "G", "i", "a", "X", "i", "a", "W", " ", "v", "m", "5", "Y", "S", "d", "u", "l", "T", "B", "3", " ", "w", "l", "!", "?", "1", "4", "W", ",", "v", "Q", "o", "H", "c", "k", "p", "E", "S", "b", "I", ",", "c", "6", "s", ".", "0", "X", "3", "l", "h", "R", "c", "p", "b", "3", "G", "a", "K", "g", "I", "P", "n", "g", "9"};
        bivcode[4] = new String[]{"p", "U", "7", "k", "P", "7", "u", "m", ".", " ", "3", "w", "l", "K", "v", "S", "U", ".", "w", "A", "d", "2", "8", "R", "y", "7", "h", "I", "f", "n", "J", "?", "1", "Z", "i", "O", "K", "n", "O", "G", "F", "N", "M", "T", "X", "C", "p", "9", "P", "m", ",", "Z", "I", "4", "u", "n", "z", "W", "I", "u", "D", "c", ",", "L", "T", "w", "t", "n", "?", "L"};
        bivcode[5] = new String[]{"Y", "B", "G", "F", "G", "Y", "k", "S", "d", "G", "G", "U", ".", "P", "Q", "s", " ", "2", "W", "V", "2", "I", ",", "2", "I", "?", "j", "W", "B", "I", "Q", "r", "E", "S", "y", "T", " ", "e", "H", "F", "M", "e", "D", "4", "B", "S", "I", "7", " ", "m", "3", "4", "X", "J", "w", "N", "z", ",", "V", "D", "M", "z", "a", "t", "B", "!", "V", "R", "n", "j"};
        bivcode[6] = new String[]{"X", "d", "6", "B", "1", "v", "G", "o", " ", "9", "T", "H", "z", "b", "5", "x", "G", "m", "l", "T", "B", "w", "u", "w", "R", "v", "Q", "O", "5", "E", "s", "G", "f", "X", "Q", "R", "5", "e", "Z", "N", "n", "l", "u", "S", "3", ",", "1", "5", " ", "h", "p", "M", "z", ".", "s", "U", "1", "5", "c", "1", "y", "F", "I", "q", "h", "O", " ", "F", "f", "6"};
        bivcode[7] = new String[]{"r", " ", "8", "R", "G", "1", "x", "P", "p", "e", " ", "?", "r", "0", "d", "c", ".", "K", "L", " ", "Y", ",", "j", "9", "w", "B", "N", "P", "j", "U", "9", "3", "l", "u", "X", "?", "T", "T", "m", "j", "G", "E", "J", "d", "R", "9", "Z", "k", "B", "y", ".", "9", "V", ".", "9", "Q", "S", "2", "X", " ", "6", "1", "?", "O", "G", "h", "W", "5", "g", "Q"};
        bivcode[8] = new String[]{"0", ",", "o", "K", "z", "r", "!", "7", "O", "c", "K", "?", "d", "K", "a", "Z", ",", "m", "x", "P", "N", "f", "f", "y", "Z", "z", "N", "S", "9", "8", "H", "2", "d", "S", "w", "a", "?", "F", "d", "8", "H", "i", "a", "w", "t", "A", "U", "E", ".", "Q", "Z", "X", "V", "5", "j", "I", "e", "M", "G", "M", "5", "l", "S", "0", "Z", "p", "d", "b", "4", "5"};
        bivcode[9] = new String[]{"6", "5", "p", "3", ",", "0", "v", "o", "6", "8", "n", "h", "i", "p", "p", "3", "d", "j", "G", " ", "6", "5", "B", "T", "Z", "Y", "s", "Q", "p", "O", "P", "8", "G", "A", "Z", "0", "a", "9", "7", "B", "J", "J", "O", "V", "y", "Z", "4", "8", "H", "t", "C", "Q", "R", "J", "1", "8", "!", "C", "5", "h", "y", "R", "T", "x", "3", "y", "3", "E", "d", "b"};
        bivcode[10] = new String[]{"J", "M", "m", "M", "8", "b", ".", "i", "P", "8", "7", "Y", "1", "s", "0", "z", "n", "u", "K", "X", "J", "6", "?", "n", "y", "V", "b", "S", "l", "M", "x", "l", "m", "4", "T", "4", "S", "?", "m", "w", "1", "a", "E", "B", "C", "m", "q", "E", "h", "?", "J", ".", "k", "E", "6", "c", "X", "X", "l", "s", "v", "R", "?", "G", "N", "m", "E", "X", "r", "7"};
        bivcode[11] = new String[]{"h", "U", "!", "!", "H", "b", "u", "T", "q", "o", "g", "0", "b", "v", "A", "Z", "B", "g", "f", "P", "r", "M", "S", "s", "c", "4", "n", "X", "Q", "B", "u", "2", "J", "R", "Y", "t", "c", "8", "N", "l", "u", "C", "j", "N", "D", "n", "S", "9", "Q", "x", "T", "S", "d", "L", "9", "h", "v", "A", "M", "K", "i", "F", "?", "q", "g", "D", "X", "d", "d", "f"};
        bivcode[12] = new String[]{"4", "n", "h", "O", "e", "U", "6", "a", "8", "b", "R", "k", "h", "q", "6", "q", "J", "Q", "x", "n", "J", "v", "d", "!", "q", "J", "N", "y", "p", "u", "C", "H", "F", "K", "l", "d", "v", "z", "X", "?", "6", "9", "?", "G", " ", "2", "t", "r", "d", " ", ",", "k", "D", "i", "D", "n", ",", "8", "!", "w", "k", "a", "U", "q", "W", "p", ",", "q", "6", "l"};
        bivcode[13] = new String[]{"6", "s", "V", "J", "K", "4", ".", "U", "t", "K", "I", "x", "z", "r", " ", "o", "6", "D", "o", "1", "q", ",", "9", "q", "f", "G", "j", "W", "8", ",", "j", "E", "n", "1", "v", "n", "G", "J", "r", "Q", "n", "5", "F", "d", "1", "n", "0", "P", "4", "h", ".", "x", "2", "C", "D", ",", "F", "V", "l", "t", "B", "P", ",", "h", "A", "9", "l", "B", "d", "U"};
        bivcode[14] = new String[]{"a", "!", "C", "1", "0", "c", "N", "p", ",", " ", "O", "i", "J", "8", ".", "p", "A", "N", "?", "h", "w", "C", "o", "J", "E", "1", "j", "7", "X", "Z", "o", "v", "Y", "R", "0", "G", "z", "r", "d", "H", "O", "7", "n", "a", "P", "F", "K", "M", "g", "7", "q", "n", "u", "G", "I", "p", "H", "X", "b", "z", "v", "x", "!", "c", "8", "y", "c", "m", "U", "v"};
        bivcode[15] = new String[]{"l", "o", "R", "9", "s", "f", "f", "9", "T", "t", " ", "T", "M", "y", "z", "R", "t", "F", "b", "G", "a", "t", "b", "u", "U", "!", "i", "M", "E", "l", "z", "3", "m", " ", "F", "k", "M", "R", "q", "D", "M", "2", "K", "b", "2", "Z", "q", "x", "3", "z", "l", "5", ",", "2", "i", "S", "g", "4", "p", "K", "m", "e", "v", "6", "B", "c", "w", "F", "r", "Q"};
        bivcode[16] = new String[]{"4", "7", "I", "K", "!", "z", "B", "Q", "A", "c", "q", "0", "s", "z", "L", "k", "s", " ", "D", "H", " ", "?", "m", "r", "v", "9", "T", "I", "A", "X", "m", "d", "x", "i", "H", "t", "r", "H", "5", "?", "a", "r", "e", "q", "s", "U", "Y", "!", "t", "A", "Y", "Q", "B", "6", "3", "D", "e", "T", " ", "!", "C", "j", "Y", "u", "N", "L", "9", "U", "W", "B"};
        bivcode[17] = new String[]{"A", "B", "k", "9", ".", "B", "6", "V", "L", "V", "f", "9", "T", "g", "P", "3", "a", "f", "O", "8", "I", "L", "K", "8", "!", "f", "K", "j", "r", "z", "l", "W", "D", "b", "!", "S", "n", "D", "i", "g", "9", "u", "1", "h", "a", "s", "S", "b", "1", "Y", "U", "9", "u", ",", "B", "V", "T", "h", "n", "z", "h", "C", " ", "6", "G", "E", "p", ",", "j", ","};
        bivcode[18] = new String[]{"Z", "Q", "T", "u", "X", "?", "p", "R", "D", "2", "5", "I", "n", "w", "1", "1", "0", "f", ".", "c", "H", "S", "l", "F", "4", "?", "Y", "a", "a", "D", "d", " ", "1", "6", "z", "N", "8", "B", "1", "a", "O", "m", "L", "Z", "l", "p", "4", "N", "0", "A", "P", "7", "K", "F", "I", "6", "h", "5", "9", "h", "Q", "b", "X", "Q", "I", "p", "7", "O", ".", "J"};
        bivcode[19] = new String[]{"N", "b", "7", "F", " ", "p", "V", "8", " ", "H", "5", "r", "E", "w", "e", "!", "P", "S", "m", "X", "r", "7", "B", "I", "b", "F", "E", "L", "g", "8", "W", "L", "v", "E", "?", "?", "u", "4", "i", "c", "2", "Y", "Z", "v", "Z", "6", "9", "x", "Q", ",", ".", "n", "s", "1", "P", "7", " ", "T", "A", "h", "j", ".", "a", "N", "H", "r", "q", "O", "Z", "3"};
        bivcode[20] = new String[]{"f", "1", "r", "A", "m", "P", "J", "d", "0", ",", "K", "G", ".", "r", "4", "S", "c", "c", "W", "x", "b", "S", "O", "0", "4", "0", "6", "g", "I", "f", "R", "6", "T", "K", "4", "w", "5", "j", "k", "K", "P", "y", "q", ".", "H", "1", "e", "?", "s", "r", ".", "O", "1", "G", "n", "h", ".", "6", "j", "n", "6", "T", "2", "T", "6", "A", "!", "?", "Q", "V"};
        bivcode[21] = new String[]{"n", "p", "b", "C", "d", "q", "m", "H", "O", "F", "Y", "7", "g", "R", "6", "U", "T", "n", "9", "Q", "A", "F", "!", "g", "g", "o", " ", "L", "?", "6", "s", "3", "G", "I", "j", "W", "T", ",", "g", "E", "h", "u", "V", "I", "t", "7", "S", "e", "x", "n", "i", ",", "r", "M", "k", "8", "6", "v", "V", "0", "S", "Q", "?", "J", "Z", "n", "p", "A", "d", "o"};
        bivcode[22] = new String[]{"l", "V", "d", "!", "A", "N", "G", "I", "0", "J", "D", "b", "7", "l", "M", "x", " ", "e", "2", "Y", " ", "a", "s", "e", "w", "b", "X", "z", "o", "K", "m", "0", "m", "X", "A", "M", "z", "J", ",", "S", "V", "V", "e", "8", "B", "J", "n", "g", "9", "k", "Y", "!", "1", "B", "e", "V", "u", "R", "L", "o", "k", "M", "y", "G", "J", "g", "Y", "B", "d", "b"};
        bivcode[23] = new String[]{"y", "n", "k", "I", ",", "z", "U", "H", "P", "!", "S", "n", "z", "I", "v", "K", "h", "p", "u", "c", "E", "j", "D", "p", "l", "l", "8", "B", "m", "h", "y", "q", "b", "Q", "R", "2", "Y", "x", "H", "e", "Q", "f", "u", "h", "y", "b", "A", ",", "K", "?", "a", "Y", "U", "l", "A", "R", "4", "I", "U", "T", "X", "s", "A", "j", "h", "K", "d", "t", "G", "t"};
        bivcode[24] = new String[]{"M", "?", "B", "x", "c", "N", "Z", "X", "F", "S", "0", "H", "G", "R", "O", "G", "C", "O", "a", "r", "H", "u", "Q", "E", "X", "Q", "F", "a", "3", "C", "e", "n", "l", "Y", "8", " ", "I", "F", "y", "q", ",", "9", "!", "c", "L", "J", "7", "M", "V", "2", "?", "L", "d", "9", "I", "K", "6", "7", "P", "Z", "9", "n", "b", "U", "b", "b", "G", "Z", "Z", "o"};
        bivcode[25] = new String[]{"1", "Z", "c", "c", "x", "J", "7", "o", "w", "a", "H", "n", "!", "L", "Z", "c", "C", "0", "I", "3", "G", "A", "o", "D", "q", "p", "h", "5", "4", "N", "t", "1", "k", "A", "n", "6", "A", "S", "M", "B", "P", "u", "X", "J", "v", "L", "V", " ", "H", "v", "3", "z", "z", ".", "O", "4", "9", "0", ",", "4", "B", "t", "i", " ", "T", "o", "n", "0", "v", "0"};
        bivcode[26] = new String[]{"C", "v", "j", "A", "w", "8", ".", ".", "3", "c", "J", "d", "o", "I", "r", "F", "Q", "!", "q", "V", "X", "q", "8", "V", "W", "d", "O", "e", "D", "r", "q", "0", "g", "c", "1", "O", "5", ",", "9", " ", "N", "K", "6", "9", "l", "x", "V", " ", "m", "T", "L", "i", "s", "y", "K", "m", "d", "i", "x", "h", "x", "g", "s", "n", "M", "T", "p", "s", "z", "j"};
        bivcode[27] = new String[]{"j", "W", "L", "z", "N", "I", "J", "C", "9", ".", "l", "Y", "1", "C", ".", "x", "V", "T", "L", "!", "6", "c", "c", "h", "E", "e", "?", "T", "R", " ", "u", "p", "7", "N", "2", "9", "2", "1", "v", "9", "e", "u", "O", "2", "P", ".", "z", "v", "K", "L", "!", "y", "C", "n", "a", "A", ".", "g", "C", ",", "U", "6", "6", "6", "3", "V", "e", "d", "b", "f"};
        bivcode[28] = new String[]{"M", "6", "z", "7", "z", "H", "P", "?", "T", "Q", "D", "U", "j", "R", "f", "6", "q", "D", "c", "i", "A", "S", "P", "J", "L", "G", "T", "t", "k", "Y", "Z", "H", "n", "a", "v", "4", "U", "Y", "x", "v", "P", "?", ".", "C", "l", "V", "Q", "V", "d", "m", "!", "d", "h", "8", "w", "N", "w", "N", "7", "h", "l", "d", "V", "2", "4", "b", "3", "B", "0", "."};
        bivcode[29] = new String[]{"K", "q", "k", "1", "6", "d", "v", "H", "h", "1", "p", "A", "6", "c", "z", "T", "3", "j", "T", "T", "b", "y", ".", "s", "f", "u", ",", "B", "S", "w", "T", "q", "T", "U", "M", ".", "o", "E", "y", "!", "s", "N", "r", "3", "b", "8", ".", "U", "1", "R", "f", "k", "6", "8", " ", "8", "2", "a", "2", "Z", "n", "4", "1", "e", "a", "U", "J", "d", "b", "0"};
        bivcode[30] = new String[]{"Z", "H", "F", "6", "f", ".", "a", "J", "t", "X", "j", "D", "B", "c", "u", "h", "N", "6", "G", "h", "4", "h", "O", "x", "f", "v", "y", "W", ".", "h", ",", "w", "V", "h", "t", "7", "g", "G", "R", "j", "6", "T", "!", "u", "Y", "X", "9", "X", "O", "I", "T", "Q", "u", "M", "d", "k", "K", "J", "a", "J", "I", "i", "g", ",", "y", "A", "J", "f", "I", "Z"};
        bivcode[31] = new String[]{"N", "3", "m", "B", "K", "5", "B", "G", "U", "Q", "S", "Z", "6", "9", "A", "B", "u", "2", "8", "y", "C", "p", "x", "C", "8", "e", "B", "W", "m", "p", "i", "m", "s", "f", "z", "i", "m", "!", "0", "8", "z", "C", "k", "r", "d", "M", "S", "b", "q", "a", "?", "n", "u", "X", "O", "k", "W", "X", "3", "p", "v", ",", "t", "u", "0", "E", "f", "a", "7", "j"};
        bivcode[32] = new String[]{"K", "0", "V", "T", ".", "A", "6", "W", "f", "N", "y", "M", "8", "7", "s", "m", "x", "1", ".", "d", "n", "N", "6", ",", "!", "C", "Y", "7", "C", "g", "u", "J", "5", "0", "m", "z", "a", "B", "j", "P", "O", "X", "r", "n", "6", "?", "2", "r", "k", "6", "y", "3", "7", "A", "Q", "K", "v", "B", ",", "b", "0", "g", "S", "Y", "P", "!", "q", "V", "Q", "U"};
        bivcode[33] = new String[]{"X", "M", "B", "C", "J", "X", "!", "w", "x", "T", "f", "H", "I", "n", "x", "w", "c", "y", "N", "o", "3", "Y", "k", "O", "e", "E", "r", "E", "A", "2", "D", "8", "d", "A", "d", "r", "q", "?", "Y", "I", "M", "o", "U", "V", "D", "U", "M", "K", "y", "N", "3", "X", "F", "4", "5", "U", "0", "6", "T", "?", "V", "V", "B", "n", "W", "O", "r", "d", "b", "x"};
        bivcode[34] = new String[]{"r", "P", "Z", "S", "6", "6", "S", "y", "a", "A", "5", "D", "U", "Q", "e", "e", "0", "g", "D", "H", "2", "8", "Z", "F", "1", "T", "t", "c", "P", "y", "R", "R", "b", ".", "!", "Z", "y", "D", "c", "a", "V", "t", "4", "H", "c", "8", "V", "z", "s", "L", "D", "d", "5", "s", "?", "o", "0", "Q", "S", "z", "x", "1", "v", "i", "0", "F", "m", "7", "K", "a"};
        bivcode[35] = new String[]{"o", "9", "X", "V", "6", "X", "K", "Z", "3", "z", "S", "y", "I", "V", "I", "!", "t", "Y", "2", "l", "C", "N", "x", "m", "x", "y", "N", "t", "8", "X", "U", "r", "z", "V", "k", "5", "O", "m", "y", "5", "0", "O", "6", "4", "d", "Y", "r", "3", "o", "T", "m", "1", "D", "c", "p", "R", "C", "n", "?", "s", "y", "Q", "x", "u", "q", "G", "Q", "d", "b", "c"};
        bivcode[36] = new String[]{"D", "z", "Y", "I", "Z", "d", "M", "T", "5", "9", "!", "C", "3", "S", ",", "c", "t", "G", "P", "z", "m", "x", "L", "C", "h", "F", " ", "P", " ", "T", "B", "6", "M", "0", "k", "X", "k", "e", "0", "W", "R", "Z", "6", "9", " ", "4", "s", "Y", " ", "?", "v", "y", "T", "Y", "k", "0", "0", "a", "1", "d", "o", "G", "?", "e", "V", "1", "r", "4", "d", "o"};
        bivcode[37] = new String[]{"C", "G", "?", "M", "B", "5", "5", "c", "8", "T", "7", "U", "a", "!", "M", "6", "t", "K", "E", "U", "V", "9", "2", "c", "H", "C", "P", "k", "4", "Y", "z", "Y", ",", "h", "l", "t", "7", "N", "2", "P", "C", "S", "d", "0", "y", "I", "9", "!", "z", "9", ",", "u", "L", "5", "Y", "c", "Z", "!", "r", "9", "K", "O", "v", "j", "F", "f", "3", "q", "d", "w"};
        bivcode[38] = new String[]{"N", "?", "i", "!", "v", "n", "b", "G", "W", "7", "m", "I", "P", "i", "9", "b", "k", "f", "i", "A", "9", "8", "U", "v", "i", "D", "H", "1", "f", "v", "5", "9", "H", "s", "u", "W", "g", "q", "8", "i", "e", "G", "G", "k", "8", "F", "L", "D", "L", "S", "K", "r", "D", "n", "b", "e", "y", "y", "U", "T", "f", "9", "T", "D", "k", "m", "9", "6", "r", "d"};
        bivcode[39] = new String[]{"j", "I", "k", "H", "?", "c", "1", "f", "A", "a", "G", "P", "!", "Q", "?", "B", "Y", "t", " ", "Q", "j", "E", "l", "5", ".", "3", "c", "1", "j", "B", "N", "X", "z", "J", "s", "v", "M", "!", "k", "Z", "i", "g", "a", "o", "r", "h", "G", "M", "G", "v", "F", "6", "7", "e", "b", "n", "z", "5", "6", "v", "!", "T", "Z", "4", "b", "U", "S", " ", "Y", "j"};
        bivcode[40] = new String[]{"h", "M", "X", "B", "E", "m", "j", "i", "S", "M", "A", "0", "y", "i", "r", "Z", "P", "k", "L", "R", "g", "7", "1", "a", "!", "M", "q", "9", "K", "v", "b", "n", "7", ",", ",", "H", "w", "8", "!", "3", "h", "k", "W", "2", "B", "r", "E", "p", " ", "y", "?", "k", "b", "4", "!", "g", "c", "I", "I", "3", "q", "b", "U", "Z", "J", "A", "G", "m", "f", "B"};
        bivcode[41] = new String[]{".", "R", "x", "U", "c", ".", "f", "B", "8", "l", "i", "V", "D", "X", "0", "F", "6", "t", "M", "X", "3", "O", "L", "8", ".", "F", "s", "7", "l", "P", "o", "a", "K", "7", "t", "M", "N", "R", "t", "u", "5", "A", "W", "r", "?", "1", "Z", "Z", "6", "B", "Q", "S", "i", "d", "d", "R", "G", "!", "D", "U", "h", "8", "l", "2", "o", "x", "P", "S", "?", "h"};
        bivcode[42] = new String[]{"W", "q", "6", "4", "e", "T", "y", "p", "E", "Z", "t", "N", "Z", "f", "N", "o", "3", ".", "W", "s", "y", "3", "z", "6", "3", "u", "W", "D", "P", "2", "b", "D", "9", "x", "n", "6", "l", "5", "L", "k", "t", "m", "A", "9", "0", "4", "c", "d", "T", "?", "r", "z", "c", "f", ",", "0", "z", "r", "G", "V", "p", "A", "w", "w", "!", "p", "w", "Z", "m", "j"};
        bivcode[43] = new String[]{"p", "s", "S", "U", ".", "G", "c", "R", "U", "w", "n", "Y", "W", "o", "G", "d", "Q", "c", "i", "z", "d", "t", "u", "J", "r", "T", "K", "8", "h", "W", "J", "9", "y", "S", "Q", "8", "d", "L", "j", "A", "S", "x", "Y", "W", "q", "v", "1", "G", "H", "y", "B", "u", "5", "0", "F", "?", "Z", "P", "e", "4", "0", "S", "4", "c", "t", "4", "M", "1", "1", "F"};
        bivcode[44] = new String[]{"4", "c", "g", "y", "R", "4", "b", "x", "C", "O", "L", "5", "I", "T", "T", "d", "l", "9", "p", "1", "h", "i", "r", "j", "?", "g", ",", "h", "5", "T", "X", "C", "m", "q", "p", "V", "4", "5", "o", "c", " ", "X", "E", "S", "x", "5", "q", "M", "r", "2", "d", "2", "i", "x", "S", "z", "8", "c", "m", "c", "R", "m", "Q", "L", "u", "5", "U", "b", "f", "B"};
        bivcode[45] = new String[]{"m", "w", "1", "P", "D", "u", "H", "U", "W", "H", "6", "p", "k", "?", "M", "q", "H", "y", "D", "G", "P", "S", "4", "n", "r", "?", "E", "U", "b", "w", "r", "M", "q", "n", "q", "W", "V", "B", "M", "o", "W", "A", "q", "n", "0", "g", "5", "f", ",", "1", "0", "O", "X", "i", "R", "0", "i", "z", "C", "M", "S", "v", "o", "b", "!", "q", "p", "d", "K", "C"};
        bivcode[46] = new String[]{"N", "Q", "?", "8", "p", "g", "M", "U", "z", "Y", "z", "v", "P", "I", "8", "o", "u", "u", "o", "S", "r", "D", "Y", ".", "z", "H", "P", "5", ",", "b", "X", "b", "j", "6", "0", "e", "g", "t", "c", "q", "i", "t", "B", "r", "x", "J", "L", "I", "Y", "1", "w", "8", " ", "s", "D", "Q", "a", "K", "e", "p", "!", "n", "x", "p", "y", "h", "L", "H", "L", "3"};
        bivcode[47] = new String[]{"m", "0", "P", "w", "C", "Z", "q", "e", "1", "I", "Y", "T", "a", "e", "B", "T", "y", "u", "Y", "t", "l", "4", ".", "x", ".", "H", "1", "n", "D", ".", "H", "h", "!", "6", ",", "o", "g", "u", "m", "i", "z", "z", "W", "C", "i", "r", "M", "9", "?", "S", "?", "H", "j", "X", "4", "4", "s", "s", "L", "L", "y", "Z", "J", "B", "p", "s", "z", "d", "b", "x"};
        bivcode[48] = new String[]{"e", "f", "V", "A", "G", "U", "U", "U", "7", "1", "?", "E", "v", "S", "s", "?", ".", "p", "7", "L", "m", "n", ",", "l", "T", "y", "I", "9", "F", "d", "S", "3", "x", "0", "J", "W", "4", "2", "z", "g", "a", "4", "u", "Y", "r", "s", "U", "f", "o", "V", "c", "y", "P", "N", "g", "Z", "i", "o", "l", "P", "e", "y", "Y", "l", "r", "I", "I", "A", "N", "w"};
        bivcode[49] = new String[]{",", "n", "b", "o", "s", "B", "L", "H", "q", "2", "n", "S", "F", "4", "Z", "8", "d", "z", "R", "L", "2", "n", "s", "r", "C", "E", ".", "7", "Z", "9", "P", "x", "X", "N", "V", "I", "B", "l", ",", "D", "L", ",", "P", "w", "B", "2", "K", "x", "V", " ", "h", "B", "c", "R", "h", "h", "A", "u", "E", "y", "B", "f", "F", "c", "x", "B", "B", "c", "d", "o"};
        bivcode[50] = new String[]{"a", "I", "O", "5", "N", "s", "v", "X", "P", "d", "5", "T", "J", "o", "g", "M", "O", "X", "H", "P", "N", "L", "h", "1", "?", "7", "6", "O", "y", "s", "G", "F", "Q", "E", "b", "?", "5", "H", "0", "W", "Y", "N", "!", "r", "Z", "J", "X", "n", "G", "g", "d", "5", "W", "z", "i", "U", "D", ",", "N", "x", "L", "P", "T", "E", "e", "7", "1", "k", "p", "d"};
        bivcode[51] = new String[]{"D", "r", "S", "i", "0", "h", "q", "9", "t", "t", "l", "p", "m", "2", "T", "z", "J", "t", "O", "O", "N", "i", "t", "x", "L", "z", "W", "D", "v", "7", "j", "H", "T", "B", "9", "f", "s", "u", "i", "9", "4", "t", "P", "9", "!", "a", "E", "z", "k", "n", "z", "P", "c", "r", "z", "n", "f", "q", "2", "g", "X", "?", "r", "Y", "N", "1", "t", "8", "n", "U"};
        bivcode[52] = new String[]{"D", "7", "W", "C", "y", "V", "y", "?", "i", "k", "Z", "2", "h", "S", "e", "9", "7", "W", "K", "1", "4", "V", "6", "c", "t", "7", "r", "M", "H", "X", "G", "w", "!", "t", "e", "I", "K", "p", "x", "?", "H", "d", "M", "G", "H", "I", "J", "Z", "f", ",", "P", "V", "m", "y", "c", "2", "K", "u", "l", "1", "v", "g", "5", "k", "O", " ", "N", "8", " ", "d"};
        bivcode[53] = new String[]{"X", "P", "z", "g", "j", "g", "o", "e", "?", "p", "6", "Q", "O", "2", "j", "H", "K", "J", "U", "L", "Q", "E", "v", "i", "O", "Y", "E", "u", "K", "C", "d", "V", "5", "6", "7", "j", "N", "x", "d", "G", "D", "P", "E", "R", "2", "2", "b", "6", "D", "H", "E", "O", "5", "q", "K", "i", "z", "0", "s", "F", "K", "O", "w", "s", "!", "T", "9", "K", "p", "C"};
        bivcode[54] = new String[]{"S", "T", "f", "P", "h", "!", "2", "8", "s", "G", "U", "2", "B", "5", "z", "H", "0", "Q", "6", "w", "z", "c", "s", "W", "v", "x", "g", "N", "9", "S", " ", "a", "2", "f", "C", "7", "Z", "!", "m", "H", "a", "q", "d", "l", "m", "U", "X", "6", " ", "o", "f", ",", "U", "s", "l", "H", "t", "M", "k", "W", "0", "S", "w", "?", "Z", "G", "J", "1", "S", "l"};
        bivcode[55] = new String[]{"t", "U", "j", "W", "i", "!", "8", "6", "o", "2", "c", "6", "?", "w", "A", "Q", "A", "z", "o", "u", "9", "W", " ", "H", "f", "P", "t", "P", "i", "2", "F", "g", "n", "T", "k", "c", "t", "6", "m", "A", "O", "K", "m", "i", "V", "j", "s", "a", "1", "3", ",", "9", "z", "P", "J", "t", "h", "B", "v", "B", "0", "J", "Z", "p", "x", "i", "0", "X", "d", "b"};
        bivcode[56] = new String[]{"O", "w", "o", "a", "s", "J", "F", "K", "o", "h", "F", "O", "n", "1", "Y", "k", "u", "V", "S", "R", "K", "g", "8", "6", "C", "?", "O", "F", "p", "W", "B", "R", "E", "G", "o", "w", "6", "L", "Z", "K", "t", "q", "F", "D", "F", "E", "T", "7", "3", "U", "4", "y", "f", "j", "0", "4", "m", "A", "U", "A", "I", "S", "J", "8", " ", "K", "H", "v", "u", "5"};
        bivcode[57] = new String[]{"4", "!", "M", "u", "W", "m", "F", "i", "G", "U", "T", "4", "q", "D", "I", "t", "X", ".", "m", "g", "K", "T", "0", ",", "e", "E", "u", "l", "k", "e", "b", "6", "H", "V", "c", "L", "q", "j", "c", "?", "i", "E", "y", "v", "E", "4", "F", "x", "R", "3", "d", "9", "2", "7", "h", "0", "i", "D", "b", "p", "M", "B", "s", "A", "L", "i", "a", ",", "s", "c"};
        bivcode[58] = new String[]{"l", "p", "8", "Q", "q", "a", "B", "i", "a", "u", "f", "2", "y", "O", "P", "5", "v", "L", "H", "Q", "x", "h", "q", "8", "7", "9", "e", "X", "y", "9", "9", "o", "9", "a", "F", "3", "1", "F", "g", "d", "g", "6", "D", "m", "f", "R", "L", "j", "O", "S", "v", "B", "o", "6", "M", "3", "3", "C", "!", "f", "r", "e", "E", "9", "9", "5", "Q", "F", "f", "8"};
        bivcode[59] = new String[]{"M", "0", "M", "i", "B", "c", "P", "m", "q", "E", "q", "N", "6", "T", "n", "F", "r", "C", "o", "A", "0", "y", "K", "Y", "q", "?", "S", "5", "A", "z", "u", "y", "J", "o", "!", "6", "C", "9", "r", "U", "y", "y", ".", "d", "x", "y", "b", "u", "P", "S", ".", "c", "i", "B", "S", "o", "u", "n", "K", "p", "W", "f", "B", "T", "v", "D", "n", "V", "?", "a"};
        bivcode[60] = new String[]{"K", "J", "U", "U", "x", "u", "8", "6", "k", "9", "0", "?", "D", "0", "7", "T", "5", "m", "Z", "G", " ", "k", "l", "y", "R", "G", "i", "v", "7", "R", "2", "W", "H", "3", "h", "F", "x", "F", "H", "z", "9", "V", "a", "f", "J", "9", "y", "B", "6", "o", "e", "9", "X", "j", ",", "z", "X", "P", "W", "z", "0", "j", "b", "!", "J", "R", "U", "d", "v", "j"};
        bivcode[61] = new String[]{"z", "s", "h", "Q", "N", "P", "6", "3", "P", "V", "h", "a", "6", "m", "S", "S", "Z", "D", "4", "?", "n", "r", "B", "!", "A", "X", "A", "R", "S", "7", "u", "R", "g", "M", "U", ".", "N", "!", "U", "b", "X", "S", "w", "e", "x", "i", "4", "D", "E", "D", "i", ".", "A", "B", "a", "c", "0", "H", "p", "E", " ", "W", "d", "2", "X", "C", "!", "Y", "d", "b"};
        bivcode[62] = new String[]{"t", "?", "5", "p", "X", "v", "J", "8", "d", "J", "Q", "r", "X", "7", "T", "4", "I", "z", "X", "g", "X", ".", "P", "G", "E", "9", "f", "n", "6", "B", "q", "D", "Q", "Q", "K", "b", "M", "M", "f", "G", "J", "a", "5", "s", "O", "N", "W", "b", "s", "l", "p", "q", "e", "J", "o", "4", "P", "N", "J", "k", "w", "s", "Q", "O", "c", "2", "!", "f", "H", "i"};
        bivcode[63] = new String[]{"x", "L", "g", "Q", "h", "M", "B", "O", "5", "u", "Z", "n", " ", "J", "Z", "!", "V", "q", "0", "f", "L", ".", "r", "b", "7", "Y", "E", "M", "C", "a", "4", "X", "3", "E", "L", "y", ".", "H", "l", "v", "s", "d", "i", "3", "Q", "Z", "5", "M", "U", "?", "R", "s", "Z", "3", "k", "T", "6", "6", "W", "B", "E", "R", "1", "Y", "6", "N", "0", "N", "F", "u"};
        bivcode[64] = new String[]{"k", "4", "5", "p", "Q", "D", "I", "4", "S", "d", "J", "L", "p", "i", "Q", "h", "p", "1", "k", "!", "K", "H", " ", "a", "c", "U", " ", "8", "n", "W", "!", "u", "q", "k", "P", "A", "p", "!", "l", "V", "H", " ", "o", "R", ".", "R", "V", "D", "?", "6", "A", "q", "?", "G", "Y", "P", "J", "g", "g", "W", "Y", "J", "W", "W", "3", "T", "y", " ", "h", "w"};
        bivcode[65] = new String[]{"Y", "D", "z", "h", "v", "a", "?", "C", "M", "p", "l", "0", "b", "g", "h", "O", "X", "D", "2", "h", "7", "k", "k", "o", "x", "N", "l", "p", "3", "S", "w", "X", "1", "r", "S", "2", "8", "g", "0", "l", "5", "3", "U", "B", "?", "l", ",", "F", "Q", "j", "k", "x", "G", "5", "F", "I", "w", "w", "r", "m", "V", "B", "U", "C", "1", "!", "8", "3", "f", "L"};
        bivcode[66] = new String[]{"A", "Z", "V", "1", "c", "4", "S", "R", "p", "e", "a", "h", "?", "x", "t", "9", "C", "R", "W", "S", "o", "z", "r", "i", "j", "u", "0", "D", "R", "h", "X", "S", "J", "u", "!", "v", "U", ",", "N", "T", "z", "X", "N", "E", "6", "s", "!", "L", "H", "s", "Z", "F", "X", "?", "O", "t", "D", ",", "k", "z", "Y", "X", "W", "G", "e", "J", "x", " ", "i", "Y"};
        bivcode[67] = new String[]{"i", "Q", "w", "j", "c", "N", "q", "3", "1", "O", "W", "n", "k", "V", "m", "U", "n", "a", "n", "m", "!", "F", ".", "Q", "O", "b", "x", "3", "o", "L", "R", "M", "?", "s", "C", "p", "w", "a", "?", "L", "b", "G", "w", "B", "N", "k", "?", "y", "P", "k", "E", "H", "W", "B", "Z", "v", "4", "i", ",", "3", "s", "2", "E", "P", "m", "6", "L", "T", "Q", " "};
        bivcode[68] = new String[]{"i", "W", "N", "3", "x", "v", "z", "R", "e", "i", "Q", "Y", "W", "S", "r", "J", "!", "2", "j", "8", "8", "C", "s", "I", "F", "n", "K", "y", "C", "D", "G", "W", " ", "9", "!", "M", "t", "b", "T", "h", "O", "R", "3", "N", "C", "f", "k", "a", "E", "j", "D", "m", "m", "X", "o", "s", "?", "T", "9", "X", "5", "b", "m", "C", "!", "W", "V", "e", "A", "b"};
        bivcode[69] = new String[]{"3", "H", "b", "s", "w", "k", "g", "0", "i", "9", "6", "j", "9", "D", "n", "G", "U", "!", "b", "q", "t", "7", "Z", "x", "a", "X", "G", "J", "R", "6", "S", "1", "G", "h", "G", "F", "N", "Q", "5", "Y", "2", "z", "u", "I", "C", "V", ",", "e", "g", "S", "3", "q", "b", "O", "A", "5", "A", "5", "e", "I", "9", " ", "Y", "j", "!", "?", "A", "4", "R", "K"};
        int num = 0;
        String texts = this.entertxt.getText().toString() + this.passwtext.getText().toString();
        String cryptedtext = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,?!";
        for (int ii = 0; ii < texts.length(); ii++) {
            for (int nums = 0; nums < cryptedtext.length(); nums++) {
                if (texts.charAt(ii) == cryptedtext.charAt(nums)) {
                    if (Character.toString(texts.charAt(ii)).equals("a")) {
                        answer = new Random().nextInt(73);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("b")) {
                        answer = new Random().nextInt(84);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("c")) {
                        answer = new Random().nextInt(79);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("d")) {
                        answer = new Random().nextInt(88);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("e")) {
                        answer = new Random().nextInt(65);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("f")) {
                        answer = new Random().nextInt(66);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("g")) {
                        answer = new Random().nextInt(64);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("h")) {
                        answer = new Random().nextInt(74);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("i")) {
                        answer = new Random().nextInt(76);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("j")) {
                        answer = new Random().nextInt(63);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("k")) {
                        answer = new Random().nextInt(65);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("l")) {
                        answer = new Random().nextInt(62);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("m")) {
                        answer = new Random().nextInt(74);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("n")) {
                        answer = new Random().nextInt(83);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("o")) {
                        answer = new Random().nextInt(64);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("p")) {
                        answer = new Random().nextInt(72);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("q")) {
                        answer = new Random().nextInt(70);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("r")) {
                        answer = new Random().nextInt(73);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("s")) {
                        answer = new Random().nextInt(71);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("t")) {
                        answer = new Random().nextInt(64);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("u")) {
                        answer = new Random().nextInt(74);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("v")) {
                        answer = new Random().nextInt(70);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("w")) {
                        answer = new Random().nextInt(58);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("x")) {
                        answer = new Random().nextInt(79);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("y")) {
                        answer = new Random().nextInt(79);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("z")) {
                        answer = new Random().nextInt(88);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("A")) {
                        answer = new Random().nextInt(68);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("B")) {
                        answer = new Random().nextInt(89);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("C")) {
                        answer = new Random().nextInt(62);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("D")) {
                        answer = new Random().nextInt(74);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("E")) {
                        answer = new Random().nextInt(63);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("F")) {
                        answer = new Random().nextInt(64);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("G")) {
                        answer = new Random().nextInt(81);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("H")) {
                        answer = new Random().nextInt(73);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("I")) {
                        answer = new Random().nextInt(66);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("J")) {
                        answer = new Random().nextInt(73);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("K")) {
                        answer = new Random().nextInt(72);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("L")) {
                        answer = new Random().nextInt(62);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("M")) {
                        answer = new Random().nextInt(73);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("N")) {
                        answer = new Random().nextInt(70);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("O")) {
                        answer = new Random().nextInt(65);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("P")) {
                        answer = new Random().nextInt(78);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("Q")) {
                        answer = new Random().nextInt(71);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("R")) {
                        answer = new Random().nextInt(66);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("S")) {
                        answer = new Random().nextInt(86);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("T")) {
                        answer = new Random().nextInt(84);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("U")) {
                        answer = new Random().nextInt(77);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("V")) {
                        answer = new Random().nextInt(72);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("W")) {
                        answer = new Random().nextInt(68);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("X")) {
                        answer = new Random().nextInt(85);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("Y")) {
                        answer = new Random().nextInt(66);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("Z")) {
                        answer = new Random().nextInt(72);
                    }
                    if (Character.toString(texts.charAt(ii)).equals(" ")) {
                        answer = new Random().nextInt(71);
                    }
                    if (Character.toString(texts.charAt(ii)).equals(".")) {
                        answer = new Random().nextInt(63);
                    }
                    if (Character.toString(texts.charAt(ii)).equals(",")) {
                        answer = new Random().nextInt(73);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("!")) {
                        answer = new Random().nextInt(81);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("?")) {
                        answer = new Random().nextInt(87);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("0")) {
                        answer = new Random().nextInt(79);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("1")) {
                        answer = new Random().nextInt(76);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("2")) {
                        answer = new Random().nextInt(64);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("3")) {
                        answer = new Random().nextInt(71);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("4")) {
                        answer = new Random().nextInt(68);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("5")) {
                        answer = new Random().nextInt(77);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("6")) {
                        answer = new Random().nextInt(103);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("7")) {
                        answer = new Random().nextInt(67);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("8")) {
                        answer = new Random().nextInt(74);
                    }
                    if (Character.toString(texts.charAt(ii)).equals("9")) {
                        answer = new Random().nextInt(88);
                    }
                    for (int i = 0; i < 70; i++) {
                        for (int j = 0; j < 70; j++) {
                            if (bivcode[i][j].equals(Character.toString(texts.charAt(ii)))) {
                                if (num == answer) {
                                    EncryptCharI(Integer.toString(i));
                                    EncryptCharJ(Integer.toString(j));
                                }
                                num++;
                            }
                        }
                    }
                }
                num = 0;
            }
        }
    }

    private String EncryptCharI(String chrs) {
        String result = "";
        if (chrs.equals("0")) {
            chrs = "À";
        }
        if (chrs.equals("1")) {
            chrs = "Ó";
        }
        if (chrs.equals("2")) {
            chrs = "1";
        }
        if (chrs.equals("3")) {
            chrs = "ď";
        }
        if (chrs.equals("4")) {
            chrs = "ĉ";
        }
        if (chrs.equals("5")) {
            chrs = "ć";
        }
        if (chrs.equals("6")) {
            chrs = "%";
        }
        if (chrs.equals("7")) {
            chrs = "Ą";
        }
        if (chrs.equals("8")) {
            chrs = "É";
        }
        if (chrs.equals("9")) {
            chrs = "Ð";
        }
        if (chrs.equals("10")) {
            chrs = "Ĝ";
        }
        if (chrs.equals("11")) {
            chrs = "ý";
        }
        if (chrs.equals("12")) {
            chrs = "ß";
        }
        if (chrs.equals("13")) {
            chrs = "ě";
        }
        if (chrs.equals("14")) {
            chrs = "å";
        }
        if (chrs.equals("15")) {
            chrs = "ġ";
        }
        if (chrs.equals("16")) {
            chrs = "Â";
        }
        if (chrs.equals("17")) {
            chrs = "Û";
        }
        if (chrs.equals("18")) {
            chrs = "á";
        }
        if (chrs.equals("19")) {
            chrs = "ā";
        }
        if (chrs.equals("20")) {
            chrs = "Þ";
        }
        if (chrs.equals("21")) {
            chrs = "ç";
        }
        if (chrs.equals("22")) {
            chrs = "Ê";
        }
        if (chrs.equals("23")) {
            chrs = "Ü";
        }
        if (chrs.equals("24")) {
            chrs = "Ø";
        }
        if (chrs.equals("25")) {
            chrs = "Ć";
        }
        if (chrs.equals("26")) {
            chrs = "Ė";
        }
        if (chrs.equals("27")) {
            chrs = "Ý";
        }
        if (chrs.equals("28")) {
            chrs = "æ";
        }
        if (chrs.equals("29")) {
            chrs = "ĥ";
        }
        if (chrs.equals("30")) {
            chrs = "Ġ";
        }
        if (chrs.equals("31")) {
            chrs = "à";
        }
        if (chrs.equals("32")) {
            chrs = "@";
        }
        if (chrs.equals("33")) {
            chrs = "ä";
        }
        if (chrs.equals("34")) {
            chrs = "Ğ";
        }
        if (chrs.equals("35")) {
            chrs = "ì";
        }
        if (chrs.equals("36")) {
            chrs = "č";
        }
        if (chrs.equals("37")) {
            chrs = "Ĕ";
        }
        if (chrs.equals("38")) {
            chrs = "ğ";
        }
        if (chrs.equals("39")) {
            chrs = "Ç";
        }
        if (chrs.equals("40")) {
            chrs = "Ë";
        }
        if (chrs.equals("41")) {
            chrs = "8";
        }
        if (chrs.equals("42")) {
            chrs = "#";
        }
        if (chrs.equals("43")) {
            chrs = "2";
        }
        if (chrs.equals("44")) {
            chrs = "Ċ";
        }
        if (chrs.equals("45")) {
            chrs = "Ã";
        }
        if (chrs.equals("46")) {
            chrs = "Á";
        }
        if (chrs.equals("47")) {
            chrs = "Ď";
        }
        if (chrs.equals("48")) {
            chrs = "Ä";
        }
        if (chrs.equals("49")) {
            chrs = "×";
        }
        if (chrs.equals("50")) {
            chrs = "Č";
        }
        if (chrs.equals("51")) {
            chrs = "Ĉ";
        }
        if (chrs.equals("52")) {
            chrs = "5";
        }
        if (chrs.equals("53")) {
            chrs = "Ò";
        }
        if (chrs.equals("54")) {
            chrs = "Æ";
        }
        if (chrs.equals("55")) {
            chrs = "!";
        }
        if (chrs.equals("56")) {
            chrs = "Ñ";
        }
        if (chrs.equals("57")) {
            chrs = "ą";
        }
        if (chrs.equals("58")) {
            chrs = "Ă";
        }
        if (chrs.equals("59")) {
            chrs = "þ";
        }
        if (chrs.equals("60")) {
            chrs = "Ö";
        }
        if (chrs.equals("61")) {
            chrs = "Ē";
        }
        if (chrs.equals("62")) {
            chrs = "Ā";
        }
        if (chrs.equals("63")) {
            chrs = "Õ";
        }
        if (chrs.equals("64")) {
            chrs = "ĝ";
        }
        if (chrs.equals("65")) {
            chrs = "Ô";
        }
        if (chrs.equals("66")) {
            chrs = "ĵ";
        }
        if (chrs.equals("67")) {
            chrs = "ċ";
        }
        if (chrs.equals("68")) {
            chrs = "Ù";
        }
        if (chrs.equals("69")) {
            chrs = "ñ";
        }
        this.resultxt.setText(this.resultxt.getText() + chrs);
        return result;
    }

    private String EncryptCharJ(String chrs) {
        String result = "";
        if (chrs.equals("0")) {
            chrs = "Å";
        }
        if (chrs.equals("1")) {
            chrs = "â";
        }
        if (chrs.equals("2")) {
            chrs = "ÿ";
        }
        if (chrs.equals("3")) {
            chrs = "è";
        }
        if (chrs.equals("4")) {
            chrs = "Ĵ";
        }
        if (chrs.equals("5")) {
            chrs = "Ï";
        }
        if (chrs.equals("6")) {
            chrs = "Ĺ";
        }
        if (chrs.equals("7")) {
            chrs = ":";
        }
        if (chrs.equals("8")) {
            chrs = "ü";
        }
        if (chrs.equals("9")) {
            chrs = "Ķ";
        }
        if (chrs.equals("10")) {
            chrs = "Ú";
        }
        if (chrs.equals("11")) {
            chrs = "Ģ";
        }
        if (chrs.equals("12")) {
            chrs = "Ĥ";
        }
        if (chrs.equals("13")) {
            chrs = "Ļ";
        }
        if (chrs.equals("14")) {
            chrs = "î";
        }
        if (chrs.equals("15")) {
            chrs = "û";
        }
        if (chrs.equals("16")) {
            chrs = "ģ";
        }
        if (chrs.equals("17")) {
            chrs = "3";
        }
        if (chrs.equals("18")) {
            chrs = "ĩ";
        }
        if (chrs.equals("19")) {
            chrs = "Ĩ";
        }
        if (chrs.equals("20")) {
            chrs = "ã";
        }
        if (chrs.equals("21")) {
            chrs = "İ";
        }
        if (chrs.equals("22")) {
            chrs = "ħ";
        }
        if (chrs.equals("23")) {
            chrs = "ķ";
        }
        if (chrs.equals("24")) {
            chrs = "ī";
        }
        if (chrs.equals("25")) {
            chrs = "?";
        }
        if (chrs.equals("26")) {
            chrs = "é";
        }
        if (chrs.equals("27")) {
            chrs = "Ę";
        }
        if (chrs.equals("28")) {
            chrs = "Ħ";
        }
        if (chrs.equals("29")) {
            chrs = "ę";
        }
        if (chrs.equals("30")) {
            chrs = "Ě";
        }
        if (chrs.equals("31")) {
            chrs = "ú";
        }
        if (chrs.equals("32")) {
            chrs = "ă";
        }
        if (chrs.equals("33")) {
            chrs = "œ";
        }
        if (chrs.equals("34")) {
            chrs = "Œ";
        }
        if (chrs.equals("35")) {
            chrs = "ő";
        }
        if (chrs.equals("36")) {
            chrs = "7";
        }
        if (chrs.equals("37")) {
            chrs = "Í";
        }
        if (chrs.equals("38")) {
            chrs = "į";
        }
        if (chrs.equals("39")) {
            chrs = "g";
        }
        if (chrs.equals("40")) {
            chrs = "^";
        }
        if (chrs.equals("41")) {
            chrs = "Ő";
        }
        if (chrs.equals("42")) {
            chrs = "ŏ";
        }
        if (chrs.equals("43")) {
            chrs = "Ŏ";
        }
        if (chrs.equals("44")) {
            chrs = "ē";
        }
        if (chrs.equals("45")) {
            chrs = "Ŕ";
        }
        if (chrs.equals("46")) {
            chrs = "ė";
        }
        if (chrs.equals("47")) {
            chrs = "ð";
        }
        if (chrs.equals("48")) {
            chrs = "Ì";
        }
        if (chrs.equals("49")) {
            chrs = "ï";
        }
        if (chrs.equals("50")) {
            chrs = "Ľ";
        }
        if (chrs.equals("51")) {
            chrs = "ê";
        }
        if (chrs.equals("52")) {
            chrs = "ë";
        }
        if (chrs.equals("53")) {
            chrs = "È";
        }
        if (chrs.equals("54")) {
            chrs = "Î";
        }
        if (chrs.equals("55")) {
            chrs = "ĕ";
        }
        if (chrs.equals("56")) {
            chrs = "Ī";
        }
        if (chrs.equals("57")) {
            chrs = "r";
        }
        if (chrs.equals("58")) {
            chrs = "ù";
        }
        if (chrs.equals("59")) {
            chrs = "ĺ";
        }
        if (chrs.equals("60")) {
            chrs = "x";
        }
        if (chrs.equals("61")) {
            chrs = "ĸ";
        }
        if (chrs.equals("62")) {
            chrs = "ļ";
        }
        if (chrs.equals("63")) {
            chrs = "Ĭ";
        }
        if (chrs.equals("64")) {
            chrs = "6";
        }
        if (chrs.equals("65")) {
            chrs = "*";
        }
        if (chrs.equals("66")) {
            chrs = "s";
        }
        if (chrs.equals("67")) {
            chrs = "4";
        }
        if (chrs.equals("68")) {
            chrs = "Į";
        }
        if (chrs.equals("69")) {
            chrs = "ĭ";
        }
        this.resultxt.setText(this.resultxt.getText() + chrs);
        return result;

    }

    public void CheckPassword() {
        String alltexts = this.entertxt.getText().toString();
        String passtext = alltexts.substring(alltexts.length() - 12, alltexts.length());
        String decryptext = alltexts.substring(0, alltexts.length() - 12);
        String encryptedpass = "";
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;
        int p6 = 0;
        int p7 = 0;
        int p8 = 0;
        int p9 = 0;
        int p10 = 0;
        int p11 = 0;
        int p12 = 0;
        String[][] bivcode = new String[70][];
        bivcode[0] = new String[]{"x", "X", "l", "L", "G", "v", "W", "3", "m", ".", "v", "6", "c", "8", "9", "X", "B", "G", "2", "y", "p", "e", "Y", "J", "O", ",", "1", "Z", "R", ",", "a", "v", "C", "g", "M", ",", "Y", "2", ",", "5", " ", "x", "6", "y", "z", "W", "3", "?", "t", "O", "b", "g", "M", "K", "5", " ", "A", "x", "m", "a", "E", "S", "T", "3", "V", " ", "d", "b", "j", "a"};
        bivcode[1] = new String[]{"F", "5", "A", "g", "N", "D", "R", "I", "i", "L", "5", "1", "b", "J", "w", "u", "G", "j", "y", "O", "j", "e", "7", "F", "N", "x", "r", "8", "P", "R", "k", "H", "T", "d", "m", "W", "z", "3", "9", "n", "5", "z", "s", "w", "5", "t", "0", "e", "u", "f", "D", "x", "M", "B", "D", "b", "v", "x", "Q", "w", "x", "b", "U", "l", "7", " ", "E", "E", "7", "8"};
        bivcode[2] = new String[]{"M", "K", "e", "0", "7", "e", ",", "p", "Z", "y", "X", "6", "s", "z", "S", "V", "e", "6", "j", "z", "?", "e", "u", "d", "b", "H", "i", "c", "3", "q", "X", "u", "K", "D", ",", "e", "t", "P", "s", " ", "c", "U", "3", "o", "r", "B", "7", "g", ",", "y", " ", "V", "g", "I", "f", "S", "P", "t", "1", "E", "b", "x", "i", "f", "K", "7", "p", "q", "O", "x"};
        bivcode[3] = new String[]{"o", "C", "P", "8", "!", "5", "f", "G", "i", "a", "X", "i", "a", "W", " ", "v", "m", "5", "Y", "S", "d", "u", "l", "T", "B", "3", " ", "w", "l", "!", "?", "1", "4", "W", ",", "v", "Q", "o", "H", "c", "k", "p", "E", "S", "b", "I", ",", "c", "6", "s", ".", "0", "X", "3", "l", "h", "R", "c", "p", "b", "3", "G", "a", "K", "g", "I", "P", "n", "g", "9"};
        bivcode[4] = new String[]{"p", "U", "7", "k", "P", "7", "u", "m", ".", " ", "3", "w", "l", "K", "v", "S", "U", ".", "w", "A", "d", "2", "8", "R", "y", "7", "h", "I", "f", "n", "J", "?", "1", "Z", "i", "O", "K", "n", "O", "G", "F", "N", "M", "T", "X", "C", "p", "9", "P", "m", ",", "Z", "I", "4", "u", "n", "z", "W", "I", "u", "D", "c", ",", "L", "T", "w", "t", "n", "?", "L"};
        bivcode[5] = new String[]{"Y", "B", "G", "F", "G", "Y", "k", "S", "d", "G", "G", "U", ".", "P", "Q", "s", " ", "2", "W", "V", "2", "I", ",", "2", "I", "?", "j", "W", "B", "I", "Q", "r", "E", "S", "y", "T", " ", "e", "H", "F", "M", "e", "D", "4", "B", "S", "I", "7", " ", "m", "3", "4", "X", "J", "w", "N", "z", ",", "V", "D", "M", "z", "a", "t", "B", "!", "V", "R", "n", "j"};
        bivcode[6] = new String[]{"X", "d", "6", "B", "1", "v", "G", "o", " ", "9", "T", "H", "z", "b", "5", "x", "G", "m", "l", "T", "B", "w", "u", "w", "R", "v", "Q", "O", "5", "E", "s", "G", "f", "X", "Q", "R", "5", "e", "Z", "N", "n", "l", "u", "S", "3", ",", "1", "5", " ", "h", "p", "M", "z", ".", "s", "U", "1", "5", "c", "1", "y", "F", "I", "q", "h", "O", " ", "F", "f", "6"};
        bivcode[7] = new String[]{"r", " ", "8", "R", "G", "1", "x", "P", "p", "e", " ", "?", "r", "0", "d", "c", ".", "K", "L", " ", "Y", ",", "j", "9", "w", "B", "N", "P", "j", "U", "9", "3", "l", "u", "X", "?", "T", "T", "m", "j", "G", "E", "J", "d", "R", "9", "Z", "k", "B", "y", ".", "9", "V", ".", "9", "Q", "S", "2", "X", " ", "6", "1", "?", "O", "G", "h", "W", "5", "g", "Q"};
        bivcode[8] = new String[]{"0", ",", "o", "K", "z", "r", "!", "7", "O", "c", "K", "?", "d", "K", "a", "Z", ",", "m", "x", "P", "N", "f", "f", "y", "Z", "z", "N", "S", "9", "8", "H", "2", "d", "S", "w", "a", "?", "F", "d", "8", "H", "i", "a", "w", "t", "A", "U", "E", ".", "Q", "Z", "X", "V", "5", "j", "I", "e", "M", "G", "M", "5", "l", "S", "0", "Z", "p", "d", "b", "4", "5"};
        bivcode[9] = new String[]{"6", "5", "p", "3", ",", "0", "v", "o", "6", "8", "n", "h", "i", "p", "p", "3", "d", "j", "G", " ", "6", "5", "B", "T", "Z", "Y", "s", "Q", "p", "O", "P", "8", "G", "A", "Z", "0", "a", "9", "7", "B", "J", "J", "O", "V", "y", "Z", "4", "8", "H", "t", "C", "Q", "R", "J", "1", "8", "!", "C", "5", "h", "y", "R", "T", "x", "3", "y", "3", "E", "d", "b"};
        bivcode[10] = new String[]{"J", "M", "m", "M", "8", "b", ".", "i", "P", "8", "7", "Y", "1", "s", "0", "z", "n", "u", "K", "X", "J", "6", "?", "n", "y", "V", "b", "S", "l", "M", "x", "l", "m", "4", "T", "4", "S", "?", "m", "w", "1", "a", "E", "B", "C", "m", "q", "E", "h", "?", "J", ".", "k", "E", "6", "c", "X", "X", "l", "s", "v", "R", "?", "G", "N", "m", "E", "X", "r", "7"};
        bivcode[11] = new String[]{"h", "U", "!", "!", "H", "b", "u", "T", "q", "o", "g", "0", "b", "v", "A", "Z", "B", "g", "f", "P", "r", "M", "S", "s", "c", "4", "n", "X", "Q", "B", "u", "2", "J", "R", "Y", "t", "c", "8", "N", "l", "u", "C", "j", "N", "D", "n", "S", "9", "Q", "x", "T", "S", "d", "L", "9", "h", "v", "A", "M", "K", "i", "F", "?", "q", "g", "D", "X", "d", "d", "f"};
        bivcode[12] = new String[]{"4", "n", "h", "O", "e", "U", "6", "a", "8", "b", "R", "k", "h", "q", "6", "q", "J", "Q", "x", "n", "J", "v", "d", "!", "q", "J", "N", "y", "p", "u", "C", "H", "F", "K", "l", "d", "v", "z", "X", "?", "6", "9", "?", "G", " ", "2", "t", "r", "d", " ", ",", "k", "D", "i", "D", "n", ",", "8", "!", "w", "k", "a", "U", "q", "W", "p", ",", "q", "6", "l"};
        bivcode[13] = new String[]{"6", "s", "V", "J", "K", "4", ".", "U", "t", "K", "I", "x", "z", "r", " ", "o", "6", "D", "o", "1", "q", ",", "9", "q", "f", "G", "j", "W", "8", ",", "j", "E", "n", "1", "v", "n", "G", "J", "r", "Q", "n", "5", "F", "d", "1", "n", "0", "P", "4", "h", ".", "x", "2", "C", "D", ",", "F", "V", "l", "t", "B", "P", ",", "h", "A", "9", "l", "B", "d", "U"};
        bivcode[14] = new String[]{"a", "!", "C", "1", "0", "c", "N", "p", ",", " ", "O", "i", "J", "8", ".", "p", "A", "N", "?", "h", "w", "C", "o", "J", "E", "1", "j", "7", "X", "Z", "o", "v", "Y", "R", "0", "G", "z", "r", "d", "H", "O", "7", "n", "a", "P", "F", "K", "M", "g", "7", "q", "n", "u", "G", "I", "p", "H", "X", "b", "z", "v", "x", "!", "c", "8", "y", "c", "m", "U", "v"};
        bivcode[15] = new String[]{"l", "o", "R", "9", "s", "f", "f", "9", "T", "t", " ", "T", "M", "y", "z", "R", "t", "F", "b", "G", "a", "t", "b", "u", "U", "!", "i", "M", "E", "l", "z", "3", "m", " ", "F", "k", "M", "R", "q", "D", "M", "2", "K", "b", "2", "Z", "q", "x", "3", "z", "l", "5", ",", "2", "i", "S", "g", "4", "p", "K", "m", "e", "v", "6", "B", "c", "w", "F", "r", "Q"};
        bivcode[16] = new String[]{"4", "7", "I", "K", "!", "z", "B", "Q", "A", "c", "q", "0", "s", "z", "L", "k", "s", " ", "D", "H", " ", "?", "m", "r", "v", "9", "T", "I", "A", "X", "m", "d", "x", "i", "H", "t", "r", "H", "5", "?", "a", "r", "e", "q", "s", "U", "Y", "!", "t", "A", "Y", "Q", "B", "6", "3", "D", "e", "T", " ", "!", "C", "j", "Y", "u", "N", "L", "9", "U", "W", "B"};
        bivcode[17] = new String[]{"A", "B", "k", "9", ".", "B", "6", "V", "L", "V", "f", "9", "T", "g", "P", "3", "a", "f", "O", "8", "I", "L", "K", "8", "!", "f", "K", "j", "r", "z", "l", "W", "D", "b", "!", "S", "n", "D", "i", "g", "9", "u", "1", "h", "a", "s", "S", "b", "1", "Y", "U", "9", "u", ",", "B", "V", "T", "h", "n", "z", "h", "C", " ", "6", "G", "E", "p", ",", "j", ","};
        bivcode[18] = new String[]{"Z", "Q", "T", "u", "X", "?", "p", "R", "D", "2", "5", "I", "n", "w", "1", "1", "0", "f", ".", "c", "H", "S", "l", "F", "4", "?", "Y", "a", "a", "D", "d", " ", "1", "6", "z", "N", "8", "B", "1", "a", "O", "m", "L", "Z", "l", "p", "4", "N", "0", "A", "P", "7", "K", "F", "I", "6", "h", "5", "9", "h", "Q", "b", "X", "Q", "I", "p", "7", "O", ".", "J"};
        bivcode[19] = new String[]{"N", "b", "7", "F", " ", "p", "V", "8", " ", "H", "5", "r", "E", "w", "e", "!", "P", "S", "m", "X", "r", "7", "B", "I", "b", "F", "E", "L", "g", "8", "W", "L", "v", "E", "?", "?", "u", "4", "i", "c", "2", "Y", "Z", "v", "Z", "6", "9", "x", "Q", ",", ".", "n", "s", "1", "P", "7", " ", "T", "A", "h", "j", ".", "a", "N", "H", "r", "q", "O", "Z", "3"};
        bivcode[20] = new String[]{"f", "1", "r", "A", "m", "P", "J", "d", "0", ",", "K", "G", ".", "r", "4", "S", "c", "c", "W", "x", "b", "S", "O", "0", "4", "0", "6", "g", "I", "f", "R", "6", "T", "K", "4", "w", "5", "j", "k", "K", "P", "y", "q", ".", "H", "1", "e", "?", "s", "r", ".", "O", "1", "G", "n", "h", ".", "6", "j", "n", "6", "T", "2", "T", "6", "A", "!", "?", "Q", "V"};
        bivcode[21] = new String[]{"n", "p", "b", "C", "d", "q", "m", "H", "O", "F", "Y", "7", "g", "R", "6", "U", "T", "n", "9", "Q", "A", "F", "!", "g", "g", "o", " ", "L", "?", "6", "s", "3", "G", "I", "j", "W", "T", ",", "g", "E", "h", "u", "V", "I", "t", "7", "S", "e", "x", "n", "i", ",", "r", "M", "k", "8", "6", "v", "V", "0", "S", "Q", "?", "J", "Z", "n", "p", "A", "d", "o"};
        bivcode[22] = new String[]{"l", "V", "d", "!", "A", "N", "G", "I", "0", "J", "D", "b", "7", "l", "M", "x", " ", "e", "2", "Y", " ", "a", "s", "e", "w", "b", "X", "z", "o", "K", "m", "0", "m", "X", "A", "M", "z", "J", ",", "S", "V", "V", "e", "8", "B", "J", "n", "g", "9", "k", "Y", "!", "1", "B", "e", "V", "u", "R", "L", "o", "k", "M", "y", "G", "J", "g", "Y", "B", "d", "b"};
        bivcode[23] = new String[]{"y", "n", "k", "I", ",", "z", "U", "H", "P", "!", "S", "n", "z", "I", "v", "K", "h", "p", "u", "c", "E", "j", "D", "p", "l", "l", "8", "B", "m", "h", "y", "q", "b", "Q", "R", "2", "Y", "x", "H", "e", "Q", "f", "u", "h", "y", "b", "A", ",", "K", "?", "a", "Y", "U", "l", "A", "R", "4", "I", "U", "T", "X", "s", "A", "j", "h", "K", "d", "t", "G", "t"};
        bivcode[24] = new String[]{"M", "?", "B", "x", "c", "N", "Z", "X", "F", "S", "0", "H", "G", "R", "O", "G", "C", "O", "a", "r", "H", "u", "Q", "E", "X", "Q", "F", "a", "3", "C", "e", "n", "l", "Y", "8", " ", "I", "F", "y", "q", ",", "9", "!", "c", "L", "J", "7", "M", "V", "2", "?", "L", "d", "9", "I", "K", "6", "7", "P", "Z", "9", "n", "b", "U", "b", "b", "G", "Z", "Z", "o"};
        bivcode[25] = new String[]{"1", "Z", "c", "c", "x", "J", "7", "o", "w", "a", "H", "n", "!", "L", "Z", "c", "C", "0", "I", "3", "G", "A", "o", "D", "q", "p", "h", "5", "4", "N", "t", "1", "k", "A", "n", "6", "A", "S", "M", "B", "P", "u", "X", "J", "v", "L", "V", " ", "H", "v", "3", "z", "z", ".", "O", "4", "9", "0", ",", "4", "B", "t", "i", " ", "T", "o", "n", "0", "v", "0"};
        bivcode[26] = new String[]{"C", "v", "j", "A", "w", "8", ".", ".", "3", "c", "J", "d", "o", "I", "r", "F", "Q", "!", "q", "V", "X", "q", "8", "V", "W", "d", "O", "e", "D", "r", "q", "0", "g", "c", "1", "O", "5", ",", "9", " ", "N", "K", "6", "9", "l", "x", "V", " ", "m", "T", "L", "i", "s", "y", "K", "m", "d", "i", "x", "h", "x", "g", "s", "n", "M", "T", "p", "s", "z", "j"};
        bivcode[27] = new String[]{"j", "W", "L", "z", "N", "I", "J", "C", "9", ".", "l", "Y", "1", "C", ".", "x", "V", "T", "L", "!", "6", "c", "c", "h", "E", "e", "?", "T", "R", " ", "u", "p", "7", "N", "2", "9", "2", "1", "v", "9", "e", "u", "O", "2", "P", ".", "z", "v", "K", "L", "!", "y", "C", "n", "a", "A", ".", "g", "C", ",", "U", "6", "6", "6", "3", "V", "e", "d", "b", "f"};
        bivcode[28] = new String[]{"M", "6", "z", "7", "z", "H", "P", "?", "T", "Q", "D", "U", "j", "R", "f", "6", "q", "D", "c", "i", "A", "S", "P", "J", "L", "G", "T", "t", "k", "Y", "Z", "H", "n", "a", "v", "4", "U", "Y", "x", "v", "P", "?", ".", "C", "l", "V", "Q", "V", "d", "m", "!", "d", "h", "8", "w", "N", "w", "N", "7", "h", "l", "d", "V", "2", "4", "b", "3", "B", "0", "."};
        bivcode[29] = new String[]{"K", "q", "k", "1", "6", "d", "v", "H", "h", "1", "p", "A", "6", "c", "z", "T", "3", "j", "T", "T", "b", "y", ".", "s", "f", "u", ",", "B", "S", "w", "T", "q", "T", "U", "M", ".", "o", "E", "y", "!", "s", "N", "r", "3", "b", "8", ".", "U", "1", "R", "f", "k", "6", "8", " ", "8", "2", "a", "2", "Z", "n", "4", "1", "e", "a", "U", "J", "d", "b", "0"};
        bivcode[30] = new String[]{"Z", "H", "F", "6", "f", ".", "a", "J", "t", "X", "j", "D", "B", "c", "u", "h", "N", "6", "G", "h", "4", "h", "O", "x", "f", "v", "y", "W", ".", "h", ",", "w", "V", "h", "t", "7", "g", "G", "R", "j", "6", "T", "!", "u", "Y", "X", "9", "X", "O", "I", "T", "Q", "u", "M", "d", "k", "K", "J", "a", "J", "I", "i", "g", ",", "y", "A", "J", "f", "I", "Z"};
        bivcode[31] = new String[]{"N", "3", "m", "B", "K", "5", "B", "G", "U", "Q", "S", "Z", "6", "9", "A", "B", "u", "2", "8", "y", "C", "p", "x", "C", "8", "e", "B", "W", "m", "p", "i", "m", "s", "f", "z", "i", "m", "!", "0", "8", "z", "C", "k", "r", "d", "M", "S", "b", "q", "a", "?", "n", "u", "X", "O", "k", "W", "X", "3", "p", "v", ",", "t", "u", "0", "E", "f", "a", "7", "j"};
        bivcode[32] = new String[]{"K", "0", "V", "T", ".", "A", "6", "W", "f", "N", "y", "M", "8", "7", "s", "m", "x", "1", ".", "d", "n", "N", "6", ",", "!", "C", "Y", "7", "C", "g", "u", "J", "5", "0", "m", "z", "a", "B", "j", "P", "O", "X", "r", "n", "6", "?", "2", "r", "k", "6", "y", "3", "7", "A", "Q", "K", "v", "B", ",", "b", "0", "g", "S", "Y", "P", "!", "q", "V", "Q", "U"};
        bivcode[33] = new String[]{"X", "M", "B", "C", "J", "X", "!", "w", "x", "T", "f", "H", "I", "n", "x", "w", "c", "y", "N", "o", "3", "Y", "k", "O", "e", "E", "r", "E", "A", "2", "D", "8", "d", "A", "d", "r", "q", "?", "Y", "I", "M", "o", "U", "V", "D", "U", "M", "K", "y", "N", "3", "X", "F", "4", "5", "U", "0", "6", "T", "?", "V", "V", "B", "n", "W", "O", "r", "d", "b", "x"};
        bivcode[34] = new String[]{"r", "P", "Z", "S", "6", "6", "S", "y", "a", "A", "5", "D", "U", "Q", "e", "e", "0", "g", "D", "H", "2", "8", "Z", "F", "1", "T", "t", "c", "P", "y", "R", "R", "b", ".", "!", "Z", "y", "D", "c", "a", "V", "t", "4", "H", "c", "8", "V", "z", "s", "L", "D", "d", "5", "s", "?", "o", "0", "Q", "S", "z", "x", "1", "v", "i", "0", "F", "m", "7", "K", "a"};
        bivcode[35] = new String[]{"o", "9", "X", "V", "6", "X", "K", "Z", "3", "z", "S", "y", "I", "V", "I", "!", "t", "Y", "2", "l", "C", "N", "x", "m", "x", "y", "N", "t", "8", "X", "U", "r", "z", "V", "k", "5", "O", "m", "y", "5", "0", "O", "6", "4", "d", "Y", "r", "3", "o", "T", "m", "1", "D", "c", "p", "R", "C", "n", "?", "s", "y", "Q", "x", "u", "q", "G", "Q", "d", "b", "c"};
        bivcode[36] = new String[]{"D", "z", "Y", "I", "Z", "d", "M", "T", "5", "9", "!", "C", "3", "S", ",", "c", "t", "G", "P", "z", "m", "x", "L", "C", "h", "F", " ", "P", " ", "T", "B", "6", "M", "0", "k", "X", "k", "e", "0", "W", "R", "Z", "6", "9", " ", "4", "s", "Y", " ", "?", "v", "y", "T", "Y", "k", "0", "0", "a", "1", "d", "o", "G", "?", "e", "V", "1", "r", "4", "d", "o"};
        bivcode[37] = new String[]{"C", "G", "?", "M", "B", "5", "5", "c", "8", "T", "7", "U", "a", "!", "M", "6", "t", "K", "E", "U", "V", "9", "2", "c", "H", "C", "P", "k", "4", "Y", "z", "Y", ",", "h", "l", "t", "7", "N", "2", "P", "C", "S", "d", "0", "y", "I", "9", "!", "z", "9", ",", "u", "L", "5", "Y", "c", "Z", "!", "r", "9", "K", "O", "v", "j", "F", "f", "3", "q", "d", "w"};
        bivcode[38] = new String[]{"N", "?", "i", "!", "v", "n", "b", "G", "W", "7", "m", "I", "P", "i", "9", "b", "k", "f", "i", "A", "9", "8", "U", "v", "i", "D", "H", "1", "f", "v", "5", "9", "H", "s", "u", "W", "g", "q", "8", "i", "e", "G", "G", "k", "8", "F", "L", "D", "L", "S", "K", "r", "D", "n", "b", "e", "y", "y", "U", "T", "f", "9", "T", "D", "k", "m", "9", "6", "r", "d"};
        bivcode[39] = new String[]{"j", "I", "k", "H", "?", "c", "1", "f", "A", "a", "G", "P", "!", "Q", "?", "B", "Y", "t", " ", "Q", "j", "E", "l", "5", ".", "3", "c", "1", "j", "B", "N", "X", "z", "J", "s", "v", "M", "!", "k", "Z", "i", "g", "a", "o", "r", "h", "G", "M", "G", "v", "F", "6", "7", "e", "b", "n", "z", "5", "6", "v", "!", "T", "Z", "4", "b", "U", "S", " ", "Y", "j"};
        bivcode[40] = new String[]{"h", "M", "X", "B", "E", "m", "j", "i", "S", "M", "A", "0", "y", "i", "r", "Z", "P", "k", "L", "R", "g", "7", "1", "a", "!", "M", "q", "9", "K", "v", "b", "n", "7", ",", ",", "H", "w", "8", "!", "3", "h", "k", "W", "2", "B", "r", "E", "p", " ", "y", "?", "k", "b", "4", "!", "g", "c", "I", "I", "3", "q", "b", "U", "Z", "J", "A", "G", "m", "f", "B"};
        bivcode[41] = new String[]{".", "R", "x", "U", "c", ".", "f", "B", "8", "l", "i", "V", "D", "X", "0", "F", "6", "t", "M", "X", "3", "O", "L", "8", ".", "F", "s", "7", "l", "P", "o", "a", "K", "7", "t", "M", "N", "R", "t", "u", "5", "A", "W", "r", "?", "1", "Z", "Z", "6", "B", "Q", "S", "i", "d", "d", "R", "G", "!", "D", "U", "h", "8", "l", "2", "o", "x", "P", "S", "?", "h"};
        bivcode[42] = new String[]{"W", "q", "6", "4", "e", "T", "y", "p", "E", "Z", "t", "N", "Z", "f", "N", "o", "3", ".", "W", "s", "y", "3", "z", "6", "3", "u", "W", "D", "P", "2", "b", "D", "9", "x", "n", "6", "l", "5", "L", "k", "t", "m", "A", "9", "0", "4", "c", "d", "T", "?", "r", "z", "c", "f", ",", "0", "z", "r", "G", "V", "p", "A", "w", "w", "!", "p", "w", "Z", "m", "j"};
        bivcode[43] = new String[]{"p", "s", "S", "U", ".", "G", "c", "R", "U", "w", "n", "Y", "W", "o", "G", "d", "Q", "c", "i", "z", "d", "t", "u", "J", "r", "T", "K", "8", "h", "W", "J", "9", "y", "S", "Q", "8", "d", "L", "j", "A", "S", "x", "Y", "W", "q", "v", "1", "G", "H", "y", "B", "u", "5", "0", "F", "?", "Z", "P", "e", "4", "0", "S", "4", "c", "t", "4", "M", "1", "1", "F"};
        bivcode[44] = new String[]{"4", "c", "g", "y", "R", "4", "b", "x", "C", "O", "L", "5", "I", "T", "T", "d", "l", "9", "p", "1", "h", "i", "r", "j", "?", "g", ",", "h", "5", "T", "X", "C", "m", "q", "p", "V", "4", "5", "o", "c", " ", "X", "E", "S", "x", "5", "q", "M", "r", "2", "d", "2", "i", "x", "S", "z", "8", "c", "m", "c", "R", "m", "Q", "L", "u", "5", "U", "b", "f", "B"};
        bivcode[45] = new String[]{"m", "w", "1", "P", "D", "u", "H", "U", "W", "H", "6", "p", "k", "?", "M", "q", "H", "y", "D", "G", "P", "S", "4", "n", "r", "?", "E", "U", "b", "w", "r", "M", "q", "n", "q", "W", "V", "B", "M", "o", "W", "A", "q", "n", "0", "g", "5", "f", ",", "1", "0", "O", "X", "i", "R", "0", "i", "z", "C", "M", "S", "v", "o", "b", "!", "q", "p", "d", "K", "C"};
        bivcode[46] = new String[]{"N", "Q", "?", "8", "p", "g", "M", "U", "z", "Y", "z", "v", "P", "I", "8", "o", "u", "u", "o", "S", "r", "D", "Y", ".", "z", "H", "P", "5", ",", "b", "X", "b", "j", "6", "0", "e", "g", "t", "c", "q", "i", "t", "B", "r", "x", "J", "L", "I", "Y", "1", "w", "8", " ", "s", "D", "Q", "a", "K", "e", "p", "!", "n", "x", "p", "y", "h", "L", "H", "L", "3"};
        bivcode[47] = new String[]{"m", "0", "P", "w", "C", "Z", "q", "e", "1", "I", "Y", "T", "a", "e", "B", "T", "y", "u", "Y", "t", "l", "4", ".", "x", ".", "H", "1", "n", "D", ".", "H", "h", "!", "6", ",", "o", "g", "u", "m", "i", "z", "z", "W", "C", "i", "r", "M", "9", "?", "S", "?", "H", "j", "X", "4", "4", "s", "s", "L", "L", "y", "Z", "J", "B", "p", "s", "z", "d", "b", "x"};
        bivcode[48] = new String[]{"e", "f", "V", "A", "G", "U", "U", "U", "7", "1", "?", "E", "v", "S", "s", "?", ".", "p", "7", "L", "m", "n", ",", "l", "T", "y", "I", "9", "F", "d", "S", "3", "x", "0", "J", "W", "4", "2", "z", "g", "a", "4", "u", "Y", "r", "s", "U", "f", "o", "V", "c", "y", "P", "N", "g", "Z", "i", "o", "l", "P", "e", "y", "Y", "l", "r", "I", "I", "A", "N", "w"};
        bivcode[49] = new String[]{",", "n", "b", "o", "s", "B", "L", "H", "q", "2", "n", "S", "F", "4", "Z", "8", "d", "z", "R", "L", "2", "n", "s", "r", "C", "E", ".", "7", "Z", "9", "P", "x", "X", "N", "V", "I", "B", "l", ",", "D", "L", ",", "P", "w", "B", "2", "K", "x", "V", " ", "h", "B", "c", "R", "h", "h", "A", "u", "E", "y", "B", "f", "F", "c", "x", "B", "B", "c", "d", "o"};
        bivcode[50] = new String[]{"a", "I", "O", "5", "N", "s", "v", "X", "P", "d", "5", "T", "J", "o", "g", "M", "O", "X", "H", "P", "N", "L", "h", "1", "?", "7", "6", "O", "y", "s", "G", "F", "Q", "E", "b", "?", "5", "H", "0", "W", "Y", "N", "!", "r", "Z", "J", "X", "n", "G", "g", "d", "5", "W", "z", "i", "U", "D", ",", "N", "x", "L", "P", "T", "E", "e", "7", "1", "k", "p", "d"};
        bivcode[51] = new String[]{"D", "r", "S", "i", "0", "h", "q", "9", "t", "t", "l", "p", "m", "2", "T", "z", "J", "t", "O", "O", "N", "i", "t", "x", "L", "z", "W", "D", "v", "7", "j", "H", "T", "B", "9", "f", "s", "u", "i", "9", "4", "t", "P", "9", "!", "a", "E", "z", "k", "n", "z", "P", "c", "r", "z", "n", "f", "q", "2", "g", "X", "?", "r", "Y", "N", "1", "t", "8", "n", "U"};
        bivcode[52] = new String[]{"D", "7", "W", "C", "y", "V", "y", "?", "i", "k", "Z", "2", "h", "S", "e", "9", "7", "W", "K", "1", "4", "V", "6", "c", "t", "7", "r", "M", "H", "X", "G", "w", "!", "t", "e", "I", "K", "p", "x", "?", "H", "d", "M", "G", "H", "I", "J", "Z", "f", ",", "P", "V", "m", "y", "c", "2", "K", "u", "l", "1", "v", "g", "5", "k", "O", " ", "N", "8", " ", "d"};
        bivcode[53] = new String[]{"X", "P", "z", "g", "j", "g", "o", "e", "?", "p", "6", "Q", "O", "2", "j", "H", "K", "J", "U", "L", "Q", "E", "v", "i", "O", "Y", "E", "u", "K", "C", "d", "V", "5", "6", "7", "j", "N", "x", "d", "G", "D", "P", "E", "R", "2", "2", "b", "6", "D", "H", "E", "O", "5", "q", "K", "i", "z", "0", "s", "F", "K", "O", "w", "s", "!", "T", "9", "K", "p", "C"};
        bivcode[54] = new String[]{"S", "T", "f", "P", "h", "!", "2", "8", "s", "G", "U", "2", "B", "5", "z", "H", "0", "Q", "6", "w", "z", "c", "s", "W", "v", "x", "g", "N", "9", "S", " ", "a", "2", "f", "C", "7", "Z", "!", "m", "H", "a", "q", "d", "l", "m", "U", "X", "6", " ", "o", "f", ",", "U", "s", "l", "H", "t", "M", "k", "W", "0", "S", "w", "?", "Z", "G", "J", "1", "S", "l"};
        bivcode[55] = new String[]{"t", "U", "j", "W", "i", "!", "8", "6", "o", "2", "c", "6", "?", "w", "A", "Q", "A", "z", "o", "u", "9", "W", " ", "H", "f", "P", "t", "P", "i", "2", "F", "g", "n", "T", "k", "c", "t", "6", "m", "A", "O", "K", "m", "i", "V", "j", "s", "a", "1", "3", ",", "9", "z", "P", "J", "t", "h", "B", "v", "B", "0", "J", "Z", "p", "x", "i", "0", "X", "d", "b"};
        bivcode[56] = new String[]{"O", "w", "o", "a", "s", "J", "F", "K", "o", "h", "F", "O", "n", "1", "Y", "k", "u", "V", "S", "R", "K", "g", "8", "6", "C", "?", "O", "F", "p", "W", "B", "R", "E", "G", "o", "w", "6", "L", "Z", "K", "t", "q", "F", "D", "F", "E", "T", "7", "3", "U", "4", "y", "f", "j", "0", "4", "m", "A", "U", "A", "I", "S", "J", "8", " ", "K", "H", "v", "u", "5"};
        bivcode[57] = new String[]{"4", "!", "M", "u", "W", "m", "F", "i", "G", "U", "T", "4", "q", "D", "I", "t", "X", ".", "m", "g", "K", "T", "0", ",", "e", "E", "u", "l", "k", "e", "b", "6", "H", "V", "c", "L", "q", "j", "c", "?", "i", "E", "y", "v", "E", "4", "F", "x", "R", "3", "d", "9", "2", "7", "h", "0", "i", "D", "b", "p", "M", "B", "s", "A", "L", "i", "a", ",", "s", "c"};
        bivcode[58] = new String[]{"l", "p", "8", "Q", "q", "a", "B", "i", "a", "u", "f", "2", "y", "O", "P", "5", "v", "L", "H", "Q", "x", "h", "q", "8", "7", "9", "e", "X", "y", "9", "9", "o", "9", "a", "F", "3", "1", "F", "g", "d", "g", "6", "D", "m", "f", "R", "L", "j", "O", "S", "v", "B", "o", "6", "M", "3", "3", "C", "!", "f", "r", "e", "E", "9", "9", "5", "Q", "F", "f", "8"};
        bivcode[59] = new String[]{"M", "0", "M", "i", "B", "c", "P", "m", "q", "E", "q", "N", "6", "T", "n", "F", "r", "C", "o", "A", "0", "y", "K", "Y", "q", "?", "S", "5", "A", "z", "u", "y", "J", "o", "!", "6", "C", "9", "r", "U", "y", "y", ".", "d", "x", "y", "b", "u", "P", "S", ".", "c", "i", "B", "S", "o", "u", "n", "K", "p", "W", "f", "B", "T", "v", "D", "n", "V", "?", "a"};
        bivcode[60] = new String[]{"K", "J", "U", "U", "x", "u", "8", "6", "k", "9", "0", "?", "D", "0", "7", "T", "5", "m", "Z", "G", " ", "k", "l", "y", "R", "G", "i", "v", "7", "R", "2", "W", "H", "3", "h", "F", "x", "F", "H", "z", "9", "V", "a", "f", "J", "9", "y", "B", "6", "o", "e", "9", "X", "j", ",", "z", "X", "P", "W", "z", "0", "j", "b", "!", "J", "R", "U", "d", "v", "j"};
        bivcode[61] = new String[]{"z", "s", "h", "Q", "N", "P", "6", "3", "P", "V", "h", "a", "6", "m", "S", "S", "Z", "D", "4", "?", "n", "r", "B", "!", "A", "X", "A", "R", "S", "7", "u", "R", "g", "M", "U", ".", "N", "!", "U", "b", "X", "S", "w", "e", "x", "i", "4", "D", "E", "D", "i", ".", "A", "B", "a", "c", "0", "H", "p", "E", " ", "W", "d", "2", "X", "C", "!", "Y", "d", "b"};
        bivcode[62] = new String[]{"t", "?", "5", "p", "X", "v", "J", "8", "d", "J", "Q", "r", "X", "7", "T", "4", "I", "z", "X", "g", "X", ".", "P", "G", "E", "9", "f", "n", "6", "B", "q", "D", "Q", "Q", "K", "b", "M", "M", "f", "G", "J", "a", "5", "s", "O", "N", "W", "b", "s", "l", "p", "q", "e", "J", "o", "4", "P", "N", "J", "k", "w", "s", "Q", "O", "c", "2", "!", "f", "H", "i"};
        bivcode[63] = new String[]{"x", "L", "g", "Q", "h", "M", "B", "O", "5", "u", "Z", "n", " ", "J", "Z", "!", "V", "q", "0", "f", "L", ".", "r", "b", "7", "Y", "E", "M", "C", "a", "4", "X", "3", "E", "L", "y", ".", "H", "l", "v", "s", "d", "i", "3", "Q", "Z", "5", "M", "U", "?", "R", "s", "Z", "3", "k", "T", "6", "6", "W", "B", "E", "R", "1", "Y", "6", "N", "0", "N", "F", "u"};
        bivcode[64] = new String[]{"k", "4", "5", "p", "Q", "D", "I", "4", "S", "d", "J", "L", "p", "i", "Q", "h", "p", "1", "k", "!", "K", "H", " ", "a", "c", "U", " ", "8", "n", "W", "!", "u", "q", "k", "P", "A", "p", "!", "l", "V", "H", " ", "o", "R", ".", "R", "V", "D", "?", "6", "A", "q", "?", "G", "Y", "P", "J", "g", "g", "W", "Y", "J", "W", "W", "3", "T", "y", " ", "h", "w"};
        bivcode[65] = new String[]{"Y", "D", "z", "h", "v", "a", "?", "C", "M", "p", "l", "0", "b", "g", "h", "O", "X", "D", "2", "h", "7", "k", "k", "o", "x", "N", "l", "p", "3", "S", "w", "X", "1", "r", "S", "2", "8", "g", "0", "l", "5", "3", "U", "B", "?", "l", ",", "F", "Q", "j", "k", "x", "G", "5", "F", "I", "w", "w", "r", "m", "V", "B", "U", "C", "1", "!", "8", "3", "f", "L"};
        bivcode[66] = new String[]{"A", "Z", "V", "1", "c", "4", "S", "R", "p", "e", "a", "h", "?", "x", "t", "9", "C", "R", "W", "S", "o", "z", "r", "i", "j", "u", "0", "D", "R", "h", "X", "S", "J", "u", "!", "v", "U", ",", "N", "T", "z", "X", "N", "E", "6", "s", "!", "L", "H", "s", "Z", "F", "X", "?", "O", "t", "D", ",", "k", "z", "Y", "X", "W", "G", "e", "J", "x", " ", "i", "Y"};
        bivcode[67] = new String[]{"i", "Q", "w", "j", "c", "N", "q", "3", "1", "O", "W", "n", "k", "V", "m", "U", "n", "a", "n", "m", "!", "F", ".", "Q", "O", "b", "x", "3", "o", "L", "R", "M", "?", "s", "C", "p", "w", "a", "?", "L", "b", "G", "w", "B", "N", "k", "?", "y", "P", "k", "E", "H", "W", "B", "Z", "v", "4", "i", ",", "3", "s", "2", "E", "P", "m", "6", "L", "T", "Q", " "};
        bivcode[68] = new String[]{"i", "W", "N", "3", "x", "v", "z", "R", "e", "i", "Q", "Y", "W", "S", "r", "J", "!", "2", "j", "8", "8", "C", "s", "I", "F", "n", "K", "y", "C", "D", "G", "W", " ", "9", "!", "M", "t", "b", "T", "h", "O", "R", "3", "N", "C", "f", "k", "a", "E", "j", "D", "m", "m", "X", "o", "s", "?", "T", "9", "X", "5", "b", "m", "C", "!", "W", "V", "e", "A", "b"};
        bivcode[69] = new String[]{"3", "H", "b", "s", "w", "k", "g", "0", "i", "9", "6", "j", "9", "D", "n", "G", "U", "!", "b", "q", "t", "7", "Z", "x", "a", "X", "G", "J", "R", "6", "S", "1", "G", "h", "G", "F", "N", "Q", "5", "Y", "2", "z", "u", "I", "C", "V", ",", "e", "g", "S", "3", "q", "b", "O", "A", "5", "A", "5", "e", "I", "9", " ", "Y", "j", "!", "?", "A", "4", "R", "K"};
        String[] columncodes = new String[]{"À", "Ó", "1", "ď", "ĉ", "ć", "%", "Ą", "É", "Ð", "Ĝ", "ý", "ß", "ě", "å", "ġ", "Â", "Û", "á", "ā", "Þ", "ç", "Ê", "Ü", "Ø", "Ć", "Ė", "Ý", "æ", "ĥ", "Ġ", "à", "@", "ä", "Ğ", "ì", "č", "Ĕ", "ğ", "Ç", "Ë", "8", "#", "2", "Ċ", "Ã", "Á", "Ď", "Ä", "×", "Č", "Ĉ", "5", "Ò", "Æ", "!", "Ñ", "ą", "Ă", "þ", "Ö", "Ē", "Ā", "Õ", "ĝ", "Ô", "ĵ", "ċ", "Ù", "ñ"};
        String[] linecodes = new String[]{"Å", "â", "ÿ", "è", "Ĵ", "Ï", "Ĺ", ":", "ü", "Ķ", "Ú", "Ģ", "Ĥ", "Ļ", "î", "û", "ģ", "3", "ĩ", "Ĩ", "ã", "İ", "ħ", "ķ", "ī", "?", "é", "Ę", "Ħ", "ę", "Ě", "ú", "ă", "œ", "Œ", "ő", "7", "Í", "į", "g", "^", "Ő", "ŏ", "Ŏ", "ē", "Ŕ", "ė", "ð", "Ì", "ï", "Ľ", "ê", "ë", "È", "Î", "ĕ", "Ī", "r", "ù", "ĺ", "x", "ĸ", "ļ", "Ĭ", "6", "*", "s", "4", "Į", "ĭ"};
        for (int i = 0; i < 70; i++) {
            if (columncodes[i].equals(passtext.substring(0, 1))) {
                p1 = i;
            }
        }
        for (int ii = 0; ii < 70; ii++) {
            if (linecodes[ii].equals(passtext.substring(1, 2))) {
                p2 = ii;
            }
        }
        for (int iii = 0; iii < 70; iii++) {
            if (columncodes[iii].equals(passtext.substring(2, 3))) {
                p3 = iii;
            }
        }
        for (int c = 0; c < 70; c++) {
            if (linecodes[c].equals(passtext.substring(3, 4))) {
                p4 = c;
            }
        }
        for (int cc = 0; cc < 70; cc++) {
            if (columncodes[cc].equals(passtext.substring(4, 5))) {
                p5 = cc;
            }
        }
        for (int ccc = 0; ccc < 70; ccc++) {
            if (linecodes[ccc].equals(passtext.substring(5, 6))) {
                p6 = ccc;
            }
        }
        for (int n = 0; n < 70; n++) {
            if (columncodes[n].equals(passtext.substring(6, 7))) {
                p7 = n;
            }
        }
        for (int nn = 0; nn < 70; nn++) {
            if (linecodes[nn].equals(passtext.substring(7, 8))) {
                p8 = nn;
            }
        }
        for (int nnn = 0; nnn < 70; nnn++) {
            if (columncodes[nnn].equals(passtext.substring(8, 9))) {
                p9 = nnn;
            }
        }
        for (int m = 0; m < 70; m++) {
            if (linecodes[m].equals(passtext.substring(9, 10))) {
                p10 = m;
            }
        }
        for (int mm = 0; mm < 70; mm++) {
            if (columncodes[mm].equals(passtext.substring(10, 11))) {
                p11 = mm;
            }
        }
        for (int mmm = 0; mmm < 70; mmm++) {
            if (linecodes[mmm].equals(passtext.substring(11, 12))) {
                p12 = mmm;
            }
        }
        if ((bivcode[p1][p2] + bivcode[p3][p4] + bivcode[p5][p6] + bivcode[p7][p8] + bivcode[p9][p10] + bivcode[p11][p12]).equals(this.passwtext.getText().toString())) {
            DecryptAllText(decryptext);
        } else {
            this.passwtext.setError("Enter Valid Password");
        }

    }

    private String DecryptAllText(String decryptedtxt) {
        String result = "";
        int beginA = 0;
        int endA = 2;
        for (int oo = 0; oo < decryptedtxt.length(); oo++) {
            if (endA < decryptedtxt.length() + 2) {
                ArrangeText(decryptedtxt.substring(beginA, endA));
                beginA += 2;
                endA += 2;
            }
        }
        return result;
    }

    private String ArrangeText(String numbers) {
        String result = "";
        String first = "";
        String second = "";
        int firstcolumn = 0;
        int secondlines = 0;
        first = numbers.substring(0, 1);
        second = numbers.substring(1, 2);
        String[] columncodes = new String[]{"À", "Ó", "1", "ď", "ĉ", "ć", "%", "Ą", "É", "Ð", "Ĝ", "ý", "ß", "ě", "å", "ġ", "Â", "Û", "á", "ā", "Þ", "ç", "Ê", "Ü", "Ø", "Ć", "Ė", "Ý", "æ", "ĥ", "Ġ", "à", "@", "ä", "Ğ", "ì", "č", "Ĕ", "ğ", "Ç", "Ë", "8", "#", "2", "Ċ", "Ã", "Á", "Ď", "Ä", "×", "Č", "Ĉ", "5", "Ò", "Æ", "!", "Ñ", "ą", "Ă", "þ", "Ö", "Ē", "Ā", "Õ", "ĝ", "Ô", "ĵ", "ċ", "Ù", "ñ"};
        String[] linecodes = new String[]{"Å", "â", "ÿ", "è", "Ĵ", "Ï", "Ĺ", ":", "ü", "Ķ", "Ú", "Ģ", "Ĥ", "Ļ", "î", "û", "ģ", "3", "ĩ", "Ĩ", "ã", "İ", "ħ", "ķ", "ī", "?", "é", "Ę", "Ħ", "ę", "Ě", "ú", "ă", "œ", "Œ", "ő", "7", "Í", "į", "g", "^", "Ő", "ŏ", "Ŏ", "ē", "Ŕ", "ė", "ð", "Ì", "ï", "Ľ", "ê", "ë", "È", "Î", "ĕ", "Ī", "r", "ù", "ĺ", "x", "ĸ", "ļ", "Ĭ", "6", "*", "s", "4", "Į", "ĭ"};
        String[][] bivcode = new String[70][];
        bivcode[0] = new String[]{"x", "X", "l", "L", "G", "v", "W", "3", "m", ".", "v", "6", "c", "8", "9", "X", "B", "G", "2", "y", "p", "e", "Y", "J", "O", ",", "1", "Z", "R", ",", "a", "v", "C", "g", "M", ",", "Y", "2", ",", "5", " ", "x", "6", "y", "z", "W", "3", "?", "t", "O", "b", "g", "M", "K", "5", " ", "A", "x", "m", "a", "E", "S", "T", "3", "V", " ", "d", "b", "j", "a"};
        bivcode[1] = new String[]{"F", "5", "A", "g", "N", "D", "R", "I", "i", "L", "5", "1", "b", "J", "w", "u", "G", "j", "y", "O", "j", "e", "7", "F", "N", "x", "r", "8", "P", "R", "k", "H", "T", "d", "m", "W", "z", "3", "9", "n", "5", "z", "s", "w", "5", "t", "0", "e", "u", "f", "D", "x", "M", "B", "D", "b", "v", "x", "Q", "w", "x", "b", "U", "l", "7", " ", "E", "E", "7", "8"};
        bivcode[2] = new String[]{"M", "K", "e", "0", "7", "e", ",", "p", "Z", "y", "X", "6", "s", "z", "S", "V", "e", "6", "j", "z", "?", "e", "u", "d", "b", "H", "i", "c", "3", "q", "X", "u", "K", "D", ",", "e", "t", "P", "s", " ", "c", "U", "3", "o", "r", "B", "7", "g", ",", "y", " ", "V", "g", "I", "f", "S", "P", "t", "1", "E", "b", "x", "i", "f", "K", "7", "p", "q", "O", "x"};
        bivcode[3] = new String[]{"o", "C", "P", "8", "!", "5", "f", "G", "i", "a", "X", "i", "a", "W", " ", "v", "m", "5", "Y", "S", "d", "u", "l", "T", "B", "3", " ", "w", "l", "!", "?", "1", "4", "W", ",", "v", "Q", "o", "H", "c", "k", "p", "E", "S", "b", "I", ",", "c", "6", "s", ".", "0", "X", "3", "l", "h", "R", "c", "p", "b", "3", "G", "a", "K", "g", "I", "P", "n", "g", "9"};
        bivcode[4] = new String[]{"p", "U", "7", "k", "P", "7", "u", "m", ".", " ", "3", "w", "l", "K", "v", "S", "U", ".", "w", "A", "d", "2", "8", "R", "y", "7", "h", "I", "f", "n", "J", "?", "1", "Z", "i", "O", "K", "n", "O", "G", "F", "N", "M", "T", "X", "C", "p", "9", "P", "m", ",", "Z", "I", "4", "u", "n", "z", "W", "I", "u", "D", "c", ",", "L", "T", "w", "t", "n", "?", "L"};
        bivcode[5] = new String[]{"Y", "B", "G", "F", "G", "Y", "k", "S", "d", "G", "G", "U", ".", "P", "Q", "s", " ", "2", "W", "V", "2", "I", ",", "2", "I", "?", "j", "W", "B", "I", "Q", "r", "E", "S", "y", "T", " ", "e", "H", "F", "M", "e", "D", "4", "B", "S", "I", "7", " ", "m", "3", "4", "X", "J", "w", "N", "z", ",", "V", "D", "M", "z", "a", "t", "B", "!", "V", "R", "n", "j"};
        bivcode[6] = new String[]{"X", "d", "6", "B", "1", "v", "G", "o", " ", "9", "T", "H", "z", "b", "5", "x", "G", "m", "l", "T", "B", "w", "u", "w", "R", "v", "Q", "O", "5", "E", "s", "G", "f", "X", "Q", "R", "5", "e", "Z", "N", "n", "l", "u", "S", "3", ",", "1", "5", " ", "h", "p", "M", "z", ".", "s", "U", "1", "5", "c", "1", "y", "F", "I", "q", "h", "O", " ", "F", "f", "6"};
        bivcode[7] = new String[]{"r", " ", "8", "R", "G", "1", "x", "P", "p", "e", " ", "?", "r", "0", "d", "c", ".", "K", "L", " ", "Y", ",", "j", "9", "w", "B", "N", "P", "j", "U", "9", "3", "l", "u", "X", "?", "T", "T", "m", "j", "G", "E", "J", "d", "R", "9", "Z", "k", "B", "y", ".", "9", "V", ".", "9", "Q", "S", "2", "X", " ", "6", "1", "?", "O", "G", "h", "W", "5", "g", "Q"};
        bivcode[8] = new String[]{"0", ",", "o", "K", "z", "r", "!", "7", "O", "c", "K", "?", "d", "K", "a", "Z", ",", "m", "x", "P", "N", "f", "f", "y", "Z", "z", "N", "S", "9", "8", "H", "2", "d", "S", "w", "a", "?", "F", "d", "8", "H", "i", "a", "w", "t", "A", "U", "E", ".", "Q", "Z", "X", "V", "5", "j", "I", "e", "M", "G", "M", "5", "l", "S", "0", "Z", "p", "d", "b", "4", "5"};
        bivcode[9] = new String[]{"6", "5", "p", "3", ",", "0", "v", "o", "6", "8", "n", "h", "i", "p", "p", "3", "d", "j", "G", " ", "6", "5", "B", "T", "Z", "Y", "s", "Q", "p", "O", "P", "8", "G", "A", "Z", "0", "a", "9", "7", "B", "J", "J", "O", "V", "y", "Z", "4", "8", "H", "t", "C", "Q", "R", "J", "1", "8", "!", "C", "5", "h", "y", "R", "T", "x", "3", "y", "3", "E", "d", "b"};
        bivcode[10] = new String[]{"J", "M", "m", "M", "8", "b", ".", "i", "P", "8", "7", "Y", "1", "s", "0", "z", "n", "u", "K", "X", "J", "6", "?", "n", "y", "V", "b", "S", "l", "M", "x", "l", "m", "4", "T", "4", "S", "?", "m", "w", "1", "a", "E", "B", "C", "m", "q", "E", "h", "?", "J", ".", "k", "E", "6", "c", "X", "X", "l", "s", "v", "R", "?", "G", "N", "m", "E", "X", "r", "7"};
        bivcode[11] = new String[]{"h", "U", "!", "!", "H", "b", "u", "T", "q", "o", "g", "0", "b", "v", "A", "Z", "B", "g", "f", "P", "r", "M", "S", "s", "c", "4", "n", "X", "Q", "B", "u", "2", "J", "R", "Y", "t", "c", "8", "N", "l", "u", "C", "j", "N", "D", "n", "S", "9", "Q", "x", "T", "S", "d", "L", "9", "h", "v", "A", "M", "K", "i", "F", "?", "q", "g", "D", "X", "d", "d", "f"};
        bivcode[12] = new String[]{"4", "n", "h", "O", "e", "U", "6", "a", "8", "b", "R", "k", "h", "q", "6", "q", "J", "Q", "x", "n", "J", "v", "d", "!", "q", "J", "N", "y", "p", "u", "C", "H", "F", "K", "l", "d", "v", "z", "X", "?", "6", "9", "?", "G", " ", "2", "t", "r", "d", " ", ",", "k", "D", "i", "D", "n", ",", "8", "!", "w", "k", "a", "U", "q", "W", "p", ",", "q", "6", "l"};
        bivcode[13] = new String[]{"6", "s", "V", "J", "K", "4", ".", "U", "t", "K", "I", "x", "z", "r", " ", "o", "6", "D", "o", "1", "q", ",", "9", "q", "f", "G", "j", "W", "8", ",", "j", "E", "n", "1", "v", "n", "G", "J", "r", "Q", "n", "5", "F", "d", "1", "n", "0", "P", "4", "h", ".", "x", "2", "C", "D", ",", "F", "V", "l", "t", "B", "P", ",", "h", "A", "9", "l", "B", "d", "U"};
        bivcode[14] = new String[]{"a", "!", "C", "1", "0", "c", "N", "p", ",", " ", "O", "i", "J", "8", ".", "p", "A", "N", "?", "h", "w", "C", "o", "J", "E", "1", "j", "7", "X", "Z", "o", "v", "Y", "R", "0", "G", "z", "r", "d", "H", "O", "7", "n", "a", "P", "F", "K", "M", "g", "7", "q", "n", "u", "G", "I", "p", "H", "X", "b", "z", "v", "x", "!", "c", "8", "y", "c", "m", "U", "v"};
        bivcode[15] = new String[]{"l", "o", "R", "9", "s", "f", "f", "9", "T", "t", " ", "T", "M", "y", "z", "R", "t", "F", "b", "G", "a", "t", "b", "u", "U", "!", "i", "M", "E", "l", "z", "3", "m", " ", "F", "k", "M", "R", "q", "D", "M", "2", "K", "b", "2", "Z", "q", "x", "3", "z", "l", "5", ",", "2", "i", "S", "g", "4", "p", "K", "m", "e", "v", "6", "B", "c", "w", "F", "r", "Q"};
        bivcode[16] = new String[]{"4", "7", "I", "K", "!", "z", "B", "Q", "A", "c", "q", "0", "s", "z", "L", "k", "s", " ", "D", "H", " ", "?", "m", "r", "v", "9", "T", "I", "A", "X", "m", "d", "x", "i", "H", "t", "r", "H", "5", "?", "a", "r", "e", "q", "s", "U", "Y", "!", "t", "A", "Y", "Q", "B", "6", "3", "D", "e", "T", " ", "!", "C", "j", "Y", "u", "N", "L", "9", "U", "W", "B"};
        bivcode[17] = new String[]{"A", "B", "k", "9", ".", "B", "6", "V", "L", "V", "f", "9", "T", "g", "P", "3", "a", "f", "O", "8", "I", "L", "K", "8", "!", "f", "K", "j", "r", "z", "l", "W", "D", "b", "!", "S", "n", "D", "i", "g", "9", "u", "1", "h", "a", "s", "S", "b", "1", "Y", "U", "9", "u", ",", "B", "V", "T", "h", "n", "z", "h", "C", " ", "6", "G", "E", "p", ",", "j", ","};
        bivcode[18] = new String[]{"Z", "Q", "T", "u", "X", "?", "p", "R", "D", "2", "5", "I", "n", "w", "1", "1", "0", "f", ".", "c", "H", "S", "l", "F", "4", "?", "Y", "a", "a", "D", "d", " ", "1", "6", "z", "N", "8", "B", "1", "a", "O", "m", "L", "Z", "l", "p", "4", "N", "0", "A", "P", "7", "K", "F", "I", "6", "h", "5", "9", "h", "Q", "b", "X", "Q", "I", "p", "7", "O", ".", "J"};
        bivcode[19] = new String[]{"N", "b", "7", "F", " ", "p", "V", "8", " ", "H", "5", "r", "E", "w", "e", "!", "P", "S", "m", "X", "r", "7", "B", "I", "b", "F", "E", "L", "g", "8", "W", "L", "v", "E", "?", "?", "u", "4", "i", "c", "2", "Y", "Z", "v", "Z", "6", "9", "x", "Q", ",", ".", "n", "s", "1", "P", "7", " ", "T", "A", "h", "j", ".", "a", "N", "H", "r", "q", "O", "Z", "3"};
        bivcode[20] = new String[]{"f", "1", "r", "A", "m", "P", "J", "d", "0", ",", "K", "G", ".", "r", "4", "S", "c", "c", "W", "x", "b", "S", "O", "0", "4", "0", "6", "g", "I", "f", "R", "6", "T", "K", "4", "w", "5", "j", "k", "K", "P", "y", "q", ".", "H", "1", "e", "?", "s", "r", ".", "O", "1", "G", "n", "h", ".", "6", "j", "n", "6", "T", "2", "T", "6", "A", "!", "?", "Q", "V"};
        bivcode[21] = new String[]{"n", "p", "b", "C", "d", "q", "m", "H", "O", "F", "Y", "7", "g", "R", "6", "U", "T", "n", "9", "Q", "A", "F", "!", "g", "g", "o", " ", "L", "?", "6", "s", "3", "G", "I", "j", "W", "T", ",", "g", "E", "h", "u", "V", "I", "t", "7", "S", "e", "x", "n", "i", ",", "r", "M", "k", "8", "6", "v", "V", "0", "S", "Q", "?", "J", "Z", "n", "p", "A", "d", "o"};
        bivcode[22] = new String[]{"l", "V", "d", "!", "A", "N", "G", "I", "0", "J", "D", "b", "7", "l", "M", "x", " ", "e", "2", "Y", " ", "a", "s", "e", "w", "b", "X", "z", "o", "K", "m", "0", "m", "X", "A", "M", "z", "J", ",", "S", "V", "V", "e", "8", "B", "J", "n", "g", "9", "k", "Y", "!", "1", "B", "e", "V", "u", "R", "L", "o", "k", "M", "y", "G", "J", "g", "Y", "B", "d", "b"};
        bivcode[23] = new String[]{"y", "n", "k", "I", ",", "z", "U", "H", "P", "!", "S", "n", "z", "I", "v", "K", "h", "p", "u", "c", "E", "j", "D", "p", "l", "l", "8", "B", "m", "h", "y", "q", "b", "Q", "R", "2", "Y", "x", "H", "e", "Q", "f", "u", "h", "y", "b", "A", ",", "K", "?", "a", "Y", "U", "l", "A", "R", "4", "I", "U", "T", "X", "s", "A", "j", "h", "K", "d", "t", "G", "t"};
        bivcode[24] = new String[]{"M", "?", "B", "x", "c", "N", "Z", "X", "F", "S", "0", "H", "G", "R", "O", "G", "C", "O", "a", "r", "H", "u", "Q", "E", "X", "Q", "F", "a", "3", "C", "e", "n", "l", "Y", "8", " ", "I", "F", "y", "q", ",", "9", "!", "c", "L", "J", "7", "M", "V", "2", "?", "L", "d", "9", "I", "K", "6", "7", "P", "Z", "9", "n", "b", "U", "b", "b", "G", "Z", "Z", "o"};
        bivcode[25] = new String[]{"1", "Z", "c", "c", "x", "J", "7", "o", "w", "a", "H", "n", "!", "L", "Z", "c", "C", "0", "I", "3", "G", "A", "o", "D", "q", "p", "h", "5", "4", "N", "t", "1", "k", "A", "n", "6", "A", "S", "M", "B", "P", "u", "X", "J", "v", "L", "V", " ", "H", "v", "3", "z", "z", ".", "O", "4", "9", "0", ",", "4", "B", "t", "i", " ", "T", "o", "n", "0", "v", "0"};
        bivcode[26] = new String[]{"C", "v", "j", "A", "w", "8", ".", ".", "3", "c", "J", "d", "o", "I", "r", "F", "Q", "!", "q", "V", "X", "q", "8", "V", "W", "d", "O", "e", "D", "r", "q", "0", "g", "c", "1", "O", "5", ",", "9", " ", "N", "K", "6", "9", "l", "x", "V", " ", "m", "T", "L", "i", "s", "y", "K", "m", "d", "i", "x", "h", "x", "g", "s", "n", "M", "T", "p", "s", "z", "j"};
        bivcode[27] = new String[]{"j", "W", "L", "z", "N", "I", "J", "C", "9", ".", "l", "Y", "1", "C", ".", "x", "V", "T", "L", "!", "6", "c", "c", "h", "E", "e", "?", "T", "R", " ", "u", "p", "7", "N", "2", "9", "2", "1", "v", "9", "e", "u", "O", "2", "P", ".", "z", "v", "K", "L", "!", "y", "C", "n", "a", "A", ".", "g", "C", ",", "U", "6", "6", "6", "3", "V", "e", "d", "b", "f"};
        bivcode[28] = new String[]{"M", "6", "z", "7", "z", "H", "P", "?", "T", "Q", "D", "U", "j", "R", "f", "6", "q", "D", "c", "i", "A", "S", "P", "J", "L", "G", "T", "t", "k", "Y", "Z", "H", "n", "a", "v", "4", "U", "Y", "x", "v", "P", "?", ".", "C", "l", "V", "Q", "V", "d", "m", "!", "d", "h", "8", "w", "N", "w", "N", "7", "h", "l", "d", "V", "2", "4", "b", "3", "B", "0", "."};
        bivcode[29] = new String[]{"K", "q", "k", "1", "6", "d", "v", "H", "h", "1", "p", "A", "6", "c", "z", "T", "3", "j", "T", "T", "b", "y", ".", "s", "f", "u", ",", "B", "S", "w", "T", "q", "T", "U", "M", ".", "o", "E", "y", "!", "s", "N", "r", "3", "b", "8", ".", "U", "1", "R", "f", "k", "6", "8", " ", "8", "2", "a", "2", "Z", "n", "4", "1", "e", "a", "U", "J", "d", "b", "0"};
        bivcode[30] = new String[]{"Z", "H", "F", "6", "f", ".", "a", "J", "t", "X", "j", "D", "B", "c", "u", "h", "N", "6", "G", "h", "4", "h", "O", "x", "f", "v", "y", "W", ".", "h", ",", "w", "V", "h", "t", "7", "g", "G", "R", "j", "6", "T", "!", "u", "Y", "X", "9", "X", "O", "I", "T", "Q", "u", "M", "d", "k", "K", "J", "a", "J", "I", "i", "g", ",", "y", "A", "J", "f", "I", "Z"};
        bivcode[31] = new String[]{"N", "3", "m", "B", "K", "5", "B", "G", "U", "Q", "S", "Z", "6", "9", "A", "B", "u", "2", "8", "y", "C", "p", "x", "C", "8", "e", "B", "W", "m", "p", "i", "m", "s", "f", "z", "i", "m", "!", "0", "8", "z", "C", "k", "r", "d", "M", "S", "b", "q", "a", "?", "n", "u", "X", "O", "k", "W", "X", "3", "p", "v", ",", "t", "u", "0", "E", "f", "a", "7", "j"};
        bivcode[32] = new String[]{"K", "0", "V", "T", ".", "A", "6", "W", "f", "N", "y", "M", "8", "7", "s", "m", "x", "1", ".", "d", "n", "N", "6", ",", "!", "C", "Y", "7", "C", "g", "u", "J", "5", "0", "m", "z", "a", "B", "j", "P", "O", "X", "r", "n", "6", "?", "2", "r", "k", "6", "y", "3", "7", "A", "Q", "K", "v", "B", ",", "b", "0", "g", "S", "Y", "P", "!", "q", "V", "Q", "U"};
        bivcode[33] = new String[]{"X", "M", "B", "C", "J", "X", "!", "w", "x", "T", "f", "H", "I", "n", "x", "w", "c", "y", "N", "o", "3", "Y", "k", "O", "e", "E", "r", "E", "A", "2", "D", "8", "d", "A", "d", "r", "q", "?", "Y", "I", "M", "o", "U", "V", "D", "U", "M", "K", "y", "N", "3", "X", "F", "4", "5", "U", "0", "6", "T", "?", "V", "V", "B", "n", "W", "O", "r", "d", "b", "x"};
        bivcode[34] = new String[]{"r", "P", "Z", "S", "6", "6", "S", "y", "a", "A", "5", "D", "U", "Q", "e", "e", "0", "g", "D", "H", "2", "8", "Z", "F", "1", "T", "t", "c", "P", "y", "R", "R", "b", ".", "!", "Z", "y", "D", "c", "a", "V", "t", "4", "H", "c", "8", "V", "z", "s", "L", "D", "d", "5", "s", "?", "o", "0", "Q", "S", "z", "x", "1", "v", "i", "0", "F", "m", "7", "K", "a"};
        bivcode[35] = new String[]{"o", "9", "X", "V", "6", "X", "K", "Z", "3", "z", "S", "y", "I", "V", "I", "!", "t", "Y", "2", "l", "C", "N", "x", "m", "x", "y", "N", "t", "8", "X", "U", "r", "z", "V", "k", "5", "O", "m", "y", "5", "0", "O", "6", "4", "d", "Y", "r", "3", "o", "T", "m", "1", "D", "c", "p", "R", "C", "n", "?", "s", "y", "Q", "x", "u", "q", "G", "Q", "d", "b", "c"};
        bivcode[36] = new String[]{"D", "z", "Y", "I", "Z", "d", "M", "T", "5", "9", "!", "C", "3", "S", ",", "c", "t", "G", "P", "z", "m", "x", "L", "C", "h", "F", " ", "P", " ", "T", "B", "6", "M", "0", "k", "X", "k", "e", "0", "W", "R", "Z", "6", "9", " ", "4", "s", "Y", " ", "?", "v", "y", "T", "Y", "k", "0", "0", "a", "1", "d", "o", "G", "?", "e", "V", "1", "r", "4", "d", "o"};
        bivcode[37] = new String[]{"C", "G", "?", "M", "B", "5", "5", "c", "8", "T", "7", "U", "a", "!", "M", "6", "t", "K", "E", "U", "V", "9", "2", "c", "H", "C", "P", "k", "4", "Y", "z", "Y", ",", "h", "l", "t", "7", "N", "2", "P", "C", "S", "d", "0", "y", "I", "9", "!", "z", "9", ",", "u", "L", "5", "Y", "c", "Z", "!", "r", "9", "K", "O", "v", "j", "F", "f", "3", "q", "d", "w"};
        bivcode[38] = new String[]{"N", "?", "i", "!", "v", "n", "b", "G", "W", "7", "m", "I", "P", "i", "9", "b", "k", "f", "i", "A", "9", "8", "U", "v", "i", "D", "H", "1", "f", "v", "5", "9", "H", "s", "u", "W", "g", "q", "8", "i", "e", "G", "G", "k", "8", "F", "L", "D", "L", "S", "K", "r", "D", "n", "b", "e", "y", "y", "U", "T", "f", "9", "T", "D", "k", "m", "9", "6", "r", "d"};
        bivcode[39] = new String[]{"j", "I", "k", "H", "?", "c", "1", "f", "A", "a", "G", "P", "!", "Q", "?", "B", "Y", "t", " ", "Q", "j", "E", "l", "5", ".", "3", "c", "1", "j", "B", "N", "X", "z", "J", "s", "v", "M", "!", "k", "Z", "i", "g", "a", "o", "r", "h", "G", "M", "G", "v", "F", "6", "7", "e", "b", "n", "z", "5", "6", "v", "!", "T", "Z", "4", "b", "U", "S", " ", "Y", "j"};
        bivcode[40] = new String[]{"h", "M", "X", "B", "E", "m", "j", "i", "S", "M", "A", "0", "y", "i", "r", "Z", "P", "k", "L", "R", "g", "7", "1", "a", "!", "M", "q", "9", "K", "v", "b", "n", "7", ",", ",", "H", "w", "8", "!", "3", "h", "k", "W", "2", "B", "r", "E", "p", " ", "y", "?", "k", "b", "4", "!", "g", "c", "I", "I", "3", "q", "b", "U", "Z", "J", "A", "G", "m", "f", "B"};
        bivcode[41] = new String[]{".", "R", "x", "U", "c", ".", "f", "B", "8", "l", "i", "V", "D", "X", "0", "F", "6", "t", "M", "X", "3", "O", "L", "8", ".", "F", "s", "7", "l", "P", "o", "a", "K", "7", "t", "M", "N", "R", "t", "u", "5", "A", "W", "r", "?", "1", "Z", "Z", "6", "B", "Q", "S", "i", "d", "d", "R", "G", "!", "D", "U", "h", "8", "l", "2", "o", "x", "P", "S", "?", "h"};
        bivcode[42] = new String[]{"W", "q", "6", "4", "e", "T", "y", "p", "E", "Z", "t", "N", "Z", "f", "N", "o", "3", ".", "W", "s", "y", "3", "z", "6", "3", "u", "W", "D", "P", "2", "b", "D", "9", "x", "n", "6", "l", "5", "L", "k", "t", "m", "A", "9", "0", "4", "c", "d", "T", "?", "r", "z", "c", "f", ",", "0", "z", "r", "G", "V", "p", "A", "w", "w", "!", "p", "w", "Z", "m", "j"};
        bivcode[43] = new String[]{"p", "s", "S", "U", ".", "G", "c", "R", "U", "w", "n", "Y", "W", "o", "G", "d", "Q", "c", "i", "z", "d", "t", "u", "J", "r", "T", "K", "8", "h", "W", "J", "9", "y", "S", "Q", "8", "d", "L", "j", "A", "S", "x", "Y", "W", "q", "v", "1", "G", "H", "y", "B", "u", "5", "0", "F", "?", "Z", "P", "e", "4", "0", "S", "4", "c", "t", "4", "M", "1", "1", "F"};
        bivcode[44] = new String[]{"4", "c", "g", "y", "R", "4", "b", "x", "C", "O", "L", "5", "I", "T", "T", "d", "l", "9", "p", "1", "h", "i", "r", "j", "?", "g", ",", "h", "5", "T", "X", "C", "m", "q", "p", "V", "4", "5", "o", "c", " ", "X", "E", "S", "x", "5", "q", "M", "r", "2", "d", "2", "i", "x", "S", "z", "8", "c", "m", "c", "R", "m", "Q", "L", "u", "5", "U", "b", "f", "B"};
        bivcode[45] = new String[]{"m", "w", "1", "P", "D", "u", "H", "U", "W", "H", "6", "p", "k", "?", "M", "q", "H", "y", "D", "G", "P", "S", "4", "n", "r", "?", "E", "U", "b", "w", "r", "M", "q", "n", "q", "W", "V", "B", "M", "o", "W", "A", "q", "n", "0", "g", "5", "f", ",", "1", "0", "O", "X", "i", "R", "0", "i", "z", "C", "M", "S", "v", "o", "b", "!", "q", "p", "d", "K", "C"};
        bivcode[46] = new String[]{"N", "Q", "?", "8", "p", "g", "M", "U", "z", "Y", "z", "v", "P", "I", "8", "o", "u", "u", "o", "S", "r", "D", "Y", ".", "z", "H", "P", "5", ",", "b", "X", "b", "j", "6", "0", "e", "g", "t", "c", "q", "i", "t", "B", "r", "x", "J", "L", "I", "Y", "1", "w", "8", " ", "s", "D", "Q", "a", "K", "e", "p", "!", "n", "x", "p", "y", "h", "L", "H", "L", "3"};
        bivcode[47] = new String[]{"m", "0", "P", "w", "C", "Z", "q", "e", "1", "I", "Y", "T", "a", "e", "B", "T", "y", "u", "Y", "t", "l", "4", ".", "x", ".", "H", "1", "n", "D", ".", "H", "h", "!", "6", ",", "o", "g", "u", "m", "i", "z", "z", "W", "C", "i", "r", "M", "9", "?", "S", "?", "H", "j", "X", "4", "4", "s", "s", "L", "L", "y", "Z", "J", "B", "p", "s", "z", "d", "b", "x"};
        bivcode[48] = new String[]{"e", "f", "V", "A", "G", "U", "U", "U", "7", "1", "?", "E", "v", "S", "s", "?", ".", "p", "7", "L", "m", "n", ",", "l", "T", "y", "I", "9", "F", "d", "S", "3", "x", "0", "J", "W", "4", "2", "z", "g", "a", "4", "u", "Y", "r", "s", "U", "f", "o", "V", "c", "y", "P", "N", "g", "Z", "i", "o", "l", "P", "e", "y", "Y", "l", "r", "I", "I", "A", "N", "w"};
        bivcode[49] = new String[]{",", "n", "b", "o", "s", "B", "L", "H", "q", "2", "n", "S", "F", "4", "Z", "8", "d", "z", "R", "L", "2", "n", "s", "r", "C", "E", ".", "7", "Z", "9", "P", "x", "X", "N", "V", "I", "B", "l", ",", "D", "L", ",", "P", "w", "B", "2", "K", "x", "V", " ", "h", "B", "c", "R", "h", "h", "A", "u", "E", "y", "B", "f", "F", "c", "x", "B", "B", "c", "d", "o"};
        bivcode[50] = new String[]{"a", "I", "O", "5", "N", "s", "v", "X", "P", "d", "5", "T", "J", "o", "g", "M", "O", "X", "H", "P", "N", "L", "h", "1", "?", "7", "6", "O", "y", "s", "G", "F", "Q", "E", "b", "?", "5", "H", "0", "W", "Y", "N", "!", "r", "Z", "J", "X", "n", "G", "g", "d", "5", "W", "z", "i", "U", "D", ",", "N", "x", "L", "P", "T", "E", "e", "7", "1", "k", "p", "d"};
        bivcode[51] = new String[]{"D", "r", "S", "i", "0", "h", "q", "9", "t", "t", "l", "p", "m", "2", "T", "z", "J", "t", "O", "O", "N", "i", "t", "x", "L", "z", "W", "D", "v", "7", "j", "H", "T", "B", "9", "f", "s", "u", "i", "9", "4", "t", "P", "9", "!", "a", "E", "z", "k", "n", "z", "P", "c", "r", "z", "n", "f", "q", "2", "g", "X", "?", "r", "Y", "N", "1", "t", "8", "n", "U"};
        bivcode[52] = new String[]{"D", "7", "W", "C", "y", "V", "y", "?", "i", "k", "Z", "2", "h", "S", "e", "9", "7", "W", "K", "1", "4", "V", "6", "c", "t", "7", "r", "M", "H", "X", "G", "w", "!", "t", "e", "I", "K", "p", "x", "?", "H", "d", "M", "G", "H", "I", "J", "Z", "f", ",", "P", "V", "m", "y", "c", "2", "K", "u", "l", "1", "v", "g", "5", "k", "O", " ", "N", "8", " ", "d"};
        bivcode[53] = new String[]{"X", "P", "z", "g", "j", "g", "o", "e", "?", "p", "6", "Q", "O", "2", "j", "H", "K", "J", "U", "L", "Q", "E", "v", "i", "O", "Y", "E", "u", "K", "C", "d", "V", "5", "6", "7", "j", "N", "x", "d", "G", "D", "P", "E", "R", "2", "2", "b", "6", "D", "H", "E", "O", "5", "q", "K", "i", "z", "0", "s", "F", "K", "O", "w", "s", "!", "T", "9", "K", "p", "C"};
        bivcode[54] = new String[]{"S", "T", "f", "P", "h", "!", "2", "8", "s", "G", "U", "2", "B", "5", "z", "H", "0", "Q", "6", "w", "z", "c", "s", "W", "v", "x", "g", "N", "9", "S", " ", "a", "2", "f", "C", "7", "Z", "!", "m", "H", "a", "q", "d", "l", "m", "U", "X", "6", " ", "o", "f", ",", "U", "s", "l", "H", "t", "M", "k", "W", "0", "S", "w", "?", "Z", "G", "J", "1", "S", "l"};
        bivcode[55] = new String[]{"t", "U", "j", "W", "i", "!", "8", "6", "o", "2", "c", "6", "?", "w", "A", "Q", "A", "z", "o", "u", "9", "W", " ", "H", "f", "P", "t", "P", "i", "2", "F", "g", "n", "T", "k", "c", "t", "6", "m", "A", "O", "K", "m", "i", "V", "j", "s", "a", "1", "3", ",", "9", "z", "P", "J", "t", "h", "B", "v", "B", "0", "J", "Z", "p", "x", "i", "0", "X", "d", "b"};
        bivcode[56] = new String[]{"O", "w", "o", "a", "s", "J", "F", "K", "o", "h", "F", "O", "n", "1", "Y", "k", "u", "V", "S", "R", "K", "g", "8", "6", "C", "?", "O", "F", "p", "W", "B", "R", "E", "G", "o", "w", "6", "L", "Z", "K", "t", "q", "F", "D", "F", "E", "T", "7", "3", "U", "4", "y", "f", "j", "0", "4", "m", "A", "U", "A", "I", "S", "J", "8", " ", "K", "H", "v", "u", "5"};
        bivcode[57] = new String[]{"4", "!", "M", "u", "W", "m", "F", "i", "G", "U", "T", "4", "q", "D", "I", "t", "X", ".", "m", "g", "K", "T", "0", ",", "e", "E", "u", "l", "k", "e", "b", "6", "H", "V", "c", "L", "q", "j", "c", "?", "i", "E", "y", "v", "E", "4", "F", "x", "R", "3", "d", "9", "2", "7", "h", "0", "i", "D", "b", "p", "M", "B", "s", "A", "L", "i", "a", ",", "s", "c"};
        bivcode[58] = new String[]{"l", "p", "8", "Q", "q", "a", "B", "i", "a", "u", "f", "2", "y", "O", "P", "5", "v", "L", "H", "Q", "x", "h", "q", "8", "7", "9", "e", "X", "y", "9", "9", "o", "9", "a", "F", "3", "1", "F", "g", "d", "g", "6", "D", "m", "f", "R", "L", "j", "O", "S", "v", "B", "o", "6", "M", "3", "3", "C", "!", "f", "r", "e", "E", "9", "9", "5", "Q", "F", "f", "8"};
        bivcode[59] = new String[]{"M", "0", "M", "i", "B", "c", "P", "m", "q", "E", "q", "N", "6", "T", "n", "F", "r", "C", "o", "A", "0", "y", "K", "Y", "q", "?", "S", "5", "A", "z", "u", "y", "J", "o", "!", "6", "C", "9", "r", "U", "y", "y", ".", "d", "x", "y", "b", "u", "P", "S", ".", "c", "i", "B", "S", "o", "u", "n", "K", "p", "W", "f", "B", "T", "v", "D", "n", "V", "?", "a"};
        bivcode[60] = new String[]{"K", "J", "U", "U", "x", "u", "8", "6", "k", "9", "0", "?", "D", "0", "7", "T", "5", "m", "Z", "G", " ", "k", "l", "y", "R", "G", "i", "v", "7", "R", "2", "W", "H", "3", "h", "F", "x", "F", "H", "z", "9", "V", "a", "f", "J", "9", "y", "B", "6", "o", "e", "9", "X", "j", ",", "z", "X", "P", "W", "z", "0", "j", "b", "!", "J", "R", "U", "d", "v", "j"};
        bivcode[61] = new String[]{"z", "s", "h", "Q", "N", "P", "6", "3", "P", "V", "h", "a", "6", "m", "S", "S", "Z", "D", "4", "?", "n", "r", "B", "!", "A", "X", "A", "R", "S", "7", "u", "R", "g", "M", "U", ".", "N", "!", "U", "b", "X", "S", "w", "e", "x", "i", "4", "D", "E", "D", "i", ".", "A", "B", "a", "c", "0", "H", "p", "E", " ", "W", "d", "2", "X", "C", "!", "Y", "d", "b"};
        bivcode[62] = new String[]{"t", "?", "5", "p", "X", "v", "J", "8", "d", "J", "Q", "r", "X", "7", "T", "4", "I", "z", "X", "g", "X", ".", "P", "G", "E", "9", "f", "n", "6", "B", "q", "D", "Q", "Q", "K", "b", "M", "M", "f", "G", "J", "a", "5", "s", "O", "N", "W", "b", "s", "l", "p", "q", "e", "J", "o", "4", "P", "N", "J", "k", "w", "s", "Q", "O", "c", "2", "!", "f", "H", "i"};
        bivcode[63] = new String[]{"x", "L", "g", "Q", "h", "M", "B", "O", "5", "u", "Z", "n", " ", "J", "Z", "!", "V", "q", "0", "f", "L", ".", "r", "b", "7", "Y", "E", "M", "C", "a", "4", "X", "3", "E", "L", "y", ".", "H", "l", "v", "s", "d", "i", "3", "Q", "Z", "5", "M", "U", "?", "R", "s", "Z", "3", "k", "T", "6", "6", "W", "B", "E", "R", "1", "Y", "6", "N", "0", "N", "F", "u"};
        bivcode[64] = new String[]{"k", "4", "5", "p", "Q", "D", "I", "4", "S", "d", "J", "L", "p", "i", "Q", "h", "p", "1", "k", "!", "K", "H", " ", "a", "c", "U", " ", "8", "n", "W", "!", "u", "q", "k", "P", "A", "p", "!", "l", "V", "H", " ", "o", "R", ".", "R", "V", "D", "?", "6", "A", "q", "?", "G", "Y", "P", "J", "g", "g", "W", "Y", "J", "W", "W", "3", "T", "y", " ", "h", "w"};
        bivcode[65] = new String[]{"Y", "D", "z", "h", "v", "a", "?", "C", "M", "p", "l", "0", "b", "g", "h", "O", "X", "D", "2", "h", "7", "k", "k", "o", "x", "N", "l", "p", "3", "S", "w", "X", "1", "r", "S", "2", "8", "g", "0", "l", "5", "3", "U", "B", "?", "l", ",", "F", "Q", "j", "k", "x", "G", "5", "F", "I", "w", "w", "r", "m", "V", "B", "U", "C", "1", "!", "8", "3", "f", "L"};
        bivcode[66] = new String[]{"A", "Z", "V", "1", "c", "4", "S", "R", "p", "e", "a", "h", "?", "x", "t", "9", "C", "R", "W", "S", "o", "z", "r", "i", "j", "u", "0", "D", "R", "h", "X", "S", "J", "u", "!", "v", "U", ",", "N", "T", "z", "X", "N", "E", "6", "s", "!", "L", "H", "s", "Z", "F", "X", "?", "O", "t", "D", ",", "k", "z", "Y", "X", "W", "G", "e", "J", "x", " ", "i", "Y"};
        bivcode[67] = new String[]{"i", "Q", "w", "j", "c", "N", "q", "3", "1", "O", "W", "n", "k", "V", "m", "U", "n", "a", "n", "m", "!", "F", ".", "Q", "O", "b", "x", "3", "o", "L", "R", "M", "?", "s", "C", "p", "w", "a", "?", "L", "b", "G", "w", "B", "N", "k", "?", "y", "P", "k", "E", "H", "W", "B", "Z", "v", "4", "i", ",", "3", "s", "2", "E", "P", "m", "6", "L", "T", "Q", " "};
        bivcode[68] = new String[]{"i", "W", "N", "3", "x", "v", "z", "R", "e", "i", "Q", "Y", "W", "S", "r", "J", "!", "2", "j", "8", "8", "C", "s", "I", "F", "n", "K", "y", "C", "D", "G", "W", " ", "9", "!", "M", "t", "b", "T", "h", "O", "R", "3", "N", "C", "f", "k", "a", "E", "j", "D", "m", "m", "X", "o", "s", "?", "T", "9", "X", "5", "b", "m", "C", "!", "W", "V", "e", "A", "b"};
        bivcode[69] = new String[]{"3", "H", "b", "s", "w", "k", "g", "0", "i", "9", "6", "j", "9", "D", "n", "G", "U", "!", "b", "q", "t", "7", "Z", "x", "a", "X", "G", "J", "R", "6", "S", "1", "G", "h", "G", "F", "N", "Q", "5", "Y", "2", "z", "u", "I", "C", "V", ",", "e", "g", "S", "3", "q", "b", "O", "A", "5", "A", "5", "e", "I", "9", " ", "Y", "j", "!", "?", "A", "4", "R", "K"};
        for (int i = 0; i < 70; i++) {
            if (columncodes[i].equals(first)) {
                firstcolumn = i;
            }
        }
        for (int ii = 0; ii < 70; ii++) {
            if (linecodes[ii].equals(second)) {
                secondlines = ii;
            }
        }
        this.resultxt.setText(this.resultxt.getText() + bivcode[firstcolumn][secondlines]);
        return result;
    }

    public void onEnterTextClick(View v) {
        this.entertxt.setText("");
    }

    public void onResultTextClick(View v) {
        this.resultxt.setText("");
    }

    public void OnEncryptionClick(View v) {
        this.endec.setText("Encrypted Text:");
        this.CopyText.setText("COPY ENCRYPTED TEXT");
        this.button4.setText("START ENCRYPTION");

    }

    public void OnDecryptionClick(View v) {
        this.endec.setText("Decrypted Text:");
        this.CopyText.setText("COPY DECRYPTED TEXT");
        this.button4.setText("START DECRYPTION");
    }


    public void CopyToClipBoard(View v) {
        if (this.radioOne.isChecked()) {
            if (this.sdkVer < 11) {
                ((ClipboardManager) getSystemService("clipboard")).setText(this.resultxt.getText().toString());
            } else {
                ((android.content.ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Message", this.resultxt.getText().toString()));
            }
        }
        if (!this.radioTwo.isChecked()) {
            return;
        }
        if (this.sdkVer < 11) {
            ((ClipboardManager) getSystemService("clipboard")).setText(this.resultxt.getText().toString());
        } else {
            ((android.content.ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Message", this.resultxt.getText().toString()));
        }
    }

    public void Share(View view) {
        if (this.resultxt.getText().toString().equals("")) {
            empty();
            return;
        }
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setType("text/plain");
        localIntent.putExtra("android.intent.extra.TEXT", this.resultxt.getText().toString());
        startActivity(Intent.createChooser(localIntent, ""));

    }

    private void empty() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Text Field Cannot Be Empty!!");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void emptypaste() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("NOTHING TO PASTE!!");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



    public void onPasteClick(View view) {
        ClipboardManager localClipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (!localClipboardManager.hasPrimaryClip()) {
            emptypaste();
            return;
        }
        ClipData.Item localItem = localClipboardManager.getPrimaryClip().getItemAt(0);
        this.entertxt.append(localItem.getText().toString());
        this.entertxt.setSelection(this.entertxt.getText().length());
    }

    public void open(View view) {
        Intent i;
        PackageManager manager = getPackageManager();
        try {
            i = manager.getLaunchIntentForPackage("com.socialnmobile.dictapps.notepad.color.note");
            if (i == null)
                throw new PackageManager.NameNotFoundException();
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            startActivity(i);
        } catch (PackageManager.NameNotFoundException e) {
        }
    }


    public void onExit(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are You Sure?");
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}


