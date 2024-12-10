// {fact rule=javascript-do-not-pass-a-string-to-setinterval-or-settimeout@v1.0 defects=1}

// Noncompliant: `setTimeout` is a string.
const timeoutObj = setTimeout("console.log(1+1)", 1500);  

// {/fact}
