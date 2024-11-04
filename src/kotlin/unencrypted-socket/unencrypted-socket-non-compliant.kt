/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-unencrypted-socket@v1.0 defects=1}
import java.net.Socket
import javax.net.ssl.SSLSocketFactory

// Noncompliant: Unencrypted sockets are used
fun unexcrypted_socket_noncompliant() {
    val soc: Socket = Socket("www.google.com", 80)
}
// {/fact}
