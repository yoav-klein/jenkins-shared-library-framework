
def call(Map args)
{
    //def custom_params = new ArrayList<ParameterDefinition>()
    //custom_params << args.custom_params
    def custom_params = []
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
