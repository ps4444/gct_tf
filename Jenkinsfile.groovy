node {
    stage('Build') {
    sh 'sudo rm -rf ps4444'  
    }
        stage('Build') {
        sh 'sudo git clone https://github.com/ps4444/gct_tf.git /ps4444'
    }
        stage('Build') {
        sh 'sudo rm -rf ps4444'  
    }
        stage('Build') {
        sh 'sudo cd  ps4444'  
    }
        stage('Build') {
        sh 'terraform -fmt'  
    }
    stage('Test') {
        sh 'terraform -plan'
        junit 'reports/**/*.xml'
    }
}
