node {
    stage('Build') {
        sh 'git clone https://github.com/ps4444/gct_tf.git /tmp'
    }
        stage('Build') {
        sh 'terraform -fmt'  
    }
    stage('Test') {
        sh 'terraform -plan'
        junit 'reports/**/*.xml'
    }
}
