
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
                }
            }
        }
    }
}
