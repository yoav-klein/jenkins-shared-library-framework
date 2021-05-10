
/************************************************
*   myJenkinsfile.groovy
*   ------------------------
*   This file demonstrates the use of a whole pipeline 
*   as a function in a shared library.
*
*   This is useful in order to create a template Jenkinsfile to reuse
*   the same logic in many Jenkins jobs.
*
*   It can take parameters to enable customizing the behaviour
*   of the pipeline. In this example, it takes a parameter 
*   of 'job_specific_params' - an ArrayList of parameters defined
*   in the calling job, which are appended to parameters defined in this
*   function that are generic parameters that should be used by all 
*   the pipelines that use this pipeline
*
*
***************************************************/



def call(Map args)
{
    // take job_specific_params into pipeline_params, 
    // and then add generic parameters to it.
    // def pipeline_params = args.job_specific_params
    def pipeline_params = args.job_specific_params ?: []
    
    pipeline_params << string(name: 'Branch', description: 'This is a generic parameter', defaultValue: '')
    properties([parameters(pipeline_params)])
    
    pipeline
    {
        agent { label 'master' }
        
        stages
        {
            stage('First')
            {
                steps
                {
                    echo "Hello ${args.Name}"
                    script {
                      //library('Jenkins-Common')   
                        // artifactory.groovy is in a library defined by the calling Jenkinsfile
                      artifactory.upload()
                    }
                }
            }
        }
    }
}
