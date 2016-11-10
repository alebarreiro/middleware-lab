#!/bin/bash

# crea el usuario
sudo -u postgres createuser middleware_user

# crea la base
sudo -u postgres createdb -O middleware_user middleware_lab_2

# cambia la password del nuevo usuario
psql -U postgres -d middleware_db -c "ALTER USER middleware_user WITH ENCRYPTED PASSWORD 'middleware_user';"

# carga la dummy data
psql -U middleware_user -d middleware_lab_2 -a -f dummy-data.sql

# crea las tablas del timer quartz
psql -U middleware_user -d middleware_lab_2 -a -f quartz.sql