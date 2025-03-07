def call(String sonarEnvName = 'sonar') {
    stage('Run SonarQube Scan') {  // No need for `stages` since it’s inside a pipeline
        steps {
            script {
                withSonarQubeEnv(sonarEnvName) {
                    sh "${env.SCANNER_HOME}/bin/sonar-scanner -Dsonar.login=${env.SONARQUBE_TOKEN}"
                }
            }
        }
    }
}
