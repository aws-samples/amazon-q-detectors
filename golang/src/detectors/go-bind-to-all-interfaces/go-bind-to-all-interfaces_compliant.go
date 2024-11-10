// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package network

// {fact rule=go-bind-to-all-interfaces@v1.0 defects=0}
import (
	"fmt"
	"io"
	"net"
)

func BindToAllInterfacesCompliant() {
	// Compliant: `192.168.1.101` IP address used.
	tel, err := net.Listen("tcp", "192.168.1.101:2000")
	if err != nil {
		fmt.Println(err)
		return
	}

	for {
		conn, err := tel.Accept()
		if err != nil {
			break
		}
		go func(c net.Conn) {
			io.Copy(c, c)
			c.Close()
		}(conn)
	}
}
// {/fact}
