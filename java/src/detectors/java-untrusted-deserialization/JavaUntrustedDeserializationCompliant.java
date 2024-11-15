// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-untrusted-deserialization@v1.0 defects=0}
import java.rmi.Remote;
import java.rmi.RemoteException;

interface JavaUntrustedDeserializationCompliant extends Remote {
    // Compliant: Uses primitive types for RMI method parameters, preventing untrusted deserialization vulnerabilities.
    boolean registerTicket(long ticketID) throws RemoteException;
    void vistTalk(long talkID) throws RemoteException;
    void poke(int attende) throws RemoteException;
}
// {/fact}
