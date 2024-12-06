#  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
#  SPDX-License-Identifier: MIT-0
# {fact rule=python-do-not-store-hardcoded-passwords-in-database@v1.0 defects=0}
from docutils.parsers.rst.directives.misc import Role
from flask_sqlalchemy import SQLAlchemy
from flask_security import SQLAlchemyUserDatastore, UserMixin, RoleMixin
from flask_security.utils import hash_password
from jupyter_server.auth import User

db = SQLAlchemy()

def compliant():
    user_datastore = SQLAlchemyUserDatastore(db, User, Role)
    db.create_all()
    user_datastore.create_user(
        email='matt@nobien.net',
        # Compliant: Encrypt passwords using `hash_password`.
        password=hash_password('password'))
    db.session.commit()
# {/fact}
