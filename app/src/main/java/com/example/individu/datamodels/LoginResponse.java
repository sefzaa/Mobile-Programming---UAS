package com.example.individu.datamodels;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

    @SerializedName("authorisation")
    private com.example.individu.datamodels.Authorisation authorisation;

    @SerializedName("user")
    private com.example.individu.datamodels.User user;

    @SerializedName("status")
    private String status;

    public com.example.individu.datamodels.Authorisation getAuthorisation(){
        return authorisation;
    }

    public com.example.individu.datamodels.User getUser(){
        return user;
    }

    public String getStatus(){
        return status;
    }
}