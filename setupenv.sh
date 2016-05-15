#!/bin/sh

export PROJECT_ROOT=`pwd`;
export DB_HOSTNAME="localhost";
export DB_PORT="5438";
export DB_USER="oracle";
export DB_NAME="oracle";
export DOGFISH_MIGRATIONS_DIR="${PROJECT_ROOT}/migrations"
export DOGFISH_SQL_OPTS="--host ${DB_HOSTNAME} --port ${DB_PORT} -U ${DB_USER}";
