package lnestares.com.br.violinapp;

import android.app.Application;

import java.util.ArrayList;

import lnestares.com.br.violinapp.model.Violin;

/**
 * Created by macinbox on 27/03/18.
 */

public class CustomApplication extends Application {

    private static ArrayList<Violin> lstViolins = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static ArrayList<Violin> getLstViolins() {
        return lstViolins;
    }
}
