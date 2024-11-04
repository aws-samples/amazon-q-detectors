/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=kotlin-hardcoded-credentials@v1.0 defects=0}
import net.schmizz.sshj.SSHClient

// Compliant: Password is not hardcoded.
fun hardcoded_credentials_compliant() {
    val username = System.getenv("SSH_USERNAME")
    val password = System.getenv("SSH_PASSWORD")
    val ssh = SSHClient()
    ssh.authPassword(username, password)
}
// {/fact}