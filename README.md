Gandalf
-----------------------------

Gandalf is the backend api for the project.
You can start the app with -

    ./run

This runs the app with gradle continuos mode, which means that changes should be visible without restarting app.

Right now there is not much support for properties file, but we want to do that in near future. Anyways for adding db support, change the setupenv.sh and the DbConfig.groovy files with correct values.
Once this is done, u can use following commands -

     bin/db-migrate to create schema on ur db.
     bin/make-migration to add schema changes
     bin/rollback to rollback any schema change.


The ability for running tests is Work in progress.