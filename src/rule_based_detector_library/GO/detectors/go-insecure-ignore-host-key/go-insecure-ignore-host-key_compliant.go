// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package insecure_ignore_host_key

// {fact rule=go-insecure-ignore-host-key@v1.0 defects=0}
import (
	"golang.org/x/crypto/ssh"
	"log"
)

func insecureIgnoreHostKeyCompliant(key ssh.PublicKey) {
	// Compliant: Used `ssh.ClientConfig`'s `HostKeyCallback`.
	config := &ssh.ClientConfig{
		User:            "name",
		Timeout:         1000,
		Auth:            []ssh.AuthMethod{},
		HostKeyCallback: ssh.FixedHostKey(key),
	}
	conn, err := ssh.Dial("tcp", "192.168.1.101:2000", config)
	if err != nil {
		log.Println(err)
	}
	defer conn.Close()
}
// {/fact}
