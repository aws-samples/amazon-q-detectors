// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package pass

// {fact rule=go-ssh-empty-password@v1.0 defects=0}
import (
	"golang.org/x/crypto/ssh"
	"golang.org/x/crypto/ssh/knownhosts"
	"log"
	"os"
)

func sshEmptyPasswordCompliant() {
	customHostKeyCallback, err := knownhosts.New("/home/username/.ssh/known_hosts")
	if err != nil {
		log.Fatal("Error initializing host key callback:", err)
	}
	sshConfig := &ssh.ClientConfig{
		User: "exampleuser",
		Auth: []ssh.AuthMethod{
			// Compliant: Password is fetched from environment variable.
			ssh.Password(os.Getenv("PASSWORD")),
		},
		HostKeyCallback: customHostKeyCallback,
	}

	_, err = ssh.Dial("tcp", "192.168.1.100:22", sshConfig)
	if err != nil {
		log.Fatal("Failed to dial: ", err)
	}
}
// {/fact}
