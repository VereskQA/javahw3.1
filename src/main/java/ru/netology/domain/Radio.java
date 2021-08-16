package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Radio {

    private int firstStation = 0;
    private int lastStation = 9;
    private int maxVolume = 100;
    private int minVolume = 0;
    private int currentStation = firstStation;
    private int currentVolume = 0;


    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }

    public void nextStation() {
        if (currentStation == lastStation) {
            currentStation = firstStation;
        } else {
            currentStation++;
        }
    }

    public void prevStation() {
        if (currentStation == firstStation) {
            currentStation = lastStation;
        } else {
            currentStation--;
        }
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > lastStation) {
            return;
        }
        if (currentStation < firstStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void increaseToMaxVolume() {
        currentVolume = maxVolume;
    }

    public void decreaseToMinVolume() {
        currentVolume = minVolume;
    }
}