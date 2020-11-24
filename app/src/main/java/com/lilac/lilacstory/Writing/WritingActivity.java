package com.lilac.lilacstory.Writing;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lilac.lilacstory.R;

public class WritingActivity extends AppCompatActivity implements WritingContract.View,View.OnClickListener {
    EditText WritingText;
    View rootView;
    ImageButton txt_font_style,txt_font_size,txt_align,btn_thumbnail;
    Button btn_complete,btn_save;

    LinearLayout bottomBar_content;
    int viewHeight = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_writing);
        initializeView();
        initializeListener();
    }

    @Override
    public void initializeView() {
        rootView = findViewById(R.id.writing_root);
        WritingText = findViewById(R.id.edt_writing);

        txt_font_style = findViewById(R.id.img_btn_font_style);
        txt_font_size = findViewById(R.id.img_btn_font_size);
        txt_align = findViewById(R.id.img_btn_align);

        btn_save = findViewById(R.id.btn_writing_save);
        btn_complete = findViewById(R.id.btn_writing_complete);
        btn_thumbnail = findViewById(R.id.btn_writing_thumbnail);

        bottomBar_content = findViewById(R.id.writing_bar_font_style);

    }

    @Override
    public void initializeListener() {
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int currentViewheight= rootView.getHeight();
                if(currentViewheight>viewHeight)
                    viewHeight = currentViewheight;
            }
        });
        txt_font_style.setOnClickListener(this);
        txt_font_size.setOnClickListener(this);
        txt_align.setOnClickListener(this);

        btn_save.setOnClickListener(this);
        btn_complete.setOnClickListener(this);
        btn_thumbnail.setOnClickListener(this);

        WritingText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                bottomBar_content.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.img_btn_font_style:
                DisplayBottomBar();
                break;
        }
    }

    @Override
    public int getKeyBoardHeight() {
        if(rootView.getHeight()>viewHeight)
            viewHeight = rootView.getHeight();
        Rect visibleFrameSize = new Rect();
        rootView.getWindowVisibleDisplayFrame(visibleFrameSize);

        int visibleFrameHeight = visibleFrameSize.bottom - visibleFrameSize.top;
        int keyboardHeight = viewHeight - visibleFrameHeight;

        return keyboardHeight;
    }

    @Override
    public void DisplayBottomBar() {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(WritingText.getWindowToken(),0);
    }
}
