
def call(Map args)
{
    ParameterDefinition custom_params = []
    custom_params << args.custom_params
    custom_params << string(name: 'Branch', description: 'This is a generic parameter', defaultValue: '')
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
