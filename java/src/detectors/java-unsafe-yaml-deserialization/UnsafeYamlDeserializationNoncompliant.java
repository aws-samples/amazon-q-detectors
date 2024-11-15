// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-unsafe-yaml-deserialization@v1.0 defects=1}
import org.yaml.snakeyaml.Yaml;

public class UnsafeYamlDeserializationNoncompliant {
    // Noncompliant: Uses unsafe YAML deserialization without restrictions, potentially allowing arbitrary code execution.
    public void noncompliant(final String yamlContents) {
        final Yaml yaml = new Yaml(); 
        final Object yamlObject = yaml.load(yamlContents);
    }
}
// {/fact}