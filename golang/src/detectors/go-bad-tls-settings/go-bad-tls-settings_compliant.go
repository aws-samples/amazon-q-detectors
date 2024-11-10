// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

package security

// {fact rule=go-bad-tls-settings@v1.0 defects=0}
import (
	"crypto/tls"
	"net/http"
)

func BadTlsSettingsCompliant() *http.Client {
	tr := &http.Transport{
		// Compliant: Secure cipher with `tls`.
		TLSClientConfig: &tls.Config{
			CipherSuites: []uint16{
				tls.TLS_AES_128_GCM_SHA256,
				tls.TLS_AES_256_GCM_SHA384,
			},
			MinVersion: tls.VersionTLS13,
		},
	}
	return &http.Client{Transport: tr}
}
// {/fact}
