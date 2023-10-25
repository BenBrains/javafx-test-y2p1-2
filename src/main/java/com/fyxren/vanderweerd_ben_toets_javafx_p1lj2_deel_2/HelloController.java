package com.fyxren.vanderweerd_ben_toets_javafx_p1lj2_deel_2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField fieldI;

    @FXML
    private TextField fieldR;

    @FXML
    private TextField fieldU;

    @FXML
    private Label subtitle;

    @FXML
    private void calculateI() {
        try {
            float valR = Float.parseFloat(fieldR.getText().replaceAll(",", "."));
            float valU = Float.parseFloat(fieldU.getText().replaceAll(",", "."));
            fieldI.setText(formattedAnswer(valU / valR));
            setError(false);
        } catch (Exception e) {
            setError(true);
        }
    }

    @FXML
    private void calculateR() {
        try {
            float valI = Float.parseFloat(fieldI.getText().replaceAll(",", "."));
            float valU = Float.parseFloat(fieldU.getText().replaceAll(",", "."));
            fieldR.setText(formattedAnswer(valU / valI));
            setError(false);
        } catch (Exception e) {
            setError(true);
        }
    }

    @FXML
    private void calculateU() {
        try {
            float valI = Float.parseFloat(fieldI.getText().replaceAll(",", "."));
            float valR = Float.parseFloat(fieldR.getText().replaceAll(",", "."));
            fieldU.setText(formattedAnswer(valI * valR));
            setError(false);
        } catch (Exception e) {
            setError(true);
        }
    }

    // Round the value of 'value' to 2 decimals
    private String formattedAnswer(float value) {
        return String.format("%.2f", value);
    }

    private void setError(boolean type) {
        if (type) {
            subtitle.setText("ERROR VOER NUMMERS IN");
            subtitle.setStyle("-fx-text-fill: red;");
        } else {
            subtitle.setText("Wet van Ohm calculator");
            subtitle.setStyle("-fx-text-fill: black;");
        }
    }

}