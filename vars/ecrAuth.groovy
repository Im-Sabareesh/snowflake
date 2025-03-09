def call() {
 sh 'aws ecr get-login-password --${env.region}  | docker login --username AWS --password-stdin ${env.account}.dkr.ecr.${env.region}.amazonaws.com'
}

