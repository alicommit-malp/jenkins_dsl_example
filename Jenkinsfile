pipelineJob('python_dsl_job_example') {
    definition {
        cps {
            script(readFileFromWorkspace('python/beerkeeper_pipeline.groovy'))
            sandbox()
        }
    }
}