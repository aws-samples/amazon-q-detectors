// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=scala-rpc-ApacheXml@v1.0 defects=0}
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl

class DeserializationOfUntrustedDataCompliant {

  def deserializationOfUntrustedDataCompliant(): Unit = {
    val clientCfg = new XmlRpcClientConfigImpl
    // Compliant: Disabled extensions within an `Apache XML-RPC` server.
    clientCfg.setEnabledForExtensions(false)
  }

}
// {/fact}
