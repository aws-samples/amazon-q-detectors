// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=java-unsafe-yaml-deserialization@v1.0 defects=0}
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;

import java.nio.file.Path;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Map;

public class UnsafeYamlDeserializationCompliant {
    // Compliant: Uses SafeConstructor with LoaderOptions for YAML deserialization, preventing arbitrary code execution.
    public void compliant(final String yamlContents) {
        LoaderOptions loadOptions = new LoaderOptions();
        final Yaml yaml = new Yaml(new SafeConstructor(loadOptions));
        final Object yamlObject = yaml.load(yamlContents);
    }

}
// {/fact}