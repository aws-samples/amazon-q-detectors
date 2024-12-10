// {fact rule=javascript-do-not-pass-a-string-to-setinterval-or-settimeout@v1.0 defects=0}

// Compliant: `setTimeout` is not a string.
const timeoutObj = setTimeout(showTime, 1500); 
// {/fact}
