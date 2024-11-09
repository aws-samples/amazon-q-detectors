// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-rpc-ApacheXml@v1.0 defects=1}
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl

class DeserializationOfUntrustedDataNoncompliant {

  def deserializationOfUntrustedDataNoncompliant(): Unit = {
    val clientCfg = new XmlRpcClientConfigImpl
    // Noncompliant: Enabled extensions within an `Apache XML-RPC` server.
    clientCfg.setEnabledForExtensions(true)
  }

}
// {/fact}
