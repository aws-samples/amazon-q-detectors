// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=javascript-sql-string-concatenation@v1.0 defects=1}
const { Sequelize } = require('sequelize');
const express = require('express');
const csrf = require('csurf');
const cookieParser = require('cookie-parser');

const app = express();

app.use(cookieParser());
app.use(csrf());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const sequelize = new Sequelize('database', 'username', process.env.ENV_VARIABLE, {
    dialect: 'sqlite',
    storage: 'data/juiceshop.sqlite',
});

app.post('/users', async (req, res) => {
    const { username } = req.body;

    if (!username) {
        return res.status(400).send({ error: 'Username is required' });
    }

    // Noncompliant: SQL injection vulnerability due to string concatenation
    try {
        const query = "INSERT INTO Users (username) VALUES ('" + username + "')";
        await sequelize.query(query);
        res.send({ message: `User has been added successfully.` });
    } catch (error) {
        console.error('Error inserting user:', error);
        res.status(500).send({ error: 'An error occurred while adding the user.' });
    }
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
// {/fact}
