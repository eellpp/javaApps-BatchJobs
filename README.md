# javaApps-BatchJobs

### job: archive.job
Environmental variables
- job.name=archive.job
- logfile.path=<path to logfile>

### Hazelcast vs Redis
- job.name=cache.job
- job.name=redis.job

Hazelcast:
- Type: Serializable
- 2 million Person records take 2.5 GB

Redis:
- 10 Million Records takes 3 GB space