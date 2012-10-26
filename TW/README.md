Mars Rover - by Matt Clarkson
=============================

Installation:
-prerequisites: jdk 1.6 or greater installed, $JAVA_HOME set
-unzip archive to any location
-Directories:
src - application source
testsrc - test source
testinputfiles - resources for unit tests and main
bin - executable scripts
lib - library dependencies
opt - tools (currently ant)



Running:
In bin dir:
-bash: go.sh
-dos: go.bat

The scripts call the embedded ant instance and executes a full compile, test run, and application run.  The individual targets are:

clean
compile
compile.unit.tests
test
run.app

Thanks For Reading!

MTC

