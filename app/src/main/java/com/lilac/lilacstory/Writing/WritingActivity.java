package com.lilac.lilacstory.Writing;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import com.lilac.lilacstory.R;

public class WritingActivity extends AppCompatActivity implements WritingContract.View,View.OnClickListener {
    EditText WritingText;
    View rootView;
    ImageButton txt_font_style,txt_font_size,txt_align,btn_thumbnail;
    LinearLayout writing_font_style;
    FrameLayout writing_font_size;
    Button btn_complete,btn_save;

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

        txt_font_style.setTag(R.id.img_btn_font_style);
        txt_font_size.setTag(R.id.img_btn_font_size);
        txt_align.setTag(R.drawable.icon_text_align_center);

        btn_save = findViewById(R.id.btn_writing_save);
        btn_complete = findViewById(R.id.btn_writing_complete);
        btn_thumbnail = findViewById(R.id.btn_writing_thumbnail);

        writing_font_style = findViewById(R.id.writing_bar_font_style);
        writing_font_size = findViewById(R.id.writing_bar_font_size);

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
                writing_font_style.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.img_btn_font_style:
                DisplayBottomBar(writing_font_style);
                break;
            case R.id.img_btn_font_size:
                DisplayBottomBar(writing_font_size);
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
    public void DisplayBottomBar(View v) {
        writing_font_size.setVisibility(View.GONE);
        writing_font_style.setVisibility(View.GONE);
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(WritingText.getWindowToken(),0);
        v.setVisibility(View.VISIBLE);
    }
}
