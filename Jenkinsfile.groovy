node {
    stage('Build') {
        sh 'terraform -fmt'
    }
    stage('Test') {
        sh 'terraform -plan'
        junit 'reports/**/*.xml'
    }
}
