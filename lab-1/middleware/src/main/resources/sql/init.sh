#!/bin/bash

# crea el usuario
sudo -u postgres createuser middleware_user

# crea la base
sudo -u postgres createdb -O middleware_user middleware_db

# cambia la password del nuevo usuario
psql -U postgres -d middleware_db -c "ALTER USER middleware_user WITH ENCRYPTED PASSWORD 'middleware_user';"

# carga la tabla
psql -U middleware_user -d middleware_db -a -f datasys.sql