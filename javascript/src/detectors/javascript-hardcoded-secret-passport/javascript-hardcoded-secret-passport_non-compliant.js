// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-hardcoded-secret-passport@v1.0 defects=1}
const passport = require("passport");
const { Strategy: JwtStrategy, ExtractJwt } = require("passport-jwt");

// Noncompliant: Hardcoded secret is used for JWT authentication.
const options = {
    jwtFromRequest: ExtractJwt.fromAuthHeaderAsBearerToken(),
    secretOrKey: "key"
};

const strategy = new JwtStrategy(options, (jwtPayload, done) => {
    try {
        return done(null, jwtPayload);
    } catch (error) {
        return done(error, false);
    }
});

passport.use(strategy);

module.exports = passport;
// {/fact}
