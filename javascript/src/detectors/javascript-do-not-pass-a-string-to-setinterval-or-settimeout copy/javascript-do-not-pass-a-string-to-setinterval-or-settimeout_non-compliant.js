// {fact rule=javascript-do-not-pass-a-string-to-setinterval-or-settimeout@v1.0 defects=1}

// Noncompliant: String is passed to `setTimeout` which could lead to potential code injection vulnerability.
setTimeout("console.log(1+1)", 1500);
// {/fact}
