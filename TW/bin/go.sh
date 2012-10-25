#standard cygwin location...edit shebang if necessary
#!/usr/bin/bash

../opt/apache-ant-1.8.4/bin/ant -buildfile ../build.xml "$@"
