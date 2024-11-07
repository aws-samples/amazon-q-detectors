// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package security

// {fact rule=go-bad-tls-settings@v1.0 defects=1}
import (
	"crypto/tls"
	"net/http"
)

func BadTlsSettingsNoncompliant() *http.Client {
	tr := &http.Transport{
		// Noncompliant: Insecure cipher with `tls`.
		TLSClientConfig: &tls.Config{
			CipherSuites: []uint16{
				tls.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,
				tls.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256,
			},
			MinVersion: tls.VersionTLS13,
		},
	}
	return &http.Client{Transport: tr}
}
// {/fact}
