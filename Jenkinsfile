pipeline {
    agent any
    stages {
        def mvnHome = tool 'M3'
        env.PATH = "${mvnHome}/bin:${env.PATH}"
        stage('build') {
            steps {
                sh 'mvn -v'
            }
        }
    }
}
