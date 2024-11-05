// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package insecure_ignore_host_key

// {fact rule=go-insecure-ignore-host-key@v1.0 defects=1}
import (
	"golang.org/x/crypto/ssh"
	"log"
)

func insecureIgnoreHostKeyNoncompliant() {
	// Noncompliant: `ssh.InsecureIgnoreHostKey()` disables trusted host validation.
	config := &ssh.ClientConfig{
		User:            "name",
		Timeout:         1000,
		Auth:            []ssh.AuthMethod{},
		HostKeyCallback: ssh.InsecureIgnoreHostKey(),
	}
	conn, err := ssh.Dial("tcp", "192.168.1.101:2000", config)
	if err != nil {
		log.Println(err)
	}
	defer conn.Close()
}
// {/fact}
