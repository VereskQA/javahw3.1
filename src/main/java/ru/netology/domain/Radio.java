package ru.netology.domain;

public class Radio {
    private int firstStation = 0;
    private int lastStation = 9;
    private int maxVolume = 10;
    private int minVolume = 0;
    private int currentStation = firstStation;
    private int currentVolume = 0;

    public int getCurrentVolume() {
        return currentVolume;
    }

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

    public int getCurrentStation() {
        return currentStation;
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
        this.currentStation = currentStation;
    }

    public void setMaxVolume() {
        currentVolume = maxVolume;
    }

    public void setMinVolume() {
        currentVolume = minVolume;
    }
}
