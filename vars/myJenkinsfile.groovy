
def call()
{
    pipeline
    {
        agent { label 'master' }
        
        stages
        {
            stage('First')
            {
                steps
                {
                    echo "Heloo"
                }
            }
        }
    }
}