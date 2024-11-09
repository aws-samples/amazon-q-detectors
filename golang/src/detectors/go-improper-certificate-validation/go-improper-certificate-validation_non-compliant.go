// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package cert

// {fact rule=go-improper-certificate-validation@v1.0 defects=1}
import (
	"crypto/tls"
	"net/http"
)

func improperCertificateValidationNoncompliant(authReq *http.Request) *http.Response {
	// Noncompliant: `InsecureSkipVerify` parameter is set to `true`.
	tr := &http.Transport{
		TLSClientConfig: &tls.Config{
			InsecureSkipVerify: true,
			MinVersion:         tls.VersionTLS13,
		},
	}
	client := &http.Client{Transport: tr}
	res, _ := client.Do(authReq)
	return res
}
// {/fact}
