node {
    env.JDK_HOME = "${tool 'JDK_HOME'}"
    env.MVN_HOME = "${tool 'MVN_HOME'}"
    env.PATH="${env.JDK_HOME}/bin:${env.MVN_HOME}/bin:${env.PATH}"
    
    echo env.JDK_HOME
    echo env.MVN_HOME
    echo env.PATH
    sh 'java -version'
    sh 'mvn -v'
}
