### File System like Drop Box:

- talk about s3 presigned URLs. 
- *ETags*: for multipart file upload, after every upload, s3 generates and returns an ETag(Hash of the chunk).
- S3 sends notification via SQS after successfully uploading a File/Multi part file. s3 doesnt send notification after each chunk upload.

- client can send a reqyest to backend with the UploadID, List of partNumbers and their corresponding Etags -> the backend calls Complete Multi part Upload on s3 to finish the upload. 
- s3 stitches the chunks together with the final Object.
- the moment the chunks are stitched, S3 sends a notification on SQS which can be picked up by a worker microservice and do further processing.

*ListParts*: the backend can call listparts on s3 by passing UploadID and filKey(e.g. fileName) and s3 returns successfully uploaded chunk's Etags. 

