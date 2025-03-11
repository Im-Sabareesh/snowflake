def call() {
try {
echo "Authenticating with ECR"
sh 'aws ecr get-login-password --region ${REGION} | docker login --username AWS --password-stdin ${ACCOUNT}.dkr.ecr.${REGION}.amazonaws.com'
echo "Successfully logged into AWS ECR. Now you can push image"
}catch (Exception e) {
        error "ECR login failed: ${e.message}"
    }
}
