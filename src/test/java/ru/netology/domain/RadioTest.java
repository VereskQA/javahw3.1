package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadioTest {

    @Test
    public void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setMaxVolume();
        int prevVolume = radio.getCurrentVolume();
        radio.increaseVolume();
        assertEquals(prevVolume, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setMinVolume();
        int prevVolume = radio.getCurrentVolume();
        radio.decreaseVolume();
        assertEquals(prevVolume, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setMinVolume();
        int expected = radio.getCurrentVolume();
        radio.increaseVolume();
        assertEquals(expected + 1, radio.getCurrentVolume());

    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setMaxVolume();
        int expected = radio.getCurrentVolume();
        radio.decreaseVolume();
        assertEquals(expected - 1, radio.getCurrentVolume());

    }

    @Test
    public void shouldSetNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        int expected = radio.getCurrentStation();
        radio.nextStation();
        assertEquals(expected + 1, radio.getCurrentStation());
    }

    @Test
    public void shouldLoopNextStation() {
        Radio radio = new Radio (12);
        int lastStation = radio.getLastStation();
        radio.setCurrentStation(lastStation);
        radio.nextStation();
        assertEquals(radio.getFirstStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldLoopPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(radio.getLastStation(), radio.getCurrentStation());
    }

    @Test
    public void shouldSetPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(2);
        int expected = radio.getCurrentStation();
        radio.prevStation();
        assertEquals(expected - 1, radio.getCurrentStation());
    }

    @Test
    public void shouldSetAllowedStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(2);
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationOverMax() {
        Radio radio = new Radio(12);
        int expected = radio.getCurrentStation();
        radio.setCurrentStation(13);
        assertEquals(expected, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationBelowMin() {
        Radio radio = new Radio();
        int expected = radio.getCurrentStation();
        radio.setCurrentStation(-1);
        assertEquals(expected, radio.getCurrentStation());
    }
}