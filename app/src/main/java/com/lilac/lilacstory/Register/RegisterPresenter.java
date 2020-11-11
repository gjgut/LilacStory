package com.lilac.lilacstory.Register;

import com.lilac.lilacstory.Common.Model.DataModel;

public class RegisterPresenter implements Contract.Presenter {
    Contract.View view_Register;
    DataModel repository;

    public RegisterPresenter(Contract.View view)
    {
        view_Register = view;
        repository = (DataModel) DataModel.getInstance();
    }

    @Override
    public void CheckValidity()
    {

    }

    @Override
    public void RegisterUserData(String email,String passwd)
    {
        repository.SaveInfo(email,passwd);
    }
}
