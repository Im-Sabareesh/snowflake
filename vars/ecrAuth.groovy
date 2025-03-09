def call(string region= '', string account-id= '') {
 sh 'aws ecr get-login-password --${region}  | docker login --username AWS --password-stdin ${account-id}.dkr.ecr.${region}.amazonaws.com'
}

