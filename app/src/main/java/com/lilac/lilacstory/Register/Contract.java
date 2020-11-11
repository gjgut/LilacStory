package com.lilac.lilacstory.Register;

public class Contract {
    interface View
    {
        void MoveToLoginActivity();
        void initializeView();
        void initializeViewListener();
    }
    interface Presenter
    {
        void CheckValidity();
        void RegisterUserData(String email,String passwd);
    }
}
