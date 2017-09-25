package com.dreads.testcatchup.network;

/**
 * Created by Dreads on 25/09/2017.
 */

public class ClearbitLogoApiService {
    public static String LOGO_BASE_URL = "https://logo.clearbit.com/";

    public static String getUrlToLogo(String domain){
        return LOGO_BASE_URL + domain;
    }
}
