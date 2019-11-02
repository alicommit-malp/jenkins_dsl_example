pipelineJob('python_dsl_job_example') {
    definition {
        cps {
            script(readFileFromWorkspace('beerkeeper_pipeline.groovy'))
            sandbox()
        }
    }
}