package com.lilac.lilacstory.Register;

public class Contract {
    interface View
    {
        public void MoveToLoginActivity();
        public void initializeView();
        public void initializeViewListener();
    }
    interface Presenter
    {
        public void CheckValidity();
        public void RegisterUserData();
    }
}
