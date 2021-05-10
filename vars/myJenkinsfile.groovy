
def call(Map args)
{
    custom_params << args.custom_params
    properties([parameters(custom_params)])
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
