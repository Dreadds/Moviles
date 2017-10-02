package com.dreads.testcatchup.models;

import android.content.Context;

import com.dreads.testcatchup.R;

/**
 * Created by Dreads on 01/10/2017.
 */

public class PreferencesRepository {
    // new 3
    private Context context;

    public PreferencesRepository(Context context) {
        this.setContext(context);
    }

    public PreferencesRepository() {
    }

    public Context getContext() {
        return context;
    }

    public PreferencesRepository setContext(Context context) {
        this.context = context;
        return this;
    }
    //new 4
    public int getMaxResults(){
        return context
                .getSharedPreferences(context.getString(R.string.app_name),
                        Context.MODE_PRIVATE)
                .getInt("max_results",20);
    }
    public  String getMaxResultsAsString(){return String.valueOf(getMaxResults());}

    public PreferencesRepository setMaxResults(int maxResults){
        context
                .getSharedPreferences(context.getString(R.string.app_name),
                        Context.MODE_PRIVATE)
                .edit()
                .putInt("max_results", maxResults)
                .commit();
        return this;
    }
}
