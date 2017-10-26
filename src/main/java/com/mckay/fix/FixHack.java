package com.mckay.fix;

import quickfix.Group;
import quickfix.Message;
import quickfix.field.*;
import quickfix.fix44.Confirmation;
import quickfix.fix44.NewOrderCross;
import quickfix.fix44.TradeCaptureReport;
import quickfix.fix44.component.Parties;


public class FixHack {

    public static void main(String args[]) {

        Message msg = new TradeCaptureReport();
        msg.setString(TradeReportID.FIELD, "TradeReport01");
        //msg.setString(SecondaryTradeReportID.FIELD, "CancellingOtherReport");
        msg.setString(TradeRequestID.FIELD, "SomeTradeReq01");
        msg.setInt(TradeReportType.FIELD, TradeReportType.SUBMIT);
        msg.setChar(PreviouslyReported.FIELD, 'N');
        msg.setString(ExecID.FIELD, "TradeXXX01");
        msg.setString(SecondaryExecID.FIELD, "TradeXXX01");
        msg.setString(TrdMatchID.FIELD, "LPTradeXXX01");
        msg.setString(LastPx.FIELD, "10000");
        msg.setString(Symbol.FIELD, "GBP/USD");
        msg.setString(TransactTime.FIELD, "20171020-20:00:00.001");
        msg.setString(LastMkt.FIELD, "Bilateral");


        Confirmation.NoPartyIDs group = new Confirmation.NoPartyIDs();

        NewOrderCross.NoSides noSidesGroup = new NewOrderCross.NoSides();
        noSidesGroup.set(new Side(Side.BUY));
        noSidesGroup.setString(OrderID.FIELD, "OURORDERIDXXX01");
        noSidesGroup.set(new ClOrdID("CLIENTIDXXX01"));
        noSidesGroup.set(new SecondaryClOrdID("CLIENTIDXXX02"));
        //noSidesGroup.set(new SecondaryOrderID("CLIENTIDXXX02"));

        noSidesGroup.set(new SettlCurrency("GBP"));


        noSidesGroup.setString(SecondaryOrderID.FIELD, "CLIENTIDXXX02");
        noSidesGroup.setString(Currency.FIELD, "GBP");
        noSidesGroup.setString(SettlCurrency.FIELD, "USD");
        noSidesGroup.setString(20558, "USD"); // CounterCCY


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

        msg.setString(SecurityType.FIELD, "SPT");
        msg.setString(SettlDate.FIELD, "20171020" );
        msg.setString(TradeDate.FIELD, "20171020");
        msg.setString(LastQty.FIELD, "1000");
        msg.setString(20500, "1000");




        System.out.println(msg.toXML());
        System.out.println(msg);


    }

}
