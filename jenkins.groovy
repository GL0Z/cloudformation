def outputs = cfnDescribe(stack:'aws-rds-logs-s3')
pipeline {
    agent any
    stages {
        stage('hello AWS') {
            steps {
                withAWS(region: 'us-east-1', credentials: 'Jenkins-s3') {
                    sh 'echo "hello KB">hello.txt'
                    //cfnDelete(stack:'S3bucket-policy')
                  //cfnDescribe(stack:"dsh-impl1b-ffm-hub-jboss-intelligent-scaling")
                    cfnValidate(file:'Cf-s3.yaml')
                }
            }
        }
    }
}
