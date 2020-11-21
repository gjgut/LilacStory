package com.lilac.lilacstory.Writing;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lilac.lilacstory.R;

public class WritingActivity extends AppCompatActivity implements WritingContract.View {
    TextView WritingText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_writing);
        initializeView();
        initializeListener();
    }

    @Override
    public void initializeView() {
        WritingText = (TextView)findViewById(R.id.edt_writing);
    }

    @Override
    public void initializeListener() {

    }
}
