// Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: MIT-0

// {fact rule=typescript-sql-string-concatenation@v1.0 defects=0}
import express, { Request, Response } from 'express';
import { Sequelize } from 'sequelize';
import csrf from 'csurf';
import cookieParser from 'cookie-parser';

const app: express.Application = express();

app.use(cookieParser());
app.use(csrf());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const sequelize: Sequelize = new Sequelize('database', 'username', process.env.ENV_VARIABLE as string, {
    dialect: 'sqlite',
    storage: 'data/juiceshop.sqlite',
});

app.post('/users', async (req: Request, res: Response): Promise<void> => {
    const { username }: { username?: string } = req.body;

    if (!username) {
        res.status(400).send({ error: 'Username is required' });
        return;
    }

    // Compliant: SQL query uses parameterized values, preventing SQL injection vulnerabilities.
    try {
        const query: string = 'INSERT INTO Users (username) VALUES (:username)';
        await sequelize.query(query, {
            replacements: { username },
        });
        res.send({ message: `User has been added successfully.` });
    } catch (error) {
        console.error('Error inserting user:', error);
        res.status(500).send({ error: 'An error occurred while adding the user.' });
    }
});

const PORT: number = Number(process.env.PORT) || 3000;
app.listen(PORT, (): void => {
    console.log(`Server is running on port ${PORT}`);
});
// {/fact}
