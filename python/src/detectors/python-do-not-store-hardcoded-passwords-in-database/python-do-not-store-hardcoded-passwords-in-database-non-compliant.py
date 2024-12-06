#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0
# {fact rule=python-do-not-store-hardcoded-passwords-in-database@v1.0 defects=1}
from flask_sqlalchemy import SQLAlchemy
from flask_security import SQLAlchemyUserDatastore, UserMixin, RoleMixin
from jupyter_server.auth import User
from docutils.parsers.rst.directives.misc import Role

db = SQLAlchemy()

def non_compliant():
    db.create_all()
    user_datastore = SQLAlchemyUserDatastore(db, User, Role)
    # Noncompliant: Storing password as plaintext in memory or database, might allow unauthorized users access to your account.
    user_datastore.create_user(email='matt@nobien.net', password='password')
    db.session.commit()
# {/fact}
