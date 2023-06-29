package com.makhabatusen.android_lesson_1_hw;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setSignUp();
    }


    private void setSignUp() {

        SpannableString signUPText = new SpannableString(getResources().getString(R.string.signUp));
        ClickableSpan signUpBtn = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
            }
        };
        signUPText.setSpan(signUpBtn,23,signUPText.length(),SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        signUp.setText(signUPText);
        signUp.setMovementMethod(LinkMovementMethod.getInstance());

    }

    private void init() {
        Button login = findViewById(R.id.btn_login);
        signUp = findViewById(R.id.tv_signUp);

        login.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainPageActivity.class);
            startActivity(intent);
        });


    }
}