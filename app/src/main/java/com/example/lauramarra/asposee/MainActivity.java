package com.example.lauramarra.asposee;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity {

    InputStream inputStream = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document("/src/main/assets/doc.pdf");
        com.aspose.pdf.TextAbsorber textAbsorber = new com.aspose.pdf.TextAbsorber();
        pdfDocument.getPages().accept(textAbsorber);
        String extractedText = textAbsorber.getText();
        java.io.FileWriter writer = null;

        try {
            writer = new java.io.FileWriter(new java.io.File("/app/src/main/assets/doc.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(extractedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
