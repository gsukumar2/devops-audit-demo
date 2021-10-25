node {

	stage('SCM Checkout') {
		git 'https://github.com/gsukumar2/devops-audit-demo.git'
	}
	stage('Build Maven') {
		def mvnHome = tool name: 'M3', type: 'maven'
		sh "${mvnHome}/bin/mvn package"
	}


}
