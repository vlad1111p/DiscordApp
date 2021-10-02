package com.banvayne;

import java.util.ArrayList;

public class Jokes {

    ArrayList<String> jokes=new ArrayList<String>();

    public Jokes(){
        jokes.add("Today I saw a dwarf climbing down a prison wall.\n" +

                "I thought to myself, “That’s a little condescending.");

        jokes.add("How much does a chimney cost\n" +
                "Nothing its on the house");
        jokes.add("How much does a chimney cost\n" +
                "Nothing its on the house");

        jokes.add("Mountains are not funny, they are hill areas");

        jokes.add("How many times do you need to tickle an octopus to make it laugh ?\n"
                +
                "10 tickles");
        jokes.add("Have you guys heard of the knight who was famous for giving up?\n" +

                "His name was sir Render\n");
        jokes.add(
                "What do you call a psychic midget who has escaped from prison? \n" +

                "A small medium at large.\n");
        jokes.add("Why was the pony unable to sing? He was a little hoarse");
        jokes.add(
                "i walked my dog to the park but it was attacked by ducks. thats what i get for buying a purebred\n");
        jokes.add("Did you hear about the dyslexic Satanist?\n" +
                "He sold his soul to Santa.");
        jokes.add(
                "Did you hear about the guy who had too much phone sex?\n" +
                "He's got Hearing AIDS.");

    }


    public String pickRandomJoke(){
        int index = (int)(Math.random() * jokes.size());
        return jokes.get(index);
    }


}
