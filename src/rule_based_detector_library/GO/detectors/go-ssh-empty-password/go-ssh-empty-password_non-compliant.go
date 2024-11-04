/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package pass

// {fact rule=go-ssh-empty-password@v1.0 defects=1}
import (
	"golang.org/x/crypto/ssh"
	"golang.org/x/crypto/ssh/knownhosts"
	"log"
)

func sshEmptyPasswordNoncompliant() {
	customHostKeyCallback, err := knownhosts.New("/home/username/.ssh/known_hosts")
	if err != nil {
		log.Fatal("Error initializing host key callback:", err)
	}
	sshConfig := &ssh.ClientConfig{
		User: "exampleuser",
		Auth: []ssh.AuthMethod{
			// Noncompliant: Empty password in `ssh` config.
			ssh.Password(""),
		},
		HostKeyCallback: customHostKeyCallback,
	}

	_, err = ssh.Dial("tcp", "192.168.1.100:22", sshConfig)
	if err != nil {
		log.Fatal("Failed to dial: ", err)
	}
}
// {/fact}
