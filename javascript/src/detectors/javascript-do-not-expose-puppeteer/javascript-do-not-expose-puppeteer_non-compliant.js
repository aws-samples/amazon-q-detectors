// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-do-not-expose-puppeteer@v1.0 defects=1}
const  puppeteer  = require('puppeteer');
const express = require('express');
const app = express();

// Noncompliant: Enabled remote debugging in production environments.
app.get("/",async () => {
  const brow = await puppeteer.launch({args:['--remote-debugging-address=123','--somethin-else']});
  const pg = await browser.newPage();
  await pg.goto('https://example123.com');
  await brow.close();
})
// {/fact}
