package com.suhorukov.ulyanova.parser;

/**
 * Created with IntelliJ IDEA.
 * User: ainex
 * Date: 07.07.13
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
public class WordCounter implements Comparable<WordCounter> {

    private String word;
    private Integer frequency;

    public String getWord() {
        return word;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public WordCounter(String word,  Integer frequency) {
        this.word = word;
        this.frequency = frequency;
    }
    @Override
    public int compareTo(WordCounter word) {
        return  word.frequency - this.frequency;
    }
    @Override
    public String toString () {
        return this.word + ";" + this.frequency;
    }
}
