/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
 */

package testing

// {fact rule=go-unsafe-reflection@v1.0 defects=1}
import (
	"fmt"
	"reflect"
)

func unsafeReflectionNoncompliant(jobInstance interface{}, userInput string) map[string]interface{} {
	data := make(map[string]interface{})

	jobValue := reflect.ValueOf(jobInstance).Elem()

	// Noncompliant: Unsafe user input is passed.
	method := jobValue.MethodByName(userInput)

	if method.IsValid() {
		colorValue := method.Call(nil)[0].Interface()
		data["color"] = fmt.Sprintf("%v", colorValue)
	} else {
		colorField := jobValue.FieldByName("color")
		if colorField.IsValid() && colorField.Kind() == reflect.String {
			data["color"] = colorField.String()
		} else {
			data["color"] = "unknown"
		}
	}
	return data
}
// {/fact}
