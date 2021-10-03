package com.banvayne;

import java.util.ArrayList;

public class Jokes {

    ArrayList<String> jokes = new ArrayList<String>();

    public Jokes() {
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
        jokes.add(
                "What do you call a cow...\n" +
                        "...w/ no legs? Ground beef.");
        jokes.add("mind goblin these nuts");
        jokes.add("do you know how to spot a blind mand at the nudist camp? its not hard");
        jokes.add(" why do mushrooms always get invited to parites. because they are all funguis");
        jokes.add(" dont trust atoms, they make up everything ");
        jokes.add("i decided to sell my vacume. it was just collecting dust.\n");
        jokes.add("Police arrested two kids yesterday, one was drinking battery acid,\n" +
                "the other was eating fireworks. They charged one and let the other one off.");
        jokes.add("why do socialists always type in lower case. because they reject capitalism");

    }


    public String pickRandomJoke() {
        int index = (int) (Math.random() * jokes.size());
        return jokes.get(index);
    }


}
