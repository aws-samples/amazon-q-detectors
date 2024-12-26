// {fact rule=javascript-s3-partial-encrypt@v1.0 defects=0}
var S3 = require('aws-sdk/clients/s3');

function compliant(){
    var s3_client = new S3();

    const params = {
        Bucket: "bucket1",
        Key: s3Key,
        Body: body,
        ACL: 'authenticated-read',
        ContentType: contentType,
        ServerSideEncryption: "aws:kms",
        SSEKMSKeyId: encryptionKey
    }


    // Compliant: The data is encrypted on all branches of a conditional.
    if ( process.env.APP_CHECK === 'UPLOAD_TO_BUCKET_1' ) {
        params.bucket = "bucket1";
        s3_client.putObject(params, function (err, data) {
            if (err) console.log(err, err.stack);
            else console.log(data);
        });
    }
    else {
        params.bucket = "bucket2";
        s3_client.putObject(params2, function (err, data) {
            if (err) console.log(err, err.stack);
            else console.log(data);
        });
    }
}
// {/fact}
