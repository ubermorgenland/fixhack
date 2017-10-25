package com.mckay.fix;

import quickfix.Message;
import quickfix.field.*;
import quickfix.fix44.Confirmation;
import quickfix.fix44.NewOrderCross;
import quickfix.fix44.TradeCaptureReport;


public class FixHack {

    public static void main(String args[]) {
        System.out.println("Hello, World");

        Message msg = new TradeCaptureReport();

        Confirmation.NoPartyIDs group = new Confirmation.NoPartyIDs();

        NewOrderCross.NoSides noSidesGroup = new NewOrderCross.NoSides();
        noSidesGroup.set(new Side(Side.BUY));
        noSidesGroup.set(new ClOrdID("CLIENTIDXXX01"));
        noSidesGroup.set(new SecondaryClOrdID("CLIENTIDXXX02"));
        //noSidesGroup.set(new SecondaryOrderID("CLIENTIDXXX02"));

        group.set(new PartyID("LEI01"));
        group.set(new PartyRole(17));
        noSidesGroup.addGroup(group);

        group.set(new PartyID("LEI02"));
        group.set(new PartyRole(22));
        noSidesGroup.addGroup(group);

        group.set(new PartyID("LEI03"));
        group.set(new PartyRole(2));
        noSidesGroup.addGroup(group);

        msg.addGroup(noSidesGroup);


        System.out.println(msg);

    }

}
