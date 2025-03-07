def call(String sonarEnvName) {
                withSonarQubeEnv(sonarEnvName) {
                    sh "${env.SCANNER_HOME}/bin/sonar-scanner -Dsonar.login=${env.SONARQUBE_TOKEN}"
    }
}
