/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-unencrypted-socket@v1.0 defects=0}
import java.net.Socket
import javax.net.ssl.SSLSocketFactory

// Compliant: Encrypted sockets are used
fun unexcrypted_socket_compliant() {
    val soc:Socket = SSLSocketFactory.getDefault().createSocket("www.google.com", 443)
}
// {/fact}
