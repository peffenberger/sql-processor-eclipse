sql-processor-eclipse
=====================

The SQL Processor Eclipse Plugin (SQLEP).

To import this plugin into IDE the STS 3.2.0 plus Xtext 2.3 are required.

The minimum installation is the next one:
- spring-tool-suite-3.2.0.RELEASE-e4.2.2-linux-gtk-installer.sh
and the plugins:
 - Ecore Tools SDK 1.1.0
 - EMF - Eclipse Modeling Framework SDK 2.8.3
 - MWE 2 language SDK 2.3.0 (do not update to 2.4.0 *)
 - MWE 2 runtime SDK 2.3.0 (do not update to 2.4.0 *)
 - Xpand SDK 1.2.1 (updated to 1.3.0)
 - Xtext SDK 2.3.1 (do not update to 2.4.0 *)

To install SQLEP, the next P2 repos can be used
 - http://sql-processor.org/plugins/milestones/
 - http://sql-processor.org/plugins/releases/

To build from the command line the Maven 3 is required plus the next command:

    cd ~/git/sql-processor-eclipse
    mvn clean install -Dtycho.targetPlatform=PATH_TO_ECLIPSE

or simple (using Eclipse P2 repositories)

    mvn clean install

To install this plugin from the build, copy the next jars into eclipse/dropins directory:
 - ./org.sqlproc.dsl/target/org.sqlproc.dsl-1.5.0-SNAPSHOT.jar
 - ./org.sqlproc.dsl.ui/target/org.sqlproc.dsl.ui-1.5.0-SNAPSHOT.jar

For example

    cp ./org.sqlproc.dsl/target/org.sqlproc.dsl-1.5.0-SNAPSHOT.jar ~/springsource/sts-3.2.0.RELEASE/dropins/
    cp ./org.sqlproc.dsl.ui/target/org.sqlproc.dsl.ui-1.5.0-SNAPSHOT.jar ~/springsource/sts-3.2.0.RELEASE/dropins/


