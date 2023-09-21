package com.example.translationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;



public class MainActivity extends AppCompatActivity {

    private EditText editTextLetters;
    private Button btnTranslate;
    private String api = "AIzaSyAfBLO6C0-BSE2TgQk_V3bKqrj0hpgzgfI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextLetters = findViewById(R.id.editTextLetters);
        btnTranslate = findViewById(R.id.btnTranslate);
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editTextLetters.getText().toString())){
                    Toast.makeText(MainActivity.this, "Text is required", Toast.LENGTH_SHORT).show();
                }else{

                    String targetLang = "kk"; // for Kazakh
                    String sourceLang = "en"; // for japan
                    Translate translate = TranslateOptions.newBuilder().setApiKey(api).build().getService();
                    Translation translation = translate.translate(editTextLetters.getText().toString(), Translate.TranslateOption.targetLanguage(targetLang), Translate.TranslateOption.sourceLanguage(sourceLang));
                    String translatedText = translation.getTranslatedText();


                }
            }
        });

    }
}