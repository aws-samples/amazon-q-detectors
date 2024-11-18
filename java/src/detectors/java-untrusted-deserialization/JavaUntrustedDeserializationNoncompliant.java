// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-untrusted-deserialization@v1.0 defects=1}
import java.rmi.Remote;
import java.rmi.RemoteException;

interface JavaUntrustedDeserializationNoncompliant extends Remote {
    // Noncompliant: Exposes a method accepting Object parameter in RMI interface, potentially allowing untrusted deserialization.
    boolean registerTicket(String ticketID) throws RemoteException;
    void vistTalk(String talkname) throws RemoteException;
    void poke(Object attende) throws RemoteException;
}
// {/fact}
