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
  
