package com.example.rnr_reporter;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class reporterAplication extends Application {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
}
