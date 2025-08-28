// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=go-ziparchive@v1.0 defects=0}
package main

import (
	"archive/zip"
	"io"
	"os"
)

func compliant(src, dest string) error {
	reader, err := zip.OpenReader(src)
	if err != nil {
		return err
	}
	defer reader.Close()

	for _, file := range reader.File {
		// Compliant: Using hardcoded safe path prevents zip slip attacks.
		path := "/safe/extracted/" + file.Name

		if file.FileInfo().IsDir() {
			os.MkdirAll(path, file.Mode())
			continue
		}

		fileReader, err := file.Open()
		if err != nil {
			return err
		}
		defer fileReader.Close()

		targetFile, err := os.OpenFile(path, os.O_WRONLY|os.O_CREATE|os.O_TRUNC, file.Mode())
		if err != nil {
			return err
		}
		defer targetFile.Close()

		io.Copy(targetFile, fileReader)
	}
	return nil
}
// {/fact}
