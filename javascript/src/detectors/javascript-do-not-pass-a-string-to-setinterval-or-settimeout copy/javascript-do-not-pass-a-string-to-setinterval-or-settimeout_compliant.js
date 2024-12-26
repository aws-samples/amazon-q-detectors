// {fact rule=javascript-do-not-pass-a-string-to-setinterval-or-settimeout@v1.0 defects=0}
// Compliant: `setTimeout` is not a string.
function showTime() {
    const now = new Date();
    console.log(`Current Time: ${now.toLocaleTimeString()}`);
}

setTimeout(showTime, 1500);
// {/fact}
