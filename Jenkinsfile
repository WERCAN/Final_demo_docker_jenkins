pipeline {
  agent any
  stages {
    stage('Stage1') {
      steps {
        echo 'This is build number $BUILD_NUMBER for demo $DEMO'
      }
    }

  }
  environment {
    DEMO = '1'
  }
}