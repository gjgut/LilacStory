package com.lilac.lilacstory.Writing;

import android.view.View;

public class WritingContract {
    interface View
    {
        void initializeView();
        void initializeListener();
        int getKeyBoardHeight();
        void DisplayBottomBar(android.view.View v);
    }
    interface Presenter
    {
        public void AlignText();

    }
}
