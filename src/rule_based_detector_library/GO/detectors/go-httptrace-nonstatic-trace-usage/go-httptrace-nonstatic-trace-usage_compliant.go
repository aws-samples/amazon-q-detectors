/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package uhoh

// {fact rule=go-httptrace-nonstatic-trace-usage@v1.0 defects=0}
import (
	"fmt"
	"net/http"
	"net/http/httptrace"
)

func httptraceNonstaticTraceUsageCompliant(request *http.Request) *http.Request {
	trace := &httptrace.ClientTrace{
		GetConn:     func(host string) { fmt.Println("Connecting to", host) },
		ConnectDone: func(network, addr string, err error) { fmt.Println("TCP connection created:", network, addr, err) },
		GotConn:     func(info httptrace.GotConnInfo) { fmt.Println("CONNECTED!!! Info:", info) },
	}
	context := request.Context()
	// Compliant: Static `ClientTrace` used in request.
	return request.WithContext(httptrace.WithClientTrace(context, trace))
}
// {/fact}
