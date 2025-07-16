// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=kotlin-unsafe-deserialization@v1.0 defects=0}
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.SafeConstructor

fun compliant() {
    // Compliant: Using SafeConstructor prevents deserialization of arbitrary classes.
    val yaml = Yaml(SafeConstructor())
    val result = yaml.load<Map<String, Any>>("key: value")
}
// {/fact}
