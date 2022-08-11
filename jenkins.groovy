
pipeline {
    agent any
    stages {
        stage('hello AWS') {
            steps {
                withAWS(region: 'us-east-1', credentials: 'Jenkins-s3') {
                    sh 'echo "hello KB">hello.txt'
                    //cfnDelete(stack:'S3bucket-policy')
                  //cfnDescribe(stack:"dsh-impl1b-ffm-hub-jboss-intelligent-scaling")
                    cfnValidate(file:'creates3.json')
                    cfnUpdate(stack:'parm-stack', file:'S3template.yaml', params:['BucketName': 'params5-bucket'])
                }
            }
        }
    }
}
