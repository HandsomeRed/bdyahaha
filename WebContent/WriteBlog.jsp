<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
    <title>ckeditor</title>
<link rel="stylesheet" type="text/css" href="css/public.css"/>
<link rel="stylesheet" type="text/css" href="css/WriteBlog.css"/>
    <script src="ckeditor5-build-classic/ckeditor.js"></script>

</head>

<body>
<form method="post" action="doWriteBlog">
<div class="bigBox"><!--文章标题 提交按钮 头像-->

    <div style="width: 100%; height: 56px; overflow: inherit;">
		<div class="topBox">
    		<div class="title"><!--文章标题-->
     	   		<input maxlength="100" placeholder="输入文章标题" class="titleInput" name="be.title"/>
                <span class="textNum"><!--标题字数统计 js控制，暂未完成-->
					0/100
                </span>
     	   	</div>
      	  	<div class="btnBox"><!--提交按钮 头像-->
      	  		<input type="submit" class="submitBtn" value="发布文章"/>
                <div class="userBox">
                	<div class="userInforBox">
                    	<div class="userPic"><a href=""><img src="images/defaultPic.jpg" class="userPicImg"/></a></div>
                        <div><!--头像下拉菜单--></div>
                    </div>
                </div>
      	  	</div>
    	</div>
	</div>

	<div><!-- 富文本编辑器 -->
        <textarea name="be.content" id="description" style="overflow-y: -moz-scrollbars-horizontal;"></textarea>
    </div>
</div>
</form>


<script type="text/javascript">

    class MyUploadAdapter {
        constructor(loader) {
            // The file loader instance to use during the upload.
            this.loader = loader;
        }

        // Starts the upload process.
        upload() {
            return this.loader.file
                .then(file => new Promise((resolve, reject) => {
                    this._initRequest();
                    this._initListeners(resolve, reject, file);
                    this._sendRequest(file);
                }));
        }

        // Aborts the upload process.
        abort() {
            if (this.xhr) {
                this.xhr.abort();
            }
        }

        // Initializes the XMLHttpRequest object using the URL passed to the constructor.
        _initRequest() {
            const xhr = this.xhr = new XMLHttpRequest();

            // Note that your request may look different. It is up to you and your editor
            // integration to choose the right communication channel. This example uses
            // a POST request with JSON as a data structure but your configuration
            // could be different.
            // 下面的API换成自己的接口地址
            xhr.open('POST', 'doUploadPicture', true);
            xhr.responseType = 'json';
        }

        // Initializes XMLHttpRequest listeners.
        _initListeners(resolve, reject, file) {
            const xhr = this.xhr;
            const loader = this.loader;
            const genericErrorText = `Couldn't upload file: ${ file.name }.`;

            xhr.addEventListener('error', () => reject(genericErrorText));
            xhr.addEventListener('abort', () => reject());
            xhr.addEventListener('load', () => {
                const response = xhr.response;

                // This example assumes the XHR server's "response" object will come with
                // an "error" which has its own "message" that can be passed to reject()
                // in the upload promise.
                //
                // Your integration may handle upload errors in a different way so make sure
                // it is done properly. The reject() function must be called when the upload fails.
                if (!response || response.error) {
                    return reject(response && response.error ? response.error.message : genericErrorText);
                }

                // If the upload is successful, resolve the upload promise with an object containing
                // at least the "default" URL, pointing to the image on the server.
                // This URL will be used to display the image in the content. Learn more in the
                // UploadAdapter#upload documentation.
                resolve({
                    default: response.url
                });
            });

            // Upload progress when it is supported. The file loader has the #uploadTotal and #uploaded
            // properties which are used e.g. to display the upload progress bar in the editor
            // user interface.
            if (xhr.upload) {
                xhr.upload.addEventListener('progress', evt => {
                    if (evt.lengthComputable) {
                        loader.uploadTotal = evt.total;
                        loader.uploaded = evt.loaded;
                    }
                });
            }
        }

        // Prepares the data and sends the request.
        _sendRequest(file) {
            // Prepare the form data.
            const data = new FormData();

            data.append('upload', file);

            // Important note: This is the right place to implement security mechanisms
            // like authentication and CSRF protection. For instance, you can use
            // XMLHttpRequest.setRequestHeader() to set the request headers containing
            // the CSRF token generated earlier by your application.

            // Send the request.
            this.xhr.send(data);
        }
    }

    // ...
    function MyCustomUploadAdapterPlugin(editor) {
        editor.plugins.get('FileRepository').createUploadAdapter = (loader) => {
            // Configure the URL to the upload script in your back-end here!
            return new MyUploadAdapter(loader);
        };
    }


    ClassicEditor
        .create(document.querySelector('#description'), {
            extraPlugins: [MyCustomUploadAdapterPlugin]
            // ckfinder: {
            // 	uploadUrl: "doUploadPicture"
            // }

        })
        .catch(error => {
            console.error(error);
        });
</script>
<style>
    .ck-editor__editable {
        min-height: 600px;
        max-height: 600px;
    }
</style>
</body>
</html>