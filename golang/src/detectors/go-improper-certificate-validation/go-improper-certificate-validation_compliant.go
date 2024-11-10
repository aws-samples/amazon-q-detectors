// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package cert

// {fact rule=go-improper-certificate-validation@v1.0 defects=0}
import (
	"crypto/tls"
	"net/http"
)

func improperCertificateValidationCompliant(authReq *http.Request) *http.Response {
	// Compliant: `InsecureSkipVerify` parameter is set to `false`.
	tr := &http.Transport{
		TLSClientConfig: &tls.Config{
			InsecureSkipVerify: false,
			MinVersion:         tls.VersionTLS13,
		},
	}
	client := &http.Client{Transport: tr}
	res, _ := client.Do(authReq)
	return res
}
// {/fact}
