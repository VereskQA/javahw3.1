package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldNotSetVolumeAboveMax() {
        radio.setMaxVolume();
        int prevVolume = radio.getCurrentVolume();
        radio.increaseVolume();
        assertEquals(prevVolume, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowMin() {
        radio.setMinVolume();
        int prevVolume = radio.getCurrentVolume();
        radio.decreaseVolume();
        assertEquals(prevVolume, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {
        radio.setMinVolume();
        int expected = radio.getCurrentVolume();
        radio.increaseVolume();
        assertEquals(expected + 1, radio.getCurrentVolume());

    }

    @Test
    public void shouldDecreaseVolume() {
        radio.setMaxVolume();
        int expected = radio.getCurrentVolume();
        radio.decreaseVolume();
        assertEquals(expected - 1, radio.getCurrentVolume());

    }

    @Test
    public void shouldSetNextStation() {
        radio.setCurrentStation(1);
        int expected = radio.getCurrentStation();
        radio.nextStation();
        assertEquals(expected + 1, radio.getCurrentStation());
    }

    @Test
    public void shouldLoopNextStation() {
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldLoopPrevStation() {
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSetPrevStation() {
        radio.setCurrentStation(8);
        int expected = radio.getCurrentStation();
        radio.prevStation();
        assertEquals(expected - 1, radio.getCurrentStation());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "allowedStations.csv")
    public void shouldSetAllowedStation(int setStation, int expected) {
        radio.setCurrentStation(setStation);
        assertEquals(expected, radio.getCurrentStation());
    }
}