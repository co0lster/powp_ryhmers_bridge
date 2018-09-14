package edu.kis.vh.nursery;

import edu.kis.vh.nursery.containers.IntLinkedList;
import edu.kis.vh.nursery.factory.ArrayStackRhymersFactory;
import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.LinkedListRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

class RhymersDemo {

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
        testRhymers(factory);
        testFactories();

    }

    private static void testRhymers(RhymersFactory factory) {
        CountingOutRhymer[] rhymers = {factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};



        for (int i = 1; i < 15; i++)
            for (int j = 0; j < 3; j++)
                rhymers[j].countIn(i);

        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < 15; i++)
            rhymers[3].countIn(rn.nextInt(20));

        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[3]).reportRejected());
    }

    public static void testFactories(){
        List<RhymersFactory> testFactories = new LinkedList<>();

        testFactories.add( new DefaultRhymersFactory());
        testFactories.add( new ArrayStackRhymersFactory());
        testFactories.add( new LinkedListRhymersFactory());

        testFactories.stream().forEach(RhymersDemo::testRhymers);



    }

}