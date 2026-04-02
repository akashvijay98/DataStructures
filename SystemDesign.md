## File System like Drop Box:

#### Uploading / Downloading a file
- talk about s3 presigned URLs. 
- __ETags__ : for multipart file upload, after every upload, s3 generates and returns an ETag(Hash of the chunk).
- S3 sends notification via SQS after successfully uploading a File/Multi part file. s3 doesnt send notification after each chunk upload.

- client can send a reqyest to backend with the UploadID, List of partNumbers and their corresponding Etags -> the backend calls Complete Multi part Upload on s3 to finish the upload. 
- s3 stitches the chunks together with the final Object.
- the moment the chunks are stitched, S3 sends a notification on __SQS__ which can be picked up by a worker microservice and do further processing.

__ListParts__: the backend can call listparts on s3 by passing UploadID and fileKey(e.g. fileName) and s3 returns successfully uploaded chunk's Etags. 

#### sharing a file:
- create a userID-FileId mapping table
- talk about how to synchronize file metadata table and sharedWith user table(using transactions)
- create a __composite primary key(userId, fileID)__, since userId is the first column in the composite index, you can easily search where userId="" and also where userId="" AND fileId=""
- (for revoking access, check who has access to a file):"Since fileId is second column in the composite index, you cannot fastly access where fileId="" in the same table.you need to create a __secondary index__ for the fileID column


## Web Crawler

- 1 billion pages are crawled a month

#### High Level Design 
- a frontier kafka queue with a set of URLS and a crawler service which crawls and extracts raw HTML, processes it, extracts text & URL  and stores them in S3
- can reduce the burden on crawler service by seperating crawling webpages and processing raw HTML into seperate pipelines
  - first raw HTML will be extracted from webpages and stored in s3 and then the s3 url will be added to another kafka queue.
  - a seperate processor service will read the s3 url from the process queue and process, extract text and url from raw html and then store the text and add the URLs to the forntier queue
        
#### Challenges to address & Solutions:
- __Handling Failures__: if a webpage is down, the queue might get stuck in retrying and other URLS wont be crawled.
    - Kafka doesnt have inbuilt support for Dead Letter Queues. so we need to add another retry_5mins topic and in the crawler consumer, we'll add a try catch block and then add the failed URLs to the retry topic with timestamp.

  __Retry Buckets__: we'll introduce multiple retry buckets with different waiting times. __BucketA(5:00 mins), BucketB(4:25 mins), BucketC(8:45 mins)__
    - when URL fails, we randomly assign it to one of the buckets.
 
__Horizontal Scaling__ : we can use multiple crawlers instead of depending entirely on one single crawler.
- Kafka topics can be partitioned so that each url is assigned to a partition.
- (dont say this if interviewer doesnt ask) - we'll maintain a hashtable with URLS that are visited. So that same URL is not crawled twice(preventing duplication).
- when we have thousands of crawlers hitting the same domain (like nytimes.com/sports, nytimes.com/international), then we need to do rate limiting to prevent these crawlers from DDosing that site.
- __Rate Limiting__: we can use a __distributed global rate limiter__ like __redis__ with __sliding window rate limiter__ so that different crawler workers will check redis before hitting the same domain.
    __scenario__ if both __workerA__ and __workerB__ want to crawl news.com and they check redis. __workerA__ gets greenlight but __workerB__ doesnt get permission. workerB will add a __jitter__ random wait time and retry with redis rate limiter again.   
-  
