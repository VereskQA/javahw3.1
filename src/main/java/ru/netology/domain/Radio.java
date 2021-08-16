package ru.netology.domain;

public class Radio {

    private final int firstStation = 0;
    private int lastStation = 9;
    private final int maxVolume = 100;
    private final int minVolume = 0;
    private int currentStation = firstStation;
    private int currentVolume = 0;

    public Radio (int lastStation){
        this.lastStation = lastStation;
    }

    public Radio() {
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getFirstStation() {
        return firstStation;
    }

    public int getLastStation() {
        return lastStation;
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
        if (currentStation > lastStation) {
            return;
        }
        if (currentStation < firstStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void setMaxVolume() {
        currentVolume = maxVolume;
    }

    public void setMinVolume() {
        currentVolume = minVolume;
    }
}
