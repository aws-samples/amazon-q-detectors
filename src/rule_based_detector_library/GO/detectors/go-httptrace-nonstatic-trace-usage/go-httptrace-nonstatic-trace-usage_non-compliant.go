/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package uhoh

// {fact rule=go-httptrace-nonstatic-trace-usage@v1.0 defects=1}
import (
	"net/http"
	"net/http/httptrace"
)

func httptraceNonstaticTraceUsageNoncompliant(request *http.Request, trace *httptrace.ClientTrace) *http.Request {
	// Noncompliant: `ClientTrace` is used directly in request.
	context := request.Context()
	return request.WithContext(httptrace.WithClientTrace(context, trace))
}
// {/fact}
