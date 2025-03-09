def call() {
 sh 'aws ecr get-login-password --region ${env.REGION}  | docker login --username AWS --password-stdin ${env.ACCOUNT}.dkr.ecr.${env.REGION}.amazonaws.com'
}

