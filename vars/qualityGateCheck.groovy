def call() {
timeout(time: 5, unit: 'MINUTES') {  // Wait for the Quality Gate result
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline failed due to Quality Gate failure: ${qg.status}"
                                       }
                         }
           } 
